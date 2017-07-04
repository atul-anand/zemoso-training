import java.util.*;
public class COD extends PaymentMode {
	private String mobileNumber;
	private String oTP;
	public COD(){
		setName("Cash on delivery");
		mobileNumber = "";
		oTP = "";
	}
	public Transaction pay(){
		Scanner scanner = new Scanner(System.in);
		double amt = 0;
		System.out.print("Enter Mobile Number:");
		if(scanner.hasNextLine())
			mobileNumber = scanner.nextLine();
		System.out.print("Enter One Time Password:");
		if(scanner.hasNextLine())
			oTP = scanner.nextLine();
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