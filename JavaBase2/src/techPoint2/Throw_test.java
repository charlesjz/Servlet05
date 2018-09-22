package techPoint2;


public class Throw_test {
	  public static void main(String[] args) throws NullPointerException {

	    try {/*www .ja v a 2  s .  c o m*/
	      callSomeFunctionThatMightThrow(null);
	    } catch (Exception e) {
	    	System.out.println("There was an null parameter2!");
	    } finally{
	    	System.out.println("Ending Messages...");
	    	System.out.println("\n\nEnd");
	    }

	  }

	  private static void callSomeFunctionThatMightThrow(Object o) {
	    if (o == null)
	      throw new NullPointerException("The object is null");

	  }

}