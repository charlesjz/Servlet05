package exception_handling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		
		new ReadFile().readFile( "C:\\work\\workspaces\\java-se\\VicJavaSE201802\\src\\exception_handling\\test.txt" );

	}
	
	public void readFile ( String filename ) throws IOException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream ( filename );
			byte[] buffer = new byte[20140];
			fis.read(buffer);
			// display buffer
		} finally {
			if ( fis != null ) {
				try {
					fis.close();
				} catch (IOException e) { }
			}
		}
		
	}

	public void readFile2 ( String filename ) throws IOException {
		try ( FileInputStream fis = new FileInputStream ( filename ) ) {
			
			byte[] buffer = new byte[20140];
			fis.read(buffer);
			// display buffer
		}
		
	}
}
