import java.text.*;
public class CurrencyChecker implements Observer {
	private double inr;
	private static int observersCount = 0;
	private final int observerID=++observersCount;
	private Subject convertor;
	public CurrencyChecker(Subject convertor, double inr){
		this.convertor = convertor;
		this.inr = inr;
		System.out.println("New observer "+this.observerID);
		convertor.add(this);
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
							"\nUSD:" + df.format(inr/(convertor.getUSD())) +
							"\nGBP:" + df.format(inr/(convertor.getGBP())) + 
							"\nEuro:" + df.format(inr/(convertor.getEuro())) + "\n");
	}
}