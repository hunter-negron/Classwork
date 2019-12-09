package Traffic.RoadNetwork;

public class TrafficBlock extends Block {

	private TrafficLight light; // Just like a normal block, except this one has a traffic light
		
	// Constructor
	public TrafficBlock(Direction d, int no, TrafficLight l) {
		
		super(BlockType.TRAFFIC, d, no);
		light = l;
	}
		
	// Accessor
	public TrafficLight getLight() {
	
		return light;
	}
	
	// Mutator
	public void setLight(TrafficLight l) {
	
		light = l;
	}
		
	// Other methods
	public void setNeighbors(Block[] neighbors) {
		
		setPrev(neighbors[0]);
		setNext(neighbors[1]);		
	}
		
	public boolean moveForward() {
	
		if(vehicle == null) {
		
			return false;
		}
	
		// If the next block is empty and the light is not red, move the car from here to there
		// Return true if the car maved, false if otherwise
		if(next.getAuto() == null && light.getCurrentColor() != Color.RED) {
		
			next.setAuto(this.getAuto());
			this.setAuto(null);
			return true;
		}
		
		return false;		
	}
}
