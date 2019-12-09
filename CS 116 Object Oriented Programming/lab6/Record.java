public class Record {

	protected String title;
	protected String authors;
	protected String date;
	protected int id;
	private static int idCounter;
	
	// Constructors
	public Record() {
	
		title = "";
		authors = "";
		date = "";
		id = idCounter;
		idCounter++;
	}
	
	public Record(String t, String a, String d) {
	
		title = t;
		authors = a;
		date = d;
		id = idCounter;
		idCounter++;	
	}
	
	// Accessors
	public String getTitle() {
	
		return title;
	}
	
	public String getAuthors() {
	
		return authors;
	}
	
	public String getDate() {
	
		return date;
	}
	
	public int getID() {
	
		return id;
	}
	
	// Mutators
	public void setTitle(String t) {
	
		title = t;
	}
	
	public void setAuthors(String a) {
	
		authors = a;
	}
	
	public void setDate(String d) {
	
		date = d;
	}
	
	// Other Methods
	public String toString() {
	
		String str = "";
		str += "ID: " + id + "\n";
		str += "Title: " + title + "\n";
		str += "Authors: " + authors + "\n";
		str += "Date: " + date + "\n";
		
		return str;
	}
}
