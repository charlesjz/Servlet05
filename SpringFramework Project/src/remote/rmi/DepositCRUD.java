/*
 * Created on Sep 6, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package remote.rmi;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DepositCRUD extends SqlUpdate {

	/**
	 * 
	 */
	public DepositCRUD() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public DepositCRUD ( DataSource dataSource, String sql ) {
		super ( dataSource, sql );
		declareParameter ( new SqlParameter ( Types.DOUBLE ) );
		declareParameter ( new SqlParameter ( Types.INTEGER ) );
		compile ( );
	}
	
	public int deposit ( int accountId, double amount )
	{
		Object[] params = new Object[] { new Double ( amount ), new Integer ( accountId ) };
		return update ( params );
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 */
	public DepositCRUD(DataSource arg0, String arg1, int[] arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public DepositCRUD(DataSource arg0, String arg1, int[] arg2, int arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
