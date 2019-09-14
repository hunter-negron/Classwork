public class Newspaper extends Record {

	protected String edition;
	
	// Constructors
	public Newspaper() {
	
		super();
	}
	
	public Newspaper(String t, String a, String d, String e) {
	
		super(t, a, d);
		edition = e;
	}
	
	// Accessors
	public String getEdition() {
	
		return edition;
	}
	
	// Mutators
	public void setEdition(String e) {
	
		edition = e;
	}
	
	// Other Methods
	public String toString() {
	
		String str = super.toString();
		str += "Edition: " + edition + "\n";
		
		return str;
	}
}
