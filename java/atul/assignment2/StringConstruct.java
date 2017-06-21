//: atul/assignment2/StringConstruct.java

package stringconstruct;
public class StringConstruct {
	StringConstruct(String s){
		System.out.println(s);
	}
	public static void main(String[] args){
		StringConstruct[] arr = new StringConstruct[10];
		for(int i=0;i<arr.length;i++){
			arr[i]=new StringConstruct("abc"+i);
		}
	}
}/* Answer:
Constructor calls are not printed just by creating references.
Initialization requires individual calls for object creation.
Constructor is called at the time of initialization using new.
*///:~

