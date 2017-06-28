public interface Subject{
	public void add(Observer o);
	public void remove(Observer o);
	public void notifyObserver();
	public double getUSD();
	public double getGBP();
	public double getEuro();
}