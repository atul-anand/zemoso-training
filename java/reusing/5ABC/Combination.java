//:reusing/5ABC/Combination.java
// Using Inheritance and Composition in one program.

class A {
	A(){
		System.out.println("A()");
	}
}

class B {
        B(){
                System.out.println("B()");
        }
}

class C extends A{
	B b = new B();
}

public class Combination {
	public static void main(String[] args){
		C c = new C();
	}
} /* Output:
A()
B()
Inheritance happens before composition.
Base Class is initialized before Derived Class
*///:~
