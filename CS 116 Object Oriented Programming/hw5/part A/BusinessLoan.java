public class BusinessLoan extends Loan {

	// Constructors
	public BusinessLoan() {
	
		super();
		interestRate = 0.0;
	}
	
	public BusinessLoan(String ln, double la, int t, double prime) {
	
		super(ln, la, t);
		interestRate = prime + 0.01;
	}
	
	// Mutator
	public void setInterestRate(double prime) {
	
		interestRate = prime + 0.01; 
	}
}
