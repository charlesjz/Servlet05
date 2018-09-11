package language_fundation.oo;

public class TestStudent {

	public TestStudent() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Student s1 = new Student ( "John", "Smith" );
		s1.firstname = "John";
		s1.lastname = "Smith";
		Student.schoolName = "Victoria College";
		
		Student.printSchoolInfo();
		
		s1.printInfo();
		
		Student s2 = new Student ( "Peter", "Pan" );
		s2.firstname = "Peter";
		s2.lastname = "Pan";
		s2.schoolName = "Victoria Park";

		s1.printInfo();
		s2.printInfo();
		
		int result = s1.add ( 10, 20 );
		System.out.println( "result = " + result );
	}

}
