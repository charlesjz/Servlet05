package com.mkyong.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
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

public class Utils {

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

	public static Set <String> SearchJob() throws Exception {
		
		Set <String>jobs = new HashSet<String>();
        Document doc,doc1,doc2;
        String str1="",str2=""; 
        for(int page=1;page<20;page++){ 
		        try {
		
		        	doc = Jsoup.connect("https://www.monster.ca/jobs/search/?q=java-Developer&where=toronto&page="+page).get();
		
		            // get page title
		            String title = doc.title();
		            System.out.println("title : " + title);
		            
		            Elements elements=doc.select("script[type=application/ld+json]");
		            
		            for(Element e:elements){
		            	if(e.data().contains("ListItem")){
		            		str2=e.data();
		            		break;
		            	}
		            }
		            
		            if(str2.contains("itemListElement")){
		            	str2=str2.substring(str2.indexOf("itemListElement")+18);
		            }
		            
		            int p1=0;int p2=0;
		            String jstr="";String urlStr="";
		            while(str2.length()-p2 >50){
		            	p1=str2.indexOf("{",p2);
		            	p2=str2.indexOf("}",p1)+1;
		            	jstr=str2.substring(p1, p2);
		            	urlStr=jstr.substring(jstr.indexOf("https"),jstr.length()-3);
		            	jobs.add(urlStr);
		            }
		            
		
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
        }//for loop
		return jobs;

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
