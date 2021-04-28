package CreditCardServer;
import java.util.Scanner;

import kioskappException.InvalidCreditCardException;
public class CardVerification {
	// Main Method
	
	public Boolean validateCreditCardNo(String creditCardNo)throws InvalidCreditCardException{
		Boolean status = null;
		if(creditCardNo.length() != 16) {
			status = false;
		 throw new InvalidCreditCardException("Your credit card number must equal to 16!");
			
		}
		else if (creditCardNo.length() == 16)
		{
			status = true;
		}
		
	return status;
	
}
}

 
