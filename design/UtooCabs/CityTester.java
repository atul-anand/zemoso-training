import java.util.*;
public class CityTester{
	public static void main(String[] args){
		CityBuilder LaunchCities = new CityBuilding();
		List<City> cities = new ArrayList<City>();
		cities.add(LaunchCities.launchCity("BLR"));
		cities.add(LaunchCities.launchCity("HYD"));
		cities.add(LaunchCities.launchCity("CHE"));
		for(City city : cities){
			System.out.println(city);
			city.displayRateChart();
		}
	}	
}