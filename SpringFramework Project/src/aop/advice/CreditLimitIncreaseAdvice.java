/*
 * Created on Sep 1, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CreditLimitIncreaseAdvice implements MethodBeforeAdvice {
	
	private int creditLimitCheckThreshold = 50000;
	
	public int getCreditLimitCheckThreshold() {
		return creditLimitCheckThreshold;
	}

	public void setCreditLimitCheckThreshold(int creditLimitCheckThreshold) {
		this.creditLimitCheckThreshold = creditLimitCheckThreshold;
	}

	/**
	 * 
	 */
	public CreditLimitIncreaseAdvice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	public void before(Method method, Object[] args, Object target)
		throws Throwable {

		//System.out.println ( "methodName = " + method.getName() );
		//System.out.println ( "args.length = " + args.length );

		if ( method.getName().equals ( "increaseCreditLimit" ) && args.length == 2 )
		{
			Customer customer = (Customer) args[0];
			int increase = ( (Integer) args[1] ).intValue();
			if ( increase > this.creditLimitCheckThreshold )
			{
				System.out.println ( "Credit Limit Increase Monitor: The increase has reached or exceeded the permitted limit ($" + this.creditLimitCheckThreshold + "). So it's been rejected." );
				throw new HighCreditLimitIncreaseException ( );
			}
			System.out.println ( "Credit Limit Increase Monitor: " + customer.getFullname() + "'s credit limit is going to be adjusted to $" + increase );
			
		}

	}

}
