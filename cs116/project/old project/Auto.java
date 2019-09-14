package Traffic.RoadNetwork;

public class Auto {

	private Direction direction;
	private Direction endDirection;
	private int entryTime;
	private int exitTime;
	private final int id;
	private static int idCounter;
	
	// Constructor
	public Auto(Direction d, int enter) {
	
		// A car is basically a vector. it has a direction and magnitude (1)
		direction = d;
		endDirection = d;
		entryTime = enter;
		id = idCounter++;
	}
	
	// Accessors
	public Direction getDirection() {
	
		return direction;
	}
	
	public Direction getEndDirection() {
	
		return endDirection;
	}
	
	public int getEntryTime() {
	
		return entryTime;
	}
	
	public int getExitTime() {
	
		return exitTime;
	}
	
	public int getId() {
	
		return id;
	}
	
	// Mutators
	public void setDirection(Direction d) {
		
		direction = d;
	}
	
	public void setEndDirection(Direction d) {
	
		endDirection = d;
	}
	
	public void setExitTime(int exit) { // Can only be called once
	
		exitTime = exit;
	}
}
