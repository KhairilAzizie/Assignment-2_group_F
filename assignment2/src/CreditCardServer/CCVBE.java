package CreditCardServer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import kioskapp.ordertransaction.OrderTransaction;


public class CCVBE {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		int portNo = 9998;
		ServerSocket s = new ServerSocket(portNo);
		
		
			
		CCVSERVER frame = new CCVSERVER();
		CardVerification cv = new CardVerification();
		frame.setVisible(true);
		OrderTransaction orderTransaction = null;
		
		while(true) {
			try {

				Socket ss = s.accept();
				//open an inputStream to read orderTransaction that send by order server
				DataInputStream inputStream = new DataInputStream(ss.getInputStream());
				
				String creditCardNo = inputStream.readUTF();
				
//				System.out.print(38);
//				System.out.print(creditCardNo);
				
				frame.updateRequest(creditCardNo);
				Boolean status = cv.validateCreditCardNo(creditCardNo);
				if(status == true)
				{
					//set last 4 digit
					int L4 = Integer.parseInt(creditCardNo.substring(creditCardNo.length() - 4));
					
					//open output stream to order server
					Socket creditCard_order = new Socket(InetAddress.getLocalHost(),9997);
					DataOutputStream OS = new DataOutputStream(creditCard_order.getOutputStream());
					OS.writeBoolean(status);
					OS.writeInt(L4);
				}
				else if(status == false)
				{
					Socket creditCard_order = new Socket(InetAddress.getLocalHost(),9997);
					DataOutputStream OS = new DataOutputStream(creditCard_order.getOutputStream());
					OS.writeBoolean(status);
					OS.writeInt(404);
				}


			
			}

			catch(Exception ex)
			{
			
			}

		}
	}
}
