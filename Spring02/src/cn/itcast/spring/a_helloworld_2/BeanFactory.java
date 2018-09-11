package cn.itcast.spring.a_helloworld_2;

import java.util.Properties;

public class BeanFactory {

	private static Properties props;
	
	static {
		// 模拟读取配置文件
		props = new Properties();
		props.setProperty("UserDao", "cn.itcast.spring.a_helloworld.UserDaoImpl");
	}

	/**
	 * 根据配置生成相应实现类的实例
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
