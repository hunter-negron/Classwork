public class SudokuApp {

	public static void main(String[] args) {
	
		Sudoku s = new Sudoku();
		
		for(int r = 0; r < 9; r++) {
		
			for(int c = 0; c < 9; c++) {
			
				int n = (int) ((9 * Math.random()) + 1);
				s.put(n, r, c);
			}
		}
		
		System.out.println(s);
		System.out.println("Is it valid? " + s.isValid());
	}
}
