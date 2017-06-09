//:reusing/12Tree/Tree.java
// Default Constructors.
class Component1 {
	Component1(){
		System.out.println("Component1()");
	}
	void dispose() {
		System.out.println("DisposeComponent1()");
	}
}

class Component2 {
        Component2(){
                System.out.println("Component2()");
        }
	void dispose() {
		System.out.println("DisposeComponent2()");
	}
}

class Component3 {
        Component3(){
                System.out.println("Component3()");
        }
	void dispose() {
		System.out.println("DisposeComponent3()");
	}
}

class Root {
	Component1 c1;
	Component2 c2;
	Component3 c3;
	Root(){
		c1 = new Component1();
		c2 = new Component2();
		c3 = new Component3();
		System.out.println("Root()");
	}
        void dispose() {
		System.out.println("DisposeRoot()");
		c1.dispose();
		c2.dispose();
		c3.dispose();
	}
}

class Stem extends Root {
	Component1 c4;
        Component2 c5;
        Component3 c6;
	Stem(){
                c4 = new Component1();
                c5 = new Component2();
                c6 = new Component3();
		System.out.println("Stem()");
	}
        void dispose() {
		System.out.println("DisposeStem()");
		c4.dispose();
                c5.dispose();
                c6.dispose();
		super.dispose();
	}
}

public class Tree {
	public static void main(String[] args){
		Stem s = new Stem();
		try {
		} finally {
			s.dispose();
		}
	}
}
