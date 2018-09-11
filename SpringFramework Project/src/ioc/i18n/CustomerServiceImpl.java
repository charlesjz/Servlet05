/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.i18n;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CustomerServiceImpl implements CustomerService, ApplicationContextAware {
	
	private ApplicationContext context;
	
	private int creditIncreaseLimit = 500;
	
	private CustomerDao customerDao;
	private AccountService accountService;
	
	private Locale locale;
		
	/**
	 * 
	 */
	public CustomerServiceImpl ( AccountService accountService, CustomerDao customerDao ) {
		this.customerDao = customerDao;
		this.accountService = accountService;
	}
	
	public void increaseCreditLimit ( Customer customer ) throws CustomerNotAvailableException
	{
		// Obtain customer . . .
		if ( customer == null )
		{
			throw new CustomerNotAvailableException ( );
		}
		
		// Checking the approval . . .
		
		// Increase the credit by $500.00
		customer.setCreditLimit ( customer.getCreditLimit() + this.creditIncreaseLimit );
		
		// Sending confirmation via email . . .
		String emailContent = context.getMessage( "email.dear", null, this.locale) + " " + customer.getFirstName() + " " + customer.getLastName() + ",\n";
		//String[] cLimit = { Integer.toString ( customer.getCreditLimit() ) }; 
		emailContent += context.getMessage ( "email.content", new String[] { Integer.toString ( customer.getCreditLimit() ) }, this.locale ) + ".\n";
		emailContent += "\n" + context.getMessage ( "email.greeting", null, this.locale ) + "\n" + context.getMessage ( "email.signature", null, this.locale );
		
		// Sending email using injected email utility . . .
		// At this point, I just print out the email instead of really sending it, since we'll cover the email later.
		System.out.println ( "============================= Beginning of the eMail ==========================" );
		System.out.println ( "From: customer_services@nct.com" );
		System.out.println ( "  To: " + customer.getEmail() );
		System.out.println ( "Subject: Re: Credit limit increase" );
		System.out.println ( emailContent );
		System.out.println ( "============================= End of the eMail ==========================" );

	}
	

	/**
	 * @return
	 */
	public int getCreditIncreaseLimit() {
		return creditIncreaseLimit;
	}

	/**
	 * @param i
	 */
	public void setCreditIncreaseLimit(int i) {
		creditIncreaseLimit = i;
	}

	public void createCustomer(Customer customer) {
		customerDao.create ( customer );
		context.publishEvent( new NewCustomerCreatedEvent ( this, customer ) );

	}

	public Customer getCustomer ( long customerId ) {
		return customerDao.findById ( customerId );
	}

	public List getHistoryActivities(Customer customer) {
		return customerDao.getActivityList ( customer );
	}

	public Set getAccountList(Customer customer) {
		return customerDao.getAccountList ( customer );
	}

	/**
	 * @return
	 */
	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	/**
	 * @param dao
	 */
	public void setCustomerDao(CustomerDao dao) {
		customerDao = dao;
	}

	/**
	 * @return
	 */
	public AccountService getAccountService() {
		return accountService;
	}

	/**
	 * @param service
	 */
	public void setAccountService(AccountService service) {
		accountService = service;
	}
	
	public void createAccount(Customer customer, Account account) {
		customer.addAccount( account );
		accountService.createAccount( account );
		context.publishEvent( new NewAccountEvent ( this, customer, account ) );
	}

	public void setApplicationContext ( ApplicationContext context )
		throws BeansException {
		
		this.context = context;
	}



	/**
	 * @return
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @param locale
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
