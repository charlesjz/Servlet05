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
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class testXML {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            File file = new File("G:/计算机学习/SSH/Hibernate/2012年1月份汤阳光hibernate视频教程/time.gplf");
            SAXReader reader=new SAXReader();
            //读取xml文件到Document中
            Document doc=reader.read(file);
            //获取xml文件的根节点
            Element rootElement=doc.getRootElement();
            List<Element> list=rootElement.elements("VideoId");
            for(Element item: list){
            	System.out.println(item.attributeValue("Duration"));
            }
            
            
            System.out.println(list.toString());

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
    }

}