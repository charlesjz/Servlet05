package jiang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortAndCombine {
	
	private static class StringEntry implements Comparable<StringEntry> {
		
		String value;
		private String sortedValue;
		
		public StringEntry( String value ) {
			this.value = value;
			char[] chs = value.toCharArray();
			Arrays.sort( chs );
			this.sortedValue = new String ( chs );
		}
		
		@Override
		public boolean equals(Object obj) {
			return this.sortedValue.equals(obj);
		}
		
		@Override
		public int hashCode() {
			return this.sortedValue.hashCode();
		}

		@Override
		public int compareTo(StringEntry anotherStringEntry) {
			return this.sortedValue.compareTo(anotherStringEntry.sortedValue);
		}
		
		@Override
		public String toString() {
			return this.value;
		}
		
		
	}

	public static void main(String[] args) {
		List<String> input = new ArrayList<>();
		input.add( "abc" );
		input.add( "bca" );
		input.add( "def" );
		input.add( "edf" );
		input.add( "fhj" );
		
		SortedSet<StringEntry> inputSet = new TreeSet<> ( );
		for ( String s : input ) {
			inputSet.add( new StringEntry(s) );
		}
		
		for ( StringEntry s : inputSet ) {
			System.out.println( s );
		}
	}

}
