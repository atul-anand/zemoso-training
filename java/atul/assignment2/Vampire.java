//: atul/assignment2/Vampire.java
// Vampire number: even no of digits formed by multiplying
// pair of numbers containing half the digits. Digits are
// from the original nu on any order. Pair of trailing
// zeroes are not alllowed.

package vampire;
import java.util.*;
import java.lang.Math.*;
import java.lang.ArithmeticException;
public class Vampire {
	static Integer one = new Integer(1);
	static Set<Integer> vamps= new TreeSet<Integer>();
	static void printSet(Set<Integer> set){
		for(int i:set)
			System.out.print(i+" ");
		System.out.println();
	}
	static boolean equalDigits(int i, int j){
		int lenI = (int) Math.log10(i) + 1;
		int lenJ = (int) Math.log10(j) + 1;
		int lenT = (int) Math.log10(i*j) + 1;
		if(lenI+lenJ==lenT&&lenI==lenJ)
			return true;
		return false;
	}
	static boolean checkMapEquality(Map<Integer,Integer> map, Map<Integer,Integer> map2){
		if(map.size()!=map2.size())
			return false;
		System.out.println(map.toString()+" "+map2.toString());
		if(map.toString().equals(map2.toString())){
			return true;
		}
		return false;
	}
	static Map<Integer,Integer> digitsMap(Map<Integer,Integer> map, int i){
		while(i>0){
			Integer intI = new Integer(i%10);
			if(map.get(intI)!=null)
				map.put(intI,new Integer(map.get(i%10)+1));
			else
				map.put(intI,one);
			i=i/10;
		}
		return map;
	}
	static void secondLevel(Map<Integer,Integer> map, int j, int i){
		map = digitsMap(map,j);
		Map<Integer,Integer> map2 = new TreeMap<Integer,Integer>();
		map2 = digitsMap(map2,i*j);
		if(checkMapEquality(map,map2)){
			System.out.println("Vampire Number: ("+i + ","+ j + "):"+(i*j));
			vamps.add(new Integer(i*j));
		}
	}
	static void listVamps(int d) {
		if(d%2!=0)
			return;
		int llim = 1;
		int ulim = (int)Math.sqrt(Math.pow(10,d));
		for(int i=llim;i<ulim;i++){
			Map<Integer,Integer> imap = new TreeMap<Integer,Integer>();
			imap = digitsMap(imap,i);
			for(int j=i;j<ulim;j++)
				if(equalDigits(i,j))
					secondLevel(imap,j,i);
		}
	}
	public static void main(String[] args){
		listVamps(6);
		printSet(vamps);
	}
}


