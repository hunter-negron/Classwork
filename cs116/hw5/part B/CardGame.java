import java.util.*;

public abstract class CardGame {

	protected List<Card> deck;
	protected int cardsDealt;
	
	public CardGame() {
	
		deck = new ArrayList<Card>();
		
		for(int i = 1; i <= 13; i++) {
		
			for(int j = 1; j <= 4; j++) {
			
				deck.add(new Card(i, j));
			}
		}
		
		shuffle();
	}
	
	public void shuffle() {
	
		Collections.shuffle(deck);
	}
	
	public abstract void displayDescription();
	
	public abstract void deal();
}
