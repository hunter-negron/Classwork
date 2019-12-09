public class LifeInsurance extends Insurance {

	// Constructors
	public LifeInsurance() {
	
		super();
	}
	
	public LifeInsurance(String n, int a, String t) {
	
		super(n, a, t, 40);
	}
	
	// Mutator
	public void setCost() {
	
		cost = 40;
	}
}
