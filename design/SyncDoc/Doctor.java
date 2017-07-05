import java.util.*;
public class Doctor extends Person{
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
	// Making 15 mins time slots for next week.
	public void addAvailableAppoints(Timing timing){
		Calendar start = (Calendar)timing.getStartTime().clone();
		Calendar end = (Calendar)timing.getEndTime().clone();
		while(start.compareTo(end)>0){
			Calendar newEnd = (Calendar)start.clone();
			newEnd.add(Calendar.MINUTE,15);
			availability.add(new Timing(start,newEnd));
			start.add(Calendar.MINUTE,15);
		}
	}
	// Add next week's slot for a particular timing.
	public void addAvailability(Timing timing, int week){
		Calendar start = (Calendar)timing.getStartTime().clone();
		Calendar end = (Calendar)timing.getEndTime().clone();
		start.add(Calendar.WEEK_OF_YEAR,week);
		end.add(Calendar.WEEK_OF_YEAR,week);
		addAvailableAppoints(new Timing(start,end));
	}
	// Add next week's timing.
	public void extendTiming(int week) {
		for(Timing timing : timings)
			addAvailability(timing,week);
	}
	// Should be automatically called on sundays to populate next week's availabilities.
	public void addTiming(Timing timing){
		// int week = timing.getStartTime().get(Calendar.WEEK_OF_YEAR);
		addTiming(timing,1);
	}
	// week no of weeks from 1st Jan 2017 to populate that particular week's availabilities.
	public void addTiming(Timing timing, int week) {
		timings.add(timing);
		addAvailability(timing,week);
	}
	// Check availability in particular time range.
	public boolean availability(Timing timing){
		for(Timing time : availability)
			if(Timing.getStartHrMin(time)>=Timing.getStartHrMin(timing)&&Timing.getEndHrMin(time)<=Timing.getEndHrMin(timing))
				return true;
		return false;
	}
	// Print the weekly timings.
	public void printTimings(){
		for(Timing timing : timings)
			if(availability(timing))
				System.out.println(timing);
	}
	// Book appointment.
	public Appointment book(Patient patient){
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
	// Remove a particular timing of doctor in case he'll stop visiting for that timing.
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
	public Set<Timing> getAvailability(){ return availability; }
	public Authority getAuthority() { return authority; }
	public void setAuthority(Authority authority) { this.authority = authority; }
	public String toString() {
		return "id: " + getID() + " Dr. " + super.toString()+", Speciality: "+getSpeciality() + ", Authority: " + getAuthority();
	}
}