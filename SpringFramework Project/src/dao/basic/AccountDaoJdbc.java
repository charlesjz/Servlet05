/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package dao.basic;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AccountDaoJdbc implements AccountDao {

	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 */
	public AccountDaoJdbc() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see sample2_1b.AccountDao#getAccount(long)
	 */
	public Account getAccount(long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see sample2_1b.AccountDao#create(sample2_1b.Account)
	 */
	public void create(Account account) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see sample2_1b.AccountDao#deposit(sample2_1b.Account, double)
	 */
	public void deposit(Account account, double amount) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see sample2_1b.AccountDao#transfer(sample2_1b.Account, sample2_1b.Account, double)
	 */
	public void transfer(
		Account accountFrom,
		Account accountTo,
		double amount) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param template
	 */
	public void setJdbcTemplate(JdbcTemplate template) {
		jdbcTemplate = template;
	}

}
