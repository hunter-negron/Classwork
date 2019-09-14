class RndGen{

public static void main(String [] args){
	//generate 10 random integers between 7 (min value) and 15 (max value)
	
	int min=7;
	int max=15;
	int rndVal;
	int range = max-min+1;
	for(int i=0;i<10;++i){
		rndVal= (int)(Math.random()*(range)+min);
		System.out.println("Random number is " + rndVal);
	}
}
}