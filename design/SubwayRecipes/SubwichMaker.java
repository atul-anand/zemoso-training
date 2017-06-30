public class SubwichMaker {
	public static void main(String[] args){
		SubwaySub subwich = new MakeSubwich().makeSubwich();
		System.out.println(subwich.getDescription());
		System.out.println("Total Cost: " + subwich.getCost());
	}
}