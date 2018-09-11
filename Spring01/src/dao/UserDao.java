package dao;

public class UserDao {
	String username;
	String address;
	String phoneNo;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public void info(){
		System.out.println("username:"+username+", address:"+address+", phoneNo:"+phoneNo);
	}

}
