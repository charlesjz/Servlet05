package generics;

import java.util.List;

public class TestCalculator {

	public static void main(String[] args) {
		
		Calculator<Integer> c1 = new Calculator<> ( 123, 321 );
		c1.setNumber1( 999 );
		
		Calculator c2 = c1;
		
		c2.setNumber1( "abc" );
		System.out.println( "c2.concatenate() = " + c2.concatenate() );
		
		List<Integer> numList = c1.getAllNumbers();
		int sum = 0;
//		for ( Integer num : numList ) {
//			sum += num;
//		}
//		System.out.println( "sum = " + sum );
		
		int r = Calculator.<String, String>compare( "abc", "abb" );
		System.out.println( "r = " + r );

		r = c1.<String, String>compare2( "abc", "abb" );
		System.out.println( "r = " + r );
	}

}
