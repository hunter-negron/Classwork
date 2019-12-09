public abstract class Block { 

	private BlockType type; // 0:normal, 1:intersection, 2:traffic-light
	private int blockNo;
	private Auto vehicle; // object of the vehicle occupying the block
	private Block prev; // previous block on the lane
	private Block next; // the next block on the lane
	private boolean processedFlag; // flag for indicate whether the block has been processed during current tick of the simulation
		
	// Constructor
	public Block(BlockType t, int no) {
	
		this.setType(t);
		this.setBlockNo(no);
	}
	
	// Accessors
	public BlockType getType() {
	
		return this.type;
	}
	
	public int getBlockNo() {
	
		return this.blockNo;
	}
	
	public Auto getAuto() {
	
		return this.vehicle;
	}
	
	public Block getPrev() {
	
		return this.prev;
	}
	
	public Block getNext() {
	
		return this.next;
	}
	
	// Mutators
	public void setType(BlockType t) {
	
		this.type = t;
	}
	
	public void setBlockNo(int no) {
	
		this.blockNo = no;
	}
	
	public void setAuto(Auto v) {
	
		this.vehicle = v;
	}
	
	public void setPrev(Block prevBlock) {
	
		this.prev = prevBlock;			
	}
	
	public void setNext(Block nextBlock) {
	
		this.next = nextBlock;			
	}
	
	// Other methods
	public abstract void setNeighbors(Block[] neighbors); // Initialization to set the road network
	
	public abstract boolean moveForward(); // method to move the vehicle to the next place in the road
}
