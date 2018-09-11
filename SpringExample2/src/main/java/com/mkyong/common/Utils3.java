package com.mkyong.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils3 {

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

    public static void HtmlPro1(String str){
    	System.out.println(str);
    	
        try {
            Parser parser = new Parser("https://www.monster.ca/jobs/search/?q=java-Developer&where=toronto&page=2");
            NodeList list = parser.parse(null);
            for (int i = 0; i < list.size(); i++) {
                Node node = list.elementAt(i);
                System.out.println(i);
                System.out.println(node.getText());
            }
            System.out.println("=========================");
            System.out.println(list.elementAt(2).getFirstChild());
        } catch (ParserException pe) {
            pe.printStackTrace ();
        }
	

    }

	public static Set <String> SearchJob() throws IOException, InterruptedException {
		
		Set <String>jobs = new HashSet<String>();
        String []htmlPages = null;
//        String linkAttr1,linkAttr2,linkText1,linkText2; 
        for(int page=1;page<13;page++){ 
        	htmlPages[page-1] = sendPost("https://www.monster.ca/jobs/search/?q=java&where=Toronto__2C-Ontario&page="+page,"");
        	System.out.println(htmlPages[page-1]);
        }
        
        Thread.sleep(10000);
        
        for(int i=1;i<htmlPages.length;i++){
		    int p1,p2;
        	p1=htmlPages[i].indexOf("ListItem")-20;
        	p2=htmlPages[i].lastIndexOf("ListItem")+200;
		    System.out.println("p1=" + p1 + ", p2=" + p2);
        	htmlPages[i] = htmlPages[i].substring(p1, p2);
        	
//			------pure htmlPage String
        	String str="";
        	p1=0;p2=0;
        	while(htmlPages[i].length()-p2 > 50){
        		p1=htmlPages[i].indexOf("{",p2);
        		p2=htmlPages[i].indexOf("}",p1);
        		
        		str=htmlPages[i].substring(p1,p2+1);
        		System.out.println(str);
        	}
//        	String []jsonString = htmlPage.split(",");
//        	
//        	Arrays.asList(jsonString).stream().forEach((x)->
//        	{
//        		if(x.contains("job-openings")){
//        			int q1=x.indexOf("https");
//        			int q2=x.indexOf("\"}");
//        			jobs.add(x.substring(q1,q2));
//        		}
//        	});
        	
        }//for loop
		return jobs;

    }

	private static Set<String> TakeOutUrl(String[] jsonStr) throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		Set <String>set = new HashSet<>();
		ObjectMapper objectMapper = new ObjectMapper();
		
		for(String x:jsonStr){
			x = x.replace("@", "");
			Thread.sleep(1000);
			ListItem e = objectMapper.readValue(x, ListItem.class);
			Thread.sleep(1000);
			set.add(e.getUrl());
		}
		return set;
	}

	public static void ApplyTheseJobs(Set<String> jobs) {
		Iterator iter = jobs.iterator();
		String url;
		while(iter.hasNext()){
			url=iter.next().toString();
			FindElement.click(url);
		}
		
	}
    
}
