public class ElectronicMagazine extends Magazine {

	protected String url;

	// Constructors
	public ElectronicMagazine() {
	
		super();
	}
	
	public ElectronicMagazine(String t, String a, String d, int i, int v, String u) {
	
		super(t, a, d, i, v);
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
	
	//Other Methods
	public String toString() {
	
		String str = super.toString();
		str += "URL: " + url + "\n";
		
		return str;
	}
}
