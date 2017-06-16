//: atul/javaAssignments/Alphabets.java

package alphabets;
import java.lang.*;

public class Alphabets {
	static boolean containAllAlphabets(String s){
		boolean[] arr = new boolean[26];
		for(char ch : s.toCharArray()){
			if(Character.isLowerCase(ch))
				arr[(int)ch - (int)'a'] = true;
			else if(Character.isUpperCase(ch))
				arr[(int)ch - (int)'A'] = true;
		}
		for(boolean b : arr)
			if(b==false)
				return false;
		return true;
	}
	public static void main(String[] args){
		String s1 = "The quick brown fox jumps over the lazy dog.";
		String s2 = "Laptops are getting ancient";
		System.out.println(containAllAlphabets(s1));
		System.out.println(containAllAlphabets(s2));
	}
}/* Output:
true
false
*///:~
