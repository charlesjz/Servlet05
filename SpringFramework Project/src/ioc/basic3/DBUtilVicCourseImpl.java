package ioc.basic3;

public class DBUtilVicCourseImpl implements DBUtil {
	
	private String dbURL;
	private String dbUsername;
	private String dbPassword;

	@Override
	public void connectToDB() {
		System.out.println( "Connect to VicCollegeCourseDB (dbUrl = " + this.dbURL + ", dbUsername = " + this.dbUsername + ", dbPassword = " + this.dbPassword );
	}

	@Override
	public void insertRecord(String sql) {
		System.out.println( "Execute SQL: " + sql );
	}

	@Override
	public void updateRecord(String sql) {
		System.out.println( "Execute SQL: " + sql );
	}

	@Override
	public void deleteRecord(String sql) {
		System.out.println( "Execute SQL: " + sql );
	}

	@Override
	public String selectRecord(String sql) {
		System.out.println( "Execute SQL: " + sql );
		return "This is the result set.";
	}

	public String getDbURL() {
		return dbURL;
	}

	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
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
