package aop.from_scratch;

public class ArtemisServiceImpl implements ArtemisService {
	
	private String name;
	
	public ArtemisServiceImpl ( String name ) {
		this.name = name;
	}

	@Override
	public void drink(String drinkName) {
		System.out.println( "Artemis has drunk " + drinkName );

	}

	@Override
	public int eat(String food) {
		int leftOver = (int) (Math.random() * 100);
		System.out.println( "Artemis has eaten " + food + ", with " + leftOver + "% left over." );
		
		return leftOver;
	}

	@Override
	public void watchMovie(String movieName) {
		System.out.println( "Artemis has watched " + movieName );

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
