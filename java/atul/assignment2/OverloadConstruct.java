//: atul/assignment2/OverloadConstruct.java

package atul.assignment2.overloadconstruct;

public class OverloadConstruct {

	OverloadConstruct(){
		System.out.println("first");
	}
	OverloadConstruct(int a){
		this();
		System.out.println("second");
	}
	public static void main(String[] args){
		OverloadConstruct over = new OverloadConstruct(12);
	}
}
