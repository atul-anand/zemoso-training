//: polymorphism/cycle/Handler.java

class Cycle {
	protected int wheel;
	public void ride(){
		System.out.println(this + " " + wheels());
	}
	public int wheels(){
		return wheel;
	}
	public String toString(){
		return "Cycle";
	}
}

class Unicycle extends Cycle {
	Unicycle() {
		wheel = 1;
	}
	public String toString(){
		return "Unicyle";
	}
}

class Bicycle extends Cycle {
        Bicycle() {
                wheel = 2;
        }
	public String toString(){
		return "Bicycle";
	}
}

class Tricycle extends Cycle {
        Tricycle() {
                wheel = 3;
        }
	public String toString(){
		return "Tricycle";
	}
}

public class Handler {
	public static void move(Cycle c){
		c.ride();
	}
	public static void main(String[] args){
		Cycle c = new Cycle();
		Unicycle u = new Unicycle();
		Bicycle b = new Bicycle();
		Tricycle t = new Tricycle();
		move(c);
		move(u);
		move(b);
		move(t);
		c.ride();
		u.ride();
		b.ride();
		t.ride();
	}
}/* Output:
Cycle
Unicyle
Bicycle
Tricycle
Cycle
Unicyle
Bicycle
Tricycle
*///:~



