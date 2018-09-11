/*
 * Created on Sep 4, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package aop.autoproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PerformanceMonitorInterceptor implements MethodInterceptor {
	
	private final long lightThreshold;
	private final long mediumThreshold;
	private final long heavyThreshold; 

	/**
	 * 
	 */
	public PerformanceMonitorInterceptor( long lightThreshold,
										  long mediumThreshold,
										  long heavyThreshold ) {
		this.lightThreshold = lightThreshold;
		this.mediumThreshold = mediumThreshold;
		this.heavyThreshold = heavyThreshold;
	}

	/* (non-Javadoc)
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		long t = System.currentTimeMillis ( );
		Object o = mi.proceed ( );
		t = System.currentTimeMillis ( ) - t;
		if ( t >= this.heavyThreshold )
		{
			System.out.print ( "//////////HEAVY//////////(" );
		}
		else if ( t >= this.mediumThreshold )
		{
			System.out.print ( "////////MEDIUM//////(" );
		}
		else
		{
			System.out.print ( "//////LIGHT//////(" );
		}
//		System.out.println (  mi.getClass().getName() + "." + mi.getMethod().getName() + "): " + t + " ms." );
		System.out.println (  mi.getMethod().getName() + "): " + t + " ms." );

		return o;
	}

	/**
	 * @return
	 */
	public long getHeavyThreshold() {
		return heavyThreshold;
	}

	/**
	 * @return
	 */
	public long getLightThreshold() {
		return lightThreshold;
	}

	/**
	 * @return
	 */
	public long getMediumThreshold() {
		return mediumThreshold;
	}

}
