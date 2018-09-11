package ioc.event.shopping;

public class Product {
	
	private String name;
	private double price;
	
	public Product ( ) { }
	
	public Product ( String name, double price ) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( obj == null ) {
			return false;
		} else if ( obj instanceof Product ) {
			if ( this.name == null || ((Product)obj).name == null ) {
				return false;
			} else {
				return this.name.equals( ((Product)obj).name );
			}
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return this.name != null ? this.name.hashCode() : 0;
	}

	
}
