package Chapter21;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Scanner;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

/**
 * @author hj
 * @version 创建时间：2016-7-5 下午9:30:49
 */
public class HtmlGetTest {
    public static void main(String[] args) throws Exception {
        // 得到浏览器对象，直接New一个就能得到，现在就好比说你得到了一个浏览器了
        WebClient webclient = new WebClient();

        // 这里是配置一下不加载css和javaScript,配置起来很简单，是不是
        webclient.getOptions().setCssEnabled(true);
        webclient.getOptions().setJavaScriptEnabled(true);

        // 做的第一件事，去拿到这个网页，只需要调用getPage这个方法即可
        HtmlPage htmlpage = null;
        try {
            htmlpage = (HtmlPage) webclient
                    .getPage("http://www.dalian-jw.gov.cn/portal/afcc3edda04f3983ed5a47c1b8bd535f/function/level2_lhsf");
        } catch (FailingHttpStatusCodeException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
           e1.printStackTrace();
        }

//        System.out.println("请输入验证码：");
//        Scanner scanner=new Scanner(System.in);
//        String str=scanner.next();
//        System.out.println(str);
//        String cardnum="04595430";

        //获取搜索输入框并提交搜索内容
        HtmlInput input1 = (HtmlInput)htmlpage.getHtmlElementById("lsbh");
        System.out.println(input1.toString());
        input1.setValueAttribute("04905430");
        System.out.println(input1.toString());
        //获取搜索按钮并点击
        //获取搜索输入框并提交搜索内容
        HtmlInput input2 = (HtmlInput)htmlpage.getHtmlElementById("verifycode");
        System.out.println(input2.toString());
        input2.setValueAttribute("0123");
        System.out.println(input2.toString());
        //获取搜索按钮并点击
//        HtmlSubmitInput btn = (HtmlSubmitInput) htmlpage.getInputEncoding("百度一下");
//        HtmlPage page2 = btn.click();c
        //输出新页面的文本
//        System.out.println(page2.asText());
        }
}
