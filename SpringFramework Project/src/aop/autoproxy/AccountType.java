/*
 * Created on Aug 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package aop.autoproxy;

import java.util.Currency;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AccountType {
	
	public final static char CHECKING_ACCOUNT = 'C';
	public final static char SAVING_ACCOUNT = 'S';
	public final static char GIC_ACCOUNT = 'G';
	public final static char MUTUAL_FUNDS_ACCOUNT = 'M';
	public final static char MORTGAGE_ACCOUNT = 'T';

	private char type;
	private Currency currency;

	/**
	 * 
	 */
	public AccountType( char type, Currency currency ) {
		this.type = type;
		this.currency = currency;
	}

	/**
	 * @return
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * @return
	 */
	public char getType() {
		return type;
	}

	/**
	 * @param currency
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/**
	 * @param c
	 */
	public void setType(char c) {
		type = c;
	}
	
	public String toString ( )
	{
		String accountTypeName = "N/A";
		
		switch ( this.type )
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
		return accountTypeName + " <" + this.currency.getCurrencyCode() + "> ";
	}

}
