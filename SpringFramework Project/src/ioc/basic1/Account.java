package ioc.basic1;

public class Account {
	
	private String accountNumber;
	private String accountName = "Unknown Name";
	private double balance = 0.0;
	
	public Account ( String accountNumber ) {
		this.accountNumber = accountNumber;
	}
	
	public Account ( ) { }
	
	public Account ( String accountNumber, double balance ) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		System.out.println ( "In constructor #1." );
	}
	
	public Account ( double balance, String accountNumber ) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		System.out.println ( "In constructor #2." );
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
