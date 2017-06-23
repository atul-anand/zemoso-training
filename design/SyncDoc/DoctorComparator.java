import java.util.*;
public class DoctorComparator implements Comparator<Doctor> {
	@Override
	public int compare(Doctor a, Doctor b){
		int authComp = a.getAuthority().ordinal()>b.getAuthority().ordinal()?a.getAuthority().ordinal():b.getAuthority().ordinal();
		
		return (authComp);
	}
}