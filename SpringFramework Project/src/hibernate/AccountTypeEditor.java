/*
 * Created on Aug 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package hibernate;

import java.beans.PropertyEditorManager;
import java.util.Currency;
import java.util.StringTokenizer;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AccountTypeEditor extends java.beans.PropertyEditorSupport {

	/**
	 * 
	 */
	public AccountTypeEditor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setAsText ( String accTypeStr )
	{
		StringTokenizer st = new StringTokenizer ( accTypeStr, "/" );

		String typeStr = st.nextToken();
		String currencyCode = st.nextToken();
		
		AccountType accountType = null;

		if ( typeStr.equalsIgnoreCase ( "SAVING" ) )
		{
			accountType = new AccountType ( AccountType.SAVING_ACCOUNT, Currency.getInstance ( currencyCode ) );
		}
		else if ( typeStr.equalsIgnoreCase ( "CHECKING" ) )
		{
			accountType = new AccountType ( AccountType.CHECKING_ACCOUNT, Currency.getInstance ( currencyCode ) );
		}
		else if ( typeStr.equalsIgnoreCase ( "GIC" ) )
		{
			accountType = new AccountType ( AccountType.GIC_ACCOUNT, Currency.getInstance ( currencyCode ) );
		}
		else if ( typeStr.equalsIgnoreCase ( "MORTGAGE" ) )
		{
			accountType = new AccountType ( AccountType.MORTGAGE_ACCOUNT, Currency.getInstance ( currencyCode ) );
		}
		else if ( typeStr.equalsIgnoreCase ( "MUTUAL FUNDS" ) )
		{
			accountType = new AccountType ( AccountType.MUTUAL_FUNDS_ACCOUNT, Currency.getInstance ( currencyCode ) );
		}
		
		setValue ( accountType );
	}

}
