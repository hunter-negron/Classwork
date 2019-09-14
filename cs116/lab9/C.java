public class C extends A {

	public double c;
	
	// Constructors
	public C() {
	
		super();
		c = 0.0;
		System.out.println("Default constructor of C is executing now.");
	}
	
	public C(int first, double second, double third) {
	
		super(first, second);
		c = third;		
		System.out.println("Non-default constructor of C is executing now.");
	}
	
	// Accessors
	public double getC() {
		
		return c;
	}
	
	// Mutators
	public void setC(double third) {
	
		c = third;
	}
	
	// Other Methods
	public String toString() {
	
		String str = super.toString();
		str += "c: " + c + "\n";
		return str;
	}
	
	public int m1() {
	
		int i2 = a + (int) (c / 2);
		System.out.println("m1 implementation of C is executing now.");
		return i2;
	}
}
