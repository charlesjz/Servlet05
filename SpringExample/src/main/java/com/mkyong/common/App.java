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
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
            		"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
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
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
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
