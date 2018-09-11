/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package email;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

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
	
	private SimpleMailMessage confirmationMailMessageTemplate;
		
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
			// Sending email using injected email utility . . .
			SimpleMailMessage message = new SimpleMailMessage ( this.confirmationMailMessageTemplate );
			StringBuffer emailContent = new StringBuffer ( context.getMessage( "email.dear", null, this.locale) + " " + customer.getFirstName() + " " + customer.getLastName() + ",\n" );
			emailContent.append ( context.getMessage ( "email.content", new String[] { Integer.toString ( customer.getCreditLimit() ) }, this.locale ) + ".\n" );
			emailContent.append ( "\n" + context.getMessage ( "email.greeting", null, this.locale ) + context.getMessage ( "email.signature", null, this.locale ) );
			message.setText ( emailContent.toString() );
			message.setTo ( customer.getEmail() );
			JavaMailSender mailSender = (JavaMailSender) context.getBean ( "mailSender" );
			String username = ((JavaMailSenderImpl)mailSender).getUsername();
			String password = ((JavaMailSenderImpl)mailSender).getPassword();
			System.out.println( "Sending email using " + username + " / " + password + " to " + message.getFrom() );

			try
			{
//				mailSender.send ( message );
			}
			catch (MailException e)
			{
				throw new RuntimeException ( e );
			}

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


	/**
	 * @return Returns the confirmationMailMessageTemplate.
	 */
	public SimpleMailMessage getConfirmationMailMessageTemplate() {
		return confirmationMailMessageTemplate;
	}
	/**
	 * @param confirmationMailMessageTemplate The confirmationMailMessageTemplate to set.
	 */
	public void setConfirmationMailMessageTemplate(
			SimpleMailMessage confirmationMailMessageTemplate) {
		this.confirmationMailMessageTemplate = confirmationMailMessageTemplate;
	}
}
