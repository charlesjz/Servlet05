package inheritance;

import java.util.Calendar;

public abstract class Account {
	
	public double balance = 0.0;
	public String accountNumber = "";
	public String[] transactionHistory = new String[100];
	private int currentTransactionHistoryIndex = 0;
	
	enum Transaction { Deposit, Withdraw, PayBill, Interest, BankFee };
	
//	public Account ( ) { }
	
	public Account ( String accountNumber ) {
		this.accountNumber = accountNumber;
	}
	
	public Account ( String accountNumber, double initialDeposit ) {
		this(accountNumber);
		this.deposit(initialDeposit);
	}
	
	protected int getCurrentTransactionHistoryIndex () {
		return this.currentTransactionHistoryIndex;
	}
	public double deposit ( double amount ) {
		
		this.balance += amount;
		logTransactionHistory(Transaction.Deposit, amount, this.balance);
		return this.balance;
	}
	
	public double withdraw ( double amount ) {
//		return this.deposit( -1 * amount );
		this.balance -= amount;
		logTransactionHistory(Transaction.Withdraw, amount, this.balance);
		return this.balance;
	}
	
	protected void logTransactionHistory ( Transaction trx, double amount, double balance ) {
		if ( this.currentTransactionHistoryIndex >= 100 ) {
			System.out.println( "Transaction History is full." );
		} else {
			this.transactionHistory[this.currentTransactionHistoryIndex++] = 
					trx.name() + ": amount = " + amount + ", new balance = " + balance + " at " + Calendar.getInstance(); 
		}
	}
	
	public void printTransactionHistory ( ) {
		System.out.println ( "Transaction History" );
		for ( int k = 0; k < this.currentTransactionHistoryIndex; k ++ ) {
			System.out.println( this.transactionHistory[k] );
		}
		System.out.println ( "---------------------------------------------" );
	}
	
	public abstract double getBalance ( );

}
