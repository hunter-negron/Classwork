public abstract class CircleVolume {

	protected double radius;
	
	// Constructors
	public CircleVolume() {
	
		radius = 0.0;
	}
	
	public CircleVolume(double r) {
	
		radius = r;
	}
	
	public CircleVolume(CircleVolume cv) {
	
		radius = cv.getRadius();
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
	
	public abstract double volume();
}
