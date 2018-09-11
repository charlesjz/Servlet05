/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.register;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Account {
	
	public final static char CHECKING_ACCOUNT = 'C';
	public final static char SAVING_ACCOUNT = 'S';
	public final static char GIC_ACCOUNT = 'G';
	public final static char MUTUAL_FUNDS_ACCOUNT = 'M';
	public final static char MORTGAGE_ACCOUNT = 'T';
	
	private long accountId;
	private char accountType;
	private double balance;
	

	/**
	 * 
	 */
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString ( )
	{
		String accountTypeName = "";
		switch ( this.accountType )
		{
			case CHECKING_ACCOUNT:
				accountTypeName = "Checking";
				break;
			
			case SAVING_ACCOUNT:
				accountTypeName = "Saving";
				break;
			
			case MUTUAL_FUNDS_ACCOUNT:
				accountTypeName = "Mutual Fund";
				break;
			
			case MORTGAGE_ACCOUNT:
				accountTypeName = "Mortgage";
				break;
				
			case GIC_ACCOUNT:
				accountTypeName = "GIC";
				break;

			default:
				accountTypeName = "N/A";
				break;
		}
		return this.accountId + "(" + accountTypeName + ") : " + this.balance;
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
	public char getAccountType() {
		return accountType;
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
	 * @param c
	 */
	public void setAccountType(char c) {
		accountType = c;
	}

	/**
	 * @param d
	 */
	public void setBalance(double d) {
		balance = d;
	}

}
