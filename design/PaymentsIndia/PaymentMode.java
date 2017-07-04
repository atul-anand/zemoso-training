public abstract class PaymentMode {
	private String name;
	private Double amtTrans;
	public void setName(String name){
		this.name = name;
		amtTrans = 0.0;
	}
	public String getName(){
		return name;
	}
	public String toString(){
		return getName();
	}
	public void addAmount(Double amount){
		amtTrans+=amount;
	}
	public abstract Transaction pay();
}