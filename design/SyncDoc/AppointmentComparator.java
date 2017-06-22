import java.util.*;
public class AppointmentComparator implements Comparator<Appointment> {
	@Override
	public int compare(Appointment a, Appointment b){
		Long aStart = a.getStartTime().getTimeInMillis();
		Long bStart = b.getStartTime().getTimeInMillis();
		return (aStart.compareTo(bStart));
	}
}