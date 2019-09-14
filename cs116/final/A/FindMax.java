public class FindMax {

	public int getMax(int[] nums) {
		
		if(nums.length <= 1) {
		
			return nums[0];
		}
		
		// Construct new array
		int[] temp = new int[nums.length - 1];
		for(int i = 1; i < nums.length; i++) {
		
			temp[i - 1] = nums[i]; // Exclude the first datum
		}
		
		if(nums[0] > getMax(temp)) {
		
			return nums[0];
		}
		else {
		
			return getMax(temp);
		}
	}
	
	public static void main(String[] args) {
	
		int[] a = {113, 2, 5, 23, 98};
		FindMax max = new FindMax();
		System.out.println("Max no. is " + max.getMax(a));
	}	
}
