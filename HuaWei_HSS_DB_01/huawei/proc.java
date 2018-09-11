package huawei;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.apache.tools.ant.types.EnumeratedAttribute;

import bin2file.StringUtil;


public class proc {
//	定义全局变量
public static long[] Addr_Table;
public static int Addr_Table_Capacity;
public static long[] a0 = new long[100];
public static long[] a1 = new long[100];
public static long[] a2 = new long[100];
public static long[] a3 = new long[100];
public static long[] a4 = new long[100];
public static long[] a5 = new long[100];
public static int[] a6 =new int[100];
public static int[] a7 =new int[100];
public static int[] a8 =new int[100];
public static int[] a9 =new int[100];
public static long[] b3 = new long[100];
public static long[] b4 = new long[100];
public static long[] b5 = new long[100];

public static FileInputStream fis;
public static DataInputStream dis;
public static BufferedInputStream bis;

public static FileOutputStream fos;
public static DataOutputStream dos;
public static PrintWriter pw;

	public static void action01(String dir, String filename) throws Exception {
//		获取文件名
		fis = new FileInputStream(dir + filename);
		dis = new DataInputStream(fis);
		bis = new BufferedInputStream(dis);
		
    	byte[] bb = new byte[0x20];
		String str_filename;
		StringBuffer sb=new StringBuffer("");
		dis.read(bb);
		for (int i=0;i<0x20;i++){
			if ((bb[i]&0xff)==0) break;
			sb.append((char)bb[i]);		
		}
		str_filename=sb.toString();
		if(str_filename.equals("")) System.out.println("Wrong Files!!!");
		System.out.println(str_filename);
//验证Address(0x22c)内容是否是0x539cf000？
		bis.close();
		dis.close();
		fis.close();
		fis = new FileInputStream(dir + filename);
		dis = new DataInputStream(fis);
		bis = new BufferedInputStream(dis);
		bis.skip(0x224);
		bb=new byte[4];
		bis.read(bb);
		Addr_Table_Capacity=(bb[0]&0xff)+(bb[1]&0xff)*0x100+(bb[2]&0xff)*0x10000+(bb[3]&0xff)*0x1000000;
		Addr_Table=new long[Addr_Table_Capacity];
		System.out.println(Addr_Table_Capacity);
		bis.skip(4);
		bis.read(bb);
		if((bb[3]&0xff)==0x53 && (bb[2]&0xff)==0x9c &&(bb[1]&0xff)==0xf0 &&(bb[0]&0xff)==0x00){
			System.out.println("OK.");
			
		}else
			System.out.println("Not ok.");
//读取映射表，存储到[]Addr_Table
		bis.close();
		dis.close();
		fis.close();
		fis = new FileInputStream(dir + filename);
		dis = new DataInputStream(fis);
		bis = new BufferedInputStream(dis);
		fos = new FileOutputStream(dir +str_filename+"_Addr_Table.txt");
		dos = new DataOutputStream(fos);
		pw = new PrintWriter(dos);

		bis.skip(0x539cf000);
		bb=new byte[4];
		for(int i=0;i<Addr_Table_Capacity;i++){
			bis.read(bb);
			Addr_Table[i]=StringUtil.reversedVal(bb, 0);
			pw.write(Integer.toHexString(i)+", "+Long.toHexString(Addr_Table[i]));
			pw.write("\n");
		}
		pw.flush();
		pw.close();
		dos.close();
		fos.close();
		
//		读取0x2000
		bis.close();
		dis.close();
		fis.close();
		fis = new FileInputStream(dir + filename);
		dis = new DataInputStream(fis);
		bis = new BufferedInputStream(dis);
		bis.skip(0x2000);
		bb=new byte[56];
		for (int i=0;i<100;i++){
			bis.read(bb);
			a0[i]=StringUtil.reversedVal(bb, 0);
			a1[i]=StringUtil.reversedVal(bb, 4);
			a2[i]=StringUtil.reversedVal(bb, 8);
			a3[i]=StringUtil.reversedVal(bb, 12);
			a4[i]=StringUtil.reversedVal(bb, 16);
			a5[i]=StringUtil.reversedVal(bb, 20);
			a6[i]=(bb[24]&0xff)+(bb[25]&0xff)*0x100;
			a7[i]=(bb[28]&0xff)+(bb[29]&0xff)*0x100;
			a8[i]=(bb[32]&0xff)+(bb[33]&0xff)*0x100;
			a9[i]=(bb[36]&0xff)+(bb[37]&0xff)*0x100;
		}

		for (int i=0;i<100;i++){

//			a7[i]:length; a8[i]:cnt; a9[i]:Addr_Table_Index;
//			b3[i]:addr_begin, b4[i],b5[i]:addr_begin
			if(a3[i]==0) break;
			if(a3[i]==-1) continue;
			b3[i]=HWUtil.findBegin(dir, filename, a3[i]);

			if(a4[i]==-1||a4[i]==a3[i]) continue;
			b4[i]=HWUtil.findBegin(dir, filename, a4[i]);

			if(a5[i]==-1) continue;
			b5[i]=HWUtil.findBegin(dir, filename, a5[i]);
		}
		
//		提取有效数据的表名
		for(int i=0;i<100;i++){
	    	String Table_Name;
	        sb=new StringBuffer("");
			if(a9[i]==0||a3[i]==-1||b3[i]<0x7000000) continue;
			fis = new FileInputStream(dir + filename);
			dis = new DataInputStream(fis);
			bis = new BufferedInputStream(dis);
			bis.skip(Addr_Table[a9[i]]+8);
			bb=new byte[0x20];
			bis.read(bb);
			for(int j=0;j<0x20;j++){
				if((bb[j]&0xff)==0) break;
				sb.append((char)bb[j]);
			}
			Table_Name=sb.toString();
			System.out.println(Integer.toHexString(i)+": "+Long.toHexString(b3[i])+": "+Table_Name);

		}
//	          提取表结构
		for(int i=0;i<100;i++){
			if (a3[i]==-1||a3[i]==0||a9[i]>0)continue;
			fis = new FileInputStream(dir + filename);
			dis = new DataInputStream(fis);
			bis = new BufferedInputStream(dis);
			fos = new FileOutputStream(dir +str_filename+"_0x"+Long.toHexString(b3[i])+".txt");
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);
			bis.skip(b3[i]+8);
			bb=new byte[a7[i]];
			for (int j=0;j<a8[i];j++){
				bis.read(bb);
				if((bb[0]&0xff)==0) break;
				pw.write(StringUtil.toHex(bb)+"\n");
				pw.flush();

			}
			
			if (a4[i]==a3[i]||a4[i]==-1||a4[i]==0||a9[i]>0)continue;
			fis = new FileInputStream(dir + filename);
			dis = new DataInputStream(fis);
			bis = new BufferedInputStream(dis);
			bis.skip(b4[i]+8);
            for (int j=0;j<a8[i];j++){
				bis.read(bb);
				if((bb[0]&0xff)==0) break;
				pw.write(StringUtil.toHex(bb)+"\n");
				pw.flush();

			}
			
			if (a5[i]==a4[i]||a5[i]==-1||a5[i]==0||a9[i]>0)continue;
			fis = new FileInputStream(dir + filename);
			dis = new DataInputStream(fis);
			bis = new BufferedInputStream(dis);
			bis.skip(b5[i]+8);
			for (int j=0;j<a8[i];j++){
				bis.read(bb);
				if((bb[0]&0xff)==0) break;
				pw.write(StringUtil.toHex(bb)+"\n");
				pw.flush();

			}

			pw.flush();
			pw.close();
			dos.close();
			fos.close();
			bis.close();
			dis.close();
			fis.close();
		}	
//		提取链表地址
		long temp1;
		temp1=0x6681dc0;
		bb=new byte[4];
		for (int i=0;i<250;i++){
			fis = new FileInputStream(dir + filename);
			dis = new DataInputStream(fis);
			bis = new BufferedInputStream(dis);
    		bis.skip(temp1);
			bis.read(bb);
			System.out.println(i+":"+Long.toHexString(temp1));
			temp1=StringUtil.reversedVal(bb, 0);
			if (temp1==-1) break;
			bis.close();
			dis.close();
			fis.close();
		

		}
		bis.close();
		dis.close();
		fis.close();

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
