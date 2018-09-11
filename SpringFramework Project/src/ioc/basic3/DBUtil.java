package ioc.basic3;

public interface DBUtil {
	
	public void connectToDB ( );
	
	public void insertRecord ( String sql );
	
	public void updateRecord ( String sql );
	
	public void deleteRecord ( String sql );
	
	public String selectRecord ( String sql );

}
