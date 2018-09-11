/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package transaction.declaratively;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;
	private AccountType[] accountTypes;
	
	/**
	 * 
	 */
	public AccountServiceImpl( AccountDao accountDao) {
		super();
		this.accountDao = accountDao;
	}
	
	public AccountServiceImpl ( )
	{
		super();
	}

	public Account getAccount ( int accountId ) {
		return accountDao.getAccount ( accountId );
	}

	public void createAccount(Account account) {
		accountDao.create ( account );

	}

	public void deposit(Account account, double amount) {
		accountDao.deposit ( account, amount );
		account.setBalance( account.getBalance() + amount );
	}

	public void withdraw(Account account, double amount) {
		accountDao.deposit ( account, amount * -1 );
		account.setBalance( account.getBalance() - amount );
	}

	/* (non-Javadoc)
	 * @see sample2_1b.AccountService#transfer(sample2_1b.Account, sample2_1b.Account, double)
	 */
	public void transfer(
		Account accountFrom,
		Account accountTo,
		double amount) {
			
		accountDao.transfer( accountFrom, accountTo, amount );
		accountFrom.setBalance( accountFrom.getBalance() - amount );
		accountTo.setBalance( accountTo.getBalance() + amount );
	}

	/**
	 * @return
	 */
	public AccountDao getAccountDao() {
		return accountDao;
	}

	/**
	 * @param dao
	 */
	public void setAccountDao(AccountDao dao) {
		accountDao = dao;
	}

	/**
	 * @return
	 */
	public AccountType[] getAccountTypes() {
		return accountTypes;
	}

	/**
	 * @param types
	 */
	public void setAccountTypes(AccountType[] types) {
		accountTypes = types;
	}

}
