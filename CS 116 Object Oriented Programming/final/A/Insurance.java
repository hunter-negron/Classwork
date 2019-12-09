import java.util.*;

public abstract class Insurance {

	protected int policyId;
	protected String name;
	protected int age;
	protected String policyType;
	protected int cost;
	
	private static int idCounter;
	
	// Constructors
	public Insurance() {
	
		policyId = idCounter;
		idCounter++;
		name = "";
		age = 0;
		policyType = "";
		cost = 0;
	}
	
	public Insurance(String n, int a, String t, int c) {
	
		policyId = idCounter++;
		name = n;
		age = a;
		policyType = t;
		cost = c;
	}
	
	// Accessors
	public int getPolicyID() {
	
		return policyId;
	}
	
	public String getName() {
	
		return name;
	}
	
	public int getAge() {
	
		return age;
	}
	
	public String getType() {
	
		return policyType;
	}
	
	public int getCost() {
	
		return cost;
	}
	
	// Mutators
	public void setPolicyID(int id) {
	
		policyId = id;
	}
	
	public void setName(String n) {
	
		name = n;
	}
	
	public void setAge(int a) {
	
		age = a;
	}
	
	public void setType(String t) {
	
		policyType = t;
	}
	
	// Other Methods
	public abstract void setCost();
}
