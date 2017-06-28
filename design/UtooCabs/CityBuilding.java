public class CityBuilding extends CityBuilder {
	protected City populateCabs(String name){
		CabBuilder BuildCabs = new CabBuilding();
		City newCity = new City();
		if(name.equals("BLR")){
			newCity.addCab(BuildCabs.orderCab("Sedan","Honda City"));
			newCity.addCab(BuildCabs.orderCab("SUV","Mahindra XUV"));
			newCity.addCab(BuildCabs.orderCab("Micro","Hyundai Eon"));
			newCity.addCab(BuildCabs.orderCab("Mini","Tata Indica"));
			newCity.setName("Bangalore");
		} else if(name.equals("HYD")){
			newCity.addCab(BuildCabs.orderCab("SUV","Mahindra XUV"));
			newCity.addCab(BuildCabs.orderCab("Micro","Hyundai Eon"));
			newCity.addCab(BuildCabs.orderCab("Mini","Tata Indica"));
			newCity.setName("Hyderabad");
		} else if(name.equals("CHE")){
			newCity.addCab(BuildCabs.orderCab("Sedan","Honda City"));
			newCity.addCab(BuildCabs.orderCab("Micro","Hyundai Eon"));
			newCity.addCab(BuildCabs.orderCab("Mini","Tata Indica"));
			newCity.setName("Chennai");
		}
		return newCity;
	}
}