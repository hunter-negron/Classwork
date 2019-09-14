import java.util.*;

public class InsuranceGroup {

	private int groupId;
	private ArrayList<Insurance> policies;
	
	private static int idCounter;
	
	// Constructor
	public InsuranceGroup() {
	
		groupId = idCounter;
		idCounter++;
		policies = new ArrayList<Insurance>();
	}
	
	// Accessors
	public String getGroupID() {
	
		String id = "" + groupId;
		
		while(id.length() < 4) {
		
			id = "0" + id;
		}
		
		return "GR-" + id;
	}
	
	public Insurance getPolicy(int index) {
	
		if(index < policies.size()) {
		
			return policies.get(index);
		}
		else {
		
			return null;
		}
	}
	
	// Mutators
	public void setGroupID(int id) {
	
		groupId = id;
	}
	
	public void setPolicy(int index, Insurance i) {
	
		if(index < policies.size()) {
		
			policies.set(index, i);
		}
	}
	
	// Other Methods
	public boolean addPolicy(Insurance i) {
	
		if(policies.size() < 5 || averageAge() < 45.0) {
		
			policies.add(i);
			return true;
		}
		else {
		
			return false;
		}
	}
	
	public String toString() {
	
		String str = "========================================\n";
		str += "Group ID: " + getGroupID() + "\n";
		str += "Number of Policies: " + policies.size() + "\n";
		str += "Average Age: " + averageAge() + "\n";
		str += "Total Monthly Charges: " + totalMonthlyCharges() + "\n";
		str += "==============================";
		
		return str;
	}
	
	// Private Helper Methods
	private double averageAge() {
	
		if(policies.size() == 0) {
		
			return 0.0;
		}
	
		double avg = 0.0;
		
		for(int i = 0; i < policies.size(); i++) {
		
			avg += (double) policies.get(i).getAge();
		}
		
		avg /= policies.size();
		
		return avg;
	}
	
	private int totalMonthlyCharges() {
	
		int total = 0;
		
		for(int i = 0; i < policies.size(); i++) {
		
			total += policies.get(i).getCost();
		}
		
		return total;
	}
}
