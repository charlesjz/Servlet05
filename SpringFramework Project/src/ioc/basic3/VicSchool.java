package ioc.basic3;

public class VicSchool {

	public static void main(String[] args) {

		StudentService studentService = new VicCollegeStudentService();
		
		studentService.register( "John Smith" );
		studentService.enroll( "John Smith", "Java EE (I)" );

	}

}
