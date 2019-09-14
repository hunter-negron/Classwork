package Traffic.RoadNetwork;

public class TrafficLight {

	// RED -> GREEN -> ORANGE
	private final int RED_START = 0;
	private final int GREEN_START;
	
	private int greenDuration;
	private int orangeDuration;
	private int redDuration;
	private Color currentColor;
	
	private int colorCounter;
	
	// Constructor
	public TrafficLight(int green, int orange, Color startingColor) {
	
		GREEN_START = green + orange; // Because green starts after the red duration
		
		greenDuration = green;
		orangeDuration = orange;
		redDuration = green + orange;
		currentColor = startingColor;
		
		if(startingColor == Color.RED) {
		
			colorCounter = RED_START;
		}
		else {
		
			colorCounter = GREEN_START;
		}
	}
	
	// Accessors
	public int getGreenDuration() {
	
		return greenDuration;
	}
	
	public int getOrangeDuration() {
	
		return orangeDuration;
	}
	
	public int getRedDuration() {
	
		return redDuration;
	}
	
	public Color getCurrentColor() {
		
		return currentColor;
	}
	
	// Mutators
	public void setGreenDuration(int green) {
		
		// Sets the new green duration and updates the red duration
		greenDuration = green;
		redDuration = orangeDuration + greenDuration;
	}
	
	public void setOrangeDuration(int orange) {
		
		// Sets the new orange duration and updates the red duration		
		orangeDuration = orange;
		redDuration = orangeDuration + greenDuration;
	}
	
	// Other methods	
	public void cycle() { // To be called at the start of each tick
	
		colorCounter++;
		
		if(colorCounter > redDuration) {
		
			currentColor = Color.GREEN;
		}
		if(colorCounter > redDuration + greenDuration) {
		
			currentColor = Color.ORANGE;
		}
		if(colorCounter > redDuration + greenDuration + orangeDuration) {
		
			currentColor = Color.RED;
			colorCounter = 0;
		}
	}
}
