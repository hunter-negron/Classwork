package Traffic.RoadNetwork;

public class NormalBlock extends Block {
	
	// Constructor
	public NormalBlock(Direction d, int no) {
			
		super(BlockType.NORMAL, d, no);
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
	
		// If the next block is empty, move the car from here to there
		// Return true if the car maved, false if otherwise
		if(next.getAuto() == null) {
		
			next.setAuto(this.getAuto());
			this.setAuto(null);
			return true;
		}
	
		return false;	
	}
}