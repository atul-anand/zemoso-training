//: reusing/8noArg/noArg.java
// Experimenting no-Arg and arg constructors.
class base {
	int i;
	base(int i){
		this.i=i;
		System.out.println("baseClass "+i);
	}
	public String toString(){
		return Integer.toString(i);
	}
}

class derived extends base{
	derived(){
		super(4);
		System.out.println("derivedClass");
	}
	derived(int i){
		super(i);
		System.out.println("derivedClass "+i);
	}
}

public class noArg {
	public static void main(String[] args){
		derived d = new derived();
		System.out.println(d);
		derived c = new derived(45);
		System.out.println(c);
	}
}/* Output:
baseClass 4
derivedClass
4
baseClass 45
derivedClass 45
45
*///:~
