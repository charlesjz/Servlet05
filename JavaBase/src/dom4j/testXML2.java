/**
 * 
 */
/**
 * @author Jiang
 *
 */
package dom4j;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class testXML2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            File file = new File("G:/计算机学习/SSH/Hibernate/2012年1月份汤阳光hibernate视频教程/time.gplf");
            SAXReader reader=new SAXReader();
            //读取xml文件到Document中
            Document doc=reader.read(file);
            //获取xml文件的根节点
            Element rootElement=doc.getRootElement();
            //定义一个Element用于遍历
            Element fooElement;
            //遍历所有名叫“VideoId”的节点
            for(Iterator i=rootElement.elementIterator("VideoId");i.hasNext();){
                fooElement=(Element)i.next();
                System.out.println(fooElement.attributeValue("Name")+","+fooElement.attributeValue("Duration"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
    }

}