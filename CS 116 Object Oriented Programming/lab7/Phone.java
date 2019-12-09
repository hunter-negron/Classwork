public class Phone {

	protected String areaCode;
	protected String exchange;
	protected String   number;
	
	// Constructors
	public Phone() {
	
		areaCode = "000";
		exchange = "000";
		number = "0000";
	}
	
	public Phone(String a, String e, String n) {
	
		if(a.length() == 3 && Character.getNumericValue(a.charAt(0)) > 1) {
		
			areaCode = a;
		}
		else {
		
			areaCode = "000";
		}
		
		if(e.length() == 3 && Character.getNumericValue(e.charAt(0)) > 1) {
		
			exchange = e;
		}
		else {
		
			exchange = "000";
		}
		
		if(n.length() == 4) {
		
			number = n;
		}
		else {
		
			number = "0000";
		}
	}
	
	// Accessors
	public String getArea() {
	
		return areaCode;
	}
	
	public String getExchange() {
	
		return exchange;
	}
	
	public String getNumber() {
	
		return number;
	}
	
	// Mutators
	public void setArea(String a) {
	
		areaCode = a;
	}
	
	public void setExchange(String e) {
	
		exchange = e;
	}
	
	public void setNumber(String n) {
	
		number = n;
	}
	
	// Other Methods
	public String toString() {
	
		return ("(" + areaCode + ") " + exchange + "-" + number);
	}
}
