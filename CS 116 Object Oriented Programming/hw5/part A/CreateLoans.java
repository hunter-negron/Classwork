import java.util.*;

public class CreateLoans {

	public static void main(String[] args) {
	
		Loan[] loans = new Loan[5];
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Current prime interest rate as decimal: ");
		double prime = Double.valueOf(scan.nextLine());
				
		for(int i = 0; i < 5; i++) {
			
			System.out.println("Loan type (b/p): ");
			String loanType = scan.nextLine();
			
			if(loanType.equals("b") || loanType.equals("B")) {
			
				System.out.println("Last name: ");
				String ln = scan.nextLine();
				System.out.println("Loan amount: ");
				double la = Double.valueOf(scan.nextLine());
				System.out.println("Term: ");
				int t = Integer.valueOf(scan.nextLine());
				
				loans[i] = new BusinessLoan(ln, la, t, prime);
			}
			else if(loanType.equals("p") || loanType.equals("P")) {
			
				System.out.println("Last name: ");
				String ln = scan.nextLine();
				System.out.println("Loan amount: ");
				double la = Double.valueOf(scan.nextLine());
				System.out.println("Term: ");
				int t = Integer.valueOf(scan.nextLine());
			
				loans[i] = new PersonalLoan(ln, la, t, prime);
			}
			else {
			
				System.out.println("Not a valid type.");
				break;
			}
		}
		
		for(int i = 0; i < 5; i++) {
		
			if(loans[i] != null) {
				
				System.out.println(loans[i]);
			}
		}
	}
}
