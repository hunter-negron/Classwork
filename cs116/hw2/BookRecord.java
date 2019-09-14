package library.service.classes;

public class BookRecord {

	private String title;
	private String[] authors;
	private BookGenre genre;
	private final int id;
	private static int idCounter;
	
	// Constructors
	public BookRecord() {
	
		title = "";
		authors = null;
		genre = null;
		id = idCounter;
		idCounter++;
	}
	
	public BookRecord(String t, String[] a, BookGenre g) {
	
		title = t;
		authors = a;
		genre = g;
		id = idCounter;
		idCounter++;
	}
	
	// Accessors
	public String getTitle() {
	
		return title;
	}
	
	public String[] getAuthors() {
	
		return authors;
	}
	
	public BookGenre getGenre() {
	
		return genre;
	}
	
	public int getId() {
	
		return id;
	}
	
	// Mutators
	public void setTitle(String t) {
	
		title = t;
	}
	
	public void setAuthors(String[] a) {
	
		authors = a;
	}
	
	public void setGenre(BookGenre g) {
	
		genre = g;
	}
	
	// Methods
	public boolean equals(BookRecord b) {
		
		// Test authors first
		if(this.authors.length != b.getAuthors().length) {
		
			return false;
		}
		
		for( int i = 0; i < this.authors.length; i++ ) {
		
			if(!this.authors[i].equals(b.getAuthors()[i])) {
			
				return false;
			}
		}
		
		return (this.title.equals(b.getTitle())) && (this.genre == b.getGenre()); // Title, and genre
	}
	
	public String toString() {
	
		String str = "";
		str += "===================================\n";
		str += "Record #" + id + "\n";
		str += "Title: " + title + "\n";
		
		for( String i : authors ) {
		
			str += "Author: " + i + "\n";
		}
		
		str += "Genre: " + genre + "\n";
		str += "===================================\n";
		
		return str;
	}
}
