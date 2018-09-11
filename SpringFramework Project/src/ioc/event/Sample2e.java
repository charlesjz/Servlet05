/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.event;

import java.util.Currency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author David Gao
 *
 * This sample illustrates the usage of publishing and listening events.
 * As an example, we use the publish/listen to log the creations of new customer and
 * new accounts.
 * 
 * But we haven't reach the awareness of beans and factories, so we implemented a
 * Service bean, which contains a static ApplicationContext variable.
 * 
 */
public class Sample2e {

	/**
	 * 
	 */
	public Sample2e() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try
		{
			ApplicationContext beanFactory = new FileSystemXmlApplicationContext ( "src/ioc/event/sample.xml" );
			System.out.println ( "The BeanFactory instance obtained." );
		
			CustomerService customerService = (CustomerService) Service.beanFactory.getBean ( "customerService" );
			AccountService accountService = (AccountService) Service.beanFactory.getBean ( "accountService" );

			Customer customer1 = new Customer ( 1, "John", "Smith", "(416)123-1230", "10 Sheppard Ave E", "smithj@yahoo.ca" );
			Customer customer2 = new Customer ( 2, "Maria", "Sun", "(416)123-1231", "11 Sheppard Ave E", "sunm@rogers.ca" );
			
			customerService.createCustomer ( customer1 );
			customerService.createCustomer ( customer2 );
			
			Account account1 = new Account ( 101, new AccountType ( AccountType.CHECKING_ACCOUNT, Currency.getInstance ( "CAD" ) ) );
			Account account2 = new Account ( 102, new AccountType ( AccountType.SAVING_ACCOUNT, Currency.getInstance ( "CAD" ) ) );
			Account account3 = new Account ( 201, new AccountType ( AccountType.CHECKING_ACCOUNT, Currency.getInstance ( "USD" ) ) );

			customerService.createAccount ( customer1, account1 );
			customerService.createAccount ( customer1, account2 );
			customerService.createAccount ( customer2, account3 );			

			System.out.println ( "done." );
		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}

	}
}
