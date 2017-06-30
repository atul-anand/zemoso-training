import java.util.*;
public class MakeSubwich{
	public SubwaySub makeSubwich(){
		SubwaySub subwich = new Subwich();
		subwich = new AddBread().addBread(subwich);
		System.out.println();
		subwich = new AddSalads().addSalads(subwich);
		System.out.println();
		subwich = new AddSauces().addSauces(subwich);
		System.out.println();
		subwich = new AddAddOns().addAddons(subwich);
		System.out.println();
		return subwich;
	}
}