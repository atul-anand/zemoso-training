//:reusing/1Lazy/Simple.java
// Lazy Initialization; just before using it.

class First {
	String s;
	public First () {
		System.out.println("Inside First()");
	}
	public void setFirst(String s) {
		this.s = s;
	}
	public String toString(){
		return s;
	}
}

class Second {
	First s;
	public Second() {
		System.out.println("Inside Second()");
	}
	public String toString() {
//		s = new First();
		s.setFirst("Hello");
		return s.toString();
	}
}

public class Simple {
	public static void main(String[] args){
		Second obj = new Second();
		try {
			System.out.println(obj);
		} catch (NullPointerException e) {
			System.out.println(e);
		}
	}
}
