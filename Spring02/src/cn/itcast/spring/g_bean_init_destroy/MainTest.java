package cn.itcast.spring.g_bean_init_destroy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	// 在ApplicationContext接口中没有定义close()方法，要想调用，就得先转为子类类型才行。
	// 一定要半闭ApplicationContext，给bean配置的销毁方法才会被调用。
	// 在单例时，配置的初始化与销毁方法都会被调用。
	// 在多例时，只有配置的初始化才会被调用。
	@Test
	public void test() throws Exception {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml", getClass());
		
		UserDao userDao = (UserDao) ac.getBean("userDao");
		System.out.println(userDao);
		
		ac.close();
	}
}
