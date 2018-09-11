package cn.itcast.spring.g_bean_init_destroy;

import javax.sql.DataSource;

public class UserDao {
	private DataSource dataSource;

	/**
	 * 初始化方法
	 */
	public void init() {
		System.out.println("UserDao.init()  初始化方法");
	}

	/**
	 * 销毁的方法
	 */
	public void destroy() {
		System.out.println("UserDao.destroy()  销毁的方法");
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("UserDao.setDataSource()");
	}

}
