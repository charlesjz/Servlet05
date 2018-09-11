/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package email;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface AccountDao {
	
	public Account getAccount ( int accountId );
	public void create ( Account account );
	public void deposit ( Account account, double amount );
	public void transfer ( Account accountFrom,
						   Account accountTo,
						   double amount );

}
