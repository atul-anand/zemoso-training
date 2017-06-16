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
	public static void except(char a) throws MyExceptionA, MyExceptionB, MyExceptionC {
		switch(a){
			case 'A':throw new MyExceptionA("Exception in A");
			case 'B':throw new MyExceptionB("Exception in B");
			case 'C':throw new MyExceptionC("Exception in C");
		}
	}
	public static void main(String[] args) {
		try {
			except('A');
			except('B');
			except('C');
		} catch (MyExceptionA | MyExceptionB | MyExceptionC e) {
			e.printStackTrace(System.out);
		} finally {
			System.out.println("Cleaning Up!");
		}
	}
}/* Output:
atul.assignment4.excep.MyExceptionA: MyExceptionA Exception in A
	at atul.assignment4.excep.Excep.A(Excep.java:30)
	at atul.assignment4.excep.Excep.main(Excep.java:37)
Cleaning Up!
*///:~
