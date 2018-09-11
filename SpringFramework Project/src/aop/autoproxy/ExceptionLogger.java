/*
 * Created on Sep 1, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package aop.autoproxy;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ExceptionLogger implements ThrowsAdvice {

	/**
	 * 
	 */
	public ExceptionLogger() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	public void afterThrowing ( Method method, Object[] args, Object target, CustomerNotAvailableException cnae )
	public void afterThrowing ( Method method, Object[] args, Object target, Throwable cnae )
	{
		System.out.println ( "======================Exception Logger========================" );
		System.out.println ( "Exception: " + cnae );
		System.out.println ( "Method : " + method.getName() );
		System.out.println ( "Class: " + target.getClass().getName() );
		System.out.println ( "==============================================================" );
	}

}
