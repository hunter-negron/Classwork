public class Spinner {

	private int arrow;
	
	public Spinner() {
		arrow = 0;
	}
	
	// Theoretically, this should throw an exception if 0 <= a <= 9.
	public Spinner(int a) {
		arrow = a;
	}
	
	public int getArrow() {
		return arrow;
	}
	
	public void setArrow(int a) {
		arrow = a;
	}
	
	public void spin() {
		arrow = (int) (Math.random() * 10); // Random between 0-9, inclusive
	}
	
	public String toString() {
		return "The arrow points to " + arrow;
	}
	
	public boolean equals(Spinner s) {
		return this.arrow == s.arrow;
	}
}
