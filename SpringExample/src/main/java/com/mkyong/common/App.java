package com.mkyong.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	 
    	MailMail mm = (MailMail) context.getBean("mailMail");
        
        String origStr = sendPost("http://goldmapleclub.com/forum.php?mod=viewthread&tid=29","");
        
        
        SimpleDateFormat sdf=new SimpleDateFormat("yy/MM/dd HH:mm:ss.SSS"); 
        System.out.println(origStr);
        String newStr;
        
        while(true){
        	newStr= sendPost("http://goldmapleclub.com/forum.php?mod=viewthread&tid=29","");
        	if(Math.abs(origStr.length()-newStr.length())>5){
        		mm.sendMail("Mr.", "The website content changed!"); 
        		System.out.println(origStr);
        		System.out.println(newStr);
        		origStr=newStr;
        	}else{
        		System.out.println("running..."+sdf.format(new Date()));
        	}
        		Thread.sleep(10000);
        }
        
        
//        http://goldmapleclub.com/forum.php?mod=viewthread&tid=29&extra=page%3D1
    }


    
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // �򿪺�URL֮�������
            URLConnection conn = realUrl.openConnection();
            // ����ͨ�õ���������
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
            		"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0");
            // ����POST�������������������
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // ��ȡURLConnection�����Ӧ�������
            out = new PrintWriter(conn.getOutputStream());
            // �����������
            out.print(param);
            // flush������Ļ���
            out.flush();
            // ����BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
//            System.out.println("getConnectTimeout:"+conn.getConnectTimeout());
//            System.out.println("getContent:"+conn.getContent());
//            System.out.println("getContentEncoding"+conn.getContentEncoding());
//            System.out.println("getContentLength:"+conn.getContentLength());
//            System.out.println("getDate:"+conn.getDate());
//            System.out.println("toString:"+conn.toString());
//            System.out.println("in.toString:"+in.toString());
//            System.out.println("conn.getContent().toString():"+conn.getContent().toString());
//            System.out.println(out.toString());
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("���� POST ��������쳣��"+e);
            e.printStackTrace();
        }
        //ʹ��finally�����ر��������������
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    


}
