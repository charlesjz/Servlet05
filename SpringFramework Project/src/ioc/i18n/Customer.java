/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.i18n;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Customer {
	
	private long customerNo;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private String email;
	private int creditLimit;
	
	private Set accounts = new HashSet ( );
	
	/**
	 * 
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer ( int customerNo,
					  String firstName,
					  String lastName,
					  String phoneNumber,
					  String address,
					  String email )
	{
		this.customerNo = customerNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}
	
	public String toString ( )
	{
		return this.customerNo + " (" + this.lastName.trim() + ", " + this.firstName.trim() + ") "
				+ this.phoneNumber.trim() + ", " + this.email.trim() + ", " + this.address.trim();
	}

	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return
	 */
	public long getCustomerNo() {
		return customerNo;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param string
	 */
	public void setAddress(String string) {
		address = string;
	}

	/**
	 * @param i
	 */
	public void setCustomerNo(long i) {
		customerNo = i;
	}

	/**
	 * @param string
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @param string
	 */
	public void setPhoneNumber(String string) {
		phoneNumber = string;
	}

	/**
	 * @return
	 */
	public int getCreditLimit ( ) {
		return this.creditLimit;
	}

	/**
	 * @param i
	 */
	public void setCreditLimit ( int creditLimit ) {
		this.creditLimit = creditLimit;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param string
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @return
	 */
	public Set getAccounts() {
		return accounts;
	}

	/**
	 * @param set
	 */
	public void setAccounts(Set set) {
		accounts = set;
	}
	
	public void addAccount ( Account account )
	{
		this.accounts.add ( account );
		account.setCustomer ( this );
	}

}
