public class B extends A {

	public String s;
	
	// Constructors
	public B() {
	
		super();
		s = "";
		System.out.println("Default constructor of B is executing now.");
	}
	
	public B(int first, double second, String third) {
	
		super(first, second);
		s = third;
		System.out.println("Non-default constructor of B is executing now.");
	}
	
	// Accessors
	public String getS() {
		
		return s;
	}
	
	// Mutators
	public void setS(String third) {
	
		s = third;
	}
	
	// Other Methods
	public String toString() {
	
		String str = super.toString();
		str += "s: " + s + "\n";
		return str;
	}
	
	public int m1() {
		
		int i1 = 5 * a + (int) aa;
		System.out.println("m1 implementation of B is executing now.");
		return i1;
	}
}
