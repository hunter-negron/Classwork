import java.util.*;
import java.io.*;

class Wrapper {

	public Wrapper() {

		try {
		
			File f = new File("list.txt");
			Scanner s = new Scanner(f);
			
			while(s.hasNextLine()) {
	
				String[] ds = s.nextLine().split(",");
				double acc = 0.0;
				
				for(int i = 0; i < ds.length(); i++) {
				
					acc += Double.getDouble(ds[i]);
				}
				
				system.out.println(acc);			
			}
		}
		catch(exception e) {
		
			system.out.println(e);
		}
	}
}
