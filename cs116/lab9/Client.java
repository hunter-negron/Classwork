import java.util.*;

public class Client {

	public static void main(String[] args) {
		
		// First Output
		System.out.println("First Output");
		B b = new B();
		C c = new C();
		
		System.out.println(b.m1());
		System.out.println(b.m1());
		
		// Second Output
		System.out.println("\nSecond Output");
		C d1 = new D();
		d1.m3();
		
		// Third Output
		System.out.println("\nThird Output");
		D d2 = new D();
		d2.m2('e');
		((A) d2).m2('f');
	}
}
