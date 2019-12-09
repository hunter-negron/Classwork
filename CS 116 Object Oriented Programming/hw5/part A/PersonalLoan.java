public class PersonalLoan extends Loan {

	// Constructors
	public PersonalLoan() {
	
		super();
		interestRate = 0.0;
	}
	
	public PersonalLoan(String ln, double la, int t, double prime) {
	
		super(ln, la, t);
		interestRate = prime + 0.02;
	}
	
	// Mutator
	public void setInterestRate(double prime) {
	
		interestRate = prime + 0.02;
	}
}
