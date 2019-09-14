public class NormalBlock extends Block {
		
	// Constructor
	public NormalBlock(int no) {
			
		super(BlockType.BLOCK_NORMAL, no);
	}
		
	// Other methods
	public void setNeighbors(Block[] neighbors) {
		
		setPrev(neighbors[0]);
		setNext(neighbors[1]);
	}
		
	public boolean moveForward() {
	
		if(next.getAuto() == null) {
		
			next.setAuto(this.getAuto());
			this.setAuto(null);
			return true;
		}
	
		return false;	
	}
}
