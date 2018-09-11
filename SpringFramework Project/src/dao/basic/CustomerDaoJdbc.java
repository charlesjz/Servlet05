/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package dao.basic;

import java.util.List;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CustomerDaoJdbc implements CustomerDao, ApplicationContextAware {
	
	private ApplicationContext context;
	
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 */
	public CustomerDaoJdbc( ) {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see sample2_1b.CustomerDao#findById(long)
	 */
	public Customer findById(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see sample2_1b.CustomerDao#create(sample2_1b.Customer)
	 */
	public void create ( Customer customer ) {
		InsertCustomerStatementCreator insertCustomerStat = (InsertCustomerStatementCreator) context.getBean( "insertCustomerStatementCreator" );
		insertCustomerStat.setCustomer( customer );
		this.jdbcTemplate.update ( insertCustomerStat.getSql(), insertCustomerStat );
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see sample2_1b.CustomerDao#getActivityList(sample2_1b.Customer)
	 */
	public List getActivityList(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see sample2_1b.CustomerDao#getAccountList(sample2_1b.Customer)
	 */
	public Set getAccountList(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
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

}
