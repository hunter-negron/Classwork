package Client.Simulator;

import java.util.*;
import java.io.*;
import Traffic.RoadNetwork.*;

public class Simulator {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		double entryRate = 0.0, turnRate = 0.0;
		int greenDur = 0, orangeDur = 0, simTime = 0, laneSpan = 0;
		
		// Try-Catch-Finally for dealing with poorly formatted numerical input
		try {
			
			System.out.println("Entry Rate (0-1): ");
			entryRate = Double.valueOf(scan.nextLine());
			System.out.println("Turn Rate (0-1): ");
			turnRate = Double.valueOf(scan.nextLine());
			System.out.println("Green (int): ");
			greenDur = Integer.valueOf(scan.nextLine());
			System.out.println("Orange (int): ");
			orangeDur = Integer.valueOf(scan.nextLine());
			System.out.println("Simulation Time (int): ");
			simTime = Integer.valueOf(scan.nextLine());
			System.out.println("Lane Span (int): ");
			laneSpan = Integer.valueOf(scan.nextLine());
		}
		catch(Exception e) {
			
			System.out.println("Not a valid number. Exiting.");
			scan.close();
			System.exit(0);
		}
		finally {
		
			if(entryRate < 0 || turnRate < 0 || greenDur < 0 || orangeDur < 0 || simTime < 0 || laneSpan <= 0) {
			
				System.out.println("All values must be nonnegative. Span must be positive. Exiting."); // Span must be positive because if not, there would be no traffic signals to control.
				scan.close();
				System.exit(0);
			}
			
			RoadNetwork road = new RoadNetwork(laneSpan, greenDur, orangeDur, turnRate);
			ArrayList<Auto> cars = new ArrayList<Auto>(); // Once a car is added, it ought not to be removed.
			int[] exitRates = new int[4];
			
			// Loop for each tick
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
			
				// An exit time of 0 means that the car did not exit, and can be ignored
				if(cars.get(i).getExitTime() > 0) {
				
					averageWaitTime += (cars.get(i).getExitTime() - cars.get(i).getEntryTime());
					carCount++;
				}
			}
			averageWaitTime = carCount == 0 ? 0 : averageWaitTime / carCount; // Will be set to zero to avoid division-by-zero
			
			System.out.println("Average Wait Time: " + averageWaitTime);
			
			// Calculate Flow Rates
			double totalFlowRate = 0;
			for(int i = 0; i < exitRates.length; i++) {
			
				System.out.println(Direction.values()[i] + "-bound flow rate: " + ((double) exitRates[i] / (double) simTime));
				totalFlowRate += exitRates[i];
			}
			
			System.out.println("Total Flow Rate: " + totalFlowRate / (double) simTime);
			
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
			
			scan.close();
		}
	}
}