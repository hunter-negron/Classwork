package Traffic.RoadNetwork;

public class RoadNetwork {
	
	private int span;

	private Block[][] road;
	private TrafficLight[] lights;
	private IntersectionBlock[] intersections;

	public RoadNetwork(int span, int green, int orange, double turnRate) {
	
		this.span = span;	
		int uniqueId = 0;
		
		// Everything is initialized according to the Order of Rights
		road = new Block[4][(2 * span) + 2];
		lights = new TrafficLight[4];
		intersections = new IntersectionBlock[4];
		
		lights[0] = new TrafficLight(green, orange, Color.GREEN); // headed north
		lights[1] = new TrafficLight(green, orange, Color.RED);   // headed east
		lights[2] = new TrafficLight(green, orange, Color.GREEN); // headed south
		lights[3] = new TrafficLight(green, orange, Color.RED);   // headed west
		
		intersections[0] = new IntersectionBlock(new Direction[]{Direction.NORTH, Direction.EAST}, turnRate, uniqueId++); // facilitates the right turn when initally headed north
		intersections[1] = new IntersectionBlock(new Direction[]{Direction.SOUTH, Direction.EAST}, turnRate, uniqueId++); // facilitates the right turn when initally headed east
		intersections[2] = new IntersectionBlock(new Direction[]{Direction.SOUTH, Direction.WEST}, turnRate, uniqueId++); // facilitates the right turn when initally headed south
		intersections[3] = new IntersectionBlock(new Direction[]{Direction.NORTH, Direction.WEST}, turnRate, uniqueId++); // facilitates the right turn when initally headed west
		
		// RoadNetwork initialization
		for(int i = 0; i < road.length; i++) {
		
			for(int j = 0; j < road[i].length; j++) {
			
				if(j < span - 1 || j > span + 1) { // NORMAL blocks
				
					road[i][j] = new NormalBlock(Direction.values()[i], uniqueId++);
				}
				else if(j == span - 1) { // TRAFFIC block
					
					road[i][j] = new TrafficBlock(Direction.values()[i], uniqueId++, lights[i]);
				}
				else if(j == span) { // First INTERSECTION block
				
					road[i][j] = intersections[i];
				}
				else if(j == span + 1) { // Second INTERSECTION block
				
					int interIndex = (i == 0) ? 3 : i - 1; // Order of Lefts
					road[i][j] = intersections[interIndex];
				}
			}
		}
		
		// Set neighbors
		for(int i = 0; i < road.length; i++) {
		
			for(int j = 0; j < road[i].length; j++) {
			
				if(j == 0) { // Beginning edge case
				
					road[i][j].setNeighbors(new Block[]{null, road[i][j + 1]}); // Creates a new array of existing block objects
				}
				else if(j == road[i].length - 1) { // Ending edge case
				
					road[i][j].setNeighbors(new Block[]{road[i][j - 1], null}); // Creates a new array of existing block objects
				}
				else { // Not edge cases
				
					if(road[i][j].getType() == BlockType.INTERSECTION) { // Intersections
					
						int ortho = (i == 3) ? 0 : i + 1; // Perpendicular lane
						road[i][j].setNeighbors(new Block[]{road[i][j - 1], road[ortho][j], road[i][j + 1], road[ortho][j + 2]}); // Creates a new array of existing block objects
						
						j++; // SKIP THE NEXT INTERSECTION BLOCK (it will be handled sooner or later)
					}
					else { // Not intersections
					
						road[i][j].setNeighbors(new Block[]{road[i][j - 1], road[i][j + 1]}); // Creates a new array of existing block objects
					}
				}
			}
		}
	}
	
	public void spawnAuto(Auto vehicle) {
		
		for(int i = 0; i < road.length; i++) {
		
			if(road[i][0].getDirection() == vehicle.getDirection() && road[i][0].getAuto() == null) {
			
				road[i][0].setAuto(vehicle);
			}
		}	
	}
	
	public Auto[] onTick() {
	
		// This function will return the cars that have exited the road
		// They will be handled by the Simulator	
		Auto[] removed = new Auto[4];
		int autoCount = 0;
	
		// Cycle lights
		for(int i = 0; i < lights.length; i++) {
			
			lights[i].cycle();	
		}
		
		// Move all cars forward
		for(int i = 0; i < road.length; i++) {
		
			for(int j = road[i].length - 1; j >= 0; j--) {
			
				if(road[i][j].getNext() == null) {
				
					removed[autoCount++] = road[i][j].getAuto();
					road[i][j].setAuto(null);
				}
				else {
				
					road[i][j].moveForward();
				}
			}
		}
		
		return removed;
	}
}
