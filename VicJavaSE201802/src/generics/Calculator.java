package generics;

import java.util.ArrayList;
import java.util.List;

public class Calculator<T> {
	
	public T number1;
	public T number2;
	
	public Calculator ( ) { } 
	
	public Calculator ( T number1, T number2 ) {
		this.number1 = number1;
		this.number2 = number2;
	}
	
	public String concatenate ( ) {
		return this.number1.toString() + this.number2.toString();
	}
	
	public List<T> getAllNumbers ( ) {
		List<T> allNumbers = new ArrayList<> ( );
		allNumbers.add( this.number1 );
		allNumbers.add( this.number2 );
		return allNumbers;
	}

	public T getNumber1() {
		return number1;
	}

	public T getNumber2() {
		return number2;
	}
	
	public static <U,V> int compare ( U u, V v ) {
		return u.hashCode() - v.hashCode();
	}

	public <U,V> int compare2 ( U u, V v ) {
		return u.hashCode() - v.hashCode();
	}

	public int compare3 ( String s1, String s2 ) {
		return this.<String,String>compare2 ( s1, s2 );
	}

	public void setNumber1(T number1) {
		this.number1 = number1;
	}

	public void setNumber2(T number2) {
		this.number2 = number2;
	}
	
}
