/*
 * Created on Aug 29, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.basic2;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Customer {
	
	private int customerNo;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private String email;
	private int creditLimit;

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

	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return
	 */
	public int getCustomerNo() {
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
	public void setCustomerNo(int i) {
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
	public int getCreditLimit() {
		return creditLimit;
	}

	/**
	 * @param i
	 */
	public void setCreditLimit(int i) {
		creditLimit = i;
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

}
