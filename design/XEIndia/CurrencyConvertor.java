import java.util.*;
public class CurrencyConvertor implements Subject {
	private List<Observer> observers;
	private double usdRate;
	private double gbpRate;
	private double euroRate;
	public CurrencyConvertor(){
		observers = new ArrayList<Observer>();
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
			observer.update(usdRate,gbpRate,euroRate);
	}
	public void setUSD(double usd){
		this.usdRate = usd;
		notifyObserver();
	}
	public void setGBP(double gbp){
		this.gbpRate = gbp;
		notifyObserver();
	}
	public void setEuro(double euro){
		this.euroRate = euro;
		notifyObserver();
	}
}