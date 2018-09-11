package aop.from_scratch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainProgram {

	public static void main(String[] args) {
		try
		{
			ApplicationContext beanFactory = new FileSystemXmlApplicationContext ( "src/aop/from_scratch/beans.xml" );
			System.out.println ( "The BeanFactory instance obtained." );
		
			ArtemisService artemisService = (ArtemisService) beanFactory.getBean ( "artemisService" );

			artemisService.drink ( "Coffee" );
			artemisService.eat( "Ice Cream" );
			artemisService.watchMovie( "Bad Ice Cream" );

			System.out.println ( "done." );
		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}
	}
}
