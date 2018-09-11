package ioc.event.shopping;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ShoppingServiceImpl implements ShoppingService, ApplicationContextAware {
	
	private ApplicationContext appCtx;

	@Override
	public void checkout(Invoice invoice) {
		System.out.println( "The shopper of " + invoice.getShopper().getName() 
				+ " has purchased $" + invoice.getTotalAmount() + "." );
		this.appCtx.publishEvent( new PurchaseEvent ( this, invoice )  );
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) throws BeansException {
		this.appCtx = appCtx;
		
	}
	
}
