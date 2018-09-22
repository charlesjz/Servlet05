package printVideoDuration;

import java.io.File;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

public class CalcVideoDuration {
	
	static Set<File> getFiles = new HashSet<>(); 

	public String readVideoTime(String path) throws Exception {
        long sum = 0;
        long num = 0;
        getFiles.clear();
        Encoder encoder = new Encoder();

        Set<File> files = getFiles(path);
        System.out.println("Start...");
        
        for (File file : files) {
        	if(file.getName().endsWith("mp4")
        			||file.getName().endsWith("flv")
        			||file.getName().endsWith("csf")
        			||file.getName().endsWith("mkv")
        			||file.getName().endsWith("mov")
        			||file.getName().endsWith("avi")
        			||file.getName().endsWith("wmv")){
                long ls;
				try {
					MultimediaInfo m = encoder.getInfo(file);
					ls = m.getDuration() / 1000;
					sum += ls;
					num++;
					System.out.println(file+":  \t"+ls+"(seconds)");
				} catch (Exception e) {
					e.printStackTrace();
				}
        	}
        }
        
     
        double sum1 = (double) sum;
        double sum2 = sum1 / 3600;// 转换成为了小时
        DecimalFormat df = new DecimalFormat("#.0");
        System.out.println("共计:"+num+"个视频,"+(int)sum+"(seconds)/"+df.format(sum2)+"hours");
        return "共计:"+num+"个视频,"+(int)sum+"(seconds)/"+df.format(sum2)+"hours";
    }

	public Set<File> getFiles(String path) throws Exception {
		
        File file = new File(path);
        if(file.isDirectory()){
        	File []files = file.listFiles();
        	for(File fileIndex:files){
        		if(fileIndex.isDirectory()){
        			getFiles(fileIndex.getPath().toString());
        		}
        		getFiles.add(fileIndex);
        	}
        }
        return getFiles;
		}
	
}
