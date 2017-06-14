//: atul/assignment/codes/Singleton.java
/** Verify Java's default initialization.
* @author Atul Anand
*/
package atul.assignment.singleton;

public class Singleton {
	private String s;
	public static Singleton setString(String st) {
		Singleton str = new Singleton();
		str.s = st;
		return str;
	}
	public void printString(){
		System.out.println(s);
	}
}
