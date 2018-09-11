package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		
//		String sourceFile = "C:\\Temp\\bunny.jpg";
//		String targetFile = "C:\\Temp\\bunny2.jpg";
		
		String sourceFile = "C:\\Temp\\f1.iso";
		String targetFile = "C:\\Temp\\f2.iso";

		new FileCopy().copyFileByBlock(sourceFile, targetFile);

	}
	
	public void copyFileByBytes ( String sourceFilename, String targetFilename ) {
		try ( 
				FileInputStream fis = new FileInputStream ( sourceFilename );
				FileOutputStream fos = new FileOutputStream ( targetFilename ); 
			) {
			
			int b;
			while ( ( b = fis.read() ) != -1 ) {
				fos.write(b);
			}
			System.out.println( "Completed." );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void copyFileByBlock ( String sourceFilename, String targetFilename ) {
		try ( 
				FileInputStream fis = new FileInputStream ( sourceFilename );
				FileOutputStream fos = new FileOutputStream ( targetFilename ); 
			) {
			
			int r = 0;
			byte[] buffer = new byte[10240];
			while ( ( r = fis.read(buffer) ) != -1 ) {
				fos.write(buffer, 0, r);
			}
			System.out.println( "Completed." );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
