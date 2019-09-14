import java.io.*;
import java.util.*;

public class textReader {
	public static void main(String[] args) {
		try {
			File textFile = new File(args[0]);
			Scanner scan = new Scanner(textFile);
			
			while(scan.hasNextLine()) {
				String[] s = scan.nextLine().split(" ");
				
				for(int i = 0; i < s.length; i++) {
					System.out.println(s[i]);
				}
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
