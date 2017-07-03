import java.util.*;
public class TimingObject {
	private Calendar cal;
	TimingObject(String dayTime){
		cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,2017);
		//Wed,12:00 PM
		//Week starts from Sunday.
		String day = dayTime.split(",")[0];
		switch(day.toUpperCase().substring(0,3)){
			case "SUN" : cal.set(Calendar.DAY_OF_YEAR, 1);
						break;
			case "MON" : cal.set(Calendar.DAY_OF_YEAR, 2);
						break;
			case "TUE" : cal.set(Calendar.DAY_OF_YEAR, 3);
						break;
			case "WED" : cal.set(Calendar.DAY_OF_YEAR, 4);
						break;
			case "THU" : cal.set(Calendar.DAY_OF_YEAR, 5);
						break;
			case "FRI" : cal.set(Calendar.DAY_OF_YEAR, 6);
						break;
			case "SAT" : cal.set(Calendar.DAY_OF_YEAR, 7);
						break;
		}		
		String time = dayTime.split(",")[1];
		String hour = time.split(":")[0];
		String minute = time.split(":")[1].split(" ")[0];
		String ampm = time.split(":")[1].split(" ")[1];
		cal.set(Calendar.HOUR,Integer.parseInt(hour));
		cal.set(Calendar.MINUTE,Integer.parseInt(minute));
		if(ampm.equals("AM"))
			cal.set(Calendar.AM_PM,1);
		else
			cal.set(Calendar.AM_PM,2);
	}
	public Calendar getTiming() { return cal; }
	public String toString() { return cal.toString(); }
}