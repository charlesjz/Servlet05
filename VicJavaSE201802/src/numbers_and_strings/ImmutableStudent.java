package numbers_and_strings;

public class ImmutableStudent {
	
	private String name;
	private int age;

	public ImmutableStudent() { }

	public ImmutableStudent( String name, int age ) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public ImmutableStudent setName(String name) {
		return new ImmutableStudent ( name, this.age );
	}

	public int getAge() {
		return age;
	}

	public ImmutableStudent setAge(int age) {
		return new ImmutableStudent ( this.name, age );
	}
	
	@Override
	public String toString() {
		return "Student: name = " + this.name + ", age = " + this.age;
	}
	
	public static void main(String[] args) {
		ImmutableStudent s1 = new ImmutableStudent ( "John", 30 );
		ImmutableStudent s2 = s1;
		s1 = s1.setName( "Mary" );
		
		System.out.println( "s1 = " + s1 );
		System.out.println( "s2 = " + s2 );
		
		if ( "Mary".equals(s1.getName())  ) {
			
		}
	}

}
