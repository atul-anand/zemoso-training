public class PaymentFactory{
	public PaymentMode makePaymentMode(String paymentType){
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
}