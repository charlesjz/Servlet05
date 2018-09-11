/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package transaction.progmatically;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Account {
	
	private int accountId;
	private AccountType accountType;
	private double balance;
	
	private Customer customer;
	

	/**
	 * 
	 */
	public Account( int accountId, AccountType accountType ) {
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
	public int getAccountId() {
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
	public void setAccountId(int l) {
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
