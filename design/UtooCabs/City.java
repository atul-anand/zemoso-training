import java.util.*;
public class City{
	private List<Cab> cabs;
	private String name;
	public City(){
		cabs = new ArrayList<Cab>();
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void addCab(Cab cab){
		cabs.add(cab);
	}
	public void displayRateChart(){
		for(Cab cab : cabs)
			System.out.println(cab);
	}
	public String toString(){
		return "The city of " + getName();
	}
}