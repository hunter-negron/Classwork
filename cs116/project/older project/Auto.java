public class Auto {

	private Direction direction;
	private int entryTime;
	private int exitTime;
	private final int id;
	private static int idCounter;
	
	// Constructor
	public Auto(Direction d, int enter) {
	
		// A car is basically a vector. it has a direction and magnitude (1)
		direction = d;
		entryTime = enter;
		id = idCounter++;
	}
	
	// Accessors
	public Direction getDirection() {
	
		return direction;
	}
	
	public int getEntryTime() {
	
		return entryTime;
	}
	
	public int getExitTime() {
	
		return entryTime;
	}
	
	public int getId() {
	
		return id;
	}
	
	// Mutators
	public void setDirection(Direction d) { // Used for turning
		
		direction = d;
	}
	
	public void setExitTime(int exit) { // Can only be called once
	
		exitTime = exit;
	}
}
