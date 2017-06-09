//:reusing/13Overload/Overload.java
// Method overloading with Inheritance.

class Base {
	void print(Object o){
		System.out.println("func("+o+")");
	}
	void func(char c){
		print(c);
	}
	void func(int i){
		print(i);
	}
	void func(float f){
		print(f);
	}
}

public class Overload extends Base {
	void func(double d){
		print(d);
	}
	public static void main(String[] args){
		Overload o = new Overload();
		o.func(4);
		o.func(0.0f);
		o.func('a');
		o.func(43.65D);
	}
}/* Output:
func(4)
func(0.0)
func(a)
func(43.65)
*///:~
