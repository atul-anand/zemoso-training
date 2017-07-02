import java.util.*;
public class PaymentPortal{
	private List<User> users;
	private Double balance;
	public PaymentPortal(){
		users = new ArrayList<User>();
		balance = 0.0;
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
		Double amount = user.makePayment();
		balance+=amount;
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
	public Double getBalance(){
		return balance;
	}
	public String toString(){
		return "Amazon Payments";
	}
}