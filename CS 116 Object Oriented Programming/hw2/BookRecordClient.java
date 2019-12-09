import library.service.classes.BookRecord;
import library.service.classes.BookGenre;
import java.util.*;
import java.io.*;

public class BookRecordClient {

	public static BookRecord[] records;
	
	public static void main(String[] args) {
	
		records = new BookRecord[5];
		int rcount = 0;
		
		String filename = args[0];
		int expansionFactor = Integer.valueOf(args[1]);
		
		try {
			// read the text file
			//read the tokens in each line and create an object of type book record
			//insert into the client class array if no duplicate exists
			//after insertion check if the array is completely filled and needs to be expanded
			Scanner s = new Scanner(new File(filename));
			
			while(s.hasNextLine()) {
			
				// Get lines from file
				String[] info = s.nextLine().split(":");
				String[] authors = info[2].split(",");
								
				// Use data from file for various attributes
				String title = info[0];
				BookGenre genre = BookGenre.valueOf(info[1]);
				
				BookRecord br = new BookRecord(title, authors, genre);
				
				// Look for duplicates
				if(!isDuplicate(br)) {
					records[rcount] = br;
					rcount++;
				}
				else {
				
					System.out.println("Duplicate found.");
				}
				
				// Expand array
				if(rcount >= records.length) {
				
					BookRecord[] temp = new BookRecord[records.length + expansionFactor];
					
					for( int i = 0; i < records.length; i++ ) {
					
						temp[i] = records[i];
					}
					
					records = temp;
					temp = null;
					
					System.out.println("Resized the array from " + (records.length - expansionFactor) + " to " + records.length);
				}
			}
		}
		catch(IOException ioe) {
		
			System.out.println("The file can not be read");
		}

		//User interactive part
		while(true) {
		
			System.out.println("Select an option:");
			System.out.println("Type \"S\" to list books of a genre");
			System.out.println("Type \"P\" to print out all the book records");
			System.out.println("Type \"Q\" to Quit");

			//get input from the user
			Scanner s = new Scanner(System.in);
			String option1 = s.nextLine();
			
			switch (option1) {
			
				case "S":
					System.out.println("Type a genre. The genres are:");
					for (BookGenre d : BookGenre.values()) {
						System.out.println(d);
					}
					String option2 = s.nextLine(); //assume the use will type in a valid genre
					                               //print out records of the selected genre
					for( BookRecord br : records ) {
					
						if((br != null) && (br.getGenre().name().equals(option2))) {
						
							System.out.println(br);
						}
					}
					
					break;	
				
				case "P": //list out all the records
				
					for( BookRecord br : records ) {
						
						System.out.println(br);
					}
				
					break;
				
				case "Q": System.out.println("Quitting program");
					System.exit(0);
				
				default: System.out.println("Wrong option! Try again");
					break;
			}
		}
	}
	
	public static boolean isDuplicate(BookRecord br) {
		
		for(int i = 0; i < records.length; i++) {
			
			if( (records[i] != null) && br.equals(records[i]) ) {
			
				return true;
			}
		}
	
		return false;
	}
}
