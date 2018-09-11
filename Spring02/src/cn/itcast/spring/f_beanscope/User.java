package cn.itcast.spring.f_beanscope;

public class User {
	private Long id;
	private String name;

	public User() {
		System.out.println("创建了User的实例!");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
