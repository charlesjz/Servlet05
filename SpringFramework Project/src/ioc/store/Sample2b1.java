/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.store;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author David Gao
 *
 * This section is to show IoC for list, array, set, map properties.
 * 
 * It also shows basic technologies of IoC, including injecting null values,
 * data types, etc.
 * 
 */
public class Sample2b1 {

	/**
	 * 
	 */
	public Sample2b1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try
		{
			BeanFactory beanFactory = new XmlBeanFactory ( new FileSystemResource ( "src/ioc/store/sample2b1.xml") );
			System.out.println ( "The BeanFactory instance obtained." );
		
			Store store = (Store) beanFactory.getBean ( "store" );

			System.out.println ( "=========== products ===========" );
			List prods = store.getProducts();
			for ( int k = 0; k < prods.size(); k ++ )
			{
				System.out.println ( (k+1) + " : " + prods.get ( k ) );
			}

			System.out.println ( "=========== employees ===========" );
			for ( int k = 0; k < store.getEmployees().length; k ++ )
			{
				System.out.println ( (k+1) + " : " + store.getEmployees()[k] );
			}

			System.out.println ( "=========== categories ===========" );
			Iterator cats = store.getCategories().iterator();
			int k = 0;
			while ( cats.hasNext ( ) )
			{
				System.out.println ( (++k) + " : " + cats.next() );
			}

			System.out.println ( "=========== prices ===========" );
			Iterator priceEntries = store.getPrices().entrySet().iterator();
			k = 0;
			while ( priceEntries.hasNext ( ) )
			{
				Object key = priceEntries.next();
				System.out.println ( (++k) + " : " + key + " / " + store.getPrices().get ( key ) );
			}

			System.out.println ( "=========== configuration ===========" );
			Iterator keys = store.getConfig().keySet().iterator();
			k = 0;
			while ( keys.hasNext ( ) )
			{
				Object key = keys.next();
				System.out.println ( (++k) + " : " + key + " -> " + store.getConfig().get ( key ) );
			}
			
			if ( store.getEmployer() == null )
			{
				System.out.println ( "\nEmployer is not specified." );
			}
			else
			{
				System.out.println ( "\nEmployer is " + store.getEmployer() );
			}
			
			System.out.println ( "Store No: " + store.getStoreNo() );
			System.out.println ( "Store Level: " + store.getStoreLevel() );

			System.out.println ( "done." );
		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}

	}
}
