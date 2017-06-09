//: polymorphism/cycle/Handler.java

class Cycle {
	public void ride(){
		System.out.println(this);
	}
	public String toString(){
		return "Cycle";
	}
}

class Unicycle extends Cycle {
	public String toString(){
		return "Unicyle";
	}
}

class Bicycle extends Cycle {
	public String toString(){
		return "Bicycle";
	}
}

class Tricycle extends Cycle {
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



