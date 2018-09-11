/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.event;

import java.util.List;
import java.util.Set;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CustomerServiceImpl implements CustomerService {
	
	private int creditIncreaseLimit = 500;
	
	private CustomerDao customerDao;
	private AccountService accountService;
		
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
		String emailContent = "Dear " + customer.getFirstName() + " " + customer.getLastName() + ",\n";
		emailContent += "  Please be advised that your credit limit has been adjusted to $" + customer.getCreditLimit() + ".\n";
		emailContent += "\nSincerely yours,\nNCT Co., Ltd.";
		
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
		Service.beanFactory.publishEvent( new NewCustomerCreatedEvent ( this, customer ) );

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
//		Service.beanFactory.publishEvent( new NewAccountEvent ( this, customer, account ) );
	}


}
