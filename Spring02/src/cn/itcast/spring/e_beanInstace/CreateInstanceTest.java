package cn.itcast.spring.e_beanInstace;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.b_springhelloworld.UserDao;

public class CreateInstanceTest {

	@Test
	public void test() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml", getClass());
		UserDao userDao = (UserDao) ac.getBean("userDao");
		UserDao userDao2 = (UserDao) ac.getBean("userDao2");
		UserDao userDao3 = (UserDao) ac.getBean("userDao3");

		System.out.println(userDao);
		System.out.println(userDao2);
		System.out.println(userDao3);
	}
}
