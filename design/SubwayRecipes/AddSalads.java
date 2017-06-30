import java.util.*;
public class AddSalads {
	private String[] salads = {"Paneer Tikka", "Chicken Ham", "Subway Club"};
	private SubwaySub addSalad(SubwaySub subwich, int salad){
		switch(salad){
			case 1: return new PaneerTikka(subwich);
			case 2: return new ChickenHam(subwich);
			case 3: return new SubwayClub(subwich);
			default: return subwich;
		}
	}
	public SubwaySub addSalads(SubwaySub subwich){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select any no of Salads separated by spaces");
		for(int i=0;i<salads.length;i++)
			System.out.println((i+1)+": " +salads[i] + " ");
		String sld = scanner.nextLine();
		String[] salad = sld.split(" ");
		for(String sal : salad){
			int sald = Character.getNumericValue(sal.charAt(0));
			try {
				System.out.println("Adding " + salads[sald-1]);
			} catch (Exception e) {} 
			subwich = addSalad(subwich,sald);
		}
		return subwich;
	}
}