package Chapter21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;


public class postUrl3 {

	public static void main(String[] args) throws IOException {
//		http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp
//		lsbh	04903399
//		verifycode	8107
//		backurl
        //发送 POST 请求
		String str="",str1="",str2="";
		File f=new File("D:/postUrl.log");
		FileWriter fw=new FileWriter(f, true);
		BufferedWriter bf=new BufferedWriter(fw);
		PrintWriter pw=new PrintWriter(bf);
		
		
		int i=12,j=1514;
		int count=0;
		int count_item=0;
		int loop;
		String item[] = new String[100];
		
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201510&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201511&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201512&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201513&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201514&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201515&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201516&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201517&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201518&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201519&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201520&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201521&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201522&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201523&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201524&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201525&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201526&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201527&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201528&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201529&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201530&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201531&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201532&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201533&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201534&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201535&verifycode=8107&backurl="));}}).start();
		new Thread(new Runnable(){ public void run(){
    	  	System.out.println(sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201536&verifycode=8107&backurl="));}}).start();



		
//		        String sr1=sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", "lsbh=01201514&verifycode=8107&backurl=");
//		        String sr=sendPost("http://www.dalian-jw.gov.cn:8080/lhsfc/querycx.asp", str);
		        
		pw.flush();
		pw.close();
		fw.close();
	}
	
	
	
    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
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
