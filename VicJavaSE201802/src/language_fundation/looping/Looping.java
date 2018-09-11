package language_fundation.looping;

public class Looping {

	public Looping() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
//		int numbers[] = { 1, 2, 3, 2, 1, 2, 10, 20, 30 };
//		
//		for ( int k = 0; k < numbers.length; k ++ ) {
//			System.out.println( "number[" + k + "] is: " + numbers[k] );
//		}
//		
//		System.out.println ( "----------------------------" );
//		
//		int k = 0;
//		for ( int number : numbers ) {
//			System.out.println( "number[" + k++ + "] is: " + number );
//			if ( k > 5 ) {
////				continue;
//				break;
//			}
//			System.out.println( "It is part of the first five numbers");
//		}
		
		int numbers[][] = { {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 
							{11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
							{21, 22, 23, 24, 25, 26, 27, 28, 29, 30} };
		int sum = 0;
		
		outerLoop:
		for ( int i = 0; i < numbers.length; i ++ ) {
			for ( int j = 0; j < numbers[i].length; j ++ ) {
				sum += numbers[i][j];
				if ( sum >= 100 ) {
					System.out.println( "Sum has reached 100. sum = " + sum + ", i = " + i + ", j = " + j);
					break outerLoop;
				}
			}
		}
		
		System.out.println( "sum = " + sum );

	}

}
