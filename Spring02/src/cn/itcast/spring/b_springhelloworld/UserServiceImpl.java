package cn.itcast.spring.b_springhelloworld;

public class UserServiceImpl {
	private UserDao userDao;

	// ...

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
