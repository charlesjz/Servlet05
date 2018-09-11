package exception_handling.chaining;

public class DataException extends Exception {
	
	private int dbErrorCode;
	private String dbErrorMessage;

	public DataException( int dbErrorCode, String dbErrorMessage ) {
		super ( dbErrorMessage );
		this.dbErrorCode = dbErrorCode;
		this.dbErrorMessage = dbErrorMessage;
	}

	public DataException(Throwable cause) {
		super(cause);
	}

	public DataException(String message, Throwable cause) {
		super(message, cause);
	}

	public int getDbErrorCode() {
		return dbErrorCode;
	}

	public void setDbErrorCode(int dbErrorCode) {
		this.dbErrorCode = dbErrorCode;
	}

	public String getDbErrorMessage() {
		return dbErrorMessage;
	}

	public void setDbErrorMessage(String dbErrorMessage) {
		this.dbErrorMessage = dbErrorMessage;
	}
	
}
