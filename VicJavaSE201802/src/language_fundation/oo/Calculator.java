package language_fundation.oo;

public class Calculator {
	
	public int add ( int num1, int num2 ) {
		int result;
		result = num1 + num2;
		return result;
	}

	public int add ( int num1, int num2, int num3 ) {
		int result;
		result = num1 + num2 + num3;
		return result;
	}
	
//	public int add ( int[] nums ) {
//		int result = 0;
//		for ( int num : nums ) {
//			result += num;
//		}
//		return result;
//	}

	public int add ( int...nums ) {
		int result = 0;
		for ( int num : nums ) {
			result += num;
		}
		return result;
	}

	
	public static void main(String[] args) {
		Calculator calc = new Calculator ( );
		int r = calc.add(10, 20);
		System.out.println( "10 + 20 = " + r );
		
//		r = calc.add( 10, 20, 30 );
		r = calc.add( 10, 20, 30, 40, 50 );
		System.out.println( "10 + 20 + 30 = " + r );
	}
}
