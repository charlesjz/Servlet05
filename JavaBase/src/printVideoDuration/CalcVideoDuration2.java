package printVideoDuration;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

public class CalcVideoDuration2 {
	public static void readVideoTime(String path) {
        long sum = 0;
        long num = 0;
        File filePath = new File(path);
        Encoder encoder = new Encoder();
        
        File[] file = filePath.listFiles();
        System.out.println("Start...");
        
//        List<File> filePaths = new ArrayList();
//        getAllFilePaths(filePath, filePaths);
        
        
        
        
        for (File file2 : file) {
            try {
                MultimediaInfo m = encoder.getInfo(file2);
                long ls = m.getDuration() / 1000;// ls是获取到的秒数
                sum += ls;
                num++;
                System.out.println(file2+":  \t"+ls+"(seconds)");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
     
        double sum1 = (double) sum;
        double sum2 = sum1 / 3600;// 转换成为了小时
        DecimalFormat df = new DecimalFormat("#.0");
        System.out.println("共计:"+num+"个视频,"+(int)sum+"(seconds)/"+df.format(sum2)+"hours");
    }
	
	private static List<File> getAllFilePaths(File filePath,List<File> filePaths){
        File[] files = filePath.listFiles();
        if(files == null){
            return filePaths;    
        }    
        for(File f:files){
            if(f.isDirectory()){
                filePaths.add(filePath);
                getAllFilePaths(f,filePaths);
            }else{
                filePaths.add(filePath);
            }    
        }
        return filePaths;

    }
	
//	public static void main(String[] args) {
//		readVideoTime("F:/计算机学习/JAVA/A Hibernate/北京圣思园Hibernate应用开发详解[更新完毕-共享完毕]");
//	}
}
