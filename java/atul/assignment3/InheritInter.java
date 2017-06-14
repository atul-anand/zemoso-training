//: atul/assignment3/InheritInter.java
// Extending an interface with inheritance.

package atul.assignment3.inheritinter;

interface First {
	void a();
	void b();
}

interface Second {
	void c();
	void d();
}

interface Third {
	void e();
	void f();
}

interface Inter extends First, Second, Third {
	void g();
}

class Concrete implements Inter{
	public void a() { System.out.println("a()"); }
	public void b() { System.out.println("b()"); }
	public void c() { System.out.println("c()"); }
	public void d() { System.out.println("d()"); }
	public void e() { System.out.println("e()"); }
	public void f() { System.out.println("f()"); }
	public void g() { System.out.println("g()"); }
}

public class InheritInter {
	static void u(First ff) {
		ff.a();
		ff.b();
	}
	static void v(Second ss) {
		ss.c();
		ss.d();
	}
	static void w(Third tt) {
		tt.e();
		tt.f();
	}
	static void x(Inter ii) {
		ii.a();
		ii.b();
		ii.c();
		ii.d();
		ii.e();
		ii.f();
		ii.g();
	}
	public static void main(String[] args) {
		Concrete c = new Concrete();
		u(c);
		v(c);
		w(c);
		x(c);
	}
}/* Output:
a()
b()
c()
d()
e()
f()
a()
b()
c()
d()
e()
f()
g()
*///:~
