package MainClass.OtherClasses;

public class Team {

	private String name;
	private int winCount;
	private int tieCount;
	private int lossCount;
	private int gameCount;
	private Conference conference;
	private final int id;
	
	static int idCounter;
	
	// Constructors
	public Team() {
		name = "NO_NAME";
		winCount = 0;
		tieCount = 0;
		lossCount = 0;
		conference = Conference.UNKNOWN;
		id = idCounter;
		idCounter++;
	}
	
	public Team(String n, int w, int t, int l, Conference c) {
		name = n;
		winCount = w;
		tieCount = t;
		lossCount = l;
		gameCount = w + t + l;
		conference = c;
		id = idCounter;
		idCounter++;
	}
	
	// Accessors
	public String getName() {
	
		return name;
	}
	
	public int getWinCount() {
	
		return winCount;
	}
	
	public int getTieCount() {
	
		return tieCount;
	}
	
	public int getLossCount() {
	
		return lossCount;
	}
	
	public int getGameCount() {
	
		return gameCount;
	}
	
	public Conference getConference() {
	
		return conference;
	}
	
	public int getId() {
	
		return id;
	}
	
	// Mutators
	public void setName(String n) {
	
		name = n;
	}
	
	public void setWinCount(int w) {
	
		winCount = w;
	}
	
	public void setTieCount(int t) {
	
		tieCount = t;
	}
	
	public void setLossCount(int l) {
	
		lossCount = l;
	}
	
	public void setGameCount(int g) {
	
		gameCount = g;
	}
	
	public void setConference(Conference c) {
	
		conference = c;
	}
	
	// Helpers
	public float calculateStanding() {
	
		return ( (2 * winCount) + (1 * tieCount) + (-1 * lossCount) ) / gameCount;
	}
	
	public String toString() {
	
		String str = "";
		str += "ID#: "          + id                  + "\n";
		str += "Name: "         + name                + "\n";
		str += "Wins: "         + winCount            + "\n";
		str += "Ties: "         + tieCount            + "\n";
		str += "Losses: "       + lossCount           + "\n";
		str += "Games played: " + gameCount           + "\n";
		str += "Conference: "   + conference          + "\n";
		str += "Standing: "     + calculateStanding() + "\n";
		
		return str;
	}
}
