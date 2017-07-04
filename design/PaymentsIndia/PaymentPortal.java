import java.util.*;
public class PaymentPortal{
	private List<User> users;
	private List<Transaction> transactions;
	public PaymentPortal(){
		users = new ArrayList<User>();
		transactions = new ArrayList<Transaction>();
	}
	public void addUser(User user){
		users.add(user);
	}
	public void addUser(String username){
		users.add(new User(username));
	}
	public void addUser(String username, String password){
		users.add(new User(username,password));
	}
	public void removeUser(String username){
		User user = findUsername(username);
		if(user==null){
			System.out.println("User does not exist.");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		String password = "";
		System.out.println("Confirm Password: ");
		if(scanner.hasNextLine()){
			password = scanner.nextLine();
			if(!checkPassword(user,password)){
				System.out.println("Incorrect Password, Try again!");
				return;
			}
		}
		int index = users.indexOf(user);
		users.remove(index);
	}
	public PaymentMode makeMode(String paymentType){
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
	public void pay(){
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("Enter Mode of Payment(CC/DC/W/NB/COD):");
			PaymentMode paymentMode = null;
			if(scanner.hasNextLine()){
				String modeType = scanner.nextLine();
				if(modeType.equals("")){
					System.out.println();
					return;
				}
				paymentMode = makeMode(modeType);
			}
			transactions.add(paymentMode.pay());
			System.out.println("Transaction approved using " + paymentMode + " for " + transactions.get(transactions.size()-1).getAmount());
		}
	}
	public void transact(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter username: ");
		User user = null;
		String username="";
		if(scanner.hasNextLine())
			username = scanner.nextLine();
		user = findUsername(username);
		if(user==null){
			System.out.println("Username does not exist!");
			return;
		}
		System.out.print("Enter password: ");
		String password="";
		if(scanner.hasNextLine())
			password = scanner.nextLine();
		if(!checkPassword(user,password)){
			System.out.println("Incorrect Password, Try paying again!");
			return;
		}
		pay();
	}
	public User findUsername(String username){
		for(User user : users){
			if(user.getUsername().equals(username))
				return user;
		}
		return null;
	}
	public boolean checkPassword(User user, String password){
		if(user.getPassword().equals(password))
			return true;
		return false;
	}
	public void printTransactions(){
		for(User user : users){
			System.out.println("Username: " + user.getUsername());
			user.printTransactions();
		}
	}
	public String toString(){
		return "Amazon Payments";
	}
}