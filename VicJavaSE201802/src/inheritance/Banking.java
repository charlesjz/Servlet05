package inheritance;

public class Banking {

	public static void main(String[] args) {
		
//		Account account1 = new Account ( "ACCT000001", 100 );
//		account1.deposit( 1000 );
//		account1.withdraw( 210 );
//		account1.printTransactionHistory();
		
		ChequingAccount account2 = new ChequingAccount ( "CHQT000002" );
		account2.deposit( 1000 );
		account2.withdraw( 210 );
		account2.printTransactionHistory();
		String bankbookContent = account2.updateBankbook();
		System.out.println( "Bank Book:\n" + bankbookContent );
		
		SavingAccount account3 = new SavingAccount ( "SAV000001", 1200 );
		account3.deposit( 1000 );
		account3.withdraw( 210 );
		account3.calculateInterest();
		account3.printTransactionHistory();
		
		System.out.println( "*******************************" );
		Account account4 = new SavingAccount ( "SAV000002", 3000 );
		account4.deposit( 1000 );
		account4.withdraw( 210 );
//		account4.calculateInterest();
		((SavingAccount)account4).calculateInterest();
		account4.printTransactionHistory();
		
//		Account account5 = account2;
//		ChequingAccount account6 = (ChequingAccount) account5;
//		
//		Account account7 = new SavingAccount();
//		ChequingAccount account8 = (ChequingAccount) account7;
//		
//		Account account9 = new SavingAccount();
//		ChequingAccount account10 = (ChequingAccount) account9;
//		
////		ChequingAccount account11 = new SavingAccount();
		
		Account account12 = new ChequingAccount ( "CHQT000012", 900 );
		account12.deposit ( 600 );
		((Payable)account12).payBill( 120 );
		account12.withdraw( 60 );
		account12.printTransactionHistory();
		System.out.println( "Account balance: " + account12.getBalance() );
		
		ChequingAccount ca001 = new ChequingAccount ( "123" );
		System.out.println( "ca001.balance = " + ca001.balance );
		System.out.println( "ca001.superBalance = " + ca001.superBalance );
		

	}

}
