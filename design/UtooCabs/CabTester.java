public class CabTester{
	public static void main(String[] args){
		CabBuilder BuildCabs = new CabBuilding();
		Cab sedan1 = BuildCabs.orderCab("Sedan","Honda City");
		System.out.println(sedan1);
	}
}