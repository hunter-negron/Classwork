public class Spinner {

	private int arrow;
	private int sections;
	
	public Spinner() {
		arrow = 0;
		sections = 10;
	}
	
	// Theoretically, this should throw an exception if a < 0 or a > n;
	public Spinner(int a, int n) {
		arrow = a;
		sections = n;
	}
	
	public int getArrow() {
		return arrow;
	}
	
	public void setArrow(int a) {
		arrow = a;
	}
	
	public void spin() {
		arrow = (int) (Math.random() * sections); // Random between 0-sections, inclusive
	}
	
	public String toString() {
		return "The arrow points to " + arrow;
	}
	
	public boolean equals(Spinner s) {
		return (this.arrow == s.arrow) && (this.sections == s.sections);
	}
}
