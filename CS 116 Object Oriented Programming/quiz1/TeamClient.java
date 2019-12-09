package MainClass;

import MainClass.OtherClasses.*;
import java.util.*;
import java.io.*;

public class TeamClient {

	public static void main(String args[]) {
	
		try {
	
			Scanner scan = new Scanner( new File(args[0]) );
			Team[] teams = new Team[1];
			int lineCount = 0;
			
			while(scan.hasNextLine()) {
				
				// Makes a larger array
				lineCount++;
				Team[] temp = new Team[lineCount];
				for(int i=0;i<teams.length;i++){
					temp[i]=teams[i];
				}
				teams = temp;
				temp = null;	
				
				String[] s = scan.nextLine().split(":");
				String name = s[0];
				int wins = Integer.valueOf(s[2]);
				int ties = Integer.valueOf(s[3]);
				int losses = Integer.valueOf(s[4]);
				Conference c = Conference.valueOf(s[1]);
				Team newTeam = new Team(name, wins, ties, losses, c);
				teams[lineCount - 1] = newTeam;
			}
			
			for(Team t : teams) {
			
				System.out.println(t);
			}		
		}
		catch(Exception e) {
		
			//System.out.println(e);
			e.printStackTrace();
		}
	}
}
