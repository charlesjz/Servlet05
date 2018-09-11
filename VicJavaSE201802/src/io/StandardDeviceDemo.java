package io;

import java.util.Scanner;

public class StandardDeviceDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner ( System.in );
		String name = scanner.nextLine();
		System.out.println( "STDOUT: name is " + name );
		System.err.println( "STDERR: name is " + name );

	}

}
