import java.util.*;

public class PlayCardGames {

	public static void main(String[] args) {
	
		Poker poker = new Poker();
		Bridge bridge = new Bridge();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Which game (poker/bridge)?");
		String game = scan.nextLine();
		
		if(game.equals("poker")) {
		
			System.out.println("Description: ");
			poker.displayDescription();
			
			System.out.println("Deal: ");
			poker.deal();
		}
		else if(game.equals("bridge")) {
		
			System.out.println("Description: ");
			bridge.displayDescription();
			
			System.out.println("Deal: ");
			bridge.deal();
		}
		else {
		
			System.out.println("Invalid.");
		}
	}
}
