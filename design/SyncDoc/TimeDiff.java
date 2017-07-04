import java.util.*;
import java.lang.Math.*;
public class TimeDiff {
    //Time Diffference Calculations Begin
    
    static public long getMinutes(Calendar cal1, Calendar cal2) {
        long timeDiffInMilliSec = cal1.getTimeInMillis() - cal2.getTimeInMillis();
        return timeDiffInMilliSec / (60 * 1000); 
    }
    
    static public int getYears(Calendar cal1, Calendar cal2) {
    	int cal1Year = cal1.get(Calendar.YEAR);
    	int cal2Year = cal2.get(Calendar.YEAR);
    	int cal1Day = cal1.get(Calendar.DAY_OF_YEAR);
    	int cal2Day = cal2.get(Calendar.DAY_OF_YEAR);
    	int dayDiff = cal1Day - cal2Day;
    	int yearDiff = cal1Year - cal2Year;
    	int absDayDiff = Math.abs(dayDiff);
    	dayDiff = dayDiff/absDayDiff;
    	if(dayDiff<0)
    		return yearDiff;
    	return yearDiff-1;
    }
}