package inheritance;

import java.io.IOException;

public class SuperC {
	
	String name = "";
	int value = 0;
	
	public static int GRADE = 1;
	
	public SuperC ( String name) {
		System.out.println( "In SuperC(String)." );
		this.name = name;
	}
	
	public SuperC ( ) {
		System.out.println( "In SuperC()." );
	}
	
	public SuperC ( String name, int value ) {
		System.out.println( "In SuperC(String, int)." );
		this.name = name;
		this.value = value;
	}
	
	public void doIt ( ) {
		System.out.println( "SuperC.doIt() is called." );
	}
	
	protected Account cloneAccount ( Account account ) throws IOException {
		return null;
	}
	
	protected Account method1 ( SavingAccount account ) throws IOException {
		return null;
	}

}
