import java.util.*;
public class AddSauces {
	private String[] sauces = {"Mayonnaise", "Honey Mustard", "Sweet Onion"};
	private SubwaySub addSauce(SubwaySub subwich, int sauce){
		switch(sauce){
			case 1: return new Mayonnaise(subwich);
			case 2: return new HoneyMustard(subwich);
			case 3: return new SweetOnion(subwich);
			default: return subwich;
		}
	}
	public SubwaySub addSauces(SubwaySub subwich){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select any no of Sauces separated by spaces");
		for(int i=0;i<sauces.length;i++)
			System.out.println((i+1)+": " +sauces[i] + " ");
		String suc = scanner.nextLine();
		String[] sauce = suc.split(" ");
		for(String sau : sauce){
			int sauc = Character.getNumericValue(sau.charAt(0));
			try{
				System.out.println("Adding " + sauces[sauc-1]);
			} catch (Exception e) {} 
			subwich = addSauce(subwich,sauc);
		}
		return subwich;
	}
}