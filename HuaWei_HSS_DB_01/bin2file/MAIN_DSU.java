package bin2file;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.lang.String;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.apache.tools.ant.types.EnumeratedAttribute;

import huawei.*;

public class MAIN_DSU {


	public static void main(String[] args) throws Exception {
		Frame fe=new dlg("www.dbhlr.com");
		fe.setBackground(Color.GRAY);
		
		String dir,filename;
		FileDialog fd1=new FileDialog(fe,"OpenFile",FileDialog.LOAD);
		fd1.show();
		File f1=new File(fd1.getFile());
		dir=fd1.getDirectory();
		filename=fd1.getFile();
		dir=dir.replace('\\', '/');
		fe.disable();

		init();//truncate database - execute TRUNCATE-HUAWEI.sql 
		
//		dir="E:/SQL/华为HLR数据库原始文件/HSS DB/DSU/";
//		String []f2={"0_81_141.fdb","0_81_142.fdb","0_81_143.fdb","0_81_144.fdb","0_81_145.fdb",
//				"0_81_146.fdb","0_81_147.fdb","0_81_148.fdb","0_81_149.fdb","0_82_27.fdb"};
		
//		for(int i=0;i<10;i++){

//		_0x06681000.action(dir, f2[9]);
//		_0x539cf000.action(dir, f2[9]);
//		_0x00010000.action(dir, f2[9]);
//		_0x00002000.analyse(dir, f2[9]);
//		_0x00002000.action(dir, f2[9]);
//		_0x00031000.action(dir, f2[9]);
//		proc.action01(dir,f2[9]);
		HW_Process.action01(dir,filename);
		HW_Process.action02(dir,filename);
		HW_Process.action03(dir,filename);
		HW_Process.action04(dir,filename);
		HW_Process.action05(dir,filename);
//		}
		
		System.exit(0);

	}

	public static void init()throws Exception {
		
		try 
     {
    	 long begin_time, end_time;
    	 begin_time=System.currentTimeMillis();
    	 
    	 	SQLExec sqlExec = new SQLExec();   
	    	//设置数据库参数   
	    	sqlExec.setDriver("oracle.jdbc.driver.OracleDriver");   
	    	sqlExec.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");  
	    	sqlExec.setUserid("system");   
	    	sqlExec.setPassword("siemens");   
	    	//要执行的脚本   
	    	sqlExec.setSrc(new File("E:/SQL/自制SQL/TRUNCATE-HUAWEI.sql"));  
	    	//有出错的语句该如何处理   
	    	sqlExec.setOnerror((SQLExec.OnError)(EnumeratedAttribute.getInstance(   
	    	SQLExec.OnError.class, "abort")));  
	    	sqlExec.setPrint(true); //设置是否输出  
	    	//输出到文件 sql.out 中；不设置该属性，默认输出到控制台   
	    	sqlExec.setOutput(new File("E:/SQL/sql.out"));   
	    	sqlExec.setProject(new Project()); // 要指定这个属性，不然会出错   
	    	sqlExec.execute();   

    	 end_time=System.currentTimeMillis();
         System.out.println("01 During:   "+(end_time-begin_time));
         
     } catch(Exception e){ 
    	 e.printStackTrace();
     } finally{  
    		 // add this section}
    	 }
     
     
	
    }


}
