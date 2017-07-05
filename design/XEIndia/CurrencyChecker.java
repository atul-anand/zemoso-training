import java.text.*;
public class CurrencyChecker implements Observer {
	private double inr;
	private CurrencyConvertor convertor;
	public CurrencyChecker(CurrencyConvertor convertor, double inr){
		this.convertor = convertor;
		this.inr = inr;
		System.out.println("New observer "+convertor.getID(this));
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
		System.out.println("Observer " + convertor.getID(this) + " INR:" + inr + 
							"\nUSD:" + df.format(inr/(convertor.getUSD())) +
							"\nGBP:" + df.format(inr/(convertor.getGBP())) + 
							"\nEuro:" + df.format(inr/(convertor.getEuro())) + "\n");
	}
}