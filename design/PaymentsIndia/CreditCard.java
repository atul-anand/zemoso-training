import java.util.*;
public class CreditCard extends PaymentMode {
	private String cardNumber;
	private int cVV;
	public CreditCard(){
		setName("Credit Card");
		cardNumber = "";
		cVV = 0;
	}
	public Transaction pay(){
		Scanner scanner = new Scanner(System.in);
		double amt = 0;
		System.out.print("Enter Credit Card Number:");
		if(scanner.hasNextLine())
			cardNumber = scanner.nextLine();
		System.out.print("Enter CVV:");
		if(scanner.hasNextLine()){
			String cvv = scanner.nextLine();
			try {
				cVV = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {}
		}		
		System.out.print("Enter amount to transact:");
		if(scanner.hasNextLine()){
			try {
				amt = Double.parseDouble(scanner.nextLine());
			} catch (Exception e){
				System.out.println("Invalid Amount");
			}
		}
		System.out.println("");
		addAmount(amt);
		return new Transaction(this,amt);
	}
}