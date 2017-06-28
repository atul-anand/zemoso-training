import java.util.*;
public class CurrencyConvertor implements Subject {
	private List<Observer> observers;
	private double usdRate;
	private double gbpRate;
	private double euroRate;
	public CurrencyConvertor(double usdRate, double gbpRate, double euroRate){
		observers = new ArrayList<Observer>();
		this.usdRate = usdRate;
		this.gbpRate = gbpRate;
		this.euroRate = euroRate;
	}
	public void add(Observer observer){
		observers.add(observer);
	}
	public void remove(Observer observer){
		int index = observers.indexOf(observer);
		System.out.println("Observer "+(index+1)+" removed");
		observers.remove(index);
	}
	public void notifyObserver(){
		for(Observer observer:observers)
			observer.update();
	}
	public void setUSD(double usd){
		this.usdRate = usd;
		notifyObserver();
	}
	public double getUSD(){
		return usdRate;
	}
	public void setGBP(double gbp){
		this.gbpRate = gbp;
		notifyObserver();
	}
	public double getGBP(){
		return gbpRate;
	}
	public void setEuro(double euro){
		this.euroRate = euro;
		notifyObserver();
	}
	public double getEuro(){
		return euroRate;
	}
}