public class TwoDayPackage extends Package {

	// Constructors
	public TwoDayPackage() {
		
		super();
	}
	
	public TwoDayPackage(String fa, String ta, float w) {
	
		super(fa, ta, w);
	}
	
	// Other Methods
	public float calculateCharge() {
	
		return super.calculateCharge() + (weight * ChargeConstants.twoDayExtraCharge);
	}
	
	public String printReceipt() {
	
		String str = "";
		str += "Receipt for package ID: " + packageId + "\n";
		str += "Type: Two-Day\n";
		str += "From: " + fromAddress + "\n";
		str += "To: " + toAddress + "\n";
		str += "Weight: " + weight + "\n";
		str += "Charge: " + calculateCharge() + "\n";
		
		return str;	
	}
}
