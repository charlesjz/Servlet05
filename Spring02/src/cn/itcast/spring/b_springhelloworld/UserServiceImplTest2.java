package cn.itcast.spring.b_springhelloworld;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class UserServiceImplTest2 {

	@Test
	public void testGetUserDao() {
		// Spring的容器对象
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cn/itcast/spring/b_springhelloworld/applicationContext.xml");

		// 从中取出配置的Bean
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");

		// 显示信息
		System.out.println(userDao);
		System.out.println(userService);
		System.out.println("---");

		userDao.printInfo();
		System.out.println(userService.getUserDao());
	}
	
	@Test
	public void testGetUserDao2() {
		// Spring的容器对象
		Resource resource = new ClassPathResource("cn/itcast/spring/b_springhelloworld/applicationContext.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		
		// 从中取出配置的Bean
		UserDao userDao = (UserDao) beanFactory.getBean("userDao");
		UserServiceImpl userService = (UserServiceImpl) beanFactory.getBean("userService");

		// 显示信息
		System.out.println(userDao);
		System.out.println(userService);
		System.out.println("---");

		userDao.printInfo();
		System.out.println(userService.getUserDao());
		System.out.println("---");
	}
}
