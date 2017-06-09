//: reusing/11Cleanser/Detergent.java
// Inheritance syntax & properties.

class Cleanser {
        private String s = "Cleanser";
        public void append(String a) { s+=a; }
        public void dilute() {  }
        public void apply() {  }
        public void scrub() {  }
        public String toString() { return s; }
}

public class Detergent {
	// Change a method:
	private Cleanser cleanser = new Cleanser();
	public void dilute() {
		cleanser.append(" dilute()");
	}
	public void apply() {
		cleanser.append(" apply()");
	}
	public void scrub() {
		cleanser.append(" scrub()");
	}
	public String toString() { return cleanser.toString(); }
	public static void main(String[] args) {
		Detergent x = new Detergent();
		x.dilute();
		x.apply();
		x.scrub();
		System.out.println(x);
	}
}
