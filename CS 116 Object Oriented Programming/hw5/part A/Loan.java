public abstract class Loan implements LoanConstants {

	protected final int id;
	protected String lastName;
	protected double loanAmount;
	protected double interestRate;
	protected int term;
	
	private static int idCounter;
	
	// Constructors
	public Loan() {
		
		id = idCounter;
		idCounter++;
		lastName = "";
		loanAmount = 0.0;
		term = 0;
	}
	
	public Loan(String ln, double la, int t) {
		
		id = idCounter;
		idCounter++;
		lastName = ln;
		loanAmount = la > LoanConstants.maxLoan ? LoanConstants.maxLoan : la;
		
		if(t < LoanConstants.mediumTerm) {
		
			term = LoanConstants.shortTerm;
		}
		else if(t < LoanConstants.longTerm) {
		
			term = LoanConstants.mediumTerm;
		}
		else {
		
			term = LoanConstants.longTerm;
		}
	}
	
	// Accesors
	public int getId() {
		
		return id;
	}
	
	public String getLastName() {
	
		return lastName;
	}
	
	public double getLoanAmunt() {
	
		return loanAmount;
	}
	
	public double getInterestRate() {
		
		return interestRate;
	}
	
	public int getTerm() {
	
		return term;
	}
	
	// mutators
	public void setLastName(String ln) {
	
		lastName = ln;
	}
	
	public void setLoanAmount(double la) {
	
		loanAmount = la;
	}
	
	public abstract void setInterestRate(double prime);
	
	public void setTerm(int t) {
	
		term = t;
	}
	
	// Other methods
	public String toString() {
	
		String str = "";
		str += "ID: " + id + "\n";
		str += "Last Name: " + lastName + "\n";
		str += "Loan Amount: " + loanAmount + "\n";
		str += "Interest Rate: " + interestRate + "\n";
		str += "Term: " + term + "\n";
		str += "Amount Owed: " + amountOwed() + "\n";
		
		return str;
	}
	
	public double amountOwed() {
	
		return loanAmount + (loanAmount * interestRate * (double) term);
	}
}
