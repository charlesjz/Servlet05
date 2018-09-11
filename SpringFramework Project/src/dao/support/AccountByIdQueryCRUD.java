/*
 * Created on Sep 6, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package dao.support;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Currency;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AccountByIdQueryCRUD extends MappingSqlQuery {

	/**
	 * 
	 */
	public AccountByIdQueryCRUD() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public AccountByIdQueryCRUD ( DataSource dataSource, String sql ) {
		super ( dataSource, sql );
		declareParameter ( new SqlParameter ( "ACCOUNT_ID", Types.INTEGER ) );
		compile ( );
	}
	
	@Override
	public Object mapRow ( ResultSet rs, int rowNumber ) throws SQLException
	{
		Account account = new Account ( rs.getInt ( "ACCOUNT_ID"),
										new AccountType ( rs.getString ( "TYPE" ).toCharArray()[0],
		   												  Currency.getInstance ( rs.getString ( "CURRENCY" ).trim() ) ) );
		account.setBalance( rs.getDouble ( "BALANCE" ) );
		account.setCustomer( new Customer ( rs.getInt ( "CUSTOMER_NO" ),
											rs.getString ( "FIRST_NAME" ),
											rs.getString ( "LAST_NAME" ),
											rs.getString ( "PHONE_NUMBER" ),
											rs.getString ( "ADDRESS" ),
											rs.getString ( "EMAIL" ) ) );
		account.getCustomer().setCreditLimit( rs.getInt ( "CREDIT_LIMIT" ) );																		

		return account;
	}
	
}
