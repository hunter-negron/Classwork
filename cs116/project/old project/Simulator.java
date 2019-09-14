package Client.Simulator;

import java.util.*;
import java.io.*;
import Traffic.RoadNetwork.*;

public class Simulator {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Entry Rate (0-1): ");
		double entryRate = Double.valueOf(scan.nextLine());
		System.out.println("Turn Rate (0-1): ");
		double turnRate = Double.valueOf(scan.nextLine());
		System.out.println("Green (int): ");
		int greenDur = Integer.valueOf(scan.nextLine());
		System.out.println("Orange (int): ");
		int orangeDur = Integer.valueOf(scan.nextLine());
		System.out.println("Simulation Time (int): ");
		int simTime = Integer.valueOf(scan.nextLine());
		System.out.println("Lane Span (int): ");
		int laneSpan = Integer.valueOf(scan.nextLine());
		
		if(entryRate < 0 || turnRate < 0 || greenDur < 0 || orangeDur < 0 || simTime < 0 || laneSpan <= 0) {
		
			System.out.println("All values must be nonnegative. Span must be positive. Exiting."); // Span must be positive beacause if not, there would be no traffic signals to control.
			return;
		}
		
		RoadNetwork road = new RoadNetwork(laneSpan, greenDur, orangeDur, turnRate);
		ArrayList<Auto> cars = new ArrayList<Auto>(); // Once a car is added, it ought not to be removed.
		int[] exitRates = new int[4];
		
		for(int i = 0; i < simTime; i++) {
		
			Auto[] removed = road.onTick();
			
			// Handle the details of the cars that have exited the road
			for(int j = 0; j < removed.length; j++) {
			
				if(removed[j] != null) {
				
					cars.get(removed[j].getId()).setExitTime(i);
					exitRates[removed[j].getEndDirection().ordinal()]++;
				}
			}
			
			// Spawn new cars
			for(int j = 0; j < 4; j++) {
			
				if(Math.random() < entryRate) {
					
					cars.add(new Auto(Direction.values()[j], i));
					road.spawnAuto(cars.get(cars.size() - 1));
				}
			}
		}
		
		// Calculate average wait time
		double averageWaitTime = 0.0;
		int carCount = 0;
		
		for(int i = 0; i < cars.size(); i++) {
		
			if(cars.get(i).getExitTime() > 0) {
			
				averageWaitTime += (cars.get(i).getExitTime() - cars.get(i).getEntryTime());
				carCount++;
			}
		}
		averageWaitTime = carCount == 0 ? 0 : averageWaitTime / carCount; // Will be set to zero to avoid division-by-zero
		
		System.out.println("Average Wait Time: " + averageWaitTime);
		
		// Calculate Flow Rates
		int totalFlowRate = 0;
		for(int i = 0; i < exitRates.length; i++) {
		
			System.out.println(Direction.values()[i] + "-bound flow rate: " + exitRates[i]);
			totalFlowRate += exitRates[i];
		}
		
		System.out.println("Total Flow Rate: " + totalFlowRate);
		
		// Output File
		try {

			FileWriter out = new FileWriter(new File("out.txt"));
			
			for(int i = 0; i < cars.size(); i++) {
			
				Auto a = cars.get(i);
				
				out.write("Car #" + a.getId() + "\n");
				out.write("Entry Time: " + a.getEntryTime() + "\n");
				out.write("Entry Lane: " + a.getDirection() + "-bound\n");
				out.write("Exit Time: " + a.getExitTime() + "\n");
				out.write("Exit Lane: " + a.getEndDirection() + "-bound\n");
				
				out.flush();
			}
			
			out.close();
		}
		catch(IOException e) {
		
			e.printStackTrace();
		}
		
	}
}
