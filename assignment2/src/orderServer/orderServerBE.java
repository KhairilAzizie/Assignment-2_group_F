package orderServer;

import java.awt.EventQueue;
import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import controller.ItemProductController;
import controller.OrderController;
import controller.OrderTransactionController;
import controller.OrderedItemController;
import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;


//server read
public class orderServerBE {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		ServerSocket c = new ServerSocket(9999);
		ServerSocket a = new ServerSocket(9990);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now));
//		System.out.println("connected");
		ServerSocket creditCard_order = new ServerSocket(9997);
		
		
		@SuppressWarnings("unused")
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		server1 frame = new server1();
		frame.setVisible(true);
		int referenceNumber = 0;
		float total = 0;
		
		while (true)
		{
			
			//accept connection client-order server
			Socket cc = c.accept();
			ObjectInputStream inputStream = new ObjectInputStream(cc.getInputStream());
			
			String creditCardNo = inputStream.readUTF();

			frame.updateRequestStatus(creditCardNo);
			
			ArrayList<OrderedItem> orderItem = new ArrayList<OrderedItem>();
			orderItem = (ArrayList<OrderedItem>) inputStream.readObject();		
			
			//send credit card to be validated to credit card server
			Socket transactionSocket = new Socket(InetAddress.getLocalHost(),9998);
			DataOutputStream OS = new DataOutputStream(transactionSocket.getOutputStream());
//			System.out.print(50);
			System.out.print(creditCardNo);
			OS.writeUTF(creditCardNo);
			
			//
			Socket CO = creditCard_order.accept();
			
			DataInputStream status = new DataInputStream(CO.getInputStream());
			Boolean stats = status.readBoolean();
			int L4 = status.readInt();
			
			Order order = new Order();
			
			
			
			//set Total
			OrderTransaction orderTransaction = new OrderTransaction();
			orderTransaction.setLast4Digits(L4);
			for(int i = 0; i< orderItem.size(); i++)
			{
				total = orderItem.get(i).getSubTotalAmount();
			}
				
			//if credit card valid then ready to send data to database
			if(stats == true)
			{
				
				//call up database object
				OrderController orderController = new OrderController();
				
				//set Order
				order.setOrderedItems(orderItem);
				order.setOrderReferenceNumber(++referenceNumber);
				Order order1 = new Order();
				order.setTotalAmount(total);
				order1 = orderController.insertOrder(order);
				
				System.out.print(order.getOrderId());
				//set order
				OrderedItemController IT = new OrderedItemController();
				

				for(OrderedItem os: orderItem)
				{
					IT.insertOrderedItem(order1,os);
				}
				
				
				//set Order Transaction
				orderTransaction.setOrder(order);
				orderTransaction.getOrder().setOrderReferenceNumber(++referenceNumber);
				orderTransaction.setAmountCharged(total);
				System.out.print(total);
				orderTransaction.setOrderMode("Take Away");
				orderTransaction.setTransactionStatus(stats);
				orderTransaction.setTransactioDate(dtf.format(now));
				orderTransaction.setOrder(order);
				
				//write transaction detail into database
				OrderTransactionController transactionController = new OrderTransactionController ();
				transactionController.insertTransaction(orderTransaction);
			
				//insert ordered item into database
				ItemProductController itemProductController = new ItemProductController();
				List<OrderedItem> products = orderTransaction.getOrder().getOrderedItems();
				for(OrderedItem product:products){
					product.setItemProduct(itemProductController.getProduct(product.getItemProduct().getItemProduct()));
				}
				
				ObjectOutputStream order_client = new ObjectOutputStream(cc.getOutputStream());
				order_client.writeObject(orderTransaction);
				
				
				//push order to kitchen
				Socket kitchen = a.accept();
				ObjectOutputStream kitchena = new ObjectOutputStream(kitchen.getOutputStream());
				kitchena.writeObject(orderItem);
				
			}
			else {
				
				
			}
			
			
	}

	}
}