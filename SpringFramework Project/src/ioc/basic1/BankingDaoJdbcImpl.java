package ioc.basic1;

public class BankingDaoJdbcImpl implements BankingDao {
	
	private DBConnector dbConn;

	public DBConnector getDbConn() {
		return dbConn;
	}

	public void setDbConn(DBConnector dbConn) {
		this.dbConn = dbConn;
	}

	@Override
	public void retrieveAccount(String accountNumber) {
		this.dbConn.connectDB();
		System.out.println( "The account (#" + accountNumber + ") has been retrieved." );

	}

	@Override
	public void updateAccount(double amount) {
		this.dbConn.connectDB();
		System.out.println( "$" + amount + " has been updated to the account table." );

	}

}
