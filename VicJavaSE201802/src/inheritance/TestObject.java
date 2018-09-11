package inheritance;

public class TestObject {

	public static void main(String[] args) {
		try {
			Student s1 = new Student ( "John", 30, new Address ( "100 Finch Ave", "Toronto", "Ontario" ) );
			Student s2 = s1.clone();
//			s1.printMe();
//			s2.printMe();
			System.out.println( "s1 = " + s1 );
			System.out.println( "s2 = " + s2 );
			System.out.println( "s1 == s2 ? " + (s1 == s2) );
			System.out.println( "s1.getAddress() == s2.getAddress() = " + (s1.getAddress() == s2.getAddress() ) );
			
			Student s3 = s1;
			
			System.out.println( "s1.equals(s2) = " + s1.equals(s2) );
			System.out.println( "s1.equals(s3) = " + s1.equals(s3) );
			
			Class clazz = s1.getClass();
			System.out.println( "s1's class name is: " + clazz.getName() );
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		

	}

}
