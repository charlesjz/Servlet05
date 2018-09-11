package atGuiGu;

import java.math.BigDecimal;
import java.util.List;

public class Staff {
	private String name;
	private int age;
	private String position;
	private BigDecimal salary;
	private List<String> skills;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public Staff(String name, int age, String position, BigDecimal salary, List<String> skills) {
		super();
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.skills = skills;
	}
	public Staff(String name) {
		super();
		this.name = name;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
