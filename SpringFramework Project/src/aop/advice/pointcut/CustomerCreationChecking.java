/*
 * Created on Sep 1, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package aop.advice.pointcut;

import java.util.HashSet;
import java.util.Set;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CustomerCreationChecking implements MethodInterceptor {

	private Set customerNos = new HashSet ( );
	/**
	 * 
	 */
	public CustomerCreationChecking() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {

//		if ( invocation.getMethod().getName().equals ( "createCustomer" ) )
//		{
			Customer customer = (Customer) invocation.getArguments()[0];
			if ( customerNos.contains( new Long ( customer.getCustomerNo() ) ) )
			{
				System.err.println ( "CustomerCreationChecking: This customer no (" + customer.getCustomerNo() + ") has been used." );
				throw new DuplicateCustomerNoException ( );
			}
			Object rtValue = invocation.proceed();
			customerNos.add ( new Long ( customer.getCustomerNo() ) );
			return rtValue;

//		}
//		else
//		{
//			return invocation.proceed();
//		}
	}

}
