//: atul/assignment/codes/Main.java
/** Verify Java's default initialization.
* @author Atul Anand
*/
package atul.assignment.main;
import atul.assignment.data.*;
import atul.assignment.singleton.*;
public class Main {
	public static void main(String[] args) {
		Data d = new Data();
		d.printInt();
		d.printChar();
		// Locally defined variables are not initialized by default.
		d.printLocal();
		Singleton s = new Singleton();
		s = s.setString("abc");
		s.printString();

	}
}
