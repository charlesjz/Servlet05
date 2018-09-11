/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package transaction.declaratively;

import java.util.List;
import java.util.Set;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface CustomerService {
	
	public Customer getCustomer ( int customerId );
	public Customer createCustomer ( Customer customer );
	public void createCustomer ( List customers );
	public List getAccountList ( Customer customer );
	public List getHistoryActivities ( Customer customer );
	public void increaseCreditLimit ( Customer customer ) throws CustomerNotAvailableException;
	public void increaseCreditLimit ( Customer customer, int increaseAmount ) throws CustomerNotAvailableException;
	public void createAccount ( Customer customer, Account account );
	public int getNumberOfPersons ( );

}
