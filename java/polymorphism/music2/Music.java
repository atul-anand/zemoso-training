//: polymorphism/music3/Music.java
// An extensible program.
package polymorphism.music2;
import enumeration.Note;
import java.util.*;

class Instrument {
	void play(Note n) { System.out.println("Instrument.play() " + n); }
	String what() { return "Instrument"; }
	void adjust() { System.out.println("Adjusting Instrument"); }
	public String toString() { return what(); }
}
class Wind extends Instrument {
	void play(Note n) { System.out.println("Wind.play() " + n); }
	String what() { return "Wind"; }
	void adjust() { System.out.println("Adjusting Wind"); }
}
class Percussion extends Instrument {
	void play(Note n) { System.out.println("Percussion.play() " + n); }
	String what() { return "Percussion"; }
	void adjust() { System.out.println("Adjusting Percussion"); }
}
class Stringed extends Instrument {
	void play(Note n) { System.out.println("Stringed.play() " + n); }
	String what() { return "Stringed"; }
	void adjust() { System.out.println("Adjusting Stringed"); }
}
class Brass extends Wind {
	void play(Note n) { System.out.println("Brass.play() " + n); }
	void adjust() { System.out.println("Adjusting Brass"); }
}
class Woodwind extends Wind {
	void play(Note n) { System.out.println("Woodwind.play() " + n); }
	String what() { return "Woodwind"; }
}
class Guitar extends Stringed {
	void play(Note n) { System.out.println("Guitar.play() " + n); }
	String what() { return "Guitar"; }
	void adjust() { System.out.println("Adjusting Guitar"); }
}
class RandomShapeGenerator {
	private Random rand = new Random(47);
	public Instrument next(){
		switch(rand.nextInt(6)){
			default:
			case 0: return new Guitar();
			case 1:	return new Woodwind();
			case 2:	return new Brass();
			case 3:	return new Wind();
			case 4: return new Stringed();
			case 5: return new Percussion();
		}
	}
}
public class Music {
	// Doesn’t care about type, so new types
	// added to the system still work right:
	public static void tune(Instrument i) {
		// ...
		i.play(Note.MIDDLE_C);
	}
	public static void tuneAll(Instrument[] e) {
		for(Instrument i : e)
		tune(i);
	}
	public static void main(String[] args) {
		// Upcasting during addition to the array:
		Instrument[] orchestra = {
			new Wind(),
			new Percussion(),
			new Stringed(),
			new Brass(),
			new Woodwind(),
			new Guitar()
		};
		tuneAll(orchestra);
		for (Instrument o : orchestra){
			System.out.println(o);
		}
		RandomShapeGenerator gen = new RandomShapeGenerator();
		Instrument[] band = new Instrument[10];
		for (int i=0;i<band.length;i++)
			band[i]=gen.next();
		for (Instrument i : band){
			System.out.println(i.what() + " " + i);
		}
	}
}/* Output:
Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C
*///:~
