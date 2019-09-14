public class HardBook extends Book {

	protected int edition;

	// Constructors
	public HardBook() {
	
		super();
	}
	
	public HardBook(String t, String a, String d, int e) {
	
		super(t, a, d);
		edition = e;
	}
	
	// Accessors
	public int getEdition() {
	
		return edition;
	}
	
	// Mutators
	public void setEdition(int e) {
	
		edition = e;
	}
	
	// Other Methods
	public String toString() {
	
		String str = super.toString();
		str += "Edition: " + edition + "\n";
		
		return str;
	}
}
