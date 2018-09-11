package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFormat {

	public static void main(String[] args) throws IOException {
		
		Student[] students = {
				new Student ( "John", "Smith", 30, 67890.23 ),
				new Student ( "Peter", "Pan", 20, 59823.12 ),
				new Student ( "Mary", "Poppins", 23, 107890.23 )
		};
		
//		writeToDataFile ( "c:\\temp\\students.dat", students );
		readAndPrintDataFile ( "c:\\temp\\students.dat" );
		
		
		
	}
	
	public static void readAndPrintDataFile ( String filename ) throws IOException {
		try (
				DataInputStream dis = new DataInputStream ( new BufferedInputStream ( new FileInputStream ( filename ))) ) {
			while ( true ) {
				try {
					String lastname = dis.readUTF();
					String firstname = dis.readUTF();
					int age = dis.readInt();
					double salary = dis.readDouble();
					System.out.println( firstname + " " + lastname + ", " + age + ", " + salary );
				} catch ( EOFException eofe ) {
					break;
				}
			}
		}
	}
	
	public static void writeToDataFile ( String filename, Student[] students ) throws IOException {
		try (
				DataOutputStream dos = new DataOutputStream ( new BufferedOutputStream ( new FileOutputStream ( filename ))) ) {
			for ( Student stu: students ) {
				dos.writeUTF( stu.lastname );
				dos.writeUTF( stu.firstname );
				dos.writeInt( stu.age );
				dos.writeDouble( stu.salary );
			}
		}
	}

}

class Student {
	public String firstname;
	public String lastname;
	public int age;
	public double salary;
	
	public Student (
			String firstname,
			String lastname,
			int age,
			double salary ) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.salary = salary;
	}
}
