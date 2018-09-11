package generics;

public class MyNumber extends Number implements Comparable<Number> {

	private int value = 0;
	
	public MyNumber ( ) { }

	public MyNumber ( int value ) { 
		this.value = value;
	}

	@Override
	public int intValue() {
		return this.value;
	}

	@Override
	public long longValue() {
		return (long)this.value;
	}

	@Override
	public float floatValue() {
		return (float)this.value;
	}

	@Override
	public double doubleValue() {
		return (double)this.value;
	}

	@Override
	public int compareTo(Number o) {
		if ( o instanceof MyNumber ) {
			MyNumber anotherMyNumber = (MyNumber)o;
			return this.value - anotherMyNumber.value;
		} else {
			return -1;
		}
	}
	
}
