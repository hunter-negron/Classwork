public class IntersectionBlock extends Block {

	Block[] prev;
	Block[] next;
	Direction[] directions;
		
	// Constructor
	public IntersectionBlock(int no, Direction[] d) {
		
		// Intersection blocks have 4 neighbours instead of 2		
		super(BlockType.BLOCK_INTERSECT, no);
			
		next = new Block[2];
		prev = new Block[2];
		directions = d;
	}
		
	// Other methods
	public void setNeighbors(Block[] neighbors) {
		
		prev[0] = neighbors[0];
		prev[1] = neighbors[1];
		next[0] = neighbors[2];
		next[1] = neighbors[3];
	}
		
	public boolean moveForward() {
	
		// Randomly pick a block from the next array
	
		return false;
	}
}
