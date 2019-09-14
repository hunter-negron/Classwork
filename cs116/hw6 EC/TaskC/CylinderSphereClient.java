public class CylinderSphereClient {

	public static void main(String[] args) {
	
		Cylinder cylinder1 = new Cylinder(1.0, 2.0);		
		Sphere sphere1 = new Sphere(3.0);
		System.out.println(cylinder1);
		System.out.println(sphere1);
		
		CircleVolume cv1 = cylinder1;
		CircleVolume cv2 = sphere1;
		
		cv1.setRadius(11.0);
		cv2.setRadius(12.0);
		System.out.println(cv1.getRadius());
		System.out.println(cv2.getRadius());
		System.out.println(cv1.circumference());
		System.out.println(cv2.circumference());
		System.out.println(cv1.area());
		System.out.println(cv2.area());
		System.out.println(cv1.volume());
		System.out.println(cv2.volume());
		System.out.println(cv1);
		System.out.println(cv2);
		
		CircleVolume[] rounds = new CircleVolume[4];
		rounds[0] = new Cylinder(20.0, 21.0);
		rounds[1] = new Cylinder(22.0, 23.0);
		rounds[2] = new Sphere(24.0);
		rounds[3] = new Sphere(25.0);
		
		for(CircleVolume cv : rounds) {
		
			System.out.println(cv);
		}
	}
}
