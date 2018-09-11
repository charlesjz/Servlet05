/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package dao.basic;

import java.util.Currency;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author David Gao
 *
 * This sample demostrates the autoproxying using DefaultAdvisorAutoProxyCreator
 * 
 * This time, all proxies defined using ProxyFactoryBean are removed, except the one
 * defined through DefaultAdvisorAutoProxyCreator.
 * 
 */
public class Sample4a {

	/**
	 * 
	 */
	public Sample4a() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try
		{
			ApplicationContext beanFactory = new FileSystemXmlApplicationContext ( "/src/dao/basic/sample.xml" );
			System.out.println ( "The BeanFactory instance obtained." );

//			CustomerService customerService = (CustomerService) beanFactory.getBean ( "customerService" );
//			AccountService accountService = (AccountService) beanFactory.getBean ( "accountService" );
			CustomerService customerService = (CustomerService) beanFactory.getBean ( "customerService" );
			AccountService accountService = (AccountService) beanFactory.getBean ( "accountService" );

			Customer customer1 = new Customer ( 21, "John", "Smith", "(416)123-1230", "10 Sheppard Ave E", "smithj@yahoo.ca" );
			Customer customer2 = new Customer ( 22, "Maria", "Sun", "(416)123-1231", "11 Sheppard Ave E", "sunm@rogers.ca" );
			Customer customer3 = new Customer ( 23, "Paul", "Martin", "(416)123-1232", "12 Sheppard Ave E", "paul.martin@gov.ca" );

			customerService.createCustomer ( customer1 );
			customerService.createCustomer ( customer2 );
			customerService.createCustomer ( customer3 );

			Account account1 = new Account ( 101, new AccountType ( AccountType.CHECKING_ACCOUNT, Currency.getInstance ( "CAD" ) ) );
			Account account2 = new Account ( 102, new AccountType ( AccountType.SAVING_ACCOUNT, Currency.getInstance ( "CAD" ) ) );
			Account account3 = new Account ( 201, new AccountType ( AccountType.CHECKING_ACCOUNT, Currency.getInstance ( "USD" ) ) );

			customerService.createAccount ( customer1, account1 );
			customerService.createAccount ( customer1, account2 );
			customerService.createAccount ( customer2, account3 );

			customerService.increaseCreditLimit ( customer1, 1000 );
			customerService.increaseCreditLimit ( customer2, 150000 );
			
			System.out.println ( customer1 );
			System.out.println ( customer2 );
			
			System.out.println ( "done." );
		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}

	}
}
