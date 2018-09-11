package ioc.basic1;

public class OnlineBankingDBConnector implements DBConnector {
	
	private String dbUrl;
	private String dbUsername;
	private String dbPassword;

	@Override
	public void connectDB() {
		System.out.println( "Database connection has been established to : " + this.dbUrl + " using username/password of " + this.dbUsername + "/" + this.dbPassword );
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

}
