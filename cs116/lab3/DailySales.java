public class DailySales {

	private int[] sales;

	// Constructors
	public DailySales() {
	
		sales = new int[10];
	}
	
	public DailySales(int totalDays) {
	
		sales = new int[totalDays];
	}
	
	// Methods
	public boolean addSales(int dayNumber, int s) {
	
		if(dayNumber <= 0 || dayNumber > sales.length) {
		
			return false;
		}
	
		sales[dayNumber - 1] = s;
		
		return true;
	}
	
	public int maxDay() {
	
		int max = 0;
		
		for(int i = 0; i < sales.length; i++) {
		
			if(sales[i] > max) {
			
				max = i;
			}
		}
		
		return max;
	}
	
	public int[] daysBelowGoal() {
	
		String indicies = "";
		
		for(int i = 0; i < sales.length; i++) {
		
			if(sales[i] < 100) {
		
				indicies += i + ",";
			}
		}
		
		String[] list = indicies.split(",");
		int[] days = new int[list.length];
		
		for(int i = 0; i < days.length; i++) {
		
			days[i] = Integer.parseInt(list[i]) + 1;
		}
		
		return days;
	}
	
	public String toString() {
	
		String str = "Sales data: \n";
		
		for(int i = 0; i < sales.length; i++) {

			str += "Day " + (i + 1) + ": " + sales[i] + "\n";
		}
		
		return str;
	}
	
	public int getSales(int day) {
	
		return sales[day];
	}
}
