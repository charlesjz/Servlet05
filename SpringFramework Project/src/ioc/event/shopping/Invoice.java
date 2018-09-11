package ioc.event.shopping;

import java.util.HashMap;
import java.util.Map;

public class Invoice {

	private Shopper shopper;
	private Map<Product, Integer> itemList = new HashMap<> () ;
	
	public Invoice ( ) { }
	public Invoice ( Shopper shopper ) {
		this.shopper = shopper;
	}
	
	public double getTotalAmount ( ) {
		double totalAmount = 0.0;
		for ( Map.Entry<Product, Integer> item : itemList.entrySet() ) {
			totalAmount += ( item.getKey().getPrice() * item.getValue() );
		}
		return totalAmount;
	}
	
	public void addItem ( Product product, int quantity ) {
		Integer originalQuantity = this.itemList.get( product );
		if ( originalQuantity == null ) {
			originalQuantity = 0;
		}
		originalQuantity += quantity;
		this.itemList.put(product, originalQuantity);
	}
	public Shopper getShopper() {
		return shopper;
	}
	public void setShopper(Shopper shopper) {
		this.shopper = shopper;
	}
	public Map<Product, Integer> getItemList() {
		return itemList;
	}
	public void setItemList(Map<Product, Integer> itemList) {
		this.itemList = itemList;
	}
	
	
}
