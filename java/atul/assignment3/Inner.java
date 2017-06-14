//: atul/assignment3/Inner.java

package atul.assignment3.inner;

class OuterF {
	OuterF() {
		System.out.println("OuterF()");
	}
	class InnerF {
		InnerF(Object a){
			System.out.println("InnerF()");
			System.out.println(a);
		}
	}
	public InnerF getInnerF(Object a) {
		return new InnerF(a);
	}
}

class OuterS {
	OuterS() {
		System.out.println("OuterS()");
	}
	OuterF outf = new OuterF();
	class InnerS extends OuterF.InnerF {
		InnerS(Object a){
			outf.super(a);
			System.out.println("InnerS()");
			System.out.println(a);
		}
	}
	public InnerS getInnerS(Object a) {
		return new InnerS(a);
	}
}

public class Inner {
	public static void main(String[] args){
		OuterF outf = new OuterF();
		OuterF.InnerF innf = outf.getInnerF(12);
		OuterS outs = new OuterS();
		OuterS.InnerS inns = outs.getInnerS(15);
	}
}
