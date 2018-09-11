package io;

import java.io.Serializable;

public class Phone implements Serializable {

	public String areaCode;
	public String phoneNumber;
	
	public String toString() {
		return "areaCode = " + this.areaCode
			+ ", phoneNumber = " + this.phoneNumber;
	}
}
