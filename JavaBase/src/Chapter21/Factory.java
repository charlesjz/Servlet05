package Chapter21;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;


class InetAddressTest
{
	public static void main(String args[]) throws UnknownHostException {
		InetAddress Address = InetAddress.getLocalHost();
		System.out.println(Address);
		Address = InetAddress.getByName("www.goldmapleclub.com");
		System.out.println(Address);
		InetAddress SW[] = InetAddress.getAllByName("www.nba.com");
	for (int i=0; i<SW.length; i++)
		System.out.println(SW[i]);

	


	//判断当前系统是否支持Java AWT Desktop扩展
	        if(java.awt.Desktop.isDesktopSupported()){
	            try{
	                //创建一个URI实例,注意不是URL
	                java.net.URI uri=java.net.URI.create("http://www.dalian-jw.gov.cn/portal/afcc3edda04f3983ed5a47c1b8bd535f/function/level2_lhsf");
	                //获取当前系统桌面扩展
	                java.awt.Desktop dp=java.awt.Desktop.getDesktop();
	                //判断系统桌面是否支持要执行的功能
	                if(dp.isSupported(java.awt.Desktop.Action.BROWSE)){
	                    //获取系统默认浏览器打开链接
	                    dp.browse(uri);
	                }
	            }catch(java.lang.NullPointerException e){
	                //此为uri为空时抛出异常
	            }catch(java.io.IOException e){
	                //此为无法获取系统默认浏览器
	            }
	            
	            System.out.println("请输入验证码：");
	            Scanner scanner=new Scanner(System.in);
	            String str=scanner.next();
	            System.out.println(str);
	            String cardnum="04595430";
	            
	            

	        }
	}
}