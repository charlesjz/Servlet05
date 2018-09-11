package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestCollectons {

	public static void main(String[] args) {
		
		Student s1 = new Student ( "John", "Smith", 30, 123456.12 );
		Student s2 = new Student ( "Peter", "Pan", 20, 654321.21 );
		Student s3 = new Student ( "Mary", "Poppins", 23, 765432.33 );
		
		Set<Student> studentSet = new HashSet<>();
		studentSet.add(s1);
		studentSet.add(s2);
		studentSet.add(s3);
		
		for ( Student s : studentSet ) {
			System.out.println( "for-each: s = " + s );
		}
		System.out.println( "-------------------------------------" );
		Iterator<Student> it = studentSet.iterator();
		while ( it.hasNext() ) {
			System.out.println( "Iterator: student = " + it.next() );
		}
		
		Student s4 = new Student ( "Norman", "Sun", 41, 2000000.0 );
		Student s5 = new Student ( "Peter", "Liu", 21, 111222.33 );
		Student s6 = new Student ( "Linda", "Wu", 18, 3.12 );
		Student s7 = new Student ( "Linda", "Wu", 19, 33.12 );
		Student s8 = new Student ( "Jiang", "Zhu", 29, 33333.12 );
		
		Set<Student> studentSet2 = new HashSet<>();
		boolean r = studentSet2.add(s4);
		System.out.println( "Adding (" + s4 + "), r = " + r );
		r = studentSet2.add(s5);
		System.out.println( "Adding (" + s5 + "), r = " + r );
		r = studentSet2.add(s6);
		System.out.println( "Adding (" + s6 + "), r = " + r );
		r = studentSet2.add(s7);
		System.out.println( "Adding (" + s7 + "), r = " + r );

		for ( Student s : studentSet2 ) {
			System.out.println( "for-each(2): s = " + s );
		}
		
		studentSet.addAll( studentSet2 );
		for ( Student s : studentSet ) {
			System.out.println( "for-each(3): s = " + s );
		}
		
		studentSet.remove(s6);
		studentSet.remove(s7);
		for ( Student s : studentSet ) {
			System.out.println( "for-each(4): s = " + s );
		}
		
		Set<Student> peterGroup = new HashSet<>();
		peterGroup.add(s2);
		peterGroup.add(s5);
		peterGroup.add(s8);
//		studentSet.removeAll(peterGroup);
		studentSet.retainAll(peterGroup);
		for ( Student s : studentSet ) {
			System.out.println( "for-each(5): s = " + s );
		}
		

	}

}
