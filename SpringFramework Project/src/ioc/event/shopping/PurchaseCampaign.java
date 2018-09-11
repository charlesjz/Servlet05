package ioc.event.shopping;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class PurchaseCampaign implements ApplicationListener {
	
	private double creditEligibility;
	private double eligibleCredit;

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		
		if ( event instanceof PurchaseEvent ) {
			PurchaseEvent purchaseEvent = (PurchaseEvent) event;
			if ( purchaseEvent.getInvoice().getTotalAmount() >= this.creditEligibility ) {
				System.out.println( "Congratulations, " + purchaseEvent.getInvoice().getShopper().getName()
						+ ", you are eligible for a $" + this.eligibleCredit + " credit for this purchase." );
			}
		}
		
	}

	public double getCreditEligibility() {
		return creditEligibility;
	}

	public void setCreditEligibility(double creditEligibility) {
		this.creditEligibility = creditEligibility;
	}

	public double getEligibleCredit() {
		return eligibleCredit;
	}

	public void setEligibleCredit(double eligibleCredit) {
		this.eligibleCredit = eligibleCredit;
	}
	
	

}
