/*
 * Created on Sep 5, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package dao.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.SqlProvider;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class InsertCustomerStatementCreator
	implements PreparedStatementCreator, SqlProvider, PreparedStatementSetter {
	
	private final String sql;
	
	private Customer customer;

	/**
	 * 
	 */
	public InsertCustomerStatementCreator ( String sql ) {
		this.sql = sql;
	}

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.PreparedStatementCreator#createPreparedStatement(java.sql.Connection)
	 */
	public PreparedStatement createPreparedStatement ( Connection conn )
		throws SQLException {
	
		return conn.prepareStatement ( sql );
	}
	
	public String getSql ( )
	{
		return this.sql;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.PreparedStatementSetter#setValues(java.sql.PreparedStatement)
	 */
	public void setValues ( PreparedStatement ps ) throws SQLException {

		ps.setInt ( 1, customer.getCustomerNo() );
		ps.setString ( 2, customer.getFirstName() );
		ps.setString ( 3, customer.getLastName() );
		ps.setString ( 4, customer.getPhoneNumber() );
		ps.setString ( 5, customer.getAddress() );
		ps.setString ( 6, customer.getEmail() );
		ps.setInt ( 7, customer.getCreditLimit() );

	}


	/**
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
