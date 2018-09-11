package cn.itcast.spring.g_bean_init_destroy;

import javax.sql.DataSource;

public class UserDao {
	private DataSource dataSource;

	/**
	 * ��ʼ������
	 */
	public void init() {
		System.out.println("UserDao.init()  ��ʼ������");
	}

	/**
	 * ���ٵķ���
	 */
	public void destroy() {
		System.out.println("UserDao.destroy()  ���ٵķ���");
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("UserDao.setDataSource()");
	}

}
