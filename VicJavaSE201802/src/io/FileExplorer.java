package io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class FileExplorer {

	public static void main(String[] args) {
		
		listFiles ( "c:\\work" );

	}
	
	public static void listFiles ( String pathname ) {
		Path path = Paths.get ( pathname );
		File file = path.toFile();
		File[] files = file.listFiles();
		
		for ( File f : files ) {
			System.out.println( ( f.isDirectory() ? "D\t" : "F\t" ) + f.getName() + "\t" + f.length() + "\t" + new Date ( f.lastModified() ) );
			if ( f.isDirectory() ) {
				listFiles ( f.getAbsolutePath() );
			}
		}
	}

}
