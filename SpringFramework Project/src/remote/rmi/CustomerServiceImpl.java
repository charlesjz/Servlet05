/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package remote.rmi;

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
	
	public void increaseCreditLimit(Customer customer, int increaseAmount)
		throws CustomerNotAvailableException {
			// Obtain customer . . .
			if ( customer == null )
			{
				throw new CustomerNotAvailableException ( );
			}

			// The following codes is for adding some delay and demostrating the Performance Monitor
			//for ( int k = 0; k < 100000; k ++ )
			//{
			//	for ( int j = 0; j < 10000; j ++ );
			//}

			// Checking the approval . . .
		
			// Increase the credit by $500.00
			customer.setCreditLimit ( customer.getCreditLimit() + increaseAmount );
		
			// Sending confirmation via email . . .
			String emailContent = context.getMessage( "email.dear", null, this.locale) + " " + customer.getFirstName() + " " + customer.getLastName() + ",\n";
			//String[] cLimit = { Integer.toString ( customer.getCreditLimit() ) }; 
			emailContent += context.getMessage ( "email.content", new String[] { Integer.toString ( customer.getCreditLimit() ) }, this.locale ) + ".\n";
			emailContent += "\n" + context.getMessage ( "email.greeting", null, this.locale ) + context.getMessage ( "email.signature", null, this.locale );
		
			// Sending email using injected email utility . . .
			// At this point, I just print out the email instead of really sending it, since we'll cover the email later.
			System.out.println ( "============================= Beginning of the eMail ==========================" );
			System.out.println ( "From: customer_services@nct.com" );
			System.out.println ( "  To: " + customer.getEmail() );
			System.out.println ( "Subject: Re: Credit limit increase" );
			System.out.println ( emailContent );
			System.out.println ( "============================= End of the eMail ==========================" );


	}

	public void increaseCreditLimit ( Customer customer ) throws CustomerNotAvailableException
	{
		increaseCreditLimit ( customer, this.creditIncreaseLimit );
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

	public Customer createCustomer(Customer customer) {
		customerDao.create ( customer );
		//context.publishEvent( new NewCustomerCreatedEvent ( this, customer ) );
		return customer;
	}

	public void createCustomer(List customers) {
		// The loop below can be used for inserting customer records
		// through the createCustomer() method. But for demostrating
		// the batchUpdate purpose, we call the CustomerDao.create ( List )
		// method created for this purpose.
		/*
		for ( int k = 0; k < customers.size(); k ++ )
		{
			createCustomer ( (Customer) customers.get ( k ) );
	    */
	    customerDao.create ( customers );
	}

	public Customer getCustomer ( int customerId ) {
		return customerDao.findById ( customerId );
	}

	public List getHistoryActivities(Customer customer) {
		return customerDao.getActivityList ( customer );
	}

	public List getAccountList(Customer customer) {
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
		customer.addAccount ( account );
		account.setCustomer ( customer );
		accountService.createAccount( account );
		//context.publishEvent( new NewAccountEvent ( this, customer, account ) );
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
	
	/* (non-Javadoc)
	 * @see sample4b.CustomerService#getNumberOfPersons()
	 */
	public int getNumberOfPersons() {
		return this.customerDao.getNumberOfCustomers();
	}


}
