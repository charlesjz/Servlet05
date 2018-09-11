/*
 * Created on Sep 4, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package transaction.progmatically;

import java.io.FileWriter;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ApplicationLoggerInterceptor implements MethodInterceptor {
	
	private final String logFilename;

	/**
	 * 
	 */
	public ApplicationLoggerInterceptor ( String logFilename ) {
		this.logFilename = logFilename;
	}

	/* (non-Javadoc)
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	public Object invoke ( MethodInvocation mi ) throws Throwable {

		String logInfo = new String ( new Date ( System.currentTimeMillis() ) + ": (" + mi.getMethod().getDeclaringClass().getName() + "." + mi.getMethod().getName() + ") " );
		Object[] args = mi.getArguments();
		Class[] types = mi.getMethod().getParameterTypes();
		for ( int k = 0; k < args.length; k ++ )
		{
			logInfo += ( "arg[" + k + "]: " + types[k].getName() + " = " + args[k] + ", " );
		}
		writeToLog ( logInfo );

		return mi.proceed();
	}
	
	private void writeToLog ( String logInfo )
	{
		try
		{
			FileWriter fileWriter = new FileWriter ( this.logFilename, true );
			fileWriter.write ( logInfo + "\n", 0, logInfo.length() + 1 );
			fileWriter.close ( );
		}
		catch ( Exception e )
		{
			throw new RuntimeException ( e );
		}
	}
		

}
