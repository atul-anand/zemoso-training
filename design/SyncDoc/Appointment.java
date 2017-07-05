import java.util.*;
public class Appointment extends Timing{
	private Patient patient;
	private Doctor doctor;
	public Appointment(Patient patient, Doctor doctor, String start, String end){
		super(start,end);
		this.patient = patient;
		this.doctor = doctor;
	}
	public Appointment(Patient patient, Doctor doctor, Calendar start, Calendar end){
		super(start,end);
		this.patient = patient;
		this.doctor = doctor;
	}
	public Appointment(Patient patient, Doctor doctor, Timing timing){
		super(timing);
		this.patient = patient;
		this.doctor = doctor;
	}
	public Patient getPatient() { return this.patient; }
	public Doctor getDoctor() { return this.doctor; }
	public String toString() { 
		return patient.getProperName()+" with Dr. " + doctor.getProperName() + " from "+getStartTime().getTime()+" to "+getEndTime().getTime(); 
	}
}