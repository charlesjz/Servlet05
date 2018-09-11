package dom4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class words3000 {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("d:/language/word3000.txt");
		InputStreamReader isr = new InputStreamReader(file);
		BufferedReader br = new BufferedReader(isr);
		
		String str;
		while((str=br.readLine())!=null){
			if(str.length()>3 && str.length()<6 && str.endsWith("c")){
				System.out.println(str);
			}
		}

	}

}
