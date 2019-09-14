public class Sudoku {

	private int[][] grid;
	
	public Sudoku() {
	
		grid = new int[9][9];
		
		/*grid = new int[][]{ {2,4,8,3,9,5,7,1,6}, {5,7,1,6,2,8,3,4,9}, {9,3,6,7,4,1,5,8,2}, 
							{6,8,2,5,3,9,1,7,4}, {3,5,9,1,7,4,6,2,8}, {7,1,4,8,6,2,9,5,3}, 
							{8,6,3,4,1,7,2,9,5}, {1,9,5,2,8,6,4,3,7}, {4,2,7,9,5,3,8,6,1}};*/
	}
	
	public void put(int n, int r, int c) {
	
		grid[r][c] = n;
	}
	
	public boolean isValid() {
	
		// Check rows
		for(int i = 0; i < grid.length; i++) {
		
			// Check each row in grid for each number 1-9
			for(int j = 1; j <= 9; j++) {
			
				if(!contains(grid[i], j)) {
				
					return false;
				}
			}
		}
		
		// Check columns
		int[] temp = new int[9];
		int tCount = 0;
		
		for(int m = 0; m < 9; m++) {
				
			for(int i = 0; i < temp.length; i++) {
			
	       		temp[i] = grid[i][m];
	    	}
			
			for(int z = 1; z <= 9; z++) { // Cycle through the temp array, checking for each number 1-9
			
				if(!contains(temp, z)) {
				
					return false;
				}
			}
		}		
		
		return true;
	}
	
	private boolean contains(int[] arr, int n) {
	
		for(int i = 0; i < arr.length; i++) {
		
			if(arr[i] == n) {
			
				return true;
			}
		}
		
		return false;
	}
	
	public String toString() {
	
		String s = "";
		
		for(int r = 0; r < 9; r++) {
		
			for(int c = 0; c < 9; c++) {
			
				s += grid[r][c] + " ";
			}
			
			s += "\n";			
		}
		
		return s;
	}
}
