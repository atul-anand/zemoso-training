import java.util.*;
public class Appointment {
	private Patient patient;
	private Doctor doctor;
	private Calendar start;
	private Calendar end;
	public Appointment(Patient patient, Doctor doctor, Calendar start){
		this.patient = patient;
		this.doctor = doctor;
		this.start = start;
		start.add(Calendar.HOUR,1);
		this.end = start;
	}
	public Calendar getStartTime() { return this.start; }
	public Calendar getEndTime() { return this.end; }
	public Patient getPatient() { return this.patient; }
	public Doctor getDoctor() { return this.doctor; }
	public void setStartTime(Calendar start) { this.start = start; }
	public String toString() { 
		return patient.toString()+" with " + doctor.toString() + " from "+start.toString()+" to "+end.toString(); 
	}
}