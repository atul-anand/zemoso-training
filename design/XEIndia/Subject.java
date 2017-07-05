public interface Subject{
	public void add(Observer o);
	public void remove(int index);
	public void notifyObserver();
}