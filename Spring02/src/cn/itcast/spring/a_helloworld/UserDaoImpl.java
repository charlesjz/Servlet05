package cn.itcast.spring.a_helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
	private String jdbcUrl;
	private String driverClass;
	private String username;
	private String password;

	// ...

	public UserDaoImpl() {
		// ��ȡ�����ļ�
		String resource = "jdbc.properties";
		Properties props = loadProperties(resource);

		// ����ʼ����Ϣ
		jdbcUrl = props.getProperty("jdbcUrl");
		driverClass = props.getProperty("driverClass");
		username = props.getProperty("username");
		password = props.getProperty("password");

		// ��ʾ��Ϣ
		printInfo();
	}

	/**
	 * ���������ļ�
	 * 
	 * @param resource
	 * @return
	 */
	private Properties loadProperties(String resource) {
		InputStream inputStream = null;
		try {
			inputStream = getClass().getResourceAsStream(resource);
			Properties props = new Properties();
			props.load(inputStream);
			return props;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void printInfo() {
		System.out.println("jdbcUrl  = " + jdbcUrl);
		System.out.println("driverClass = " + driverClass);
		System.out.println("username = " + username);
		System.out.println("password = " + password);
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
