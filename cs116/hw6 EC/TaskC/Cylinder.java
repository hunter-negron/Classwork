public class Cylinder extends CircleVolume {

	private double height;
	
	// Constructors
	public Cylinder() {
		
		super();
		height = 0.0;
	}
	
	public Cylinder(double r, double h) {
	
		super(r);
		height = h;
	}
	
	public Cylinder(CircleVolume c, double h) {
	
		super(c.getRadius());
		height = h;
	}
	
	// Accessors
	public double getHeight() {
	
		return height;
	}
	
	// Mutators
	public void setHeight(double h) {
	
		height = h;
	}
	
	// Other Methods
	public double volume() {
	
		return this.area() * height;
	}
	
	public String toString() {
	
		String str = super.toString();
		str += "Height: " + height + "\n";
		str += "Volume: " + volume() + "\n";
		
		return str;
	}
}
