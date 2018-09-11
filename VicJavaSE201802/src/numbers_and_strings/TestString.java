package numbers_and_strings;

public class TestString {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println( s1 == s2 );
		
		String s11 = new String ( "abc" );
		String s22 = new String ( "abc" );
		System.out.println( s11 == s22 );
		
		String s33 = s11;
		s11 += "123";
		
		System.out.println ( "s11 = " + s11 );
		System.out.println ( "s33 = " + s33 );

	}

}
