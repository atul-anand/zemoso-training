//: atul/assignment5/Regexp.java

package atul.assignment5.regexp;
import java.util.regex.*;

public class RegExp {
	static boolean sentence(String s){
		Pattern pattern = Pattern.compile("[A-Z].*\\.$");
	        Matcher matcher = pattern.matcher(s);
		if(matcher.find())
			return true;
		return false;
	}
	public static void main(String[] args){
		String s1 = "This is life.";
		String s2 = "this is life.";
		String s3 = "This is life";
		String s4 = "this is life";
		System.out.println(sentence(s1));
                System.out.println(sentence(s2));
                System.out.println(sentence(s3));
                System.out.println(sentence(s4));
	}
}/* Output:
true
false
false
false
*///:~
