package exception_handling.chaining;

import java.util.List;

public class DataAccessObject {
	
	public List<String> queryDB ( String criteria ) throws DataException {
		System.out.println( "Connecting to DB." );
		System.out.println( "Querying . . ." );
		throw new DataException ( 101, "Database server is out of space." );
	}

}
