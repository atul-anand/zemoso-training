import java.io.*;
import java.lang.*;
public class ConstructorOutput{
	static public <Any> Any suppress(String className){
		PrintStream originalStream = System.out;
		PrintStream dummyStream    = new PrintStream(new OutputStream(){
		    public void write(int b) {
        		//NO-OP
			}
		});
		System.setOut(dummyStream);	
		Any o = null;
		try{
			Class<?> c1 = Class.forName(className);
			// Constructor<?> cons = c1.getConstructor();
			o = c1.newInstance();
		} catch (Exception e){}
		System.setOut(originalStream);
		return o;
	}
}