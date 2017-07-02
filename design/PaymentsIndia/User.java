import java.util.*;
public class User{
	private String username;
	private String password;
	private Double balance;
	private List<Transaction> transactions;
	public User(String username){
		this.username = username;
		password = "12345678";
		balance = 0.0;
		transactions = new ArrayList<Transaction>();
	}
	public User(String username, String password){
		this(username);
		this.password = password;
	}
	public String getUsername(){
		return username;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}
	public Double getBalance(){
		return balance;
	}
	public Double makePayment(){
		Transaction transaction = null;
		try{
			transaction = Payment.pay();
		} catch (Exception e){}
		if(transaction!=null){
			transactions.add(transaction);
			balance+=transaction.getAmount();
			return transaction.getAmount();
		}
		return 0.0;
	}
	public void addTransaction(PaymentMode paymentMode, Double amount){
		Transaction transaction = new Transaction(paymentMode,amount);
		transactions.add(transaction);
	}
	public void printTransactions(){
		if(transactions.size()==0){
			System.out.println("No transactions for this user.");
			return;
		}
		for(Transaction transaction : transactions)
			System.out.println(transaction);
	}
	public String toString(){
		return getUsername() + " " + getBalance();
	}
}