public class Transaction{
	private PaymentMode paymentMode;
	private Double amount;
	public Transaction(PaymentMode paymentMode, Double amount){
		this.paymentMode = paymentMode;
		this.amount = amount;
	}
	public PaymentMode getPaymentMode(){
		return paymentMode;
	}
	public Double getAmount(){
		return amount;
	}
	public String toString(){
		return getPaymentMode() + " " + getAmount();
	}
}