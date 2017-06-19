//: atul/javaAssignments/PingHost.java

import java.net.*;
import java.util.*;
public class PingHost {
	static Long currentTime(){
		return System.currentTimeMillis();
	}
	static Long medianTime(ArrayList<Long> times){
		Collections.sort(times, Collections.reverseOrder());
		if(times.size()%2==0)
			return (times.get(times.size()/2)+times.get(times.size()/2-1))/2;
		return times.get(times.size()/2);
	}
	static Long pingMedianTime(String ipAddress, int ipPort, int numberOfPings) throws Exception{
                ArrayList<Long> times = new ArrayList<Long>();
                Long finish = currentTime();
                Long start = currentTime();
		for(int i=0;i<numberOfPings;i++){
			try {
				Socket socket = new Socket();
		                InetAddress inet = InetAddress.getByName(ipAddress);
        	        	SocketAddress remoteSocketAddress = new InetSocketAddress(inet, ipPort);
				start = currentTime();
				socket.connect(remoteSocketAddress,1000);
	       	                finish = currentTime();
				socket.close();
                	        times.add(finish-start);
				Long pingTime = finish - start;
				System.out.println("Ping Successful@" + inet + " " + start + "ms " + finish + "ms " + pingTime + "ms");
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
		}		if(times.size()!=0)
			return medianTime(times);
		return new Long(0);
	}
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Address: ");
		String ipAddress = scanner.nextLine();
		System.out.print("Enter Port: ");
		int ipPort = scanner.nextInt();
		System.out.print("Enter No of Pings: ");
		int numberOfPings = scanner.nextInt();
		System.out.println("Median Ping Time: " + pingMedianTime(ipAddress,ipPort,numberOfPings)+"ms");
	}
}








