import java.util.*;
public class AddBread {
	private String[] breads = {"Multigrain", "Honey Oat", "Roasted Garlic"};
	public SubwaySub addBread(SubwaySub subwich){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select one Bread");
		for(int i=0;i<breads.length;i++)
			System.out.println((i+1)+": " +breads[i] + " ");
		String brd = scanner.nextLine();
		int bread = Character.getNumericValue(brd.charAt(0));
		try{
			System.out.println("Adding " + breads[bread-1]);
		} catch (Exception e){ }
		switch(bread){
			case 1: return new Multigrain(subwich);
			case 2: return new HoneyOat(subwich);
			case 3: return new RoastedGarlic(subwich);
			default: return subwich;
		}
	}
}