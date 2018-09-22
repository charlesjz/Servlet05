
package printVideoDuration;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class GetFileList {
	
	static Set<FileInfo> filesInfo = new HashSet<>(); 
	public static Set<FileInfo> getFiles(String path) throws Exception {

        File file = new File(path);
        if(file.isDirectory()){
        	File []files = file.listFiles();
        	for(File fileIndex:files){
        		if(fileIndex.isDirectory()){
        			getFiles(fileIndex.getPath().toString());
        		}else if(fileIndex.length()>10000000){
        			FileInfo fileInfo = new FileInfo();
        			fileInfo.setLongname(fileIndex.toString());
        			fileInfo.setFilename(fileIndex.getName());
        			fileInfo.setLength(fileIndex.length());
        			filesInfo.add(fileInfo);
        		}
        	}
        }
        return filesInfo;
		}
	
	public static void main(String[] args) throws Exception {
		GetFileList gfl = new GetFileList();
		Set<FileInfo> results = gfl.getFiles("F:/计算机学习");
		results.forEach(System.out::println);
		Optional<FileInfo> max = results.stream().collect(Collectors.maxBy((o1, o2)->Integer.compare((o1.getLongname()).length(),(o2.getLongname()).length())));
		System.out.println("max:"+max.get().getLongname().length());
		
		Optional<FileInfo> max2 = results.stream().collect(Collectors.maxBy((o1, o2)->Long.compare((o1.getLength()),(o2.getLength()))));
		System.out.println("max2:"+max2.get().getLength());
		
		Connection connection =null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
        String username = "root";
        String password = "";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            if(!connection.isClosed()){
            	System.out.println("Database connected.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
      
        PreparedStatement ps= connection.prepareStatement("insert into filesinfo (longname,filename,length) values(?,?,?)");
        int count=0;
        
        for(FileInfo o:results){
			ps.setString(1, o.getLongname());
			ps.setString(2, o.getFilename());
			ps.setLong(3, o.getLength());
			ps.addBatch();
            count++;
			if (count >= 1000) {
				count = 0;
				ps.executeBatch();
			}
        }
		ps.clearBatch();
        ps.close();
        connection.close();


	}
}
