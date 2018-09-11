package ioc.event.shopping;

import org.springframework.context.ApplicationEvent;

public class PurchaseEvent extends ApplicationEvent {
	
	private Invoice invoice;

	public PurchaseEvent(Object source, Invoice invoice) {
		super(source);
		this.invoice = invoice;
	}

	public Invoice getInvoice() {
		return invoice;
	}

}
