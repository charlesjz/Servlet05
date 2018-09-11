/*
 * Created on Aug 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package aop.advice.pointcut;

import java.util.Date;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CustomerActivityLogger implements ApplicationListener {

	/**
	 * 
	 */
	public CustomerActivityLogger() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	public void onApplicationEvent ( ApplicationEvent event ) {

		if ( event instanceof NewAccountEvent )
		{
			NewAccountEvent newAccountEvent = (NewAccountEvent) event;
			System.out.println ( new Date( event.getTimestamp() ) + " : Account (" + newAccountEvent.getAccount() + ") has been created for customer " + newAccountEvent.getCustomer() );
		}
		else if ( event instanceof NewCustomerCreatedEvent )
		{
			NewCustomerCreatedEvent newCustomerCreatedEvent = (NewCustomerCreatedEvent) event;
			System.out.println ( new Date( event.getTimestamp() ) + " : A new customer created (" + newCustomerCreatedEvent.getCustomer() + ")" );
		}
	}

}
