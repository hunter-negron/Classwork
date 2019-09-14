public class Student {

	private String firstName;
	private String lastName;
	private int age;
	
	/*public Student() {
		this.firstName = "";
		this.lastName = "";
		this.age = 0;
	}*/

	public Student(String f, String l, int a) {
		this.firstName = f;
		this.lastName = l;
		this.age = a;
	}	
	
	// Accessors
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public int getAge() {
		return this.age;
	}
	
	// Mutators
	public void setFirstName(String f) {
		this.firstName = f;
	}
	
	public void setLastName(String l) {
		this.lastName = l;
	}
	
	public void setAge(int a) {
		this.age = a;
	}
	
	public boolean equals(Student s) {
			return this.firstName.equals(s.firstName) &&
					this.lastName.equals(s.lastName) &&
					this.age.equals(s.age)
}

