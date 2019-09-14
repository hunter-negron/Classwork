import java.util.*;

public class RepeatedOrder extends SupplyOrder {

	private int period;
	private Date endDate;
	
	// Constructors
	public RepeatedOrder() {
	
		super();
		period = 0;
		endDate = new Date();
	}
	
	public RepeatedOrder(String c, String p, Date d, int oa, int per, Date ed) {
	
		super(c, p, d, oa);
		period = per;
		endDate = ed;
	}
	
	// Accessors
	public int getPeriod() {
	
		return period;
	}
	
	public Date getEndDate() {
	
		return endDate;
	}
	
	// Mutators
	public void setPeriod(int per) {
	
		period = per;
	}
	
	public void setEndDate(Date ed) {
	
		endDate = ed;
	}
	
	// Other Methods
	public String toString() {
	
		String str = super.toString();
		str += "Period: " + period + "\n";
		str += "End Date: " + endDate.toString() + "\n";
		
		return str;
	}
}
