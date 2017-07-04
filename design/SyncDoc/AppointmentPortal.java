import java.util.*;
public class AppointmentPortal extends Populate{
	private Set<Appointment> appoints;
	public AppointmentPortal(){
		appoints = new TreeSet<Appointment>(new TimingComparator());
	}
	public Speciality getSpecialityFromCondition(Condition condition){
		List<Condition> cond = new ArrayList<Condition>(Arrays.asList(Condition.values()));
		List<Speciality> spec = new ArrayList<Speciality>(Arrays.asList(Speciality.values()));
		int i=0;
		while(i<cond.size()){
			if(cond.get(i)==condition)
				break;
			i++;
		}
		return spec.get(i);
	}
	// Select doctor with authority and speciality.
	public Set<Doctor> getDoctors(Speciality speciality, Authority authority){
		Set<Doctor> specialisedDoctors = new TreeSet<Doctor>(new DoctorComparator());
		for(Doctor doc:doctors){
			if(doc.getSpeciality()==speciality&&doc.getAuthority()==authority)
				specialisedDoctors.add(doc);
		}
		return specialisedDoctors;
	}
	// 
	public int getDoctorByID(){
		System.out.print("Enter Doctor's id.");
		String response = "";
		int respons = -1;
		Scanner scanner = new Scanner(System.in);
		if(scanner.hasNextLine())
			response = scanner.nextLine();
		try {
			respons = Integer.parseInt(response);
		} catch (Exception e) {
			System.out.println("Invalid Entry.");
		}
		return respons;
	}
	public void makeAppointment(Patient patient, Authority authority){
		Speciality spec = getSpecialityFromCondition((patient.getCondition()));
		Set<Doctor> specialisedDoctors = getDoctors(spec,authority);
		if(specialisedDoctors.size()==0){
			System.out.println("No doctors available.");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select Doctor to list available appointments.");
		for(Doctor doc : specialisedDoctors){
			System.out.println(doc);
			doc.printTimings();
		}
		int docID = -1;
		while(docID!=-1){
			docID = getDoctorByID();
			if(docID!=-1)
				break;
			System.out.print("Press Q to quit. Any other key to try again.");
			if(scanner.hasNextLine())
				if(scanner.nextLine().equals("Q"))
					return;
		}
		Appointment newAppointment = null;
		for(Doctor doc : doctors)
			if(doc.getID()==docID){
				newAppointment = doc.makeAppointment(patient);
				break;
			}
		if(newAppointment==null){
			System.out.println("Appointment not booked.");
			return;
		}
		appoints.add(newAppointment);
		System.out.println("Appointment for " + newAppointment + " approved.");
	}
	public void printAppointments(){
		for(Appointment appointment : appoints)
			System.out.println(appointment);
	}
	public String toString(){
		return "Welcome to ABC Hospital Appointment Booking Portal.";
	}
}