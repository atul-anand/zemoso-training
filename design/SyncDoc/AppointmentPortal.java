import java.util.*;
public class AppointmentPortal extends Populate{
	private Set<Appointment> appoints;
	public AppointmentPortal(){
		appoints = new TreeSet<Appointment>(new TimingComparator());
	}
	public Speciality getSpecFromCond(Condition condition){
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
	public boolean checkDoctors(Set<Doctor> docs, int id){
		boolean k=false;
		for(Doctor doc : docs)
			if(doc.getID()==id)
				k=true;
		return k;
	}
	public void makeAppointment(Patient patient, Authority authority){
		System.out.println("Welcome " + patient);
		Speciality spec = getSpecFromCond((patient.getCondition()));
		Set<Doctor> specialisedDoctors = getDoctors(spec,authority);
		if(specialisedDoctors.size()==0){
			System.out.println("No doctors available.");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nSelect Doctor to list available appointments.");
		for(Doctor doc : specialisedDoctors){
			System.out.println(doc);
			doc.printTimings();
		}
		int docID = -1;
		Appointment newAppointment = null;
		loop:while(true){
			System.out.print("\nEnter Doctor's id.");
			String response = "";
			if(scanner.hasNextLine())
				response = scanner.nextLine();
			try {
				docID = Integer.parseInt(response);
			} catch (Exception e) {
				System.out.println("Invalid Entry.");
			}
			if(!checkDoctors(specialisedDoctors,docID)){
				System.out.println("ID not available.");
				break;
			}
			System.out.print("\nPress Y to see listings/Q to quit.");
			if(scanner.hasNextLine())
				switch(scanner.nextLine()){
					case "Y":   for(Doctor doc : doctors)
								if(doc.getID()==docID){
									newAppointment = doc.book(patient);
									break loop;
								}
								break;
					case "Q":   break loop;
				}
		
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