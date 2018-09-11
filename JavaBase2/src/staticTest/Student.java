package staticTest;

public class Student {
	String name;
	String id;
	String email;
	
	static int totalStudent=0;
	
	public Student() {
	}
	public Student(String name, String id, String email) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		totalStudent++;
		System.out.println(this.toString());
		System.out.println("How many student in your database? "+ totalStudent);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", email=" + email + "]";
	}
	
	

}
