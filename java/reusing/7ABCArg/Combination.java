//:reusing/7ABCArg/Combination.java
// Using Inheritance and Composition in one program.

class A {
	A(int i){
		System.out.println("A("+i+")");
	}
}

class B {
        B(int i){
                System.out.println("B("+i+")");
        }
}

class C extends A{
	B b;
	C(int i, int j){
	//	super(i);
		b = new B(j);
		System.out.println("C("+i+","+j+")");
	}
}

public class Combination {
	public static void main(String[] args){
		C c = new C(56,47);
	}
} /* Output:
A(56)
B(47)
Compile time error if different no of arguments are passed as
no default constructor will initialize any variable.
*///:~
