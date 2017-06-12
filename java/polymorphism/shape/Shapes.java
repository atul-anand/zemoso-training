//: polymorphism/shape/Shapes.java
import polymorphism.shape.*;

public class Shapes {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	public static void main(String[] args){
		Shape[] s = new Shape[9];
		for(int i=0;i<s.length;i++)
			s[i]=gen.next();
		for(Shape shp : s)
			shp.draw();
	}
} /*Output:
Triangle.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Circle.draw()
*///:~
