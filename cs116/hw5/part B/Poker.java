public class Poker extends CardGame {

	public Poker() {
	
		super();
	}
	
	public void displayDescription() {
	
		System.out.println("Poker is a game of chance, gambling, strategy, and skill.");
	}
	
	public void deal() {
	
		for(int i = 0; i < 5; i++) {
		
			System.out.println(deck.get(i));
			cardsDealt++;
		}	
	}
}
