//: interfaces/interfaceprocessor/SwapPair.java

package interfaces.interfaceprocessor;
public class SwapPair extends StringProcessor{
	public String process(Object input){
		String s = input.toString();
		if(s.length()<2)
			return s;
		return s.charAt(1) +""+ s.charAt(0) + process(s.substring(2));
	}
}
