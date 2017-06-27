public abstract class PaymentMode {
	private double amount;
	private String name;
	PaymentMode(){

	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void pay(double amt){
		System.out.println("Amount transacted: " + amt + 
						   "\nMode of Payment: " + getName());
	}
	public double getBalance(){
		return amount;
	}
}