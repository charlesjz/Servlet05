/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package hibernate;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CustomerDaoHibernate extends HibernateDaoSupport implements CustomerDao, ApplicationContextAware {
	
	private ApplicationContext context;
	
	//private Session session;
	
	/*
	private Session obtainSession ( )
	{
		if ( this.session == null )
		{
			this.session = getSession ( );
		}

		if ( !session.isConnected() )
		{
			session.reconnect();
			System.out.println ( ".............. sesson reconnected." );
		}

		return this.session;
	}
	*/
	
//	private HibernateTemplate hibernateTemplate;

	/**
	 * 
	 */
	public CustomerDaoHibernate( ) {
		super();
		// TODO Auto-generated constructor stub
		//this.session = getSession ( );
	}

	public Customer findById ( int customerId ) {
		Session session = getSession ( );
		Customer customer = (Customer) session.get( Customer.class, new Integer ( customerId ) );
		releaseSession ( session );
		return customer;
		//return (Customer) this.hibernateTemplate.find ( "from Customer c where c.customerNo = ?", new Integer ( customerId ) );
	}

	public void create ( Customer customer ) {
		// We can use getHibernateTemplate() to save the customer record.
		// But we have to go through the whole Hibernate session process (begin
		// transaction, commit/rollback, close session, etc.) to insert/update
		// records if we want to use HibernateDaoSupport.getSession() and go through it.
		// Just use getSesson.save() doesn't work, like the line right below this.
		//getSession().saveOrUpdate ( customer );
		
		Session session = getSession ( );
		Transaction tx = session.beginTransaction();
		session.save ( customer );
		tx.commit();
		releaseSession ( session );
		
		//getHibernateTemplate().save( customer );
	}
	
	public void create ( final List customers ) {
		
		for ( int k = 0; k < customers.size(); k ++ )
		{
			create ( (Customer) customers.get( k ) );
			
		}
	}
	
	public void updateCustomer ( Customer customer )
	{
		Session session = getSession ( );
		Transaction tx = session.beginTransaction();
		session.lock( customer, LockMode.UPGRADE );
		session.update( customer );
		tx.commit();
		releaseSession( session );
		//this.getHibernateTemplate().saveOrUpdate ( customer );
	}

	public List getActivityList(Customer customer) {
		return null;
	}

	public List getAccountList ( Customer customer ) {
		return getSession().createQuery ( "from Account acct where acct.customer = :customer" )
							.setEntity ( "customer", customer )
							.list();
	}

	public void setApplicationContext(ApplicationContext context)
		throws BeansException {
		
		this.context = context;

	}


	/* (non-Javadoc)
	 * @see sample4b.CustomerDao#getNumberOfCustomers()
	 */
	public int getNumberOfCustomers() {

		Session session = getSession ( );
//		Transaction tx = session.beginTransaction();
		int number = ((Integer)session.createQuery( "select count(*) from Customer").list().get(0)).intValue();
//		tx.commit();
		releaseSession( session );
		return number;
	}


	/**
	 * @param template
	 */
//	public void setHibernateTemplate(HibernateTemplate template) {
//		hibernateTemplate = template;
//	}

}
