package gui;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;

public class kitchenBE {

	public static void main(String[] args) throws IOException, IOException, ClassNotFoundException {
		Socket s = new Socket("localhost",9990);
		ObjectInputStream input = new ObjectInputStream(s.getInputStream());
		ArrayList<OrderedItem> orderItem = (ArrayList<OrderedItem>) input.readObject();	
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kitchen frame = new kitchen();
					frame.setVisible(true);
					
					frame.printOrderedItem(orderItem);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	

}
}
