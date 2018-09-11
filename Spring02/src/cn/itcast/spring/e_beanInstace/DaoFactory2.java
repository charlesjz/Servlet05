package cn.itcast.spring.e_beanInstace;

import cn.itcast.spring.b_springhelloworld.UserDao;
import cn.itcast.spring.b_springhelloworld.UserDaoImpl;

public class DaoFactory2 {

	/**
	 * ����UserDao�Ĺ�����������static�ģ�
	 * 
	 * @return
	 */
	public UserDao createUserDao() {
		System.out.println("DaoFactory2.createUserDao()");
		return new UserDaoImpl();
	}
}
