//: atul/assignment/Vampire.java
// Vampire number: even no of digits formed by multiplying
// pair of numbers containing half the digits. Digits are
// from the original nu on any order. Pair of trailing
// zeroes are not alllowed.

package atul.assignment.vampire;
import java.lang.Math.*;
import java.lang.ArithmeticException;
public class Vampire {
	static void listVamps(int d) {
		if(d%2!=0)
			return;
		int llim = (int)Math.pow(10,d/2);
		int ulim = (int)Math.pow(10,d);
		for(int i=llim;i<ulim;i++)
			for(int j=i;j<ulim;j++){
				if((i*j)%(ulim/10)==0)
					continue;
				try {
					if((i*j)%(llim/10-1)==(i+j))
						System.out.println(i*j+"="+i+"*"+j);
				} catch (ArithmeticException e){

				}
			}
	}
	public static void main(String[] args){
		listVamps(1);
		listVamps(2);
		listVamps(3);
		listVamps(4);
	}
}


