import java.util.*;
public class Doctor extends Person{
	private static int counter = 0;
	private final int id = counter++;
	private Speciality speciality;
	private Authority authority;
	private Set<Appointment> appointments;
	private Set<Timing> availability;
	private Set<Timing> timings;
	public Doctor(Person person, Speciality speciality, Authority authority){
		super(person);
		this.speciality = speciality;
		this.authority = authority;
		this.appointments = new TreeSet<Appointment>(new TimingComparator());
		this.availability = new TreeSet<Timing>(new TimingComparator());
		this.timings = new TreeSet<Timing>(new TimingComparator());
	}
	public void addAvailableAppointments(Timing timing){
		Calendar start = (Calendar)timing.getStartTime().clone();
		Calendar end = (Calendar)timing.getEndTime().clone();
		while(start.compareTo(end)<0){
			Calendar newEnd = (Calendar)start.clone();
			newEnd.add(Calendar.MINUTE,15);
			availability.add(new Timing(start,newEnd));
			start.add(Calendar.MINUTE,30);
		}
	}
	public void addAvailability(Timing timing, int week){
		Calendar start = (Calendar)timing.getStartTime().clone();
		Calendar end = (Calendar)timing.getEndTime().clone();
		start.add(Calendar.WEEK_OF_YEAR,week);
		end.add(Calendar.WEEK_OF_YEAR,week);
		addAvailableAppointments(new Timing(start,end));
	}
	public void extendTiming(int week) {
		for(Timing timing : timings)
			addAvailability(timing,week);
	}
	public void addTiming(Timing timing){
		int week = timing.getStartTime().get(Calendar.WEEK_OF_YEAR);
		addTiming(timing,week+1);
	}
	public void addTiming(Timing timing, int week) {
		timings.add(timing);
		addAvailability(timing,week);
	}
	public boolean availability(Timing timing){
		for(Timing time : availability)
			if(Timing.getStartMillis(time)>=Timing.getStartMillis(timing)&&Timing.getEndMillis(time)<=Timing.getEndMillis(timing))
				return true;
		return false;
	}
	public void printTimings(){
		for(Timing timing : timings)
			if(availability(timing))
				System.out.println(timing);
	}
	public Appointment makeAppointment(Patient patient){
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nAvailable Appointments (Sorted by earliest)");
		Appointment newAppointment = null;
		for(Timing timing : availability){
			System.out.println(timing + " Y to book/Q to quit/any key for next available appointment.");
			String res = "";
			if(scanner.hasNextLine())
				res = scanner.nextLine();
			switch(res){
				case "Y" :  newAppointment = new Appointment(patient,this,timing);
							removeAvailability(timing);
							appointments.add(newAppointment);
							break;
				case "Q" :  break;	
				default  :  continue;
			}
		}
		return newAppointment;
	}
	public void removeAvailability(Timing timing){
		Iterator<Timing> avIter = availability.iterator();
		while(avIter.hasNext()){
			Timing time = avIter.next();
			if(time.equals(timing)){
				avIter.remove();
				return;
			}
		}
	}
	public void printAppointments(){
		for(Appointment appointment : appointments)
			System.out.println(appointment);
	}
	public Speciality getSpeciality(){ return speciality; }
	public Set<Timing> getTimings() { return timings; }
	public int getID() { return this.id; }
	public Authority getAuthority() { return authority; }
	public void setAuthority(Authority authority) { this.authority = authority; }
	public String toString() {
		return "id: " + getID() + " Dr. " + super.toString()+",Speciality:"+getSpeciality();
	}
}