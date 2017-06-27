import java.text.*;
public class CurrencyChecker implements Observer {
	private double usdRate;
	private double gbpRate;
	private double euroRate;
	private static int observersCount = 0;
	private final int observerID=++observersCount;
	private Subject currencyConvertor;
	public CurrencyChecker(Subject currencyConvertor){
		this.currencyConvertor = currencyConvertor;
		System.out.println("New observer "+this.observerID);
		currencyConvertor.add(this);
	}
	public void update(double usd, double gbp, double euro){
		this.usdRate = usd;
		this.gbpRate = gbp;
		this.euroRate = euro;
		printRates();
	}
	public void printRates(){
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("Observer " + observerID + 
							"\nUSD:" + df.format(usdRate) +
							"\nGBP:" + df.format(gbpRate) + 
							"\nEuro:" + df.format(euroRate) + "\n");
	}
}