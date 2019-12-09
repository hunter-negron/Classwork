public class Magazine extends Record {

	protected int issue;
	protected int volume;
	
	// Constructors
	public Magazine() {
	
		super();
	}
	
	public Magazine(String t, String a, String d, int i, int v) {
	
		super(t, a, d);
		issue = i;
		volume = v;
	}
	
	// Accessors
	public int getIssue() {
	
		return issue;
	}
	
	public int getVolume() {
	
		return volume;
	}
	
	// Mutators
	public void setIssue(int i) {
	
		issue = i;
	}
	
	public void setVolume(int v) {
	
		volume = v;
	}
	
	//Other Methods
	public String toString() {
	
		String str = super.toString();
		str += "Issue: " + issue + "\n";
		str += "volume: " + volume + "\n";
		
		return str;
	}
}
