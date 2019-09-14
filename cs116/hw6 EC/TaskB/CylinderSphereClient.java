public class CylinderSphereClient {

	public static void main(String[] args) {
	
		Cylinder cylinder1 = new Cylinder(28.0, 35.0);
		System.out.println(cylinder1);
		
		Sphere sphere1 = new Sphere(6.0);
		System.out.println(sphere1);
		
		System.out.print(cylinder1.volume() / sphere1.volume());
		System.out.println(" spheres in the cylinder.\n");
		
		Circle circle1 = new Circle(1.0);
		
		circle1 = cylinder1;
		System.out.println(circle1);
		
		circle1 = sphere1;
		System.out.println(circle1);
		
		Circle[] rounds = new Circle[3];
		rounds[0] = new Circle(11.0);
		rounds[1] = new Cylinder(12.0, 13.0);
		rounds[2] = new Sphere(14.0);
		
		for(Circle c : rounds) {
		
			System.out.println(c);
		}
	}
}
