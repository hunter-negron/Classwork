class threeDimPrac{
	int grade;
	public threeDimPrac(int i, int j, int k)//notice the constructor takes in the dim1, dim 2 and dim 3 index values
	{
		this.grade=i*j*k;
	}
	public String toString(){
		String ret="";
		ret=ret+this.grade;
		return ret;
	}
	public static void main(String [] args){
		
		//use a random number generator to generate the values of dim1, dim2 and dim3
		//the random number generator will generate values between 1 and 20
		
		int range=(20-1)+1;
		int min=1;
		int dim1=(int)(Math.random()*(range)+min);
		//declare the 3 dim array
		threeDimPrac [][][] myArray;
		
		//Task: intantiate the 3 dim array
		
		
		//Task: using a nested for-loop print out all the objects in the array
		
		
	}
}