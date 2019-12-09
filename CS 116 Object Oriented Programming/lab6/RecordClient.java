public class RecordClient {

	public static void main(String[] args) {
	
		HardBook obj1 = new HardBook("Book!", "Joe Smith", "Tomorrow", 1);
		Newspaper obj2 = new Newspaper("The Daily", "Joe Smith", "Yesterday", "Chicago");
		ElectronicMagazine obj3 = new ElectronicMagazine("Magazine!", "Joe Smith", "Today", 1, 1, "example.net");
		
		System.out.println("obj1\n" + obj1);
		System.out.println("obj2\n" + obj2);
		System.out.println("obj3\n" + obj3);
	}
}
