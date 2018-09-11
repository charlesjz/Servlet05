package exception_handling.chaining;

import java.util.List;

public class AppService {
	
	private DataAccessObject dao = new DataAccessObject ( );
	
	public List<String> search ( String searchStr ) throws ServiceException {
		
		try {
			System.out.println( "Preparing search criteria . . ." );
			System.out.println( "Invoking DAO . . ." );
			this.dao.queryDB( "xxx" );
			System.out.println( "Returning the result" );
			return null;
		} catch (DataException e) {
//			e.printStackTrace();
			throw new ServiceException ( "Database Error", e );
		}
		
	}

}
