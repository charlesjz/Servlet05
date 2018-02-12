package Chapter21;

public class ReverseString {

	public static void main(String[] args) {
		
		String str1="abcdefg";
		String str2="";
		for(int i=0;i<str1.length();i++){
			str2+=str1.charAt(str1.length()-i-1);
		}
		System.out.println(str2);
	}

}
