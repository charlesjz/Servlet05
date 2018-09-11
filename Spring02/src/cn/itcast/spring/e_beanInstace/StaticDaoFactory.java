package cn.itcast.spring.e_beanInstace;

import cn.itcast.spring.b_springhelloworld.UserDao;
import cn.itcast.spring.b_springhelloworld.UserDaoImpl;

public class StaticDaoFactory {

	/**
	 * static�Ĵ���UserDaoʵ���Ĺ�������
	 * 
	 * @return
	 */
	public static UserDao createUserDaoInstance() {
		System.out.println("DaoFactory1.createUserDaoInstance()");
		return new UserDaoImpl();
	}
}
