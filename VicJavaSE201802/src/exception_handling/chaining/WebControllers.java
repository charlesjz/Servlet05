package exception_handling.chaining;

public class WebControllers {

	public static void main(String[] args) {
		
		System.out.println( "Taking user input . . ." );
		String searchTerm = "abc";
		try {
			new WebControllers().handleSearchRequest(searchTerm);
		} catch (WebException e) {
//			e.printStackTrace(System.err);
			System.out.println( "Error occurred: " + e.getMessage() );
			logException ( e );
		}

	}

	private AppService appService = new AppService ( );
	
	public void handleSearchRequest ( String searchStrnig ) throws WebException {
		
		try {
			System.out.println( "Processing search string . . ." );
			System.out.println( "Invoking appService . . ." );
			this.appService.search(searchStrnig);
			System.out.println( "Returning formatted result." );
		} catch (ServiceException e) {
//			e.printStackTrace();
			throw new WebException ( "Technical error during search", e );
		}
		
	}
	
	public static void logException ( Throwable e ) {
		Throwable cause = e;
		while ( ( cause = cause.getCause() ) != null ) {
			System.out.println( "LOG: " + cause.getMessage() );
		}

	}

}
