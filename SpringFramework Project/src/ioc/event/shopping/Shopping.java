/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.event.shopping;

import java.util.Currency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author David Gao
 *
 * This sample illustrates the usage of publishing and listening events.
 * As an example, we use the publish/listen for large amount purchase.
 * 
 * But we haven't reach the awareness of beans and factories, so we implemented a
 * Service bean, which contains a static ApplicationContext variable.
 * 
 */
public class Shopping {

	public static void main(String[] args) {

		try
		{
			ApplicationContext beanFactory = new FileSystemXmlApplicationContext ( "src/ioc/event/shopping/shopping.xml" );
			System.out.println ( "The BeanFactory instance obtained." );
		
			ShoppingService shoppingService = (ShoppingService) beanFactory.getBean ( "shoppingService" );

			Shopper shopper = new Shopper ( "Zhu Jiang" );
			Invoice invoice = new Invoice ( shopper );
			invoice.addItem( new Product ( "Water", 1.2 ), 12 );
			invoice.addItem( new Product ( "Ice Cream", 3.99 ), 2 );
			invoice.addItem( new Product ( "Bicycle", 239.99 ), 1 );
			
			shoppingService.checkout(invoice);

			System.out.println ( "done." );
		}
		catch ( Exception e )
		{
			e.printStackTrace ( System.err );
		}

	}
}
