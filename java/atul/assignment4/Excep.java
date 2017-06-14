//: atul/assignment4/Excep.java
package atul.assignment4.excep;
class MyExceptionA extends Exception {
	public MyExceptionA() {}
	public MyExceptionA(String msg) { super(msg); }
	public String getMessage() {
		return "MyExceptionA "+super.getMessage();
	}
}

class MyExceptionB extends Exception {
        public MyExceptionB() {}
        public MyExceptionB(String msg) { super(msg); }
	public String getMessage() {
                return "MyExceptionB "+super.getMessage();
        }
}

class MyExceptionC extends Exception {
        public MyExceptionC() {}
        public MyExceptionC(String msg) { super(msg); }
	public String getMessage() {
                return "MyExceptionC "+super.getMessage();
        }
}

public class Excep {
	public static void A() throws MyExceptionA {
		throw new MyExceptionA("Exception in A");
	}
	public static void B() throws MyExceptionB {
		throw new MyExceptionB("Exception in B");
	}
	public static void C() throws MyExceptionC {
		throw new MyExceptionC("Exception in C");
	}
	public static void main(String[] args) {
		try {
			A();
			B();
			C();
		} catch (MyExceptionA | MyExceptionB | MyExceptionC e) {
			e.printStackTrace(System.out);
		} finally {
			System.out.println("Cleaning Up!");
		}
	}
}/* Output:
atul.assignment4.excep.MyExceptionA: MyExceptionA Exception in A
	at atul.assignment4.excep.Excep.A(Excep.java:29)
	at atul.assignment4.excep.Excep.main(Excep.java:39)
Cleaning Up!
*///:~
