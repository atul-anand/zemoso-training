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
	static public Timing getNextTime(Timing timing){
		Calendar start = timing.getStartTime();
		Calendar end = timing.getEndTime();
		start.add(Calendar.MINUTE,30);
		return new Timing(end,start);
	}
	static public Calendar getNextSunday(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		while(cal.get(Calendar.DAY_OF_WEEK)!=1)
			cal.add(Calendar.DAY_OF_WEEK,1);
		return cal;
	}
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