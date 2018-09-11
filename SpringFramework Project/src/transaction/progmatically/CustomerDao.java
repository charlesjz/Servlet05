/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package transaction.progmatically;

import java.util.List;
import java.util.Set;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface CustomerDao {
	
	public Customer findById ( int customerId );
	public void create ( Customer customer );
	public void create ( List<Customer> customers );
	public List getActivityList ( Customer customer );
	public List getAccountList ( Customer customer );
	public int getNumberOfCustomers ( );

}
