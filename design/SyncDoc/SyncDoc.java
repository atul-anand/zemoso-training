import java.io.*;
import java.util.*;
public class SyncDoc {
	public static void main(String[] args){
		AppointmentPortal portal = ConstructorOutput.suppress("AppointmentPortal");
		// AppointmentPortal portal1 = new AppointmentPortal();
		List<Patient> patients = portal.getPatients();
		// portal.makeAppointment(patients.get(4),Authority.Senior);
		// portal.makeAppointment(patients.get(4),Authority.Senior);
		portal.makeAppointment(patients.get(2),Authority.Junior);
		// portal.printAppointments();
		// portal.getDoctors().get(0).printTimings();
		// portal.printDoctors();
		// portal.printPatients();
		// portal.printTimings();
		// Doctor doc = portal.getDoctors().get(0);
		// Timing time = new Timing("Wed,12:45 PM","Wed,04:15 PM");
		// System.out.println(doc);
		// doc.addAvailability(time,0);
		// doc.printAvailability();
		// doc.book(patients.get(4));
		// doc.book(patients.get(4));
		// doc.book(patients.get(4));
		// doc.book(patients.get(4));
		
		// portal.printAvailabilities();
	}
}