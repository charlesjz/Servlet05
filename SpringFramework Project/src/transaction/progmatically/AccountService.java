/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package transaction.progmatically;

import java.util.List;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface AccountService {
	
	public Account getAccount ( int accountId );
	public void createAccount ( Account account );
	public void deposit ( Account account, double amount );
	public void withdraw ( Account account, double amount );
	public void transfer ( Account accountFrom, Account accountTo, double amount );
	public AccountType[] getAccountTypes ( );

}
