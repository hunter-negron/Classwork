import java.util.*;

public class PhoneClient {
	public static void main(String[] args) {

		// create a Phone
		Phone phone1 = new Phone("312", "867", "5309");
		System.out.println("phone1:"+phone1.toString()+"\n");

		// create a BusinessPhone
		BusinessPhone businessPhone1 = new BusinessPhone("312", "567", "3000", "5148");
		System.out.println("businessPhone1:"+businessPhone1.toString()+"\n");

		// create a BusinessPhone from a Phone
		BusinessPhone businessPhone2 = new BusinessPhone(phone1, "1111");
		System.out.println("businessPhone2:"+businessPhone2.toString()+"\n");

		// change the Phone
		phone1.setArea("773");
		System.out.println("phone1:"+phone1.toString()+"\n");

		// output the BusinessPhone created from the Phone
		System.out.println("businessPhone2:"+businessPhone2.toString()+"\n");

		// call Phone method on a BusinessPhone
		System.out.println("businessPhone1 exchange:" + businessPhone1.getExchange()+"\n");

		// try to create a bad phone number
		Phone phone2 = new Phone("111", "867", "309");
		System.out.println("phone2:"+phone2.toString()+"\n");

		// call a BusinessPhone method on a Phone
		//This should not work. why?
		//String temp = phone1.getExtension();
		
		// User Input
		Scanner s = new Scanner(System.in);
		System.out.println("Area Code: ");
		String a = s.nextLine();
		System.out.println("Exchange: ");
		String e = s.nextLine();
		System.out.println("Number: ");
		String n = s.nextLine();
		Phone p = new Phone(a, e, n);
		System.out.println(p);
	}
}
