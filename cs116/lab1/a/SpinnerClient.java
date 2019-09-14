public class SpinnerClient {

	public static void main(String[] args) {
		Spinner d1 = new Spinner();
		Spinner d2 = new Spinner(8);
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println("d1 + d2 = " + (d1.getArrow() + d2.getArrow()));
		
		d1.spin();
		d2.spin();
		System.out.println("Same value? " + d1.equals(d2));
		
		System.out.println("d1: " + d1.getArrow());
		System.out.println("d2: " + d2.getArrow());
		System.out.println("d1 + d2 = " + (d1.getArrow() + d2.getArrow()));
			
	}
}
