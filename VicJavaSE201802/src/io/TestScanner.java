package io;

import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner ( System.in );
		System.out.print ( "Please input number #1: ");
		int number1 = scanner.nextInt();
		System.out.print ( "Please input number #2: ");
		int number2 = scanner.nextInt();
		System.out.println( "The sum of both number is: " + (number1 + number2) );

	}

}
