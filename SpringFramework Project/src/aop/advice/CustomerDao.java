/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package aop.advice;

import java.util.List;
import java.util.Set;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface CustomerDao {
	
	public Customer findById ( long customerId );
	public void create ( Customer customer );
	public List getActivityList ( Customer customer );
	public Set getAccountList ( Customer customer );

}
