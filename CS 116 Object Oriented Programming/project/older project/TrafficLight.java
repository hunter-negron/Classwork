public class TrafficLight {

	// RED -> GREEN -> ORANGE
	private final int RED_START = 0;
	private final int GREEN_START;
	
	private int greenDuration;
	private int orangeDuration;
	private int redDuration;
	private TrafficColor currentColor;
	
	private int colorCounter;
	
	// Constructor
	public TrafficLight(int green, int orange, TrafficColor startingColor) {
	
		GREEN_START = green + orange;
		
		greenDuration = green;
		orangeDuration = orange;
		redDuration = green + orange;
		currentColor = startingColor;
		
		if(startingColor == TrafficColor.LIGHT_RED) {
		
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
	
	public TrafficColor getCurrentColor() {
		
		return currentColor;
	}
	
	// Mutators
	public void setGreenDuration(int green) {
		
		greenDuration = green;
		redDuration = orangeDuration + greenDuration;
	}
	
	public void setOrangeDuration(int orange) {
		
		orangeDuration = orange;
		redDuration = orangeDuration + greenDuration;
	}
	
	// Other methods
	
	public void cycle() { // To be called at the start of each tick
	
		colorCounter++;
		
		if(colorCounter > redDuration) {
		
			currentColor = TrafficColor.LIGHT_GREEN;
		}
		if(colorCounter > redDuration + greenDuration) {
		
			currentColor = TrafficColor.LIGHT_ORANGE;
		}
		if(colorCounter > redDuration + greenDuration + orangeDuration) {
		
			currentColor = TrafficColor.LIGHT_RED;
			colorCounter = 0;
		}
	}
}
