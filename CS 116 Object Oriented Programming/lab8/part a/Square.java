public class Square extends GeometricFigure {

	public Square() {
		
		super();
	}
	
	public Square(int h, int w) {
	
		super(h, w);
	}
	
	public double area() {
		
		return (double) height * width;
	}
	
	public String toString() {
	
		return "Square: \n" + super.toString();
	}
}
