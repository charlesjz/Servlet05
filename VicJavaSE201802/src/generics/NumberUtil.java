package generics;

public class NumberUtil <T extends Number & Comparable<Number>> {
	
	public T number1;
	public T number2;
	
	public NumberUtil ( ) { }
	
	public NumberUtil ( T n1, T n2 ) { 
		this.number1 = n1;
		this.number2 = n2;
	}
	
	public double add ( ) {
		return this.number1.doubleValue() + this.number2.doubleValue();
	}
	
	public int compare ( ) {
		return this.number1.compareTo(this.number2);
	}
	
	public static void main(String[] args) {
		NumberUtil<MyNumber> util = new NumberUtil<>( new MyNumber(10), new MyNumber(20) );
		System.out.println( "add = " + util.add() );
		System.out.println( "compare = " + util.compare() );
		
		
	}
	

}
