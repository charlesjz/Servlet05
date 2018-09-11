package numbers_and_strings;

import static java.lang.Math.*;

public class TestNumbers {

	public static void main(String[] args) {
		int intValue = 10;
		Integer integerValue = new Integer ( intValue );
		intValue = Integer.parseInt( "3FA0", 16 );
		intValue = integerValue.intValue();
		
		integerValue = intValue;
		intValue = integerValue;
		Integer ii = 100;
		
		String dayOfWeek[] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }; 
		for ( int k = 0; k < 10; k ++ ) {
			double r = random();
//			System.out.println( "r = " + r );
			int dayOfWeekIndex = (int) (r * 7);
			System.out.println( "dayOfWeek = " + dayOfWeek[dayOfWeekIndex] );
		}
		
		double perimeterOfCircleOfRaduisOfFive =2 * 5.0 * PI;
		
		char ch = 'c';
		
		if ( ch <= 'z' || ch >= 'A' ) {
			
		}

	}

}
