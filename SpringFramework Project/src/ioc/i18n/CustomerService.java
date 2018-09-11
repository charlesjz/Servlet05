/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.i18n;

import java.util.List;
import java.util.Set;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface CustomerService {
	
	public Customer getCustomer ( long customerId );
	public void createCustomer ( Customer customer );
	public Set getAccountList ( Customer customer );
	public List getHistoryActivities ( Customer customer );
	public void increaseCreditLimit ( Customer customer ) throws CustomerNotAvailableException;
	public void createAccount ( Customer customer, Account account );

}
