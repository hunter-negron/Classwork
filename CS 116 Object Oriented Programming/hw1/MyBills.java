package Client.Services.Classes;

import Client.Services.BillsType;

public class MyBills {

	String month;
	BillsType type;
	double[] expenses;
	int numberOfDays;
	
	final int ID;
	static int idCounter; // IDs are assigned starting at 0
	
	// Constructors
	public MyBills() {
		
		month = "Any Month";
		type = null;
		expenses = null;
		numberOfDays = 0;
		ID = idCounter;
		idCounter++;
	}
	
	public MyBills(String m, BillsType bt, double[] e, int n) {
	
		month = m;
		type = bt;
		expenses = e;
		numberOfDays = n;
		ID = idCounter;
		idCounter++;	
	}
	
	// Accessors
	public String getMonth() {
	
		return month;
	}
	
	public BillsType getType() {
	
		return type;
	}
	
	public double[] getExpenses() {
	
		return expenses;
	}
	
	public int getNumberOfdays() {
	
		return numberOfDays;
	}
	
	public int getID() {
	
		return ID;
	}
	
	// Mutators
	public void setMonth(String m) {
	
		month = m;
	}
	
	public void setType(BillsType bt) {
	
		type = bt;
	}
	
	public void setExpenses(double[] e) {
	
		expenses = e;
	}
	
	public void setNumberOfDays(int n) {
	
		numberOfDays = n;
	}
	
	// Methods
	public boolean equals(MyBills mb) {
	
		return (this.type == mb.type) && (this.numberOfDays == mb.numberOfDays);
	}
	
	
	public String toString() {
	
		String expensesStr = "";
		
		for(double d : expenses) {
		
			expensesStr += d + ", ";
		}
	
		return  "Month: "          + month        + "\n" +
				"Type: "           + type         + "\n" +
				"Expenses: "       + expensesStr  + "\n" +
				"Number of days: " + numberOfDays + "\n" +
				"Object ID: "      + ID           + "\n" +
				"ID counter: "     + idCounter    + "\n" ;
	}
}
