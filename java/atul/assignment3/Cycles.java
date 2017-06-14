//: atul/assignment3/Cycles.java

package atul.assignment3.cycle;
class Cycle {
	public String toString(){
		return "Cycle";
	}
}

class Unicycle extends Cycle {
	public void balance() {
		System.out.println(this+".balance()");
	}
	public String toString(){
		return "Unicyle";
	}
}

class Bicycle extends Cycle {
	public void balance() {
                System.out.println(this+".balance()");
        }
	public String toString(){
		return "Bicycle";
	}
}

class Tricycle extends Cycle {
	public String toString(){
		return "Tricycle";
	}
}

public class Cycles {
	public static void main(String[] args){
		Cycle[] c = new Cycle[3];
		c[0] = new Unicycle();
		c[1] = new Bicycle();
		c[2] = new Tricycle();
		// Cycle does not have balance method.
		//!c[0].balance();
		//!c[1].balance();
		//!c[2].balance();
		((Unicycle)c[0]).balance();
		((Bicycle)c[1]).balance();
		// Tricycle does not have balance method.
		//!((Tricycle)c[2]).balance();
	}
}/* Output:
Unicyle.balance()
Bicycle.balance()
*///:~



