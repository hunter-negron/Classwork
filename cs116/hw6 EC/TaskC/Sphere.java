public class Sphere extends CircleVolume {

	// Constructors
	public Sphere() {
	
		super();
	}
	
	public Sphere(double r) {
	
		super(r);
	}
	
	public Sphere(CircleVolume c) {
	
		super(c.getRadius());
	}
	
	// Other Methods
	public double volume() {
	
		return (4.0 / 3.0) * Math.PI * radius * radius * radius;
	}
	
	public String toString() {
	
		String str = super.toString();
		str += "Volume: " + volume() + "\n";
		
		return str;
	}
}
