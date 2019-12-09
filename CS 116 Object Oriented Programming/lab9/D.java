public class D extends C {

	public String str;
	
	// Constructors
	public D() {
	
		super();
		str = "";
		System.out.println("Default constructor of D is executing now.");
	}
	
	public D(int first, double second, double third, String fourth) {
	
		super(first, second, third);
		str = fourth;
		System.out.println("Non-default constructor of D is executing now.");
	}
	
	// Accessors
	public String getStr() {
		
		return str;
	}
	
	// Mutators
	public void setStr(String fourth) {
	
		str = fourth;
	}
	
	// Other Methods
	public String toString() {
	
		String string = super.toString();
		string += "str: " + str + "\n";
		return string;
	}
	
	public void m3() {
	
		super.m3();
		System.out.println("I am executing m3 as implemented in class D.");
	}
	
	public int m2(char c) {
	
		int returnVal;
	
		if(c == 'e') {
		
			int x = super.m2(c);
			System.out.println("The m2(char c) version of D is executing now with return value = " + x);
			returnVal = x;
		}
		else {
		
			int x = super.m2(100);
			System.out.println("The m2(int x1) version of D is executing now with return value = " + x);
			returnVal = x;
		}
		
		return returnVal;
	}
}
