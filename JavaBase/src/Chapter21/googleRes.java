package Chapter21;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Scanner;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class googleRes {

	private static final String HtmlSubmitInput = null;

	public static void main(String[] args) throws FailingHttpStatusCodeException, IOException, IOException {
		// TODO Auto-generated method stub
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		webClient.getOptions().setJavaScriptEnabled(false);
		
		HtmlPage page=webClient.getPage(
				"http://www.dalian-jw.gov.cn/portal/afcc3edda04f3983ed5a47c1b8bd535f/function/level2_lhsf\r\n");
		System.out.println(page.asXml());
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter VerifyCode:");
		String veryfyCode=sc.next();
		

		HtmlForm form=(HtmlForm) page.getElementById("querycx_form");
        HtmlInput input1 = (HtmlInput)page.getHtmlElementById("lsbh");
        input1.setValueAttribute("04905430");

        HtmlInput input2 = (HtmlInput)page.getHtmlElementById("verifycode");
        input2.setValueAttribute(veryfyCode);
        
        System.out.println(form.asXml());
               
        HtmlButton button = (HtmlButton)form.getElementsByTagName("button").get(0);
        System.out.println("Class:"+button.getAttribute("class"));
        HtmlPage newPage = button.click();
        
        System.out.println(newPage.asXml());
               


	}

}
