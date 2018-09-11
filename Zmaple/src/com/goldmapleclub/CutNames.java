package com.goldmapleclub;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CutNames {
	
	public static void main(String[] args) throws Exception {
		
		final String dir="D:/pa/";
		final String preFileName="postUrl";
		String fileName="";
		String num;
		
		for(int i=1;i<11;i++){
			num="000";
			num+=i;
			num=num.substring(num.length()-3);
			fileName=preFileName+"_"+num;
			System.out.println(fileName);
			
			CutNames.action(dir,fileName);
		}
	}

	private static void action(String dir, String fileName) throws IOException{
		
		System.out.println(dir + fileName+".log");
		
		File file = new File(dir + fileName+".log");
		
		if(!file.exists()){
			System.out.println("File is not exist!");
			return;
		}
		
		FileInputStream fis = new FileInputStream(dir + fileName+".log");
		InputStreamReader isr = new InputStreamReader(fis,"utf-8");
		BufferedReader br = new BufferedReader(isr);

		FileOutputStream fos = new FileOutputStream("D:/pb/" +fileName+".log");
		DataOutputStream dos = new DataOutputStream(fos);
		PrintWriter pw = new PrintWriter(dos);
		
		String s;
		StringBuilder sb = new StringBuilder();
		
		long l=0;
		while((s=br.readLine()) != null){
			sb.setLength(0);
			sb.append(s);
			sb=sb.replace(sb.indexOf("大连市城乡建设委员会"),sb.indexOf("大连市城乡建设委员会")+10,"GoldMapleClub");
			sb=sb.delete(sb.indexOf("姓名")-1,sb.indexOf("姓名")+12);
			sb=sb.delete(sb.indexOf("说明：")-21,sb.indexOf("说明：")+370);

			s=sb.toString();
			

			System.out.println(l++);
			pw.println(s);
			System.out.println(s);
			
			if(l%1000==0){
				System.gc();
			}
		}
		
		pw.flush();

		br.close();
		isr.close();
		fis.close();
		pw.close();
		dos.close();
		fos.close();
		
		 

	}
}
