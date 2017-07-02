import java.util.*;
public class Payment{
	static public Transaction pay(){
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("Enter Mode of Payment(CC/DC/W/NB/COD):");
			PaymentMode paymentMode = null;
			if(scanner.hasNextLine()){
				String modeType = scanner.nextLine();
				if(modeType.equals("")){
					System.out.println();
					return null;
				}
				paymentMode = makePaymentMode(modeType);
			}
			double amt=0;
			if(paymentMode!=null){
				System.out.print("Enter amount to transact:");
				if(scanner.hasNextLine()){
					try {
						amt = Double.parseDouble(scanner.nextLine());
					} catch (Exception e){
						System.out.println("Invalid Amount");
					}
				}
				System.out.println("");
				return new Transaction(paymentMode,amt);
			}
		}
	}
	static public PaymentMode makePaymentMode(String paymentType){
		if(paymentType.equals("DC"))
			return new DebitCard();
		if(paymentType.equals("CC"))
			return new CreditCard();
		if(paymentType.equals("COD"))
			return new COD();
		if(paymentType.equals("W"))
			return new Wallets();
		if(paymentType.equals("NB"))
			return new NetBanking();
		return null;
	}
}