package techPoint;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nSample {

	public static void main(String[] args) {
//		String language;
//		String country;
//		if(args.length!=2){
//			language = new String("en");
//			country = new String("US");
//		}else{
//			language = new String(args[0]);
//			country = new String(args[1]);
//		}
//		Locale currentLocale;
//		ResourceBundle messages;
//		currentLocale = new Locale(language,country);
//		
//		System.out.println(currentLocale);
//		messages = ResourceBundle.getBundle("MessageBundle",currentLocale);
		for(String s:args){
			System.out.println(s);
		}
		

	}

}
