package inheritance;

public class Student {
	
	private String name;
	private int age;
	private Address address;

	public Student() { }

	public Student( String name, int age ) {
		this.name = name;
		this.age = age;
	}

	public Student( String name, int age, Address address ) {
		this ( name, age );
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	protected Student clone() throws CloneNotSupportedException {
		Student newStudent = new Student ( this.name, this.age );
		newStudent.setAddress( this.address.clone() );
		return newStudent;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( obj == null ) {
			return false;
		} else if ( obj instanceof Student ) {
			Student anotherStudent = (Student) obj;
			if ( this.name == null || anotherStudent.name == null ) {
				return false;
			} else {
				return this.name.equals( anotherStudent.name ) && this.age == anotherStudent.age;
			}
		} else {
			return false;
		}
		
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode() * 10 + this.age;
	}
	
	@Override
	public String toString() {
		return "Student: name = " + this.name + ", age = " + this.age + ", " + this.address;
	}

}
