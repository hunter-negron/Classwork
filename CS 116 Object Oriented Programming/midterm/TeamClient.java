package Midterm.Client;

import java.io.File;
import java.util.*;
import java.io.IOException;
import Midterm.Service.*;

public class TeamClient{
	
	static ArrayList<Team> teams = new ArrayList<Team>();
	
	public static void main(String args[]){
		
		//read the file and create the objects
		String line=new String();
		try{
			File textFile = new File("TeamTxt.txt");
			Scanner scan = new Scanner(textFile);
			while(scan.hasNextLine())
			{
				line=scan.nextLine();				
				String []tok=line.split(":");
				String name=tok[0];
				int wins=Integer.parseInt(tok[1]);
				int losses=Integer.parseInt(tok[2]);	
				
				Team t = new Team(name, wins, losses);
				if(duplicate(t) == -1) {
				
					teams.add(t);	
				}
				else {
				
					Team dup = teams.get(duplicate(t));
					dup.setWins(dup.getWins() + t.getWins());
					dup.setLosses(dup.getLosses() + t.getLosses());
				}		
			}
			
		}catch(IOException e){
			System.out.println("Issuse with reading the file. Aborting");
			System.out.println(e.getMessage());
		}
		
		// Selection Sort
		for(int i = 0; i < teams.size(); i++) {
		
			// Find lowest winPercentage
			int lowestPos = 0;
			for(int j = 0; j < teams.size() - i; j++) {
			
				if(teams.get(j).winPercentage() < teams.get(lowestPos).winPercentage()) {
				
					lowestPos = j;
				}
			}
			
			// Swap
			Team temp = teams.get(lowestPos);
			teams.set(lowestPos, teams.get(teams.size() - i - 1));
			teams.set(teams.size() - i - 1, temp);
		}
		
		// Print
		for(Team t : teams) {
		
			System.out.println(t);
		}
	}
	
	// Returns the position of a matching team
	public static int duplicate(Team t) {
	
		for(int i = 0; i < teams.size(); i++) {
		
			if(teams.get(i).getName().equals(t.getName())) {
			
				return i;
			}
		}
		
		return -1;
	}
}
