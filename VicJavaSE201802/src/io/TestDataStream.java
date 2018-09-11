package io;

public class TestDataStream {

	public static void main(String[] args) {
		
		Student[] students = {
				new Student ( "John", "Smith", 30, 67890.23 ),
				new Student ( "Peter", "Pan", 20, 59823.12 ),
				new Student ( "Mary", "Poppins", 23, 107890.23 )
		};
		
		System.out.println( "+----------+-----------+-----+-----------+");
		System.out.println( "|First Name| Last Name | Age |   Salary  |");
		System.out.println( "+----------+-----------+-----+-----------+");
		for ( Student student : students ) {
			System.out.format("|%10s|%11s| %3d |%010.2f |%n", student.firstname, student.lastname, student.age, student.salary );
			System.out.println( "+----------+-----------+-----+-----------+");
		}
	}

}

class Student {
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
}
