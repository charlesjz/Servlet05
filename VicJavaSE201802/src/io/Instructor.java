package io;

import java.io.Serializable;

public class Instructor implements Serializable {
	
	public String name;
	public String email;
	public Phone phone;
	
	public String toString() {
		return "name = " + this.name 
			+ ", email = " + this.email
			+ ", phone = " + this.phone;
	}

}
