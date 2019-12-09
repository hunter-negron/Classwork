import java.util.*;

public class SupplyOrder {

	protected final int orderId;
	protected String customerId;
	protected String productId;
	protected Date date;
	protected int orderAmount;
	
	protected static int idCounter;
	
	// Constructors
	public SupplyOrder() {
	
		orderId = idCounter;
		idCounter++;
		customerId = "";
		productId = "";
		date = new Date();
		orderAmount = 0;
	}
	
	public SupplyOrder(String c, String p, Date d, int oa) {
	
		orderId = idCounter;
		idCounter++;
		customerId = c;
		productId = p;
		date = d;
		orderAmount = oa;
	}
	
	// Accessors
	public int getOrderId() {
	
		return orderId;
	}
	
	public String getCustomerId() {
	
		return customerId;
	}
	
	public String getProductId() {
	
		return productId;
	}
	
	public Date getDate() {
	
		return date;
	}
	
	public int orderAmount() {
	
		return orderAmount;
	}
	
	// Mutators
	public void setcustomerId(String c) {
	
		customerId = c;
	}
	
	public void setProductId(String p) {
	
		productId = p;
	}
	
	public void setDate(Date d) {
	
		date = d;
	}
	
	public void setOrderAmount(int oa) {
	
		orderAmount = oa;
	}
	
	// Other Methods
	public String toString() {
	
		String str = "";
		str += "================================\n";
		str += "Order ID: " + orderId + "\n";
		str += "Customer ID: " + customerId + "\n";
		str += "Product ID: " + productId + "\n";
		str += "Date: " + date.toString() + "\n";
		str += "Order Amount: " + orderAmount + "\n";
		
		return str;
	}
}
