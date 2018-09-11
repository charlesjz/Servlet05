/*
 * Created on Aug 7, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package dao.support;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

/**
 * @author gaod
 *
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MSSqlDataFieldMaxValueIncrementer implements DataFieldMaxValueIncrementer {

	protected JdbcTemplate jdbcTemplate;
	protected CRUDStatements crudStatements;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer
	 * #nextIntValue()
	 */
	@Override
	public int nextIntValue() throws DataAccessException {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForInt("select max(COURSE_ID) from COURSE") + 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer
	 * #nextLongValue()
	 */
	@Override
	public long nextLongValue() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer
	 * #nextStringValue()
	 */
	@Override
	public String nextStringValue() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
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

}
