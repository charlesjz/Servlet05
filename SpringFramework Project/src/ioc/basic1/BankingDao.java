package ioc.basic1;

public interface BankingDao {
	
	public void retrieveAccount ( String accountNumber );
	
	public void updateAccount ( double amount );

}
