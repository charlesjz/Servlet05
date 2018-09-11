package processSrtFilesFromYoutubeSubtitle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Main {

	public static void main(String[] args) throws IOException {
		JFileChooser jfc = new JFileChooser("C:/Users/Jiang/Downloads");
		jfc.showOpenDialog(null);
		File file = jfc.getSelectedFile();
		
		FileReader fr=new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String sline="";
		String result="";
		String tmp="";
		
		while((sline=br.readLine()) != null){
			if(!sline.contains("<"))
				continue;
			else{
				while(sline.contains("<")){
					tmp=sline.substring(0, sline.indexOf("<"));
					result+=tmp;
					if(result.length()>75){
						result=result.trim();
						int pos=result.indexOf(' ', 75);
						if(pos > 0){
							System.out.println(result.substring(0,pos));
							result=result.substring(pos);
						}
					}
					sline=sline.substring(sline.indexOf(">")+1);
				}
				if(result.length()!=0){
					result+=" ";
				}
				
			}
		};
		

	}

}
