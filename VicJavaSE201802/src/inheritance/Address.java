package inheritance;

public class Address {
	
	private String street;
	private String city;
	private String province;

	public Address() { }
	
	public Address ( String street, String city, String province ) {
		this.street = street;
		this.city = city;
		this.province = province;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	@Override
	protected Address clone() throws CloneNotSupportedException {
		return new Address ( this.street, this.city, this.province );
	}
	
	@Override
	public String toString() {
		return "Address is: street = " + this.street + ", city = " + city + ", province = " + this.province;
	}
	
}
