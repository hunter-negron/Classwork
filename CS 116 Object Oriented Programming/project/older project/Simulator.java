import java.util.*;

public class Simulator {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Entry Rate (0-1): ");
		double entryRate = Double.valueOf(scan.nextLine()); // RNG seed
		System.out.println("Turn Rate (0-1): ");
		double turnRate = Double.valueOf(scan.nextLine()); // RNG seed
		System.out.println("Green (int): ");
		int greenDur = Integer.valueOf(scan.nextLine());
		System.out.println("Orange (int): ");
		int orangeDur = Integer.valueOf(scan.nextLine());
		System.out.println("Simulation Time (int): ");
		int simTime = Integer.valueOf(scan.nextLine());
		System.out.println("Lane Span (int): ");
		int laneSpan = Integer.valueOf(scan.nextLine());
		
		RoadNetwork road = new RoadNetwork(laneSpan, greenDur, orangeDur);
		
		System.out.println(road);
		
		for(int i = 0; i < simTime; i++) {
		
			boolean[] entries = new boolean[];
			
			for(int i = 0; i < 4; i++) {
			
				entries[i] = Math.random(entryRate) < 0.5 ? true : false;
			}			
			
			boolean[] turns = new boolean[];
			
			for(int i = 0; i < 4; i++) {
			
				turns[i] = Math.random(turnRate) < 0.5 ? true : false;
			}
			
			road.onTick(entries, turns);
		}
		
		// Calculate average wait time
	}
}
