/*
 * Created on Aug 7, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package remote.http;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MSSqlCustomerNoIncrementer
	extends MSSqlDataFieldMaxValueIncrementer {

	public int nextIntValue( ) throws DataAccessException {
		return this.jdbcTemplate.queryForInt ( this.crudStatements.getCustomerNoIncSql() );
	}

}
