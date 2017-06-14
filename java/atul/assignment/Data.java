//: atul/assignment/codes/Data.java
/** Verify Java's default initialization.
* @author Atul Anand
*/
package atul.assignment.data;

public class Data {
	private int num;
	private char ch;
	public void printInt() { System.out.println(num); }
	public void printChar() { System.out.println(ch); }
	public void printLocal() {
		int i;
		char j;
		// Variable i,j might not have been initialized.
		// Default Constructor can only initialize data members
		// It can't deal with local variables defined separately.
		//!System.out.println(i);
		//!System.out.println(j);
	}
}
