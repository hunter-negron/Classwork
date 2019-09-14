enum Days { Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday};

public class EnumDemo {

	public static void main(String[] args) {
	
		Days today = Days.Tuesday;
		Days tomorrow = Days.Wednesday;
		
		System.out.println("Are today and tomorrow equal? " + today.equals(tomorrow));
		
		int cmp = today.compareTo(tomorrow);
		if(cmp < 0):
			System.out.println("Today comes before tomorrow");
		else if(cmp == 0):
			System.out.println("Today is the same as tomorrow");
		else:
			System.out.println("Today comes after tomorrow");
	
	}
}
