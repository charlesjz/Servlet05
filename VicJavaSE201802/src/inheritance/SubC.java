package inheritance;

import java.io.FileNotFoundException;

public class SubC extends SuperC implements IntfC {
	
	public static int GRADE = 10;
	int name = 100;

	public SubC ( ) {
		System.out.println( "In SubC()." );
	}
	
	public SubC ( String name) {
		super(name);
		this.name = name;
		System.out.println( "In SubC(String)." );
	}
	
	public SubC ( String name, int value ) {
		super(name, value);
		System.out.println( "In SubC(String, int)." );
		this.name = name;
		this.value = value;
	}
	
	public SubC ( int value, String name ) {
		this ( name, value );
//		super ( name );
		System.out.println( "In SubC(String, int)." );
//		this.name = name;
//		this.value = value;
	}
	

	
	@Override
	public void doIt() {
		super.doIt();
		System.out.println( "SubC.doIt() is called." );
	}
	
	@Override
	public ChequingAccount cloneAccount(Account account) throws FileNotFoundException {
		return new ChequingAccount( account.accountNumber );
	}

	@Override
	public SavingAccount method1 ( SavingAccount account ) {
		return null;
		
	}
}
