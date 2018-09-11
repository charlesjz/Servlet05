/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package remote.rmi.client;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import remote.rmi.*;

/**
 * @author David Gao
 *
 * This sample is written based on sample4d (using programming transaction management) and
 * demonstrates the RMI usage.
 * 
 */
public class Sample5aClient {

	/**
	 * 
	 */
	public Sample5aClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try
		{
			ApplicationContext beanFactory = new FileSystemXmlApplicationContext ( "src/remote/rmi/client/sample.xml" );
			System.out.println ( "The BeanFactory instance obtained." );

			Object obj = beanFactory.getBean ( "customerService" );
			System.out.println ( "***" + obj.getClass().getName() );

			CustomerService customerService = (CustomerService) beanFactory.getBean ( "customerService" );
			AccountService accountService = (AccountService) beanFactory.getBean ( "accountService" );

			// The following codes show inserting three individual recrod.
			
			Customer customer1 = new Customer ( 1, "Eric", "Chou", "(416)123-1230", "10 Sheppard Ave E", "smithj@yahoo.ca" );
			Customer customer2 = new Customer ( 2, "Maria", "Sun", "(416)123-1231", "11 Sheppard Ave E", "sunm@rogers.ca" );
			Customer customer3 = new Customer ( 3, "Paul", "Martin", "(416)123-1232", "12 Sheppard Ave E", "paul.martin@gov.ca" );

			customerService.createCustomer ( customer1 );
			//customerService.createCustomer ( customer2 );
			//customerService.createCustomer ( customer3 );


			// The following codes show inserting three recrods in a batch.
			/*
			Customer customer4 = new Customer ( 4, "John", "Smith", "(416)123-1230", "10 Sheppard Ave E", "smithj@yahoo.ca" );
			Customer customer5 = new Customer ( 5, "Maria", "Sun", "(416)123-1231", "11 Sheppard Ave E", "sunm@rogers.ca" );
			Customer customer6 = new Customer ( 6, "Paul", "Martin", "(416)123-1232", "12 Sheppard Ave E", "paul.martin@gov.ca" );

			List customers = new ArrayList ( );
			customers.add ( customer4 );
			customers.add ( customer5 );
			customers.add ( customer6 );
			customerService.createCustomer ( customers );

			customerService.increaseCreditLimit ( customer1, 1000 );
			customerService.increaseCreditLimit ( customer2, 150000 );
			*/

			/*
			Customer customer11 = customerService.getCustomer ( 1 );
			Customer customer22 = customerService.getCustomer ( 2 );
			*/

			// The following codes are designed to demo the account recrods insertion.
			/*
			Account account1 = new Account ( 101, new AccountType ( AccountType.CHECKING_ACCOUNT, Currency.getInstance ( "CAD" ) ) );
			Account account2 = new Account ( 102, new AccountType ( AccountType.SAVING_ACCOUNT, Currency.getInstance ( "CAD" ) ) );
			Account account3 = new Account ( 201, new AccountType ( AccountType.CHECKING_ACCOUNT, Currency.getInstance ( "USD" ) ) );

			customerService.createAccount ( customer1, account1 );
			customerService.createAccount ( customer1, account2 );
			customerService.createAccount ( customer2, account3 );
			*/


//			System.out.println ( customer11 );

			// The following codes are designed to demo the CustomerService.getAccountList() method,
			// which used RowMapper interface.
			/*
			List accounts1 = customerService.getAccountList( customer11 );
			for ( int k = 0; k < accounts1.size(); k ++ )
			{
				System.out.println ( (Account) accounts1.get ( k ) );
			}
			*/
			
//			System.out.println ( customer22 );

			// The following codes are designed to demo the CustomerService.getAccountList() method,
			// which used RowMapper interface.
			/*
			List accounts2 = customerService.getAccountList( customer22 );
			for ( int k = 0; k < accounts2.size(); k ++ )
			{
				System.out.println ( (Account) accounts2.get ( k ) );
			}
			*/
			/*
			Account acct = accountService.getAccount( 201 );
			Account acct2 = accountService.getAccount( 101 );
			System.out.println ( acct );
			System.out.println ( acct2 );
			*/
			// The following codes show the deposit/withdraw/transfer methods.
			/*
			accountService.deposit ( acct, 1000 );
			accountService.deposit ( acct2, 10000 );
			System.out.println ( acct );
			System.out.println ( acct2 );
			
			accountService.withdraw ( acct, 100 );
			accountService.withdraw ( acct2, 1000 );
			System.out.println ( acct );
			System.out.println ( acct2 );

			accountService.transfer ( acct2, acct, 300000 );
			System.out.println ( acct );
			System.out.println ( acct2 );
			*/

			System.out.println ( "Total number of customers is: " + customerService.getNumberOfPersons() );

			// The following codes are showing that creating accounts using stored-procedure.
			/*			
			Account account1 = new Account ( 101, new AccountType ( AccountType.CHECKING_ACCOUNT, Currency.getInstance ( "CAD" ) ) );
			System.out.println ( account1 );
			customerService.createAccount ( customer1, account1 );
			System.out.println ( account1 );
			*/
			
			System.out.println ( "done." );
		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}

	}
}
