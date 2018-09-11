/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package javatimer;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.time.LocalTime;
import java.util.TimerTask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author David Gao
 *
 * This sample demostrates the email function via Spring Framework.
 * 
 */
public class Sample6e {

	/**
	 * 
	 */
	public Sample6e() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try
		{
			ApplicationContext beanFactory = new FileSystemXmlApplicationContext ( "src/javatimer/sample.xml" );
			System.out.println ( "The BeanFactory instance obtained." );
			
			CustomerService customerService = (CustomerService) beanFactory.getBean ( "customerService" );
			AccountService accountService = (AccountService) beanFactory.getBean ( "accountService" );

//			Customer customer5 = new Customer ( 5, "Maria", "Sun", "(416)123-1231", "11 Sheppard Ave E", "davidgao2008@yahoo.ca" );
//			Customer customer6 = new Customer ( 6, "Paul", "Martin", "(416)123-1232", "12 Sheppard Ave E", "davidgao2008@yahoo.ca" );
////			Customer customer5 = customerService.getCustomer ( 5 );
////			Customer customer6 = customerService.getCustomer ( 6 );
//
//			customerService.increaseCreditLimit ( customer5, 1000 );
//			customerService.increaseCreditLimit ( customer6, 150000 );

			System.out.println ( "NCT Bank Services ( CustomerService and AccountService ) has started, type \"EXIT\" to terminate . . ." );
			while ( ( new LineNumberReader ( new InputStreamReader ( System.in ) ) ).readLine ( ).equalsIgnoreCase ( "EXIT" ) );

			System.out.println ( "done." );
		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}

//		org.springframework.mail.javamail.JavaMailSenderImpl sender = 
//			new org.springframework.mail.javamail.JavaMailSenderImpl ( );
//		sender.


	}

	public void checkCredit() {

		System.out.println( "I'm checking the credit @ " + LocalTime.now() );
		
	}
}
