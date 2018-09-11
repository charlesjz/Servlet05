package cn.itcast.spring.f_beanscope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml", getClass());

	// ���Ե���
	@Test
	public void test() throws Exception {
		System.out.println("------ ��getBean()����֮ǰ");

		User userA = (User) ac.getBean("user1");
		User userB = (User) ac.getBean("user1");

		System.out.println(userA != null); // true
		System.out.println(userA == userB); // true
	}

	// ���Զ���
	@Test
	public void test2() throws Exception {
		System.out.println("------ ��getBean()����֮ǰ");

		User userA = (User) ac.getBean("user2");
		User userB = (User) ac.getBean("user2");

		System.out.println(userA != null); // true
		System.out.println(userA == userB); // true
	}
}
