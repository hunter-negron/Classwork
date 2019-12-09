import java.util.*;

public class DailySalesClient {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of days (<=0 will assume 10): ");
		int numberOfDays = Integer.parseInt(in.next());
		
		if(numberOfDays <= 0) {
		
			numberOfDays = 10;
		}
		
		DailySales ds = new DailySales(numberOfDays);
		
		do {
		
			System.out.print("Enter day to enter input (<=0 will quit): ");
			int day = Integer.parseInt(in.next());
			
			if(day <= 0) {
			
				break;
			}
			
			System.out.print("Enter sales for day " + day + ": ");
			int sales = Integer.parseInt(in.next());
			
			ds.addSales(day, sales);
			
			System.out.println("successfully added data:");
			System.out.println(ds);
				
		} while(true);	
		
		System.out.println("Final sales analysis:");
		System.out.println(ds);
		System.out.println("Max sales occurred during day " + ds.maxDay());		
		System.out.println("Days not meeting sales goal: ");
		int[] days = ds.daysBelowGoal();	
		String str = "";	
		
		for(int i = 0; i < days.length; i++) {

			str += "Day " + days[i] + ": " + ds.getSales(days[i] - 1) + "\n";
		}
		
		System.out.println(str);
	}
}
