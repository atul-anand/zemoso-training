import java.util.*;
public class AddAddOns {
	private String[] addons = {"Cheese", "Pickles", "Veggies"};
	private SubwaySub addAddon(SubwaySub subwich, int addon){
		switch(addon){
			case 1: return new Cheese(subwich);
			case 2: return new Pickles(subwich);
			case 3: return new Veggies(subwich);
			default: return subwich;
		}
	}
	public SubwaySub addAddons(SubwaySub subwich){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select any no of Addons separated by spaces");
		for(int i=0;i<addons.length;i++)
			System.out.println((i+1)+": " +addons[i] + " ");
		String add = scanner.nextLine();
		String[] addon = add.split(" ");
		for(String addo : addon){
			int ad = Character.getNumericValue(addo.charAt(0));
			try {
				System.out.println("Adding " + addons[ad-1]);
			} catch (Exception e) {}
			subwich = addAddon(subwich,ad);
		}
		return subwich;
	}
}