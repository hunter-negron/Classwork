public class CylinderClient {

	public static void main(String[] args) {
	
		Circle circle1 = new Circle(1.0);
		System.out.println(circle1);
		
		Cylinder cylinder1 = new Cylinder(2.0, 3.0);
		System.out.println(cylinder1);
		
		Cylinder cylinder2 = new Cylinder(circle1, 4.0);
		System.out.println(cylinder2);
		
		circle1.setRadius(5.0);
		System.out.println(circle1);
		
		cylinder1.setRadius(6.0);
		System.out.println(cylinder1.getRadius());
		System.out.println(cylinder1.circumference());
		System.out.println(cylinder1.area());
	}
}
