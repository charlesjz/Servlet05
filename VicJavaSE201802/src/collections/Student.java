package collections;

public class Student {
	public String firstname;
	public String lastname;
	public int age;
	public double salary;
	
	public Student (
			String firstname,
			String lastname,
			int age,
			double salary ) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.salary = salary;
	}

	public String toString ( ) {
		return "firstname = " + this.firstname
			+ ", lastname = " + this.lastname
			+ ", age = " + age
			+ ", salary = " + salary;
	}
	
	@Override
	public boolean equals ( Object other ) {
		if ( other instanceof Student ) {
			Student otherStudent = (Student) other;
			if ( this.firstname == null || this.lastname == null || 
				 otherStudent.firstname == null || otherStudent.lastname == null ) {
				return false;
			} else {
				return this.firstname.equals(otherStudent.firstname) &&
						this.lastname.equals(otherStudent.lastname) &&
						this.age == otherStudent.age;
			}
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode ( ) {
		return this.firstname.hashCode() * 100 + this.lastname.hashCode() * 10 + this.age;
	}
}
