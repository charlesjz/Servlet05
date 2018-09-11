package inheritance;

public class SavingAccount extends Account {
	
	private double interestRate = 0.5;
	
	public SavingAccount(String accountNumber) {
		super(accountNumber);
	}
	
	public SavingAccount(String accountNumber, double initialDeposit) {
		super ( accountNumber, initialDeposit );
	}

	public double calculateInterest ( ) {
		double interest = this.balance * this.interestRate;
		this.balance += interest;
		this.logTransactionHistory( Transaction.Interest, interest, this.balance);
		return this.balance;
	}

	@Override
	public double getBalance() {
		return this.balance;
	}

}
