/*
 * Created on Sep 4, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package aop.autoproxy;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CreditLimitCheckingMixin
	extends DelegatingIntroductionInterceptor
	implements CreditLimit {
		
	private int creditLimit;

	/**
	 * @param arg0
	 */
	public CreditLimitCheckingMixin(Object arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public CreditLimitCheckingMixin() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return
	 */
	public int getCreditLimit() {
		return creditLimit;
	}

	/**
	 * @param i
	 */
	public void setCreditLimit(int i) {
		creditLimit = i;
	}
	
	public Object invoke ( MethodInvocation mi ) throws Throwable
	{
		String name = mi.getMethod().getName();
		Object[] args = mi.getArguments();
System.out.println ( "======> " + name );
		if ( name.equals ( "increaseCreditLimit") && args.length == 2 )
		{
			Customer customer = (Customer) args[0];
			int increaseLimit = ( (Integer) args[1] ).intValue();
System.out.println ( "------> " + this.creditLimit + "/" + customer.getCreditLimit() );
			if ( this.creditLimit == CreditLimit.CREDIT_LIMIT_NOT_ALLOWED )
			{
				throw new CreditLimitCheckingNotAvailableException ( );
			}
			else if ( this.creditLimit <= customer.getCreditLimit() + increaseLimit )
			{
				throw new MaximumCreditLimitReachedException ( );
			}
		}
		
		return super.invoke ( mi );
	}

}
