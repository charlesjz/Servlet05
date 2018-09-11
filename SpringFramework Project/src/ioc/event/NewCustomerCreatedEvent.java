/*
 * Created on Aug 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NewCustomerCreatedEvent extends ApplicationEvent {

	private Customer customer;

	public NewCustomerCreatedEvent(Object source, Customer customer) {
		super(source);
		this.customer = customer;
	}

	/**
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}

}
