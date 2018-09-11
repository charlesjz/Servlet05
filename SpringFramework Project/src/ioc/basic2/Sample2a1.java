/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.basic2;

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
public class Sample2a1 {

	/**
	 * 
	 */
	public Sample2a1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try
		{
			BeanFactory beanFactory = new XmlBeanFactory ( new FileSystemResource ( "C:\\Users\\gaod\\Google Drive\\eclipse-workspaces\\java_ee\\SpringFramework Project\\src/ioc/basic2/sample.xml") );
			System.out.println ( "The BeanFactory instance obtained." );
		
			CustomerServices customerServices1 = (CustomerServices) beanFactory.getBean ( "customerServices" );
			CustomerServices customerServices2 = (CustomerServices) beanFactory.getBean ( "customerServices" );
			Customer customer1 = (Customer) beanFactory.getBean ( "customer" );
			Customer customer2 = (Customer) beanFactory.getBean ( "customer" );
			System.out.println ( "customer1 is identical to customer2 : " + ( customer1 == customer2 ) );
			System.out.println ( "customerServices1 is identical to customerServices2 : " + ( customerServices1 == customerServices2 ) );
			
			System.out.println ( "customer1.getCreditLimit() = " + customer1.getCreditLimit() );
			System.out.println ( "customerServices1.getCreditIncreaseLimit() = " + customerServices1.getCreditIncreaseLimit() );
			
			Customer customer01 = ( (CustomerServicesImpl)customerServices1 ).getCustomer0();
			Customer customer02 = ( (CustomerServicesImpl)customerServices2 ).getCustomer0();
			System.out.println ( "customer01 is identical to customer02 : " + ( customer01 == customer02 ) );
			System.out.println ( "customer1 is identical to customer01 : " + ( customer1 == customer01 ) );
			System.out.println ( "customer2 is identical to customer01 : " + ( customer2 == customer01 ) );
		
			System.out.println ( "customer01.getCreditLimit() = " + customer01.getCreditLimit() );
			customer01.setCreditLimit( customer01.getCreditLimit() + 100 );
			System.out.println ( "customer01.getCreditLimit() = " + customer01.getCreditLimit() );
			
			customerServices1.increaseCreditLimit();

			System.out.println ( "customer01.getCreditLimit() = " + customer01.getCreditLimit() );

		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}

	}
}
