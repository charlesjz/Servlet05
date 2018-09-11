package exception_handling;

public class TestExceptionCapture {

	public static void main(String[] args) {
	
		try {
			System.out.println( "A" );
			methodA ( -2 );
			System.out.println( "B" );
		} catch (AppException e) {
			System.out.println( "C" );
		} finally {
			System.out.println( "D" );
		}

	}
	
	public static void methodA ( int p) throws AppException {
		if ( p < 0 ) {
			throw new AppException ( );
		}
	}

}
