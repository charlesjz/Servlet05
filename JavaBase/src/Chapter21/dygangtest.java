package Chapter21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dygangtest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String regex2="http:\\/\\/www\\.dygang\\.net\\/.{2}\\/\\d{8}\\/\\d{5}.htm";

		String sr2="r=title¡¾<a href=http://www.dygang.net/ys/20180401/40164.htm>";
		
		Pattern pattern;
		Matcher matcher;
		
		pattern = Pattern.compile(regex2);
		matcher = pattern.matcher(sr2);
		
		while(matcher.find()){
			System.out.println(matcher.group());
		}

	}
}
