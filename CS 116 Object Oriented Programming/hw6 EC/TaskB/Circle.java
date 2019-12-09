public class Circle {

	protected double radius;
	
	// Constructors
	public Circle() {
	
		radius = 0.0;
	}
	
	public Circle(double r) {
	
		radius = r;
	}
	
	// Accessor
	public double getRadius() {
	
		return radius;
	}
	
	// Mutator
	public void setRadius(double r) {
	
		radius = r;
	}
	
	// Other Methods
	public double circumference() {
	
		return 2.0 * Math.PI * radius;
	}
	
	public double area() {
	
		return Math.PI * radius * radius;
	}
	
	public String toString() {
	
		String str = "";
		str += "Radius: " + radius + "\n";
		str += "Circumference: " + circumference() + "\n";
		str += "Area: " + area() + "\n";
		
		return str;
	}
}
