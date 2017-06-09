//: object/TestObj.java
/**
* Verify Java's default initialization.
* Test program to check above using exercise1 object.
* @author Atul Anand
* @version 1.0
* @since 2017-06-07
*/
public class TestObj {
	/**
	* @param args Ununsed.
	* @return Nothing.
	*/
	public static void main(String[] args){
		obj e = new obj();
		System.out.println(e.num);
		System.out.println("A"+e.ch+"B");
	}
} /* Output: (100% match)
0
AB
*///:~
