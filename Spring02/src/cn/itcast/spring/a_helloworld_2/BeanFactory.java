package cn.itcast.spring.a_helloworld_2;

import java.util.Properties;

public class BeanFactory {

	private static Properties props;
	
	static {
		// ģ���ȡ�����ļ�
		props = new Properties();
		props.setProperty("UserDao", "cn.itcast.spring.a_helloworld.UserDaoImpl");
	}

	/**
	 * ��������������Ӧʵ�����ʵ��
	 * 
	 * @param clazz
	 * @return
	 */
	public static <T>T getBeanInstance(Class<T> clazz) {
		try {
			String className = props.getProperty(clazz.getSimpleName());
			return (T)Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
