/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package remote.rmi;

import java.sql.CallableStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AccountDaoJdbc implements AccountDao {

	private JdbcTemplate jdbcTemplate;
	private TransactionTemplate transactionTemplate;

	private CRUDStatements crudStatements;
	
	private DepositCRUD depositCRUD;
	private AccountByIdQueryCRUD accountByIdQueryCRUD;
	
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
	public Account getAccount ( int accountId ) {
		// We can certainly use the following statement to insert the account record into database.
		// But we want to show the usage of operation objects ( DepositCRUD this time ).
		/*
		final Account account = new Account ( 0, null );
		final Object[] params = new Object[] { new Integer ( accountId ) };
		this.jdbcTemplate.query ( this.crudStatements.getFindAccountByIdSql(),
								  params,
								  new RowCallbackHandler ( )
								  {
									public void processRow ( ResultSet rs ) throws SQLException
									{
										account.setAccountId ( rs.getInt ( "ACCOUNT_ID") );
										account.setAccountType ( new AccountType ( rs.getString ( "TYPE" ).toCharArray()[0],
																				   Currency.getInstance ( rs.getString ( "CURRENCY" ).trim() ) ) );
										account.setBalance( rs.getDouble ( "BALANCE" ) );
										account.setCustomer( new Customer ( rs.getInt ( "CUSTOMER_NO" ),
																			rs.getString ( "FIRST_NAME" ),
																			rs.getString ( "LAST_NAME" ),
																			rs.getString ( "PHONE_NUMBER" ),
																			rs.getString ( "ADDRESS" ),
																			rs.getString ( "EMAIL" ) ) );
										account.getCustomer().setCreditLimit( rs.getInt ( "CREDIT_LIMIT" ) );																		
									}
								  }
								 );

		return account;
		*/
		Object[] params = new Object[] { new Integer ( accountId ) };
		return (Account) this.accountByIdQueryCRUD.execute ( params ).get ( 0 );
	}

	/* (non-Javadoc)
	 * @see sample2_1b.AccountDao#create(sample2_1b.Account)
	 */
	public void create ( final Account account ) {
		// We can certainly use the following statement to insert the account record into database.
		// But we want to show the usage of stored-procedure.
		/*
		this.jdbcTemplate.update ( crudStatements.getInsertAccountSql(),
								   new Object[] { new Integer ( account.getAccountId() ),
								   				  new Integer ( account.getCustomer().getCustomerNo() ),
								   				  account.getAccountType().getCurrency().toString(),
								   				  new Character ( account.getAccountType().getType() ).toString(),
								   				  new Double ( account.getBalance() ) } );
		*/
		CallableStatementCallback cb = new CallableStatementCallback ( )
		{
			public Object doInCallableStatement ( CallableStatement cs ) throws SQLException
			{
				cs.registerOutParameter ( 1, java.sql.Types.INTEGER );
				cs.setInt ( 2, account.getCustomer().getCustomerNo() );
				cs.setString ( 3, new Character ( account.getAccountType().getType() ).toString() );
				cs.setString ( 4, account.getAccountType().getCurrency().toString() );
				cs.setDouble ( 5, account.getBalance() );
				cs.execute ( );
				account.setAccountId ( cs.getInt ( 1 ) );
				return account;
			}
		};
		//return ((Integer)jdbcTemplate.execute ( "{ADD_COURSE}", cb )).intValue();
		Account account0 = (Account) jdbcTemplate.execute ( "{call SP_ADD_ACCOUNT ( ?, ?, ?, ?, ? )}", cb );
	}

	/* (non-Javadoc)
	 * @see sample2_1b.AccountDao#deposit(sample2_1b.Account, double)
	 */
	public void deposit(Account account, double amount) {
		// We can certainly use the following statement to insert the account record into database.
		// But we want to show the usage of operation objects ( DepositCRUD this time ).
		/*
		this.jdbcTemplate.update ( crudStatements.getDepositSql ( ),
								   new Object[] { new Double ( amount ), new Integer ( account.getAccountId() ) } );
		*/
		
		depositCRUD.deposit ( account.getAccountId(), amount );
		

	}

	/* (non-Javadoc)
	 * @see sample2_1b.AccountDao#transfer(sample2_1b.Account, sample2_1b.Account, double)
	 */
	public void transfer(
		final Account accountFrom,
		final Account accountTo,
		final double amount) {
			

		transactionTemplate.execute ( 
			new TransactionCallback ( )
			{
				public Object doInTransaction(TransactionStatus ts)
				{
					try
					{
						if ( accountFrom.getBalance() - amount < 0 )
						{
							throw new InsufficientFundException ( );
						}
						deposit ( accountTo, amount );
						deposit ( accountFrom, amount * -1 );
					}
					catch ( Exception e )
					{
						ts.setRollbackOnly();
						if ( e instanceof InsufficientFundException )
						{
							throw (InsufficientFundException)e;
						}
						else
						{
							throw new RuntimeException ( e );
						}
					}
						
					return null;
				}
			} );

	}

	/**
	 * @param template
	 */
	public void setJdbcTemplate(JdbcTemplate template) {
		jdbcTemplate = template;
	}

	/**
	 * @param statements
	 */
	public void setCrudStatements(CRUDStatements statements) {
		crudStatements = statements;
	}

	/**
	 * @param depositCRUD
	 */
	public void setDepositCRUD(DepositCRUD depositCRUD) {
		this.depositCRUD = depositCRUD;
	}

	/**
	 * @param queryCRUD
	 */
	public void setAccountByIdQueryCRUD(AccountByIdQueryCRUD queryCRUD) {
		accountByIdQueryCRUD = queryCRUD;
	}

	/**
	 * @param template
	 */
	public void setTransactionTemplate(TransactionTemplate template) {
		transactionTemplate = template;
	}

}
