public abstract class A {

	public int a;
	public double aa;
	
	// Constructors
	public A() {
	
		a = 0;
		aa = 0.0;
		System.out.println("Default constructor of A is executing now.");
	}
	
	public A(int first, double second) {
	
		a = first;
		aa = second;
		System.out.println("Non-default constructor of A is executing now.");
	}
	
	// Accessors
	public int getA() {
	
		return a;
	}
	
	public double getAa() {
	
		return aa;
	}
	
	// Mutators
	public void setA(int first) {
	
		a = first;
	}
	
	public void setAa(double second) {
	
		aa = second;
	}
	
	// Other Methods
	public String toString() {
	
		String str = "";
		str += "a: " + a + "\n";
		str += "aa: " + aa + "\n";
		return str;
	}
	
	public int m2(char c) {
		
		int x = (int) c;
		System.out.println("m2 of A is executing now.");
		return x;
	}
	
	public int m2(int x1) {
		
		int y = 10 + x1;
		System.out.println("Secornd version of m2 of A is executing now.");
		return y;
	}
	
	public void m3() {
	
		System.out.println("m3 of A is executing now.");
	}
	
	public abstract int m1();
}
