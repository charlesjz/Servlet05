/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package dao.support;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultReader;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CustomerDaoJdbc implements CustomerDao, ApplicationContextAware {
	
	private ApplicationContext context;
	
	private JdbcTemplate jdbcTemplate;

	private CRUDStatements crudStatements;
	
	private MSSqlCustomerNoIncrementer customerNoIncrementer;

	/**
	 * 
	 */
	public CustomerDaoJdbc( ) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer findById ( final int customerId ) {
		final Customer customer = new Customer ( );
		final Object[] params = new Object[] { new Integer ( customerId ) };
		this.jdbcTemplate.query ( this.crudStatements.getFindCustomerByIdSql(),
								  params,
								  new RowCallbackHandler ( )
								  {
								  	public void processRow ( ResultSet rs ) throws SQLException
								  	{
								  		customer.setCustomerNo( rs.getInt ( "CUSTOMER_NO") );
								  		customer.setFirstName( rs.getString ( "FIRST_NAME" ) );
								  		customer.setLastName ( rs.getString ( "LAST_NAME" ) );
								  		customer.setPhoneNumber( rs.getString ( "PHONE_NUMBER" ) );
								  		customer.setAddress( rs.getString ( "ADDRESS" ) );
								  		customer.setEmail( rs.getString ( "EMAIL" ) );
								  		customer.setCreditLimit( rs.getInt ( "CREDIT_LIMIT" ) );
								  	}
								  }
								 );
		
		return customer;
	}

	public void create ( Customer customer ) {
		this.jdbcTemplate.update ( crudStatements.getInsertCustomerSql(),
//								   new Object[] { new Integer ( customer.getCustomerNo() ),
								   new Object[] { new Integer ( customerNoIncrementer.nextIntValue() ),
								   				  customer.getFirstName(),
								   				  customer.getLastName(),
								   				  customer.getPhoneNumber(),
								   				  customer.getAddress(),
								   				  customer.getEmail(),
								   				  new Integer ( customer.getCreditLimit() ) } );
	}
	
	public void create ( final List customers ) {
		/*
		for ( int k = 0; k < customers.size(); k ++ )
		{
			//create ( (Customer) customers.get( k ) );
			
		}
		*/

		
		this.jdbcTemplate.batchUpdate (
				this.crudStatements.getInsertCustomerSql(),
				new BatchPreparedStatementSetter ( )
				{
					private int customerNo = customerNoIncrementer.nextIntValue(); 
					
					@Override
					public int getBatchSize ( )
					{
						return customers.size ( );
					}
					
					@Override
					public void setValues ( PreparedStatement ps, int index ) throws SQLException
					{
						Customer customer = (Customer) customers.get ( index );
						ps.setInt ( 1, customerNo ++ );
						ps.setString ( 2, customer.getFirstName() );
						ps.setString ( 3, customer.getLastName() );
						ps.setString ( 4, customer.getPhoneNumber() );
						ps.setString ( 5, customer.getAddress() );
						ps.setString ( 6, customer.getEmail() );
						ps.setInt ( 7, customer.getCreditLimit() );
					}
				}
			);
	}

	public List getActivityList(Customer customer) {
		return null;
	}

	public List getAccountList(final Customer customer) {
		final Object[] params = new Object[] { new Integer ( customer.getCustomerNo() ) };
		return this.jdbcTemplate.query ( this.crudStatements.getAccountListSql(),
										  params,
										  new RowMapperResultReader ( new RowMapper ( )
										  	{
										  		public Object mapRow ( ResultSet rs, int index ) throws SQLException
										  		{
										  			Account account = new Account ( rs.getInt ( "ACCOUNT_ID" ),
																					new AccountType ( rs.getString ( "TYPE" ).toCharArray()[0],
																	  								  Currency.getInstance ( rs.getString ( "CURRENCY" ).trim() ) )
										  			);
										  			account.setBalance( rs.getDouble( "BALANCE" ) );
										  			account.setCustomer( customer );

										  			return account;
										  								  
										  		}
										  	}
										  ) );
	}

	public void setApplicationContext(ApplicationContext context)
		throws BeansException {
		
		this.context = context;

	}

	/**
	 * @return
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param template
	 */
	public void setJdbcTemplate(JdbcTemplate template) {
		jdbcTemplate = template;
	}

	/**
	 * @return
	 */
	public CRUDStatements getCrudStatements() {
		return crudStatements;
	}

	/**
	 * @param statements
	 */
	public void setCrudStatements(CRUDStatements statements) {
		crudStatements = statements;
	}
	
	/* (non-Javadoc)
	 * @see sample4b.CustomerDao#getNumberOfCustomers()
	 */
	public int getNumberOfCustomers() {
		
		return this.jdbcTemplate.queryForInt( this.crudStatements.getRetrieveCustomerNumberSql() );
	}


	/**
	 * @param incrementer
	 */
	public void setCustomerNoIncrementer(MSSqlCustomerNoIncrementer incrementer) {
		customerNoIncrementer = incrementer;
	}

}
