import java.util.*;
import java.io.File;
import java.io.IOException;

class UseInsurance {

	static ArrayList<InsuranceGroup> groups;

	public static void main(String[] args) {		
	// arg[0]: text file  containing the policy information		
				
		Scanner scan;
		String str;
		groups = new ArrayList<InsuranceGroup>();
		groups.add(new InsuranceGroup());
		
		try {
		
			File myFile = new File(args[0]);
            scan = new Scanner(myFile); // each line has the format 
			
			// name;age;policy-type{Health or Life}
			while(scan.hasNextLine()) {
			
				str = scan.nextLine();		
				String[] tok = str.split(";");
				String name = tok[0]; // name of the policy holder
				int age = Integer.parseInt(tok[1]); // age of the policy holder
				String type = tok[2]; // type of the insurance values are "Health" or "Life"
				
				if(type.compareTo("Health") == 0) {
					// this is a Health insurance policy
					HealthInsurance hi = new HealthInsurance(name, age, type);
					addToGroup(hi);
				}
				else {
					// this is a Life insurance policy
					LifeInsurance li = new LifeInsurance(name, age, type);
					addToGroup(li);
				}
			}
			
			for(InsuranceGroup g : groups) {
			
				System.out.println(g);
			}
			
			scan.close();
        }
        catch(IOException ioe) {
        
			System.out.println("The file can not be read");
		}		
	}
	
	public static void addToGroup(Insurance policy) {
	
		for(int i = 0; i < groups.size(); i++) {
		
			if(groups.get(i).addPolicy(policy)) {
			
				return; // If there is an available group, add the policy to it and return
			}
		}
		
		// No available group found, so create a new one and add the poliy to it
		groups.add(new InsuranceGroup());
		groups.get(groups.size() - 1).addPolicy(policy);
	}
}
