package cn.itcast.spring.f_beanscope;

public class MyFactory {

	// 饿汉式
	// private static MyFactory instance = new MyFactory();
	// public static MyFactory getInstance() {
	// return instance;
	// }

	// 懒汉式（要注意处理线程安全问题）
	private static MyFactory instance;
	public static MyFactory getInstance() {
		if (instance == null) {
			synchronized (MyFactory.class) {
				if (instance == null) {
					instance = new MyFactory();
				}
			}
		}
		return instance;
	}

	private MyFactory() {
	}

	public Object createObject() {
		System.out.println("MyFactory.createObject()");
		return new Object();
	}
}
