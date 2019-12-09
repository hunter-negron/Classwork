package Client;

import Client.Services.Classes.MyBills;
import Client.Services.BillsType;

import java.util.*;
import java.io.*;

public class MyBillsClient {

	public static void main(String[] args) {
	
		try {
		
			Scanner s = new Scanner(new File("myexpenses.txt"));
			List<MyBills> bills = new ArrayList<MyBills>();
			
			while(s.hasNextLine()) {
			
				// Get lines from file
				String[] first = s.nextLine().split(":");
				String[] second = s.nextLine().split(",");
				
				// Use data from file for various attributes
				String month = first[1];
				BillsType type = BillsType.valueOf(first[3]);
				double[] expenses = new double[second.length];
				
				for(int i = 0; i < expenses.length; i++) {
				
					expenses[i] = Double.valueOf(second[i]);
				}
				
				bills.add(new MyBills(month, type, expenses, expenses.length));
			}
			
			// Output #1
			System.out.println("Output #1:");
			for(MyBills mb : bills) {
			
				System.out.println(mb);
			}
			
			// Output #2
			System.out.println("Output #2:");
			MyBillsClient mbc = new MyBillsClient();
			MyBills[] arrayForm = new MyBills[bills.size()];             // Converting ArrayList
			for(int i=0;i<bills.size();i++){arrayForm[i]=bills.get(i);}  //      to array
			String[] totals = mbc.totalExpensesPerMonth(arrayForm);
			
			for(int i = 0; i < totals.length; i++) {
			
				System.out.println(totals[i]);
			}
		}
		catch(Exception e) {
		
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public String[] totalExpensesPerMonth(MyBills[] exp) {
	
		String[] out = new String[12];
		
		String[] months = { "JANUARY"  , "FEBRUARY",    "MARCH",    "APRIL", 
							"MAY"      , "JUNE"    ,     "JULY",   "AUGUST", 
							"SEPTEMBER", "OCTOBER" , "NOVEMBER", "DECEMBER"};
		
		for(int i = 0; i < out.length; i++) {
		
			double monthlyTotal = 0.0;
		
			for(int j = 0; j < exp.length; j++) {
			
				if(exp[j].getMonth().equals(months[i])) {
				
					for(double d : exp[j].getExpenses()) {
					
						monthlyTotal += d;
					}
				}
			}
			
			out[i] = "The total expenses for " + months[i] + " is $" + monthlyTotal;
		}
		
		return out;
	}
}
