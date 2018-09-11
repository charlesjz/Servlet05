package Chapter21;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @author hj
 * @version ����ʱ�䣺2016-7-5 ����9:30:49
 */
public class HtmlGetTest {
    public static void main(String[] args) throws Exception {
        // �õ����������ֱ��Newһ�����ܵõ������ھͺñ�˵��õ���һ���������
        WebClient webclient = new WebClient();

        // ����������һ�²�����css��javaScript,���������ܼ򵥣��ǲ���
        webclient.getOptions().setCssEnabled(true);
        webclient.getOptions().setJavaScriptEnabled(true);

        // ���ĵ�һ���£�ȥ�õ������ҳ��ֻ��Ҫ����getPage�����������
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

//        System.out.println("��������֤�룺");
//        Scanner scanner=new Scanner(System.in);
//        String str=scanner.next();
//        System.out.println(str);
//        String cardnum="04595430";

        //��ȡ����������ύ��������
        HtmlInput input1 = (HtmlInput)htmlpage.getHtmlElementById("lsbh");
        System.out.println(input1.toString());
        input1.setValueAttribute("04905430");
        System.out.println(input1.toString());
        //��ȡ������ť�����
        //��ȡ����������ύ��������
        HtmlInput input2 = (HtmlInput)htmlpage.getHtmlElementById("verifycode");
        System.out.println(input2.toString());
        input2.setValueAttribute("0123");
        System.out.println(input2.toString());
        //��ȡ������ť�����
//        HtmlSubmitInput btn = (HtmlSubmitInput) htmlpage.getInputEncoding("�ٶ�һ��");
//        HtmlPage page2 = btn.click();c
        //�����ҳ����ı�
//        System.out.println(page2.asText());
        }
}
