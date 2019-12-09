public class Bridge extends CardGame {

	public Bridge() {
		
		super();
	}
	
	public void displayDescription() {	
	
		System.out.println("Bridge is a trick-taking game played in partnerships.");
	}
	
	public void deal() {
	
		for(int i = 0; i < 13; i++) {
		
			System.out.println(deck.get(i));
			cardsDealt++;
		}
	}
}
