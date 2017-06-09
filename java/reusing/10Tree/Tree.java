//:reusing/10Tree/Tree.java
// Default Constructors.
class Component1 {
	Component1(int i){
		System.out.println("Component1("+i+")");
	}
}

class Component2 {
        Component2(int i){
                System.out.println("Component2("+i+")");
        }
}

class Component3 {
        Component3(int i){
                System.out.println("Component3("+i+")");
        }
}

class Root {
	Component1 c1;
	Component2 c2;
	Component3 c3;
	Root(int i){
		c1 = new Component1(i);
		c2 = new Component2(i);
		c3 = new Component3(i);
		System.out.println("Root("+i+")");
	}
}

class Stem extends Root {
	Component1 c4;
        Component2 c5;
        Component3 c6;
	Stem(int i){
		super(i);
                c4 = new Component1(i);
                c5 = new Component2(i);
                c6 = new Component3(i);
		System.out.println("Stem("+i+")");
	}
}

public class Tree {
	public static void main(String[] args){
		Stem s = new Stem(4);
	}
}
