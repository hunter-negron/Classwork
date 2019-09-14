class House {

	private int stories = 0;
	private String streetName = "";
	private double footage = 0.0;
	
	// Constructors
	public House() {
		stories = 1;
		streetName = "Main St.";
		footage = 1000.0;
	}
	
	public House(int s, String sn, double f) {
		stories = s;
		streetName = sn;
		footage = f;
	}
	
	// Accessors
	public int getStories() {
		return stories;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public double getFootage() {
		return footage;
	}
	
	// Mutators
	public void setStories(int s) {
		stories = s;
	}
	
	public void setStreetName(String sn) {
		streetName = sn;
	}
	
	public void setFootage(double f) {
		footage = f;
	}
	
	public String toString() {
		return "Number of stories: " + stories + "\n" +
				"Name of street: " + streetName + "\n" +
				"Square footage: " + footage + "\n";
	}
}
