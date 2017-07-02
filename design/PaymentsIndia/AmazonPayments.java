import java.util.*;
public class AmazonPayments {
	public static void main(String[] args){
		PaymentPortal portal = new PaymentPortal();
		portal.addUser(new User("abcdef"));
		portal.addUser("abc");
		portal.addUser("efgh","ijkl");
		portal.transact();
		portal.transact();
		portal.transact();
		portal.transact();
		portal.printTransactions();
		System.out.println("Total Amount Transacted: " + portal.getBalance());
	}
}