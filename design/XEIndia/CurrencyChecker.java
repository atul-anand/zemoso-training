import java.text.*;
public class CurrencyChecker implements Observer {
	private double inr;
	private static int observersCount = 0;
	private final int observerID=++observersCount;
	private Subject currencyConvertor;
	public CurrencyChecker(Subject currencyConvertor, double inr){
		this.currencyConvertor = currencyConvertor;
		this.inr = inr;
		System.out.println("New observer "+this.observerID);
		currencyConvertor.add(this);
	}
	public void update(){
		printRates();
	}
	public void setINR(double inr){
		this.inr = inr;
		update();
	}
	public void printRates(){
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("Observer " + observerID + " INR:" + inr + 
							"\nUSD:" + df.format(inr/(currencyConvertor.getUSD())) +
							"\nGBP:" + df.format(inr/(currencyConvertor.getGBP())) + 
							"\nEuro:" + df.format(inr/(currencyConvertor.getEuro())) + "\n");
	}
}