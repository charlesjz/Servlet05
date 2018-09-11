package ioc.basic1;

public interface BankingService {
	
	public void createAccount ( Account account );
	
	public void printAllAccounts ( );
	
	public void deposit ( double amount );
	
	public void withdraw ( double amount );

}
