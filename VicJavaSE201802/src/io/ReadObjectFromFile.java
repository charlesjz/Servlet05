package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObjectFromFile {

	public static void main(String[] args) {
		
		try ( ObjectInputStream ois = new ObjectInputStream ( new FileInputStream ( "c:\\work\\temp\\course.dat" ) ) ) {
			
			Course course = (Course) ois.readObject();
			
			System.out.println( "course = " + course );
			
			System.out.println( "course.instructor == course.instructor2 ? " + ( course.instructor == course.instructor2 ) );
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
