/*
 * Created on Sep 6, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package transaction.declaratively;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CRUDStatements {
	
	private String insertCustomerSql;
	private String findCustomerByIdSql;
	private String insertAccountSql;
	private String accountListSql;
	private String retrieveCustomerNumberSql;
	private String findAccountByIdSql;
	private String depositSql;
	private String customerNoIncSql;

	/**
	 * 
	 */
	public CRUDStatements() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param string
	 */
	public void setInsertCustomerSql(String string) {
		insertCustomerSql = string;
	}

	/**
	 * @return
	 */
	public String getInsertCustomerSql() {
		return insertCustomerSql;
	}

	/**
	 * @return
	 */
	public String getFindCustomerByIdSql() {
		return findCustomerByIdSql;
	}

	/**
	 * @param string
	 */
	public void setFindCustomerByIdSql(String string) {
		findCustomerByIdSql = string;
	}

	/**
	 * @return
	 */
	public String getInsertAccountSql() {
		return insertAccountSql;
	}

	/**
	 * @param string
	 */
	public void setInsertAccountSql(String string) {
		insertAccountSql = string;
	}

	/**
	 * @return
	 */
	public String getAccountListSql() {
		return accountListSql;
	}

	/**
	 * @param string
	 */
	public void setAccountListSql(String string) {
		accountListSql = string;
	}

	/**
	 * @return
	 */
	public String getRetrieveCustomerNumberSql() {
		return retrieveCustomerNumberSql;
	}

	/**
	 * @param string
	 */
	public void setRetrieveCustomerNumberSql(String string) {
		retrieveCustomerNumberSql = string;
	}

	/**
	 * @return
	 */
	public String getFindAccountByIdSql() {
		return findAccountByIdSql;
	}

	/**
	 * @param string
	 */
	public void setFindAccountByIdSql(String string) {
		findAccountByIdSql = string;
	}

	/**
	 * @return
	 */
	public String getDepositSql() {
		return depositSql;
	}

	/**
	 * @param string
	 */
	public void setDepositSql(String string) {
		depositSql = string;
	}

	/**
	 * @return
	 */
	public String getCustomerNoIncSql() {
		return customerNoIncSql;
	}

	/**
	 * @param string
	 */
	public void setCustomerNoIncSql(String string) {
		customerNoIncSql = string;
	}

}
