//: atul/javaAssignments/KYC.java

import java.util.*;
import java.text.*;
import java.lang.Math.*;
public class KYC {
	static Long currentTimeDifference(Calendar cal){
		Calendar cur = Calendar.getInstance();
		Long curTime = cur.getTimeInMillis();
                return Math.abs(cal.getTimeInMillis()-curTime);
        }
	static Long minimumOfThree(Long a, Long b, Long c){
		return Math.min(a,Math.min(b,c));
	}
	static void printDate(Calendar cal, String s){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print(dateFormat.format(cal.getTime())+s);
	}
	static Date editYearToClosest(Calendar ani){
		Long aniTime = currentTimeDifference(ani);
		Calendar prevAni = (Calendar)ani.clone();
		prevAni.add(Calendar.YEAR,-1);
		Long prevAniTime = currentTimeDifference(prevAni);
		Calendar nextAni = (Calendar)ani.clone();
                nextAni.add(Calendar.YEAR,1);
                Long nextAniTime = currentTimeDifference(nextAni);
/*		printDate(prevAni," ");
		System.out.println(prevAniTime);
		printDate(ani," ");
		System.out.println(aniTime);
		printDate(nextAni," ");
		System.out.println(nextAniTime);
*/		if(prevAniTime.equals(minimumOfThree(prevAniTime,aniTime,nextAniTime)))
			return prevAni.getTime();
		if(nextAniTime.equals(minimumOfThree(prevAniTime,aniTime,nextAniTime)))
			return nextAni.getTime();
		return ani.getTime();
	}
	static void allowableDates(String str){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date signUp = new Date();
		try {
			signUp = dateFormat.parse(str);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		Calendar anniversary = Calendar.getInstance();
		anniversary.setTime(signUp);
		// anniversary in current year.
		anniversary.set(Calendar.YEAR,Calendar.getInstance().get(Calendar.YEAR));
		// closest anniversary among previous, current and next anniversary.
		Date aniDate = editYearToClosest(anniversary);
		anniversary.setTime(aniDate);
		// 30 days before closest anniversary.
		anniversary.add(Calendar.DATE,-30);
		printDate(anniversary,"");
		System.out.print(" - ");
		// 30 days after closest anniversary.
		anniversary.add(Calendar.DATE,60);
		printDate(anniversary,"\n");
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("Enter Signup Date (DD/MM/YYYY): ");
			String str = scanner.nextLine();
			if(str.equals("exit"))
				break;
			allowableDates(str);
		}
	}
}
