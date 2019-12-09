public class TrafficBlock extends Block {

	private TrafficLight light;
		
	// Constructor
	public TrafficBlock(int no, TrafficColor startingColor, int green, int orange) {
		
		super(BlockType.BLOCK_TRAFFIC, no);
		light = new TrafficLight(green, orange, startingColor);
	}
	
	public TrafficBlock(int no, TrafficLight l) {
		
		super(BlockType.BLOCK_TRAFFIC, no);
		light = l;
	}
		
	// Accessors
	public TrafficLight getLight() {
	
		return light;
	}
	
	// Mutators
	public void setLight(TrafficLight l) {
	
		light = l;
	}
		
	// Other methods
	public void setNeighbors(Block[] neighbors) {
		
		setPrev(neighbors[0]);
		setNext(neighbors[1]);		
	}
		
	public boolean moveForward() {
	
		if(next.getAuto() == null && light.getCurrentColor() != TrafficColor.LIGHT_RED) {
		
			next.setAuto(this.getAuto());
			this.setAuto(null);
			return true;
		}
	
		return false;
	
		return false;		
	}
}
