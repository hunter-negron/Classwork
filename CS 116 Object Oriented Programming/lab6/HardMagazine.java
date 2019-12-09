public class HardMagazine extends Magazine {

	protected String edition;

	// Constructors
	public HardMagazine() {
	
		super();
	}
	
	public HardMagazine(String t, String a, String d, int i, int v, String e) {
	
		super(t, a, d, i, v);
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
		str += "Editon: " + edition + "\n";
		
		return str;
	}
}
