import java.text.*;
public abstract class Cab {
	private String type;
	private String name;
	private Double rate;
	Seats seats;
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Double getRate() { return rate; }
	public void setRate(Double rate) { this.rate = rate; }
	abstract void makeCab();
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return getType() + ": The " + getName() + " manages to sit " + seats + " and charges Rs." + df.format(rate) + " per km.";
	}
}