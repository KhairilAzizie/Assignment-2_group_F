package gui;



import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;

public class receipt {
	

	public String writeReceipt(OrderTransaction orderTransaction) {
		
		String receipt = "-------------------------------------------------------"+
						 "\n"+"          	Your Order Reference No is"+"\r\n"+
						 "\r\n		     			";
		// get reference number
		receipt += orderTransaction.getOrder().getOrderReferenceNumber();
		receipt +=	"\r\n"+"-------------------------------------------------------"+
					"\r\n"+"    	Welcome to M Malacca Restaurant"+"\r\n"+
					"\r\n"+"    	Lot 4588 Bandaraya Melaka \r\n"+
					"\r\n                	75450 Melaka"+
					"\r\n              	TEL :  0123456789"+
					"\r\n                	TAX INVOICE"+"\r\n"+
					"\r\nOrder ID : ";
					
		
		// get order id
		receipt += orderTransaction.getOrder().getOrderId();
	    
		// get transaction date
		receipt += "\r\nTime	 : ";
		receipt += orderTransaction.getTransactioDate();
		
		// get order mode 
		receipt += "\r\n";
		receipt += orderTransaction.getOrderMode();
		receipt += "\r\n";

		//product details
		receipt += "\r\n";
		receipt += String.format("%-5s%-40s%-20s","QTY","ITEM","PRICE");
		
		
		//get order details
		for(OrderedItem item : orderTransaction.getOrder().getOrderedItems()) {
			receipt += "\r\n";
			
			receipt += String.format("%-5d%-40sRM %7.2f",item.getQuantity(),
					item.getItemProduct().getName(),item.getSubTotalAmount());
		}
		
		//get total
		receipt += "\r\n";
		receipt += String.format("%44s RM %7.2f","Total",orderTransaction.getAmountCharged());
		

		//credit card last 4 digits
		receipt += "\r\nCredit Card No:**** **** **** ";
		receipt += orderTransaction.getLast4Digits();

		//ending
		 receipt+="\r\n"+"\r\n			Thank You!!Please Come Again!!!"+
				 "\r\n		Customer Service Hotline : 06-2134 214"; 
	
		
		return receipt;
        
  }
	
}

	

