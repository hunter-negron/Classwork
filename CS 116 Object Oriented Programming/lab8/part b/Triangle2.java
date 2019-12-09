public class Triangle2 extends GeometricFigure2 implements SidedObject {

	public Triangle2() {
		
		super();
	}
	
	public Triangle2(int h, int w) {
	
		super(h, w);
	}
	
	public double area() {
		
		return ((double) height) * ((double) width) * .5;
	}
	
	public void displaySides() {
	
		System.out.println(3);
	}
	
	public String toString() {
	
		return "Triangle: \n" + super.toString();
	}
}
