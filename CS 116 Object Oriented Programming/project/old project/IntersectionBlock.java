package Traffic.RoadNetwork;

public class IntersectionBlock extends Block {

	private Block[] prev;
	private Block[] next;
	private Direction[] directions;
	private double turnRate;
		
	// Constructor
	public IntersectionBlock(Direction[] d, double tr, int no) {
		
		// Intersection blocks have 4 neighbors instead of 2		
		super(BlockType.INTERSECTION, d[0], no);
			
		next = new Block[2];
		prev = new Block[2];
		directions = d;
		turnRate = tr;
	}
	
	// Accessors
	public Block getPrev() {
	
		return prev[0];
	}
	
	public Block getNext() {
	
		return next[0];
	}
	
	public double getTurnRate() {
	
		return turnRate;
	}
	
	// Mutators
	public void setPrev(Block[] prevBlocks) {
	
		prev[0] = prevBlocks[0];
		prev[1] = prevBlocks[1];
	}
	
	public void setNext(Block[] nextBlocks) {
	
		next[0] = nextBlocks[0];
		next[1] = nextBlocks[1];
	}
	
	public void setTurnRate(double tr) {
	
		turnRate = tr;
	}
		
	// Other methods
	public void setNeighbors(Block[] neighbors) {
		
		prev[0] = neighbors[0];
		prev[1] = neighbors[1];
		next[0] = neighbors[2];
		next[1] = neighbors[3];
	}
		
	public boolean moveForward() {
	
		if(vehicle == null) {
		
			return false;
		}
	
		if(Math.random() < turnRate) { // YES Turn
		
			if(vehicle.getDirection() == next[0].getDirection() && next[1].getAuto() == null) {
			
				vehicle.setEndDirection(next[1].getDirection());
				next[1].setAuto(vehicle);
				vehicle = null;
			}
			else {
			
				vehicle.setEndDirection(next[1].getDirection());
				next[0].setAuto(vehicle);
				vehicle = null;
			}
		}
		else { // NO Turn
		
			if(vehicle.getDirection() == next[0].getDirection() && next[0].getAuto() == null) {
			
				next[0].setAuto(vehicle);
				vehicle = null;
			}
			else {
			
				next[1].setAuto(vehicle);
				vehicle = null;
			}
		}
	
		return false;
	}
}
