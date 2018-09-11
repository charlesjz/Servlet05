/*
 * Created on Sep 3, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package aop.autoproxy;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DynamicTimeSensitivePointcut implements MethodMatcher, Pointcut {

	private List methods;
	private String hourList;

	/**
	 * 
	 */
	public DynamicTimeSensitivePointcut() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.aop.Pointcut#getClassFilter()
	 */
	public ClassFilter getClassFilter() {
		return ClassFilter.TRUE;
	}

	/* (non-Javadoc)
	 * @see org.springframework.aop.Pointcut#getMethodMatcher()
	 */
	public MethodMatcher getMethodMatcher() {
		return this;
	}

	public final boolean matches(Method method, Class targetClass) {
		if ( this.methods.contains(targetClass.getName() + "." + method.getName() ) )
		{
			System.out.println ( "DynamicTimeSensitivePointcut.matches(static) retrns true." );
			return true;
		}
		else
		{
			System.out.println ( "DynamicTimeSensitivePointcut.matches(static) retrns false." );
			return false;
		}
	}

	public final boolean isRuntime() {
		System.out.println ( "DynamicTimeSensitivePointcut.isRunTime() is going to return true." );
		return true;
	}

	public boolean matches(Method method, Class targetClass, Object[] args) {
		System.err.print ( "DynamicTimeSensitivePointcut: " + targetClass.getName() + "." + method.getName() );
		int hour = Calendar.getInstance().get( Calendar.HOUR_OF_DAY);
		if ( !this.hourList.startsWith( "," ) )
		{
			this.hourList = "," + this.hourList;
		}
		if ( !this.hourList.endsWith( "," ) )
		{
			this.hourList += ",";
		}
		if ( this.hourList.indexOf ( "," + Integer.toString ( hour ) + "," ) >= 0 )
		{
			System.err.println ( " -> Right time, working." );
			return true;
		}
		else
		{
			System.err.println ( " -> Not the right time, not working." );
			return false;
		}
	}

	/**
	 * @return
	 */
	public String getHourList() {
		return hourList;
	}

	/**
	 * @return
	 */
	public List getMethods() {
		return methods;
	}

	/**
	 * @param string
	 */
	public void setHourList(String string) {
		hourList = string.trim();
	}

	/**
	 * @param list
	 */
	public void setMethods(List list) {
		methods = list;
	}

}
