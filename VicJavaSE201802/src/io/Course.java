package io;

import java.io.Serializable;

public class Course implements Serializable {
	
	public String name;
	transient public Address location;
	public Instructor instructor;
	public Instructor instructor2;
	public String startDatetime;
	public int duration;
	public double price;
	
	public String toString ( ) {
		return "name = " + this.name
			+ ", location = [" + this.location
			+ "], instructor = [" + this.instructor
			+ "], instructor2 = [" + this.instructor2
			+ "], startDatetime = " + this.startDatetime
			+ ", duration = " + this.duration
			+ ", price = " + this.price;
	}

}
