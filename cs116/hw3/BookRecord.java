package library.service.classes; //set up the package
import library.service.classes.BookGenre;

public class BookRecord {

	int recordNo;
	String title;	
	String[] authors;
	BookGenre genre;
	String tag;
	int pageCount;
	static int cnt = 10000;
		
	//non-default constructor      
    public BookRecord(String title, String genre, String[] name, String t, int p) {
    
		this.setTitle(title);
		this.setGenre(genre);
		this.setAuthors(name);
		this.setRecordNo();
		tag = t;
		pageCount = p;
	}
	
    //accessors
	public String getTitle() {
	
		return this.title;
	}	
	
	public BookGenre getGenre() {
	
		return this.genre;
	}
	
	public String[] getAuthors() {
	
		String[] ret = new String[this.authors.length];
		
		for(int i = 0; i < this.authors.length; ++i) {
		
			ret[i] = this.authors[i];
		}
		
		return ret;
	}
	
	public String getAuthorList() {
	
		String ret = "";
		
		for(int i = 0; i < this.authors.length; ++i) {
		
			ret = ret + " " +this.authors[i];
		}
		
		return ret;
	}
	 
	public int getRecordNo() {
	
		return this.recordNo;
	}
	
	public String getTag() {
	
		return tag;
	}
	
	public int getPageCount() {
	
		return pageCount;
	}
	
	//mutators
	public void setRecordNo() {
	
		this.recordNo = BookRecord.cnt++;
	}
	
	public void setTitle(String title) {
	
		this.title = title;
	}
	
	public void setGenre(String genre) {
	
		this.genre = BookGenre.valueOf(genre);
	}
	
	public void setAuthors(String[] authorList) {
	
		this.authors = new String[authorList.length];
		
		for(int i = 0; i < authorList.length; ++i) {
		
			this.authors[i] = authorList[i];
		}
	}
	
	public void setTag(String t) {
	
		tag = t;
	}
	
	
	public void setPageCount(int p) {
	
		pageCount = p;
	}
	
	//toString method
	public String toString() {
			
		String str = "";
		str = str + "===================================\n";
		str = str + "Record No:" + this.getRecordNo() + "\n";
		str = str + "Title:" + this.getTitle() + "\n";
		str = str + "Genre: " + this.getGenre() + "\n";
		str = str + "Authors: " + this.getAuthorList() + "\n";
		str = str + "Tag: " + this.getTag() + "\n";
		str = str + "Page Count: " + this.getPageCount() + "\n";
		str = str + "===================================\n";
		return str;
	}
	
	//toEquals method
	public boolean equals(BookRecord aRecord) { //remember you should not compare the record no
	
		if(!this.getTitle().equals(aRecord.getTitle())) {
		
			return false;
		}
		
		if(!this.equalsHelper(aRecord)) {
		
			return false;
		}
		
		if(!this.getTag().equals(aRecord.getTag())) {
		
			return false;
		}
		
		if(this.getPageCount() != aRecord.getPageCount()) {
		
			return false;
		}
		
		return true;
	}
	
	private boolean equalsHelper(BookRecord aRecord) {
	
		for(int i = 0; i < this.authors.length; ++i) {
		
			if(!this.authors[i].equals(aRecord.authors[i])) { //assume the authors will always be provided in the same order
			
				return false;
			}
		}
		
		return true;
	}
}
