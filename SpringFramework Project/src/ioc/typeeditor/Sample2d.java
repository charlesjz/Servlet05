/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.typeeditor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author David Gao
 *
 * This sample illustrates the usage of java.beans.PropertyEditor interface
 * and java.beans.PropertyEditorSupport class to accept text-based AccountType
 * values.
 * 
 */
public class Sample2d {

	/**
	 * 
	 */
	public Sample2d() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try
		{
			ApplicationContext beanFactory = new FileSystemXmlApplicationContext ( "src/ioc/typeeditor/sample2d.xml" );
			System.out.println ( "The BeanFactory instance obtained." );
		
			CustomerService customerService = (CustomerService) beanFactory.getBean ( "customerService" );
			AccountService accountService = (AccountService) beanFactory.getBean ( "accountService" );

			Customer customer1 = new Customer ( 1, "John", "Smith", "(416)123-1230", "10 Sheppard Ave E", "smithj@yahoo.ca" );
			Customer customer2 = new Customer ( 2, "Maria", "Sun", "(416)123-1231", "11 Sheppard Ave E", "sunm@rogers.ca" );
			
			customerService.createCustomer ( customer1 );
			customerService.createCustomer ( customer2 );
			
			AccountType[] aTypes = accountService.getAccountTypes();
			System.out.println ( "======================== Account Types List ======================" );
			for ( int k = 0; k < ( aTypes == null ? 0 : aTypes.length ); k ++ )
			{
				System.out.println ( aTypes[k] );
			}
			System.out.println ( "======================== End of List ======================" );

			System.out.println ( "done." );
		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}

	}
}
