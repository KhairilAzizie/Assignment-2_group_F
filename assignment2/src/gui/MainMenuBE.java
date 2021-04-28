package gui;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import orderServer.server1;
import kioskapp.ordertransaction.OrderTransaction;
import kioskapp.ordereditem.*;
import javax.swing.JOptionPane;


public class MainMenuBE {
	//static String creditCard_1;
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		
		Home mm1 = new Home();
		mm1.setVisible(true);
		
		
		while(true)
		{
			
			Socket s = new Socket("localhost",9999);
			//DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			ObjectOutputStream outputStream = new ObjectOutputStream(s.getOutputStream());
			
			ArrayList<OrderedItem> orderItem = new ArrayList<OrderedItem>();
			
			
			orderItem = mm1.getOrderedItems();
			
			String so = mm1.getcreditCard();
			outputStream.writeUTF(so);
			outputStream.writeObject(orderItem);
			outputStream.flush();
			
			
			//open InputStream to accept credit card status from order server
			ObjectInputStream input = new ObjectInputStream(s.getInputStream());
			OrderTransaction orderTransaction = (OrderTransaction)input.readObject();
			
			Boolean result = orderTransaction.isTransactionStatus();
			if(result == true)
			{
				receipt receipt = new receipt();
				String receiptdata = receipt.writeReceipt(orderTransaction);
				String targetSource = "receipt.txt";
				FileWriter writeReceipt = new FileWriter (targetSource );
				writeReceipt.write(receiptdata);
				writeReceipt.flush();
				writeReceipt.close();
				JOptionPane.showMessageDialog(mm1, "Card Credit Valid");
			}
			else if(result == false)
			{
				JOptionPane.showMessageDialog(mm1, "Card Credit In-Valid");
			}
			
			
			
			
		}
	}
	}

