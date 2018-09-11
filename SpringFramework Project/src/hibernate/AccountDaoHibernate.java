/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package hibernate;

import java.sql.CallableStatement;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AccountDaoHibernate implements AccountDao {

	private HibernateTemplate hibernateTemplate;

	/**
	 * 
	 */
	public AccountDaoHibernate() {
		super();
	}

	public Account getAccount ( final int accountId ) {
		return (Account) this.hibernateTemplate.execute ( 
				new HibernateCallback ( )
				{
					public Object doInHibernate ( Session session ) throws HibernateException
					{
						return session.get ( Account.class, new Integer ( accountId ) );
					}
				} );
	}

	public void create ( Account account ) {
		hibernateTemplate.save ( account );
	}

	public void deposit(Account account, double amount) {
		account.setBalance( account.getBalance() + amount );
		hibernateTemplate.update( account );
	}

	public void transfer(
		Account accountFrom,
		Account accountTo,
		double amount) {
			
		deposit ( accountTo, amount );
		deposit ( accountFrom, amount * -1 );

	}

	/**
	 * @param template
	 */
	public void setHibernateTemplate(HibernateTemplate template) {
		hibernateTemplate = template;
	}

}
