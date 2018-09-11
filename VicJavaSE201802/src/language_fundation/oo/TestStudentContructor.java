package language_fundation.oo;

import java.util.Scanner;

public class TestStudentContructor {

	public static void main(String[] args) {
////		Student s1 = null;
//		System.out.println( Student.schoolName );
		Student s1 = new Student ( );	// object #1
		s1.printInfo();
		Student s2 = new Student ( "Linda" );	// object #2
		Student s3 = new Student ( "Linda", "Wu" );	// object #3
		Student s4 = s3;
				
		s4.printInfo();
		System.out.println( "s32 = " + s4 );
//		s1 = null;
//		s3 = s2;
//		s2 = s3;
//		s4 = s1;
		
//		s1.score = Student.SCORE_A;
//		s2.score = Student.SCORE_B;
//		s3.score = Student.SCORE_PASS;
//		s3.score = "X";
		s1.score = Score.A;
		s2.score = Score.B;
		s3.score = Score.Pass;
		
//		s1.printInfo();
//		Scanner scanner = new Scanner ( System.in );
//		System.out.println( "Please enter the new score value: " );
//		String newScore = scanner.nextLine();
////		s1.score = Score.string2Score ( newScore );
//		s1.score = Score.valueOf ( newScore );
//		s1.printInfo();
//
//		System.out.println( "Please enter the index of new score (0 - A, 1 - B, 2- C, 3 - Pass, 4 - Fail): " );
//		int newScoreIndex = scanner.nextInt();
//		s1.score = Score.values()[newScoreIndex];
//		s1.printInfo();
//		s1.add(10, 20);
		
		GiftedStudent apple = new GiftedStudent ( );
		apple.firstname = "Apple";
		apple.printInfo();
		
		double d0 = apple.add( 100, 200 );
		System.out.println( "d0 = " + d0 );

	}
	
}
