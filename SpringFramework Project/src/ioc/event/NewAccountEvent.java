/*
 * Created on Aug 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.event;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NewAccountEvent extends NewCustomerCreatedEvent {
	
	private Account account;

	/**
	 * @param source
	 * @param customer
	 */
	public NewAccountEvent(Object source, Customer customer, Account account) {
		super(source, customer);
		this.account = account;
	}

	/**
	 * @return
	 */
	public Account getAccount() {
		return account;
	}

}
