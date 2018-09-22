package hugo;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;


public class Ceshi {
	
//	private int i=0;
	
	public static void main(String[] args) {

		List<String> elements=Arrays.asList("1","2","3","4");
		
		String str = elements.stream()
			.reduce("",String::concat);
		Optional<Integer> i = elements.stream()
				.map((t) -> Integer.parseInt(t))
				.reduce(Integer::sum);
		
		System.out.println(str);
		if(i.isPresent()){
			System.out.println(i.get());
		}
		
		String language;
		String country;
		if(args.length!=2){
			language = new String("en");
			country = new String("US");
		}else{
			language = new String(args[0]);
			country = new String(args[1]);
		}
		
		Locale currentLocale = new Locale(language,country);
		System.out.println(currentLocale);
		ResourceBundle messages = ResourceBundle.getBundle("MessageBundle",currentLocale);
		
//		greetings = Hello
//				farewell  = GoodBye
//				inqury    = How are you?
		System.out.println(messages.getString("greetings"));
		System.out.println(messages.getString("farewell"));
		System.out.println(messages.getString("inqury"));
		
	}
	
}
