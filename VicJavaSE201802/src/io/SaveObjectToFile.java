package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveObjectToFile {

	public static void main(String[] args) {
		
		try ( ObjectOutputStream oos = new ObjectOutputStream ( new FileOutputStream ( "c:\\work\\temp\\course.dat" ) ) ) {
			
			Course course = new Course ( );
			course.name = "Java SE (I)";
			course.duration = 50;
			course.startDatetime = "10:30am Mar 1st, 2018";
			
			Address location = new Address ( );
			location.street = "1000 Yonge St.";
			location.city = "Toronto";
			location.province = "Ontario";
			location.postalCode = "M1M 1M1";
			
			course.location = location;
			
			Instructor instructor = new Instructor ( );
			instructor.name = "John Smith";
			instructor.phone = new Phone();
			instructor.phone.areaCode = "416";
			instructor.phone.phoneNumber = "123-1230";
			instructor.email = "john.smith@hotmail.com";
			
			course.instructor = instructor;
			course.instructor2 = instructor;
			
			System.out.println( "course = " + course );
			
			oos.writeObject( course );
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
