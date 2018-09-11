package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class PostThread extends Thread {
	  
	public PostThread(String name) {
		super(name);
	}
	  
	static int i = 54;
	static int j = 2890;
	  
	static Object ob = "aa";
	
	

	
		@Override
	public void run() {
		while (j < 2900) {
			synchronized (ob) {
				String str="",str1="";
				String str2="";
				Date now=new Date();
				str1=StringUtils.leftPad(""+i, 3,"0");
				str2=StringUtils.leftPad(""+j, 5,"0");
				str="lsbh="+ str1 + str2 +"&verifycode=" +str2+ "&backurl=";
				now=new Date();
				System.out.println("======"+getName()+"============================================="+now+"====="+str1+str2+"=");
				System.out.println("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp"+str);
		        String sr=sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", str);
		        System.out.println(sr.substring(100, 200));
		        j++;
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  
		}
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
	
		
