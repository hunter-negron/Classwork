class MinimumFinder {

	public static void main(String[] args) {
	
		int[] numbers = {4, 3, 6, 3, 7, -8, 10, 2};
		int smallest = numbers[0];
		
		for(int i = 0; i < numbers.length; i++) {
		
			if(numbers[i] < smallest) {
			
				smallest = numbers[i];
			}
		}
		
		system.out.println(smallest);
	}
}
