package Traffic.RoadNetwork;

public abstract class Block { 

	protected BlockType type;
	protected Direction direction; // Direction of intended movement for the car
	protected int blockNo;
	
	protected Auto vehicle; // object of the vehicle occupying the block
	protected Block prev; // previous block on the lane
	protected Block next; // the next block on the lane
		
	// Constructor
	public Block(BlockType t, Direction d, int no) {
	
		type = t;
		direction = d;
		blockNo = no;
	}
	
	// Accessors
	public BlockType getType() {
	
		return type;
	}
	
	public Direction getDirection() {
	
		return direction;
	}
	
	public int getBlockNo() {
	
		return blockNo;
	}
	
	public Auto getAuto() {
	
		return vehicle;
	}
	
	public Block getPrev() {
	
		return prev;
	}
	
	public Block getNext() {
	
		return next;
	}
	
	// Mutators
	public void setType(BlockType t) {
	
		type = t;
	}
	
	public void setDirection(Direction d) {
	
		direction = d;
	}
	
	public void setBlockNo(int no) {
	
		blockNo = no;
	}
	
	public void setAuto(Auto v) {
	
		vehicle = v;
	}
	
	public void setPrev(Block prevBlock) {
	
		prev = prevBlock;			
	}
	
	public void setNext(Block nextBlock) {
	
		next = nextBlock;			
	}
	
	// Other methods
	public abstract void setNeighbors(Block[] neighbors); // Initialization to set the road network
	
	public abstract boolean moveForward(); // method to move the vehicle to the next place in the road
}
