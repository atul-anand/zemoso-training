import java.util.*;
public class SyncDoc {
	public static void main(String[] args){
		AppointmentPortal portal = new AppointmentPortal();
		List<Patient> patients = portal.getPatients();
		portal.makeAppointment(patients.get(4),Authority.Senior);
		portal.makeAppointment(patients.get(2),Authority.Junior);
		portal.printAppointments();WG
	}
}