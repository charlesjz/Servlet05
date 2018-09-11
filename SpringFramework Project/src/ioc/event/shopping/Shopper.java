package ioc.event.shopping;

public class Shopper {
	
	private String name;
	
	public Shopper ( ) { }
	
	public Shopper ( String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
