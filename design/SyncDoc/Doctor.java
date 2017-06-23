import java.util.*;
public class Doctor extends Person{
	private static int counter = 0;
	private final int id = counter++;
	private Speciality speciality;
	private Authority authority;
	private Set<Appointment> appointments;
	private Set<Timing> timings;
	public Doctor(Person person, Speciality speciality, Authority authority){
		super(person);
		this.speciality = speciality;
		this.authority = authority;
		this.appointments = new TreeSet<Appointment>(new AppointmentComparator());
		this.timings = new TreeSet<Timing>(new TimingComparator());
	}
	public Speciality getSpeciality() { return this.speciality; }
	public Set<Appointment> getAppointments() { return this.appointments; }
	public void addAppointment(Appointment appointment) { appointments.add(appointment); }
	public void addTiming(Timing timing) {
		Calendar start = (Calendar)timing.getStartTime().clone();
		Calendar end = (Calendar)timing.getEndTime().clone();
		while(start.compareTo(end)<0){
			Calendar newEnd = (Calendar)start.clone();
			newEnd.add(Calendar.MINUTE,15);
			timings.add(new Timing(start,newEnd));
			start.add(Calendar.MINUTE,30);
		}
	}
	public Set<Timing> getTimings() { return timings; }
	public int getID() { return this.id; }
	public Authority getAuthority() { return authority; }
	public void setAuthority(Authority authority) { this.authority = authority; }
	public String toString() {
		return "id: " + getID() + " Dr. " + super.toString()+",Speciality:"+getSpeciality();
	}
}