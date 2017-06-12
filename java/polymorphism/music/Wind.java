//: polymorphism/music/Wind.java
package polymorphism.music;
import enumeration.*;

public class Wind extends Instrument {
	public void play(Note n){
		System.out.println("Wind.play() "+n);
	}
}///:~
