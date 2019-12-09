public class Triangle extends GeometricFigure {

	public Triangle() {
		
		super();
	}
	
	public Triangle(int h, int w) {
	
		super(h, w);
	}
	
	public double area() {
		
		return ((double) height) * ((double) width) * .5;
	}
	
	public String toString() {
	
		return "Triangle: \n" + super.toString();
	}
}
