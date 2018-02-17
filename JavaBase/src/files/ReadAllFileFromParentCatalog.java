package files;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ReadAllFileFromParentCatalog {  
    
    //读取一个文件夹下所有文件及子文件夹下的所有文件  
    public void ReadAllFile(String filePath) {  
    	List<String> results = new ArrayList<String>();
        File f = null;  
        f = new File(filePath);  
        File[] files = f.listFiles(); // 得到f文件夹下面的所有文件。  
        List<File> list = new ArrayList<File>();  
        for (File file : files) {  
            if(file.isDirectory()) {  
                //如何当前路劲是文件夹，则循环读取这个文件夹下的所有文件  
                ReadAllFile(file.getAbsolutePath());  
            } else {  
                list.add(file);  
            }  
        }  
        for(File file : files) {  
        	if(file.length()>1000000){
	        	results.add(StringUtils.leftPad(""+file.length(),11,"0")+" "+file.getAbsolutePath());
//	            System.out.println(file.getAbsolutePath()+", "+file.length()+" for "+map.);  
        	}
        }
        results.sort(Comparator.naturalOrder());
        for(String result:results){
        	System.out.println(result);
        }
    }  
      
    //读取一个文件夹下的所有文件夹和文件  
    public void ReadFile(String filePath) {  
        File f = null;  
        f = new File(filePath);  
        File[] files = f.listFiles(); // 得到f文件夹下面的所有文件。  
        List<File> list = new ArrayList<File>();  
        for (File file : files) {  
            list.add(file);  
        }  
        for(File file : files) {  
            System.out.println(file.getAbsolutePath());  
        }  
    }  
      
    public static void main(String[] args) {  
        String filePath = "D:/计算机学习";  
        new ReadAllFileFromParentCatalog().ReadAllFile(filePath);  
    }  
} 