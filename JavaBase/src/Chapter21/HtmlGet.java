package Chapter21;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @author hj
 * @version ����ʱ�䣺2016-7-5 ����9:30:49
 */
public class HtmlGet {
    public static void main(String[] args) {
        // �õ����������ֱ��Newһ�����ܵõ������ھͺñ�˵��õ���һ���������
        WebClient webclient = new WebClient();

        // ����������һ�²�����css��javaScript,���������ܼ򵥣��ǲ���
        webclient.getOptions().setCssEnabled(false);
        webclient.getOptions().setJavaScriptEnabled(false);

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
        
        System.out.println(htmlpage.getElementsById("querycx_type"));
        HtmlForm form=(HtmlForm) htmlpage.getForms().iterator();
        System.out.println(form.asXml());

//        // �������ֵõ�һ�������鿴���������ҳ��Դ������Է��ֱ������ֽС�f��
//        final HtmlForm form = htmlpage.getFormByName("f");
//        // ͬ��������ȡ���ٶ�һ�¡������ť
//        final HtmlSubmitInput button = (HtmlSubmitInput) form.getInputByValue("�ٶ�һ��");
//        // �õ�������
//        final HtmlTextInput textField = (HtmlTextInput) form.getInputByName("q1");
//        // ������ǳ۱Ƚϻ�ѽ������������һ���������������롱���ǳۡ�
//        textField.setValueAttribute("�Ծ���");
//        // ������ˣ����ǵ�һ�������ť
//        HtmlPage nextPage = null;
//        try {
//            nextPage = (HtmlPage) button.click();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        // �Ұѽ��ת��String
//        String result = nextPage.asXml();
//        System.out.println(result);
    }
}
