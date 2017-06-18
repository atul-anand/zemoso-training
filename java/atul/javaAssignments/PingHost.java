//: atul/javaAssignments/PingHost.java

import java.net.*;
import java.util.*;
public class PingHost {
	static Long medianTime(ArrayList<Long> times){
		Collections.sort(times, Collections.reverseOrder());
		if(times.size()%2==0)
			return (times.get(times.size()/2)+times.get(times.size()/2-1))/2;
		return times.get(times.size()/2);
	}
	static Long pingMedianTime(String ipAddress, int numberOfPings) throws Exception{
		InetAddress inet = InetAddress.getByName(ipAddress);
                ArrayList<Long> times = new ArrayList<Long>();
		Calendar cal = new GregorianCalendar();
                Long finish = cal.getTimeInMillis();
                Long start = cal.getTimeInMillis();
		System.out.println(numberOfPings + "  " + start);
		while(numberOfPings>0){
			try {
				start = cal.getTimeInMillis();
			        if(inet.isReachable(5000)) {
	        	                finish = cal.getTimeInMillis();
        	        	        times.add(finish-start);
		                }
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
			System.out.println(inet + " " + start + " " + finish + " " + numberOfPings);
			numberOfPings--;
		}
		System.out.println(numberOfPings);
		if(times.size()!=0)
			return medianTime(times);
		return new Long(0);
	}
	public static void main(String[] args) throws Exception{
		String ipAddress = "192.168.0.1";
		int numberOfPings = 10;
		System.out.println(pingMedianTime(ipAddress,numberOfPings));
	}
}
