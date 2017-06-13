//: interfaces/multiple/HorrorShow.java
// Extending an interface with inheritance.

interface first {
	void a();
	void b();
}

interface second {
	void c();
	void d();
}

interface third {
	void e();
	void f();
}

interface inherit implements first, second, third {

}

