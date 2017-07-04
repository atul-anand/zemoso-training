import java.util.*;
public class NetBanking extends PaymentMode {
	private String username;
	private String password;
	public NetBanking(){
		setName("Net Banking");
		username = "";
		password = "";
	}
	public Transaction pay(){
		Scanner scanner = new Scanner(System.in);
		double amt = 0;
		System.out.print("Enter Net Banking Username:");
		if(scanner.hasNextLine())
			username = scanner.nextLine();
		System.out.print("Enter Net Banking Password:");
		if(scanner.hasNextLine())
			password = scanner.nextLine();
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