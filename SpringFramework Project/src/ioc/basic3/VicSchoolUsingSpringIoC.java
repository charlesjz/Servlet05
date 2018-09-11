package ioc.basic3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class VicSchoolUsingSpringIoC {

	public static void main(String[] args) {

//		StudentService studentService = new VicCollegeStudentService();
//		
//		studentService.register( "John Smith" );
//		studentService.enroll( "John Smith", "Java EE (I)" );
		
		try
		{
			BeanFactory beanFactory = new XmlBeanFactory ( new FileSystemResource ( "C:\\work\\workspaces\\java-se\\SpringFramework Project\\src\\ioc\\basic3\\viccollege.xml") );
			System.out.println ( "The BeanFactory instance obtained." );
		
			StudentService studentService = (StudentService) beanFactory.getBean( "studentService" );
			StudentService studentService2 = (StudentService) beanFactory.getBean( "studentService" );
			
			System.out.println( "studentService == studentService2 ? " + (studentService == studentService2 ) );
			studentService.register( "John Smith" );
			studentService.enroll( "John Smith", "Java EE (I)" );

		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}


	}

}
