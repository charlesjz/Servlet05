/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package aop.advice;

import java.util.Currency;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author David Gao
 *
 * This sample illustrates the "Before", "After" and "Around" advices used for 
 * monitoring the customers' credit limit increases.
 * 
 */
public class Sample3a {

	/**
	 * 
	 */
	public Sample3a() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try
		{
			ApplicationContext beanFactory = new FileSystemXmlApplicationContext ( "src/aop/advice/sample.xml" );
			System.out.println ( "The BeanFactory instance obtained." );
		
			CustomerService customerService = (CustomerService) beanFactory.getBean ( "customerService" );
			AccountService accountService = (AccountService) beanFactory.getBean ( "accountService" );

			Customer customer1 = new Customer ( 1, "John", "Smith", "(416)123-1230", "10 Sheppard Ave E", "smithj@yahoo.ca" );
			Customer customer2 = new Customer ( 2, "Maria", "Sun", "(416)123-1231", "11 Sheppard Ave E", "sunm@rogers.ca" );
			Customer customer3 = new Customer ( 3, "Paul", "Martin", "(416)123-1232", "12 Sheppard Ave E", "paul.martin@gov.ca" );
			
			try {
				customerService.createCustomer(customer1);
				customerService.createCustomer(customer2);
				customerService.createCustomer(customer3);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			Account account1 = new Account ( 101, new AccountType ( AccountType.CHECKING_ACCOUNT, Currency.getInstance ( "CAD" ) ) );
			Account account2 = new Account ( 102, new AccountType ( AccountType.SAVING_ACCOUNT, Currency.getInstance ( "CAD" ) ) );
			Account account3 = new Account ( 201, new AccountType ( AccountType.CHECKING_ACCOUNT, Currency.getInstance ( "USD" ) ) );

			customerService.createAccount ( customer1, account1 );
			customerService.createAccount ( customer1, account2 );
			customerService.createAccount ( customer2, account3 );

			try
			{
				customerService.increaseCreditLimit ( customer1, 1000 );
			}
			catch ( HighCreditLimitIncreaseException hclie )
			{
				System.err.println ( "The increase exceeds the limitation." );
			}
			try
			{
				customerService.increaseCreditLimit ( customer2, 350000 );
			}
			catch ( HighCreditLimitIncreaseException hclie )
			{
				System.err.println ( "The increase exceeds the limitation." );
			}
			
			System.out.println ( customer1 );
			System.out.println ( customer2 );
			System.out.println ( customer3 );

			System.out.println ( "done." );
		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}

	}
}
