import java.util.*;
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
	static public Long getStartMillis(Timing timing){
		return timing.getStartTime().getTimeInMillis();
	}
	static public Long getEndMillis(Timing timing){
		return timing.getEndTime().getTimeInMillis();
	}
	
	public String toString() { 
		return "From "+start.toString()+" to "+end.toString(); 
	}
}