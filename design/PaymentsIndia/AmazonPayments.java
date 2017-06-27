import java.util.*;
public class AmazonPayments {
	public static void main(String[] args){
		PaymentFactory payments = new PaymentFactory();
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("Enter Mode of Payment(CC/DC/W/NB/COD)(Q to Quit):");
			PaymentMode paymentMode = null;
			if(scanner.hasNextLine()){
				String modeType = scanner.nextLine();
				if(modeType.equals("Q"))
					break;
				paymentMode = payments.makePaymentMode(modeType);
			}
			if(paymentMode!=null){
				System.out.print("Enter amount to transact:");
				if(scanner.hasNextLine()){
					try {
						double amt = Double.parseDouble(scanner.nextLine());
						paymentMode.pay(amt);
					} catch (Exception e){
						System.out.println("Invalid Amount");
					}
				}
			}
			System.out.println("");
		}
	}
}