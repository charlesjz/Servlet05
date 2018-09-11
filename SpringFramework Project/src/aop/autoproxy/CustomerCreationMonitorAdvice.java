/*
 * Created on Sep 1, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package aop.autoproxy;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CustomerCreationMonitorAdvice implements AfterReturningAdvice {

	/**
	 * 
	 */
	public CustomerCreationMonitorAdvice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	public void afterReturning(
								Object returnValue,
								Method method,
								Object[] args,
								Object target)
		throws Throwable {

		System.out.println ( "Advice: " + this.getClass().getName() + ", methodName = " + method.getName() );

		// The logic of checking method name can be removed since we implemented NameMethodMatchPointcutAdvisor
//		if ( method.getName().equals ( "createCustomer" ) && target instanceof CustomerService )
//		{
			Customer customer = (Customer) returnValue;
			System.out.println ( "Customer creation monitor: " + customer.getFullname() + " has been created." );

			// Sending the customer an email for confirmation . . .
			// . . . . . .

//		}

	}

}
