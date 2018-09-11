/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package email;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author David Gao
 *
 * This sample demostrates the email function via Spring Framework.
 * 
 */
public class Sample6c {

	/**
	 * 
	 */
	public Sample6c() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws CustomerNotAvailableException {

		try
		{
			ApplicationContext beanFactory = new FileSystemXmlApplicationContext ( "src/email/sample.xml" );
			System.out.println ( "The BeanFactory instance obtained." );
			
			CustomerService customerService = (CustomerService) beanFactory.getBean ( "customerService" );
			AccountService accountService = (AccountService) beanFactory.getBean ( "accountService" );

			Customer customer5 = new Customer ( 5, "Maria", "Sun", "(416)123-1231", "11 Sheppard Ave E", "charles.j.zhu@gmail.com" );
			Customer customer6 = new Customer ( 6, "Paul", "Martin", "(416)123-1232", "12 Sheppard Ave E", "charles.j.zhu@gmail.com" );

			customerService.increaseCreditLimit ( customer5, 1000 );
			customerService.increaseCreditLimit ( customer6, 150000 );

			System.out.println ( "done." );
		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}

		
//		System.out.println("Test!");
//		ApplicationContext beanFactory = new FileSystemXmlApplicationContext("/src/email/sample.xml");
//		CustomerService customerService = (CustomerService) beanFactory.getBean ( "customerService" );
//		Customer customer5 = new Customer ( 5, "Maria", "Sun", "(416)123-1231", "11 Sheppard Ave E", "charles.j.zhu@gmail.com" );
//		customerService.increaseCreditLimit ( customer5, 1000 );
//		System.out.println ( "done." );

	}
}
