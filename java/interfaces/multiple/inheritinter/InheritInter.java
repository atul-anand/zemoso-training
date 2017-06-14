//: interfaces/multiple/InheritInter.java
// Extending an interface with inheritance.

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
	public void a() {}
	public void b() {}
	public void c() {}
	public void d() {}
	public void e() {}
	public void f() {}
	public void g() {}
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
}

