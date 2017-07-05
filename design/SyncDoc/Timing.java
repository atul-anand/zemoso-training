import java.util.*;
import java.text.*;
public class Timing {
	private Calendar start;
	private Calendar end;
	public Timing(String start, String end){
		this.start = new TimingObject(start).getTiming();
		this.end = new TimingObject(end).getTiming();
	}
	public Timing(Calendar start, Calendar end){
		this.start = start;
		this.end = end;
	}
	public Timing(Timing timing){

	}
	public Calendar getStartTime() { return this.start; }
	public Calendar getEndTime() { return this.end; }
	public void setStartTime(Calendar start) { this.start = start; }
	public void setEndTime(Calendar end) { this.end = end; }	
	static public int getStartHrMin(Timing timing){
		return timing.getStartTime().get(Calendar.HOUR_OF_DAY)+timing.getStartTime().get(Calendar.MINUTE)*60;
	}
	static public int getEndHrMin(Timing timing){
		return timing.getEndTime().get(Calendar.HOUR_OF_DAY)+timing.getEndTime().get(Calendar.MINUTE)*60;
	}
	// public boolean 
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("EEE, hh:mm a");
		return df.format(start.getTime())+" to "+df.format(end.getTime()); 
	}
}