public class OvernightPackage extends Package {

	// Constructors
	public OvernightPackage() {
	
		super();
	}
	
	public OvernightPackage(String fa, String ta, float w) {
		
		super(fa, ta, w);
	}
	
	// Other Methods
	public float calculateCharge() {
	
		return super.calculateCharge() + (weight * ChargeConstants.overNightExtraCharge);
	}
	
	public String printReceipt() {
	
		String str = "";
		str += "Receipt for package ID: " + packageId + "\n";
		str += "Type: Overnight\n";
		str += "From: " + fromAddress + "\n";
		str += "To: " + toAddress + "\n";
		str += "Weight: " + weight + "\n";
		str += "Charge: " + calculateCharge() + "\n";
		
		return str;
	}
}
