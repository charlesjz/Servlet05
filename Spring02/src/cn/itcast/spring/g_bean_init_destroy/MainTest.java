package cn.itcast.spring.g_bean_init_destroy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	// ��ApplicationContext�ӿ���û�ж���close()������Ҫ����ã��͵���תΪ�������Ͳ��С�
	// һ��Ҫ���ApplicationContext����bean���õ����ٷ����Żᱻ���á�
	// �ڵ���ʱ�����õĳ�ʼ�������ٷ������ᱻ���á�
	// �ڶ���ʱ��ֻ�����õĳ�ʼ���Żᱻ���á�
	@Test
	public void test() throws Exception {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml", getClass());
		
		UserDao userDao = (UserDao) ac.getBean("userDao");
		System.out.println(userDao);
		
		ac.close();
	}
}
