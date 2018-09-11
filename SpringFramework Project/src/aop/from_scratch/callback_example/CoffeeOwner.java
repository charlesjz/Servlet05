package aop.from_scratch.callback_example;

public class CoffeeOwner {

	public static void main(String[] args) {
		CoffeePurchaser cp = new CoffeePurchaser ( );
		cp.purchaseCoffee( new FlavourAdder ( ) {
			@Override
			public void addFlavour() {
				System.out.println( "Add cream and honey." );
			}
		});

	}

}
