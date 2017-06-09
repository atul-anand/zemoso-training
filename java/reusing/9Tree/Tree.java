//:reusing/9Tree/Tree.java
// Default Constructors.
class Component1 {
	Component1(){
		System.out.println("Component1()");
	}
}

class Component2 {
        Component2(){
                System.out.println("Component2()");
        }
}

class Component3 {
        Component3(){
                System.out.println("Component3()");
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
}

public class Tree {
	public static void main(String[] args){
		Stem s = new Stem();
	}
}
