public abstract class Package implements ChargeConstants {

	protected String fromAddress;
	protected String toAddress;
	protected float weight;
	protected int packageId;
	protected static int idCounter = 10000;
	
	// Constructors
	public Package() {
	
		fromAddress = "";
		toAddress = "";
		weight = 0.0f;
		packageId = idCounter++;
	}
	
	public Package(String fa, String ta, float w) {
	
		fromAddress = fa;
		toAddress = ta;
		weight = w;
		packageId = idCounter++;	
	}
	
	// Accessors
	public int getId() {
	
		return packageId;
	}
	
	public String getFromAddress() {
	
		return fromAddress;
	}
	
	public String getToAddress() {
	
		return toAddress;
	}
	
	public float getWeight() {
	
		return weight;
	}
	
	// Mutators
	public void setId(int newId) {
	
		packageId = newId;
	}
	
	public void setFromAddress(String fa) {
	
		fromAddress = fa;
	}
	
	public void setToAddress(String ta) {
	
		toAddress = ta;
	}
	
	public void setWeight(float w) {
	
		weight = w;
	}
	
	// Other Methods
	public float calculateCharge() {
	
		return weight * ChargeConstants.baseCharge;
	}
	
	public abstract String printReceipt();
}
