class twoDimPrac{
	int grade;
	public twoDimPrac(int i, int j)//notice the constructor takes in the row and column index values
	{
		this.grade=i*j;
	}
	public String toString(){
		String ret="";
		ret=ret+this.grade;
		return ret;
	}
	public static void main(String [] args){
		//use a random number generator to generate the number of rows and columns
		//the random number generator will generate values between 1 and 20
		
		int range=(20-1)+1;
		int min=1;
		int rows=(int)(Math.random()*(range)+min);
		int cols=(int)(Math.random()*(range)+min);
		//declare the 2 dim array
		twoDimPrac [][] myArray;
		//Task: intantiate the 2 dimensional array
		myArray = new twoDimPrac[rows][cols];
		
		for(int r = 0; r < myArray.length(); r++) {
		
			for(int c = 0; c < myArray[r].length; c++) {
			
				myArray[r][c] = new twoDimPrac(r, c);
			}
		}
		
		
		
		//Task: using a nested for-loop print out all the objects in the array
		for(int r = 0; r < myArray.length(); r++) {
		
			for(int c = 0; c < myArray[r].length; c++) {
			
				System.oit.println(myArray[r][c]);
			}
		}
	}
}
