package techPoint;

public class IsChar {

	public static void main(String[] args) {
		
		char ch='9';
		
		if(Character.isLetter(ch)){
			System.out.println("Is a letter.");
		}else{
			System.out.println("Is NOT a letter.");
		}
	}

}
