public class ElectronicBook extends Book {

	protected String url;

	// Constructors
	public ElectronicBook() {
	
		super();
	}
	
	public ElectronicBook(String t, String a, String d, String u) {
	
		super(t, a, d);
		url = u;
	}
	
	// Accessors
	public String getUrl() {
	
		return url;
	}
	
	// Mutators
	public void setUrl(String u) {
	
		url = u;
	}
	
	// Other Methods
	public String toString() {
	
		String str = super.toString();
		str += "URL: " + url + "\n";
		
		return str;
	}
}
