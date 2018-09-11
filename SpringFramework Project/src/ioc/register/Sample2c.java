/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.register;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/**
 * @author David Gao
 *
 * This sample illustrates the usage of BeanPostProcessor and BeanFactoryPostProcessor
 * interfaces. The BeanRegister class implements those two interfaces and counts all
 * beans.
 * 
 */
public class Sample2c {

	/**
	 * 
	 */
	public Sample2c() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try
		{
			ApplicationContext beanFactory = new FileSystemXmlApplicationContext ( "src/ioc/register/sample.xml" );
			System.out.println ( "The BeanFactory instance obtained." );
		
			CustomerService customerService = (CustomerService) beanFactory.getBean ( "customerService" );
			AccountService accountService = (AccountService) beanFactory.getBean ( "accountService" );

			Customer customer1 = new Customer ( 1, "John", "Smith", "(416)123-1230", "10 Sheppard Ave E", "smithj@yahoo.ca" );
			Customer customer2 = new Customer ( 2, "Maria", "Sun", "(416)123-1231", "11 Sheppard Ave E", "sunm@rogers.ca" );
			
			customerService.createCustomer ( customer1 );
			customerService.createCustomer ( customer2 );
			
			Customer customer = (Customer) beanFactory.getBean ( "customer" );
			
			BeanRegister rBean = (BeanRegister) beanFactory.getBean ( "beanRegister" );
			System.out.println ( "Number of beans: " + BeanRegister.getBeanTotal() );
			
			customerService.increaseCreditLimit( customer );
			
			System.out.println ( "done." );
		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}

	}
}
