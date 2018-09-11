package inheritance;

public class TestOverlap {

	public static void main(String[] args) {
		
		SubC subC = new SubC ( "abc", 100 );
		subC.doIt();
		
		SuperC c1 = new SuperC ( );
		SuperC c2 = new SubC ( );
		
		System.out.println( "subC.GRADE = " + subC.GRADE );
		System.out.println( "c1.GRADE = " + c1.GRADE );
		System.out.println( "c2.GRADE = " + c2.GRADE );

	}

}
