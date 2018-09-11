package cn.itcast.spring.d_applicationContext;

import java.util.Arrays;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.b_springhelloworld.UserDao;

public class ApplicationContextTest {

	@Test
	public void test1() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/spring/d_applicationContext/applicationContext_dao.xml");
		ApplicationContext ac2 = new ClassPathXmlApplicationContext("applicationContext_dao.xml", this.getClass());

		System.out.println(ac.getBeanDefinitionCount());
		System.out.println(Arrays.toString(ac.getBeanDefinitionNames()));

		System.out.println(ac2.getBeanDefinitionCount());
		System.out.println(Arrays.toString(ac2.getBeanDefinitionNames()));
	}

	// һ�μ��ض�������ļ�
	@Test
	public void test2() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {//
				"cn/itcast/spring/d_applicationContext/applicationContext_service.xml",//
						"cn/itcast/spring/d_applicationContext/applicationContext_dao.xml" });
		System.out.println(Arrays.toString(ac.getBeanDefinitionNames()));

		ApplicationContext ac2 = new ClassPathXmlApplicationContext(new String[] {//
				"applicationContext_dao.xml", "applicationContext_service.xml" }, this.getClass());
		System.out.println(Arrays.toString(ac2.getBeanDefinitionNames()));
	}

	@Test
	public void testMethod() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_dao.xml", getClass());

		// ��ȡ����ָ�����͵�bean������
		String[] names = ac.getBeanNamesForType(UserDao.class);
		System.out.println(Arrays.toString(names));

		// ��ȡ����ָ�����͵�bean����Ϣ��key�����ƣ�value�Ƕ���ʵ����
		Map<String, Object> map = ac.getBeansOfType(UserDao.class);
		System.out.println(map);
	}
}
