/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package aop.advice;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Account {
	
	private long accountId;
	private AccountType accountType;
	private double balance;
	
	private Customer customer;
	

	/**
	 * 
	 */
	public Account( long accountId, AccountType accountType ) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
	}
	
	public String toString ( )
	{
		return this.accountId + "(" + accountType + ") : " + this.balance;
	}

	/**
	 * @return
	 */
	public long getAccountId() {
		return accountId;
	}

	/**
	 * @return
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param l
	 */
	public void setAccountId(long l) {
		accountId = l;
	}

	/**
	 * @param d
	 */
	public void setBalance(double d) {
		balance = d;
	}

	/**
	 * @return
	 */
	public AccountType getAccountType() {
		return accountType;
	}

	/**
	 * @param type
	 */
	public void setAccountType(AccountType type) {
		accountType = type;
	}

	/**
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
