package hugo;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] argv) {
        Object array = "book2s.com";
        System.out.println(toString(array));
    }

    private static String toString(Object array) {
    	String s = (String) array;
    	
    	char[] a=s.toCharArray();
    	StringBuilder b=new StringBuilder();
    	
    	        b.append('[');
    	        for (int i = 0;; i++) {
    	            b.append(Array.get(a, i));
    	            if (i == a.length - 1) {
    	                return b.append(']').toString();
    	            }
    	            b.append(", ");
    	        }
    }
}