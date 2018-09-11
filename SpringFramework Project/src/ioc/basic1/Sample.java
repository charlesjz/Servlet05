/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.basic1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author David Gao
 *
 * This sample is built on top of sample2_1a and illustrates the singleton usage in getting beans
 * and in wiring beans.
 * 
 * This sample needs to add the following codes in CustomerServicesImpl.java:
 * 
 * 	private Customer customer0 = null;
 * 
 *  public Customer getCustomer0() {
 *		return customer0;
 *	}
 *
 *	public void setCustomer0(Customer customer) {
 *		customer0 = customer;
 *	}
 * 
 */
public class Sample {

	/**
	 * 
	 */
	public Sample() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try
		{
			BeanFactory beanFactory = new XmlBeanFactory ( new FileSystemResource ( "C:\\Users\\gaod\\Google Drive\\eclipse-workspaces\\java_ee\\SpringFramework Project\\src\\ioc\\basic1\\beans.xml") );
			System.out.println ( "The BeanFactory instance obtained." );
			
			BankingService service = (BankingService) beanFactory.getBean( "bankingService" );
			BankingService service2 = (BankingService) beanFactory.getBean( "bankingService" );
			service.deposit( 100 );
			service.withdraw( 20 );
			
//			Account account1 = new Account ( );
			Account account1 = (Account) beanFactory.getBean( "account" );
			account1.setAccountNumber( account1.getAccountNumber() + "01" );
			account1.setAccountName( "Eric's first account" );
//			account1.setBalance( 1000 );
			
//			Account account2 = new Account ( );
			Account account2 = (Account) beanFactory.getBean( "account" );
			account2.setAccountNumber( account1.getAccountNumber() + "02" );
//			account2.setAccountNumber( "10000002");
			account2.setAccountName( "Frank's first account" );
			account2.setBalance( 2000 );
			
			service.createAccount ( account1 );
			service2.createAccount ( account2 );
			
			service.printAllAccounts();
			
		
		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}

	}
}
