package cn.itcast.spring.a_helloworld_2;

import cn.itcast.spring.a_helloworld.UserDao;

public class UserServiceImpl {
	// private UserDao userDao = new UserDaoImpl();
	private UserDao userDao = BeanFactory.getBeanInstance(UserDao.class);

	public UserServiceImpl() {
		System.out.println("所使用的UserDao = " + userDao.getClass());
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
