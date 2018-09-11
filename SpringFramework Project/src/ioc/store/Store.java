/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.store;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Store {
	
	private List products;
	private String[] employees;
	private Set categories;
	private Map prices;
	private Properties config;
	
	private String employer;
	
	private String storeNo;
	private int storeLevel;
	

	/**
	 * 
	 */
	public Store() {
		super();
	}
	
	public Store ( String storeNo, int storeLevel )
	{
		this.storeNo = storeNo;
		this.storeLevel = storeLevel;
		System.out.println ( "Two-argument constructor is called." );
	}

	public Store ( String storeNo, int storeLevel, String test )
	{
		this.storeNo = storeNo;
		this.storeLevel = storeLevel;
		System.out.println ( "Test: " + test );
	}
	
	public Store ( String storeNo, int storeLevel, int test )
	{
		this.storeNo = storeNo;
		this.storeLevel = storeLevel;
		System.out.println ( "Test #: " + test );
	}

	/**
	 * @return
	 */
	public Set getCategories() {
		return categories;
	}

	/**
	 * @return
	 */
	public Properties getConfig() {
		return this.config;
	}

	/**
	 * @return
	 */
	public String[] getEmployees() {
		return this.employees;
	}

	/**
	 * @return
	 */
	public Map getPrices() {
		return this.prices;
	}

	/**
	 * @return
	 */
	public List getProducts() {
		return this.products;
	}

	/**
	 * @param set
	 */
	public void setCategories(Set categories) {
		this.categories = categories;
	}

	/**
	 * @param properties
	 */
	public void setConfig(Properties config) {
		this.config = config;
	}

	/**
	 * @param strings
	 */
	public void setEmployees(String[] employees) {
		this.employees = employees;
	}

	/**
	 * @param map
	 */
	public void setPrices(Map prices) {
		this.prices = prices;
	}

	/**
	 * @param list
	 */
	public void setProducts(List products) {
		this.products = products;
	}
	
	/**
	 * @return
	 */
	public String getEmployer() {
		return employer;
	}

	/**
	 * @param string
	 */
	public void setEmployer(String string) {
		employer = string;
	}

	/**
	 * @return
	 */
	public int getStoreLevel() {
		return storeLevel;
	}

	/**
	 * @return
	 */
	public String getStoreNo() {
		return storeNo;
	}

	/**
	 * @param i
	 */
	public void setStoreLevel(int i) {
		storeLevel = i;
	}

	/**
	 * @param string
	 */
	public void setStoreNo(String string) {
		storeNo = string;
	}

}
