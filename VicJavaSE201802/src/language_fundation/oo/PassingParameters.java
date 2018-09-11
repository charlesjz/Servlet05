package language_fundation.oo;

public class PassingParameters {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 20;
		int result = 0;
		System.out.println( "a = " + a + ", b = " + b + ", result = " + result );
		result = add ( a, b );
		System.out.println( "a = " + a + ", b = " + b + ", result = " + result );
		
		MyNumber num = new MyNumber ( 10, 20 );
		System.out.println( "n1 = " + num.number1 + ", n2 = " + num.number2 + ", result = " + num.result );
		add ( num );
		System.out.println( "n1 = " + num.number1 + ", n2 = " + num.number2 + ", result = " + num.result );
	}
	
	public static int add ( int n1, int n2 ) {
		n1 *= 2;
		n2 += 10;
		int r = n1 + n2;
		return r;
	}
	
	public static int add ( MyNumber number ) {
		number = new MyNumber ( 100, 200 );
		number.number1 *= 2;
		number.number2 += 10;
		number.result = number.number1 + number.number2;
		return number.result;
	}
 
}
