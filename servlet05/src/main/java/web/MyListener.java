package web;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements ServletRequestListener, 
								   ServletRequestAttributeListener, 
								   ServletContextListener, 
								   ServletContextAttributeListener,
								   HttpSessionAttributeListener, 
								   HttpSessionListener {

	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println(scae.toString());
	}

	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println(scae.toString());

	}

	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println(scae.toString());

	}

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println(se.toString());

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println(se.toString());

	}

	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println(se.toString());

	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println(se.toString());

	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println(se.toString());

	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println(sce.toString());

	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println(sce.toString());

	}

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println(srae.toString());

	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println(srae.toString());

	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println(srae.toString());

	}

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println(sre.toString());

	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println(sre.toString());

	}
	
}
