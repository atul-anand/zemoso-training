import java.util.*;
public class Timing {
	private Calendar start;
	private Calendar end;
	public Timing(Timing timing){
		start = timing.getStartTime();
		end = timing.getEndTime();
	}
	public Timing(String start, String end){
		this.start = new TimingObject(start).getTiming();
		this.end = new TimingObject(end).getTiming();
	}
	public Timing(Calendar start, Calendar end){
		this.start = start;
		this.end = end;
	}
	public Calendar getStartTime() { return this.start; }
	public Calendar getEndTime() { return this.end; }
	public void setStartTime(Calendar start) { this.start = start; }
	public void setEndTime(Calendar end) { this.end = end; }	
	
	public String toString() { 
		return "From "+start.toString()+" to "+end.toString(); 
	}
}