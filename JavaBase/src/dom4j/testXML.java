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
            File file = new File("C:/Temp/PLAYLIST0816.gplf");
            SAXReader reader=new SAXReader();
            //读取xml文件到Document中
            Document doc=reader.read(file);
            Element rootElement=doc.getRootElement();
//            System.out.println(rootElement.asXML());
//            System.out.println(rootElement.elements().stream().toString());
            List<Element> listFolder=rootElement.elements("FolderId");
            for (Element Folder:listFolder){
            	System.out.println("FolderPath` "+Folder.attributeValue("FolderPath"));
                List<Element> listVideo=Folder.elements("VideoId");
                for(Element Video:listVideo){
                	System.out.print("Name` "+Video.attributeValue("Name"));
                	System.out.print("` ");
               	
                	System.out.println("Duration` "+Video.attributeValue("Duration"));

                }

            }
 
//            System.out.println(rootElement.elements("FolderId"));
            //获取xml文件的根节点
//            System.out.println(rootElement.content().toString());
            List<Element> list=rootElement.elements("VideoId");
            for(Element item: list){
            	System.out.println(item.attributeValue("Duration"));
            }
            
            
//            System.out.println(list.toString());

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
    }

}