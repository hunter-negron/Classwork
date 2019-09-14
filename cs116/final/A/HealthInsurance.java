public class HealthInsurance extends Insurance {

	// Constructors
	public HealthInsurance() {
	
		super();
	}
	
	public HealthInsurance(String n, int a, String t) {
	
		super(n, a, t, 180);
	}
	
	// Mutator
	public void setCost() {
	
		cost = 180;
	}
}
