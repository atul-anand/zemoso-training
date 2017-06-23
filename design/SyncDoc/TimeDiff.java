import java.util.*;
public class TimeDiff {
    //Time Diffference Calculations Begin
    
    static public long getMinutes(Calendar cal1, Calendar cal2) {
        long timeDiffInMilliSec = cal1.getTimeInMillis() - cal2.getTimeInMillis();
        return timeDiffInMilliSec / (60 * 1000); 
    }
    
}