package techPoint;

import java.text.DecimalFormat;

public class DecimalFormatter {

	public static void main(String[] args) {
		double value=123456.789d;
		String output;
		String pattern;
		/*  1  */
		pattern="###,###.###";
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		output = myFormatter.format(value);
		System.out.println(output);
		
		/*  2  */
		pattern="###.##";
		myFormatter = new DecimalFormat(pattern);
		output = myFormatter.format(value);
		System.out.println(output);
		
		/*  3  */
		pattern="00000000.000";
		myFormatter = new DecimalFormat(pattern);
		output = myFormatter.format(value);
		System.out.println(output);
		
		/*  4  */
		pattern="$###,###.###";
		myFormatter = new DecimalFormat(pattern);
		output = myFormatter.format(value);
		System.out.println(output);
		
		/*  5  */
		pattern="\u00A5###,###.###";
		myFormatter = new DecimalFormat(pattern);
		output = myFormatter.format(value);
		System.out.println(output);
		

		
	}

}
