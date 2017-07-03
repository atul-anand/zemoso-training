import java.util.*;
public class DoctorComparator implements Comparator<Doctor> {
	@Override
	public int compare(Doctor a, Doctor b){
		Integer aNext = a.getSpeciality().ordinal();
		Integer bNext = a.getSpeciality().ordinal();
		return aNext.compareTo(bNext);
	}
}