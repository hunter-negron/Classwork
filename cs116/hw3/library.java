package library.client.classes;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import library.service.classes.BookGenre;
import library.service.classes.BookRecord;

class library {

	BookRecord[] books; //array of objects
	int noRecords = 0; //no of records; it is not the size of the array
	
	public void resize(int resizeFactor) { //library to expand the array
	
		//initiatilize a new array with larger size and then copy the variables to
		int initSize = this.noRecords;
		BookRecord[] newArray = new BookRecord[initSize + resizeFactor];
		//copy the object over
		for(int i = 0; i < this.books.length; ++i) {
		
			newArray[i] = this.books[i];
		}
		
		this.books = newArray;
		System.out.println("Resized the array from " + initSize + " to " + this.books.length);
		
	}
	
	public void searchByGenre(BookGenre genre) {
	
		//loop through the book records and list the genre
		for(int i=0;i<this.noRecords;++i) {
		
			if(this.books[i].getGenre()==genre) {
			
				System.out.println(this.books[i].toString());
			}
		}
	}
	
	public boolean searchForDuplicate(BookRecord aRecord) {
	
		//loop through the library and find duplicates
		//return true if duplicate found 
		//else return false		
		if(this.noRecords == 0) {
		
			return false;
		}
		
		for(int i = 0; i < this.noRecords; ++i) {
		
			if(this.books[i].equals(aRecord)) {
			
				return true;
			}
		}
		
		return false;
	}
	
	public void print() { //list the library
	
		for(int i = 0; i < this.noRecords; ++i) {
		
			System.out.println(this.books[i].toString());
		}	
	}
	
	public BookRecord[] sortString(BookRecord[] myArray, int noRecords) {
	
		for(int i = 1; i <= noRecords; i++) {
		
			int largest = 0;
			for(int j = 0; j <= noRecords - i; j++) {
			
				if(myArray[j] != null && myArray[largest] != null && myArray[j].getTag().compareTo( myArray[largest].getTag() ) > 0) {
				
					largest = j;
				}
			}
			
			BookRecord temp = myArray[noRecords - i];
			myArray[noRecords - i] = myArray[largest];
			myArray[largest] = temp;
		}
		
		return myArray;		
	}
	
	public BookRecord[] sortPages(BookRecord[] myArray, int noRecords) {
	
		for(int i = 1; i <= myArray.length; i++) {
		
			int largest = 0;
			for(int j = 0; i <= noRecords - i; j++) {
			
				if(myArray[j] != null && myArray[largest] != null && myArray[j].getPageCount() < myArray[largest].getPageCount()) {
				
					largest = j;
				}
			}
			
			BookRecord temp = myArray[noRecords - i];
			myArray[noRecords - i] = myArray[largest];
			myArray[largest] = temp;
		}
		
		return myArray;		
	}
	
	public void searchTag(String tag) {
	
		int start = 0;
		
		int end = 0;
		for(int i = 0; i < books.length; i++) {
		
			if(books[i] == null) { 
				end = i - 1; 
				break; 
			}
		}
		
		while(end >= start) {
		
			int mid = (start + end) / 2;
					
			if(books[mid].getTag().equals(tag)) {
			
				System.out.println("Found a match");
				System.out.println(books[mid]);
				return;
			}
			else if(books[mid].getTag().compareTo(tag) < 0) {
			
				start = mid + 1;
			}
			else if(books[mid].getTag().compareTo(tag) > 0) {
			
				end = mid - 1;
			}
		}
		
		System.out.println("No match found.");
	}
	
	library() {
	
		this.books = new BookRecord[5]; //intial size is 5		
	}
	
	// Debugging
	public void printALL() {
	
		for(int i = 0; i < books.length; i++) {
		
			if(books[i] == null) {
			
				System.out.println(i + ". null");
			}
			else {
			
				System.out.println(i + ". " + books[i].getTag() + ":" + books[i].getTitle());
			}
		}
	}
	
	public static void main(String[] args) { //instantiate the library
	
		//arg[0]: text file //arg[1]: resize factor
		int resizeFactor = Integer.parseInt(args[1]);
		library myLib = new library();
		//read the the files from text files
		String[] authors;
		BookRecord aRecord;
		Scanner scan;
		String str;
		
		try {
		
			File myFile = new File(args[0]);
            scan = new Scanner(myFile); //each line has the format title:genre:author-name-1,author-name-2..authorname-m
			while(scan.hasNextLine()) {
			
				str = scan.nextLine();				
				String[] tok = str.split(":");
				authors = tok[2].split(",");
				aRecord = new BookRecord(tok[0], tok[1], authors, tok[3], Integer.valueOf(tok[4]));
				
				//check for duplicate records
				if (!myLib.searchForDuplicate(aRecord)) {
				
					//create a BookRecord object and load it on the array
					myLib.books[myLib.noRecords] = aRecord;
					myLib.noRecords++;
					//System.out.println("No of records: " + myLib.noRecords);
				}
				else {
					System.out.println("Found a duplicate");
					System.out.println(aRecord.toString());
				}
				
				//check if the array needs to resize
				if(myLib.books.length == myLib.noRecords) { //need to add additional space
				
					myLib.resize(resizeFactor);
				}
			}
			
			myLib.books = myLib.sortString(myLib.books, myLib.noRecords);
			
			scan.close();
        }
        catch(IOException ioe) {
         
			System.out.println("The file can not be read");
		}
		
		//User interactive part
		String option1, option2;
		scan = new Scanner(System.in);
		
		while(true) {
		
			System.out.println("Select an option:");
			System.out.println("Type \"S\" to list books of a genre");
			System.out.println("Type \"P\" to print out all the book records");	
			System.out.println("Type \"T\" to search for a book with a specific tag");		
			System.out.println("Type \"Q\" to Quit");
			option1=scan.nextLine();
			
			switch (option1) {
				case "S":	System.out.println("Type a genre. The genres are:");
				
							for (BookGenre d : BookGenre.values()) {
							
									System.out.println(d);
							}
							
							option2 = scan.nextLine(); //assume the use will type in a valid genre
							myLib.searchByGenre(BookGenre.valueOf(option2));
							break;
							 
				case "P":   myLib.print();	 
							break;
							
				case "T":	System.out.println("Type a tag:");
							String userTag = scan.nextLine();
							myLib.searchTag(userTag);
							//myLib.printALL();
							break;
				
				case "Q":   System.out.println("Quitting program");
							System.exit(0);
							
				default:	System.out.println("Wrong option! Try again");
							break;
			
			}
			
		}
			 
	}
	
}
