package io;

import java.io.Serializable;

public class Address 
//implements Serializable 
{
	
	public String street;
	public String city;
	public String province;
	public String postalCode;
	
	public String toString() {
		return "street = " + this.street
			+ ", city = " + this.city
			+ ", province = " + this.province
			+ ", postalCode = " + this.postalCode;
	}

}
