public class Square2 extends GeometricFigure2 implements SidedObject {

	public Square2() {
		
		super();
	}
	
	public Square2(int h, int w) {
	
		super(h, w);
	}
	
	public double area() {
		
		return (double) height * width;
	}
	
	public void displaySides() {
	
		System.out.println(4);
	}
	
	public String toString() {
	
		return "Square: \n" + super.toString();
	}
}
