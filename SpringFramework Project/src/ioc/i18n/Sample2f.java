/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.i18n;

import java.util.Currency;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author David Gao
 *
 * This sample is built based on sample2e, adding the awareness of beans and
 * factories.
 * 
 * Besides, it also shows the I18N, that is:
 * MessageSource
 * ResourceBundleMessageSource
 * ApplicationContext.getMessage()
 * 
 */
public class Sample2f {

	/**
	 * 
	 */
	public Sample2f() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try
		{
			ApplicationContext beanFactory = new FileSystemXmlApplicationContext ( "src/ioc/i18n/sample.xml" );
			System.out.println ( "The BeanFactory instance obtained." );
		
			CustomerService customerService = (CustomerService) beanFactory.getBean ( "customerService" );
			AccountService accountService = (AccountService) beanFactory.getBean ( "accountService" );
			
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

			customerService.increaseCreditLimit ( customer1 );

			System.out.println ( "done." );
		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}

	}
}
