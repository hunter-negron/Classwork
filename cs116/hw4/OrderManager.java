import java.util.*;
import java.io.*;
import java.text.*;

public class OrderManager {

	static ArrayList<SupplyOrder> orders = new ArrayList<SupplyOrder>();

	public static void main(String[] args) {
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
				
		try {
		// Part A
		System.out.println((new SupplyOrder()).toString());
		System.out.println((new RepeatedOrder()).toString());
		System.out.println((new SupplyOrder("C ID", "P ID", dateFormatter.parse("01/01/2011"), 12)).toString());
		System.out.println((new RepeatedOrder("C ID", "P ID", dateFormatter.parse("01/01/2011"), 12, 100, dateFormatter.parse("01/01/2012"))).toString());
		
		// Part B
		
			Scanner scan = new Scanner(new File("orders.txt"));
			
			while(scan.hasNextLine()) {
			
				String[] tok = scan.nextLine().split(",");
				
				String customerId = tok[1];
				String productId = tok[2];
				Date orderDate = dateFormatter.parse(tok[3]);
				int orderAmount = Integer.valueOf(tok[4]);
				
				if(tok[0].equals("O")) {
				
					orders.add(new SupplyOrder(customerId, productId, orderDate, orderAmount));
				}
				else { // "R"
				
					int period = Integer.valueOf(tok[5]);
					Date endDate = dateFormatter.parse(tok[6]);
					orders.add(new RepeatedOrder(customerId, productId, orderDate, orderAmount, period, endDate));
				}
			}
		
			//User options
			String option1;
			scan = new Scanner(System.in);
			option1="";
			
			while(!option1.equals("Q")) {
			
				System.out.println("Select an option:");
				System.out.println("Type \"A\" to add an order.");
				System.out.println("Type \"D\" to delete an order.");		
				System.out.println("Type \"L\" to List orders of a customer.");		
				System.out.println("Type \"Q\" to Quit.");
				option1=scan.nextLine();
				
				switch (option1) {
					case "A":	System.out.println("One-Time or Repeated? (O/R): ");				
								String orderType = scan.nextLine();
					
								if(orderType.equals("O")) {
																
									System.out.println("Customer ID: ");
									String customerId = scan.nextLine();
									System.out.println("Product ID: ");
									String productId = scan.nextLine();
									System.out.println("Date: ");
									Date orderDate = dateFormatter.parse(scan.nextLine());
									System.out.println("Order Amount: ");
									int orderAmount = Integer.valueOf(scan.nextLine());	
									orders.add(new SupplyOrder(customerId, productId, orderDate, orderAmount));	
									System.out.println(orders.get(orders.size() - 1));					
								}
								else if(orderType.equals("R")) {
																
									System.out.println("Customer ID: ");
									String customerId = scan.nextLine();
									System.out.println("Product ID: ");
									String productId = scan.nextLine();
									System.out.println("Date: ");
									Date orderDate = dateFormatter.parse(scan.nextLine());
									System.out.println("Order Amount: ");
									int orderAmount = Integer.valueOf(scan.nextLine());	
									System.out.println("Period: ");
									int period = Integer.valueOf(scan.nextLine());	
									System.out.println("End Date: ");
									Date endDate = dateFormatter.parse(scan.nextLine());
									
									orders.add(new RepeatedOrder(customerId, productId, orderDate, orderAmount, period, endDate));	
									System.out.println(orders.get(orders.size() - 1));						
								}
								else {
								
									System.out.println("Invalid order type.");
									break;
								}
								
								break;									
					
					case "D":   System.out.println("Order ID to delete: ");				
								int id = Integer.valueOf(scan.nextLine());
								
								for(int i = 0; i < orders.size(); i++) {

									SupplyOrder s = orders.get(i);
									
									if(s.getOrderId() == id) {
										orders.remove(i);
										System.out.println(id + " successfully deleted.");
										break;
									}
								}
									 
								break;								
					
					case "L":   System.out.println("Customer ID to print: ");				
								String cid = scan.nextLine();
								sortAndPrint(cid);
									 
								break;
					
					case "Q":   System.out.println("Quitting interactive part.");
								break;
								
					default:	System.out.println("Invalid. Try again.");
								break;
				
				}
			}
		}
		catch(Exception e) {
		
			e.printStackTrace();
		}
	}
	
	private static void sortAndPrint(String id) {
	
		// Selection Sort
		for(int i = 1; i <= orders.size(); i++) {
		
			int largest = 0;
			for(int j = 0; j <= orders.size() - i; j++) {
			
				if(orders.get(j).getDate().compareTo(orders.get(largest).getDate()) > 1) {
				
					largest = j;
				}
			}
			
			SupplyOrder temp = orders.get(orders.size() - i);
			orders.set(orders.size() - i, orders.get(largest));
			orders.set(largest, temp);
		}
		
		// Print
		for(SupplyOrder s : orders) {
		
			if(s.getCustomerId().equals(id)) {
			
				System.out.println(s);
			}
		}
	}
}
