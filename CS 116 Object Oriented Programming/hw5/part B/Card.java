public class Card {

	
	public static final String[] RANKS = {"Ace", "Two", "Three", "Four", "Five", "Six",
	                  "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"}; 
	public static final String[] SUITS = {"Spades", "Clubs", "Diamond", "Hearts"};
		
	String rank;
	String suit;
	
	// Constructors
	public Card() {
	
		rank = "";
		suit = "";
	}
	
	public Card(String r, String s) {
	
		rank = r;
		suit = s;
	}
	
	public Card(int r, int s) {
	
		// Numbers 1 - 13
		rank = (r > 0 && r < 14) ? RANKS[r - 1] : RANKS[0];
		// Numbers 1 -  4
		suit = (s > 0 && s <  5) ? SUITS[s - 1] : SUITS[0];
	}
	
	
	// Accessors
	public String getRank() {
	
		return rank;
	}
	
	public String getSuit() {
	
		return suit;
	}
	
	// Mutators
	public void setRank(String r) {
	
		rank = r;
	}
	
	public void setSuit(String s) {
	
		suit = s;
	}
	
	public void setRank(int r) {
	
		rank = (r > 0 && r < 14) ? RANKS[r - 1] : RANKS[0];
	}
	
	public void setSuit(int s) {
	
		suit = (s > 0 && s <  5) ? SUITS[s - 1] : SUITS[0];
	}
	
	// Other Methods
	public String toString() {
	
		return rank + " of " + suit;
	}
}
