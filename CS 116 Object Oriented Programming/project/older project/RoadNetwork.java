import java.util.*;

public class RoadNetwork {

	private Block[] northToSouth;
	private Block[] eastToWest;
	private Block[] southToNorth;
	private Block[] westToEast;	
	private Block[][] road; // This is just a 2d array that holds the four above arrays.
	private TrafficLight[] lights;
	private InterectionBlock[] intersections;
	private int span;
	ArrayList<Auto> cars;

	public RoadNetwork(int span, int green, int orange) {
	
		//
		//   PERHAPS update this code later so everything is handled via arrays
		//
	
		this.span = span;
		cars = new ArrayList<Auto>();
	
		int uniqueId = 0;
		IntersectionBlock northOrEast = new IntersectionBlock(uniqueId++, new Direction[]{Direction.NORTH, Direction.EAST});
		IntersectionBlock northOrWest = new IntersectionBlock(uniqueId++, new Direction[]{Direction.NORTH, Direction.WEST});
		IntersectionBlock southOrEast = new IntersectionBlock(uniqueId++, new Direction[]{Direction.SOUTH, Direction.EAST});
		IntersectionBlock southOrWest = new IntersectionBlock(uniqueId++, new Direction[]{Direction.SOUTH, Direction.WEST});
		intersections = new IntersectionBlocks[4];
		intersections[0] = northOrEast;
		intersections[1] = northOrWest;
		intersechions[2] = southOrEast;
		intersections[3] = southOrWest;
		
		TrafficLight northToSouthLight = new TrafficLight(TrafficColor.LIGHT_GREEN, green, orange);
		TrafficLight southToNorthLight = new TrafficLight(TrafficColor.LIGHT_GREEN, green, orange);
		TrafficLight  eastToWestLight  = new TrafficLight(TrafficColor.LIGHT_RED,   green, orange);
		TrafficLight  westToEastLight  = new TrafficLight(TrafficColor.LIGHT_RED,   green, orange);
		lights = new TrafficLight[4];
		lights[0] = northToSouthLight;
		lights[1] = southToNorthLight;
		lights[2] = eastToWestLight;
		lights[3] = westToEastLight;
		
		northToSouth = new Block[(span * 2) + 2];
		southToNorth = new Block[(span * 2) + 2];
		eastToWest   = new Block[(span * 2) + 2];
		westToEast   = new Block[(span * 2) + 2];
		road = new Block[4][];
		road[0] = northToSouth;
		road[1] = eastToWest;
		road[2] = southToNorth;
		road[3] = westToEast;
		
		// North To South	
		int j = 0;
		while(j < span - 1) {
		
			northToSouth[j] = new NormalBlock(uniqueId++);
			
			j++;
		}
		
		northToSouth[j] = new TrafficBlock(uniqueId++, northToSouthLight);
		j++;	
		northToSouth[j] = southOrWest;
		j++;
		northToSouth[j] = southOrEast;
		j++;
			
		while(j < (span * 2) + 2) {
		
			northToSouth[j] = new NormalBlock(uniqueId++);
			
			j++;			
		}
		
		// South To North	
		j = 0;
		while(j < span - 1) {
		
			southToNorth[j] = new NormalBlock(uniqueId++);
			
			j++;
		}
		
		southToNorth[j] = new TrafficBlock(uniqueId++, southToNorthLight);
		j++;
		southToNorth[j] = northOrEast;
		j++;
		southToNorth[j] = northOrWest;
		j++;
			
		while(j < (span * 2) + 2) {
		
			southToNorth[j] = new NormalBlock(uniqueId++);
			
			j++;			
		}
		
		// East To West	
		j = 0;
		while(j < span - 1) {
		
			eastToWest[j] = new NormalBlock(uniqueId++);
			
			j++;
		}
		
		eastToWest[j] = new TrafficBlock(uniqueId++, eastToWestLight);
		j++;
		eastToWest[j] = northOrWest;
		j++;
		eastToWest[j] = southOrWest;
		j++;
			
		while(j < (span * 2) + 2) {
		
			eastToWest[j] = new NormalBlock(uniqueId++);
			
			j++;			
		}
		
		// West To East	
		j = 0;
		while(j < span - 1) {
		
			westToEast[j] = new NormalBlock(uniqueId++);
			
			j++;
		}
		
		westToEast[j] = new TrafficBlock(uniqueId++, westToEastLight);
		j++;
		westToEast[j] = southOrEast;
		j++;
		westToEast[j] = northOrEast;
		j++;
			
		while(j < (span * 2) + 2) {
		
			westToEast[j] = new NormalBlock(uniqueId++);
			
			j++;			
		}
		
		// Set neighbors
		for(int i = 0; i < road.length; i++) {
		
			for(int k = 0; k < road[i].length; k++) {
			
				if(road[i][k].getType() == BlockType.BLOCK_INTERSECT) {					
					
					int ortho = i == 3 ? 0 : i + 1;
					
					road[i][k].setNeighbors(new Block[]{road[i][k - 1], road[ortho][k], road[i][k + 1], road[ortho][k + 2]});
					
					k++;
				}
				else {
				
					if(k == 0) {
					
						road[i][k].setNeighbors(new Block[]{null, road[i][k + 1]});
					}
					else if(k == road[i].length - 1) {
					
						road[i][k].setNeighbors(new Block[]{road[i][k - 1], null});
					}
					else {
					
						road[i][k].setNeighbors(new Block[]{road[i][k - 1], road[i][k + 1]});
					}
				}
			}
		}
	}
	
	public String toString() {
	
		//
		// 
		//
		
		String str = "";
		
		for(int i = 0; i < span; i++) {
		
			for(int j = 0; j < span; j++) {
			
				str += " ";
			}
			
			str += northToSouth[i].getAuto()                           == null ? "." : "v";
			
			str += southToNorth[southToNorth.length - 1 - i].getAuto() == null ? "." : "^";
		
			for(int j = 0; j < span; j++) {
			
				str += " ";
			}
			
			str += "\n";
		}
		
		for(int i = eastToWest.length - 1; i >= 0; i--) {
			
			str += eastToWest[i].getAuto() == null ? "." : "<";	
		}
		
		str += "\n";
		
		for(int i = 0; i < westToEast.length; i++) {
			
			str += westToEast[i].getAuto() == null ? "." : ">";	
		}
		
		str += "\n";
		
		for(int i = span + 2; i < (span * 2) + 2; i++) {
		
			for(int j = 0; j < span; j++) {
			
				str += " ";
			}
			
			str += northToSouth[i].getAuto()                           == null ? "." : "v";
			
			str += southToNorth[southToNorth.length - 1 - i].getAuto() == null ? "." : "^";
		
			for(int j = 0; j < span; j++) {
			
				str += " ";
			}
			
			str += "\n";
		}
		
		return str;
	}
	
	public void onTick(boolean[] entries, boolean[] turns) {
	
		// Cycle lights
		for(int i = 0; i < lights.length; i++) {
			
			lights[i].cycle();	
		}
		
		// Turning
		for(int i = 0; i < intersections.length; i++) {
		
			if(intersections[i].getAuto() != null) {
			
				
			}
		}
	}
}
