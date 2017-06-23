import java.util.*;
public class TimingComparator implements Comparator<Timing> {
	@Override
	public int compare(Timing a, Timing b){
		Long aStart = a.getStartTime().getTimeInMillis();
		Long bStart = b.getStartTime().getTimeInMillis();
		return (aStart.compareTo(bStart));
	}
}