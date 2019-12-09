public class BusinessPhone extends Phone {

	protected String extension;
	
	// Constructors
	public BusinessPhone() {
	
		super();
		extension = "0000";
	}
	
	public BusinessPhone(String a, String e, String n, String ex) {
	
		super(a, e, n);
		
		if(ex.length() == 4) {
			
			extension = ex;
		}
		else {
			
			extension = "0000";
		}
	}
	
	public BusinessPhone(Phone p, String ex) {
	
		super(p.getArea(), p.getExchange(), p.getNumber());
		
		if(ex.length() == 4) {
			
			extension = ex;
		}
		else {
			
			extension = "0000";
		}		
	}
	
	// Accessors
	public String getExtension() {
	
		return extension;
	}
	
	// Mutators
	public void setExtension(String ex) {
	
		extension = ex;
	}
	
	// Other Methods
	public String toString() {
	
		return super.toString() + "-" + extension;
	}
}
