package library.client.classes;
import java.util.*;
import java.io.File;
import java.io.IOException;

/*Task 2: Import necessary user defined classes */
import carddeck.service.classes.*;


class CardGame{
	static Card [] userHand;
	Card [] dealerHand;
	

    private void generateDealerHand(){
		dealerHand = new Card[5];
		/*Task 5: Implement the class method generateDealerHand() in CardGame class. This method will use a random generator to generate signs, and values of the cards for the dealer.*/
		for(int i = 0; i < dealerHand.length; i++) {
			int sign = (int) (Math.random() * 4);
			int value = (int) (Math.random() * 13);
			dealerHand[i] = new Card(CardSign.values()[sign], CardValue.values()[value]);
		}
	}
	
	private int getScore(){
		/*Task 3: Implement the class method getScore() in CardGame class. This method will compare the cards of the dealer and player and provide a score. If the score is zero, it means the game is a tie. If the score is positive, then the player has won the game. You should implement other methods as needed.*/
		int score = 0;
		for(int i = 0; i < userHand.length; i++) {
			score += userHand[i].getSign().compareTo(dealerHand[i].getSign());
		}
		
		return score;
	}	
	public static void main(String []args){
		userHand = new Card[5];
	//arg[0]: file containing user hand
		CardGame game=new CardGame();
		//read the the files from text files
		int counter=0;
		Card aCard;
		Scanner scan;
		String str;
		try {
			File myFile=new File(args[0]);
            scan=new Scanner(myFile);
			while(scan.hasNextLine()){
				str=scan.nextLine();				
				String []tok=str.split(":");
			/*Task 4: Implement the code in the main method of the CardGame class, that will take the values read from the text file, create Card objects and populate the array Hand. userHand is an attribute of the CardGame class.*/
				userHand[counter] = new Card(CardSign.valueOf(tok[0]), CardValue.valueOf(tok[1]));
				counter++;
			}			
		
		//lets play iPoker!!
		//User interactive part
		String option1;
		scan = new Scanner(System.in);
		int score;
		while(true){
			System.out.println("Select an option:");
			System.out.println("Type \"P\" to play a round of iPoker");			
			System.out.println("Type \"Q\" to Quit");
			option1=scan.nextLine();
			
			switch (option1) {								 
				case "P":   game.generateDealerHand();
				            score=game.getScore();
							game.printHand();///First print out the hands
							System.out.println("\n\nCompare the two hands:");
							if(score < 0)
								System.out.println("Dealer Wins :-(");
							else if (score == 0)
								System.out.println("Its a draw");
							else if (score > 0)
								System.out.println("Congrats You win !!");
							else
								System.out.println("Somethings wrong!");
							break;
				
				case "Q":   System.out.println("Quitting program");
							System.exit(0);
							
				default:	System.out.println("Wrong option! Try again");
							break;
			
			}			
		}
		}catch(IOException ioe){ 
			System.out.println("The file can not be read");
		}catch(IllegalArgumentException ia){ 
            System.out.println(ia.getMessage());
		} catch(NullPointerException np){
			System.out.println(np.getMessage());
		}
	}
	
	public void printHand() {
		for(int i = 0; i < userHand.length; i++) {
			System.out.println("User: " + userHand[i]);
		}
		
		for(int i = 0; i < dealerHand.length; i++) {
			System.out.println("Dealer: " + dealerHand[i]);
		}		
	}	

}
