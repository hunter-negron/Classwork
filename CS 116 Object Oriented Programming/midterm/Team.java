package Midterm.Service;

public class Team {

	String name;
	int wins;
	int losses;
	int totalGames;
	
	// Constructors
	public Team() {
	
		name = "";
		wins = 0;
		losses = 0;
		totalGames = 0;
	}
	
	public Team(String n, int w, int l) {
	
		name = n;
		wins = w;
		losses = l;
		totalGames = wins + losses;
	}
	
	// Accessors
	public String getName() {
	
		return name;
	}
	
	public int getWins() {
	
		return wins;
	}
	
	public int getLosses() {
	
		return losses;
	}
	
	public int getTotalGames() {
	
		return totalGames;
	}
	
	// Mutators
	public void setName(String n) {
	
		name = n;
	}
	
	public void setWins(int w) {
	
		wins = w;
		totalGames = wins + losses;
	}
	
	public void setLosses(int l) {
	
		losses = l;
		totalGames = wins + losses;
	}
	
	// Other methods
	public double winPercentage() {
	
		if(totalGames != 0) {
		
			return ( ((double) wins) / ((double) totalGames) );
		}
		
		return 0.0;
	}
	
	public String toString() {
	
		String str = "";
		str += "Name: " + name + "\n";
		str += "Wins: " + wins + "\n";
		str += "Losses: " + losses + "\n";
		//str += "Total games played: " + totalGames + "\n";
		str += "Win percentage: " + winPercentage() + "\n";
		
		if(winPercentage() == .5) {
		
			str += "500 Team\n";
		}
		else if(winPercentage() < .5) {
		
			str += "Under 500 Team\n";
		}
		else {
		
			str += "Over 500 Team\n";
		}
		
		return str;
	}
}
