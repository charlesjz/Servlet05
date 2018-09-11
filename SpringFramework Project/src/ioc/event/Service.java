/*
 * Created on Aug 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Service implements ApplicationContextAware {
	
	public static ApplicationContext beanFactory;
	

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext beanFactory)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println ( "beanFactory obtained." );
		Service.beanFactory = beanFactory;
	}
	/**
	 * 
	 */
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

}
