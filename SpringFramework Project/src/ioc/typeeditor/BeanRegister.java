/*
 * Created on Aug 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package ioc.typeeditor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author gaod
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BeanRegister implements BeanPostProcessor, BeanFactoryPostProcessor {
	
	private static int beanTotal = 0;

	/**
	 * 
	 */
	public BeanRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Object postProcessBeforeInitialization(Object bean, String name)
		throws BeansException {

		System.out.println ( "(Before)bean class: " + bean.getClass().getName() + ", name = " + name );
		beanTotal ++;

		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String name)
		throws BeansException {
			
		System.out.println ( "(After)bean class: " + bean.getClass().getName() + ", name = " + name );
		return bean;
	}

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
		throws BeansException {
		
		System.out.println ( "Bean Count: " + beanFactory.getBeanDefinitionCount() );

	}


	/**
	 * @return
	 */
	public static int getBeanTotal() {
		return beanTotal;
	}

	/**
	 * @param i
	 */
	public static void setBeanTotal(int i) {
		beanTotal = i;
	}

}
