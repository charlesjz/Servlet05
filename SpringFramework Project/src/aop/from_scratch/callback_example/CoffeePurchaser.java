package aop.from_scratch.callback_example;

public class CoffeePurchaser {
	
	public void purchaseCoffee ( FlavourAdder flavourAdder ) {
		
		System.out.println( "Select coffee." );
		System.out.println( "Pay money." );
//		System.out.println( "Add flavour." );
		flavourAdder.addFlavour();
		System.out.println( "Deliver coffee." );
		
	}

}
