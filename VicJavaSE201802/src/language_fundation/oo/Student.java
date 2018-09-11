package language_fundation.oo;

public class Student {
	
//	public static final String SCORE_A = "A";
//	public static final String SCORE_B = "B";
//	public static final String SCORE_C = "C";
//	public static final String SCORE_PASS = "Pass";
//	public static final String SCORE_FAIL = "Fail";
	
	static String schoolName;
	
	String firstname;
	String lastname = "Unknown-lastname";
	String phoneNumber;
	String email;
	String wechatId;
	
	Score score;	// A, B, C, Pass, Fail
	
//	{
//		this.score = SCORE_PASS;
//		System.out.println( "In initializer block #1" );
//	}
//	
//	static {
//		schoolName = "Vic College";
//		System.out.println( "In static initializer block #1" );
//	}

	public Student() {
		System.out.println( "In Student() contructor." );
		this.firstname = "Unknown-firstname";
	}
	
	public Student ( String firstname ) {
		
		this.firstname = firstname;
	}
	
//	{
//		System.out.println( "In initializer block #2" );
//	}
//	
//	static {
//		System.out.println( "In static initializer block #2" );
//	}

	public Student ( String firstname, String lastname ) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public static void printSchoolInfo ( ) {
		System.out.println( "SchoolName = " + schoolName );
//		System.out.println( "student name: " + this.firstname + " " + this.lastname);
	} 
	
	public void printInfo ( ) {
		String s = firstname + " " + lastname + ". Email: " + email;
		System.out.println( "Student Info: " + s );
		System.out.println( "School name: " + schoolName );
		if ( phoneNumber != null ) {
			String s2 = firstname + "'s phone number is: " + phoneNumber;
			System.out.println( s2 );
		}
		if ( this.score != null ) {
			System.out.println( "score: " + score.name() + "(" + score.ordinal() + ")" );
			if ( score.isEligibleForCoop() ) {
				System.out.println( "This student is eligible for Coop." );
			}
		}
	}

	public void repeat ( String statement, int times ) {
		
	}

	public void repeat ( int times, String statement ) {
		
	}

	@Deprecated
	public int add ( int n1, int n2 ) {
		int r = n1 + n2;
		return r;
	}
	
	public int add ( int...numbers ) {
		
		int r = 0;
		for ( int number : numbers ) {
			r += number;
		}
		return r;
	}
	
//	public double add ( int n1, int n2 ) {
//		int r = n1 + n2;
//		return r;
//	}
	
	public int add ( int n1, int n2, int n3 ) {
		int r = n1 + n2 + n3;
		return r;
	}
	
	public double add ( double n1, double n2 ) {
		double r = n1 + n2;
		return r;
	}

	public int add ( int n ) {
		int r = n + n;
		return r;
	}
	


}
