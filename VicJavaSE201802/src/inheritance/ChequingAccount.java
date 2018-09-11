package inheritance;

public class ChequingAccount extends Account implements Payable {
	
	public double balance = 10.0;
	public double superBalance = super.balance;
	
	public ChequingAccount(String accountNumber) {
		super(accountNumber);
	}
	
	public ChequingAccount(String accountNumber, double initialDeposit) {
		super ( accountNumber, initialDeposit );
	}

	public static final double bankFeePerTrx = 0.1;
	
	@Override
	public double withdraw(double amount) {
		this.balance -= bankFeePerTrx;
		this.logTransactionHistory( Transaction.BankFee, bankFeePerTrx, this.balance );
		return super.withdraw(amount);
	}
	
	public String updateBankbook ( ) {
		StringBuffer result = new StringBuffer ( "" );
		for ( int k = 0; k < this.getCurrentTransactionHistoryIndex(); k ++ ) {
			result.append(this.transactionHistory[k] + "\n" );
		}
		return result.toString();
	}

	@Override
	public double payBill(double amount) {
		this.balance -= amount;
		this.logTransactionHistory( Transaction.PayBill, amount, this.balance);
		return 0;
	}

	@Override
	public double getBalance() {
		return this.balance;
	}
	
	public static double PrimeRate = 1.50;
}
