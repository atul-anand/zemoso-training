import java.util.*;
public class Wallets extends PaymentMode {
	private String wallet;
	private String mobileNumber;
	public Wallets(){
		setName("Wallets");
	}
	public Transaction pay(){
		Scanner scanner = new Scanner(System.in);
		double amt = 0;
		System.out.print("Enter Type of Wallet:");
		if(scanner.hasNextLine())
			wallet = scanner.nextLine();
		System.out.print("Enter Mobile Number:");
		if(scanner.hasNextLine())
			mobileNumber = scanner.nextLine();
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