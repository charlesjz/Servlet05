package huawei;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.apache.tools.ant.types.EnumeratedAttribute;

import dao.DBUtils;


import bin2file.StringUtil;

public class HW_Process {

	//	定义全局变量
	public static long[] Addr_Table;
	public static int Addr_Table_Capacity;
	public static long[] a0 = new long[200];
	public static long[] a1 = new long[200];
	public static long[] a2 = new long[200];
	public static long[] a3 = new long[200];
	public static long[] a4 = new long[200];
	public static long[] a5 = new long[200];
	public static int[] a6 =new int[200];
	public static int[] a7 =new int[200];
	public static int[] a8 =new int[200];
	public static int[] a9 =new int[200];
	public static long[] b3 = new long[200];
	public static long[] b4 = new long[200];
	public static long[] b5 = new long[200];

	public static FileInputStream fis;
	public static DataInputStream dis;
	public static BufferedInputStream bis;

	public static FileOutputStream fos;
	public static DataOutputStream dos;
	public static PrintWriter pw;

	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date d;


	public static void action01(String dir, String filename) throws Exception  {
		// Check filename
		fis = new FileInputStream(dir + filename);
		dis = new DataInputStream(fis);
		bis = new BufferedInputStream(dis);
		
    	byte[] bb = new byte[0x20];
		String str_filename;
		StringBuffer sb=new StringBuffer("");
		bis.read(bb);
		for (int i=0;i<0x20;i++){
			if ((bb[i]&0xff)==0) break;
			sb.append((char)bb[i]);		
		}
		str_filename=sb.toString();
		if(str_filename.equals("")) System.out.println("0 Wrong Files!!!");
		System.out.println(str_filename+"  OK.");
		
		sb=new StringBuffer("");
		bis.skip(0xff4);
		bb=new byte[0x50];
		bis.read(bb);
		for (int i=0;i<0x50;i++){
			if ((bb[i]&0xff)==0) break;
			sb.append((char)bb[i]);		
		}
		str_filename=sb.toString();
		if(str_filename.equals("")) System.out.println("0 Wrong Files!!!");
		System.out.println(str_filename+"  OK.");
		

		bis.close();
		dis.close();
		fis.close();
	}

	public static void action02(String dir, String filename) throws Exception {
		//Verify Address(0x22c)'s context is '0x539cf000'?
		//Get Addr_Table_Capacity
		fis = new FileInputStream(dir + filename);
		dis = new DataInputStream(fis);
		bis = new BufferedInputStream(dis);
		bis.skip(0x224);
		byte[] bb=new byte[4];
		bis.read(bb);
		Addr_Table_Capacity=(bb[0]&0xff)+(bb[1]&0xff)*0x100+(bb[2]&0xff)*0x10000+(bb[3]&0xff)*0x1000000;
//		System.out.println(Addr_Table_Capacity);
		Addr_Table=new long[Addr_Table_Capacity];
		bis.skip(4);
		bis.read(bb);
		if((bb[3]&0xff)==0x53 && (bb[2]&0xff)==0x9c &&(bb[1]&0xff)==0xf0 &&(bb[0]&0xff)==0x00){
			System.out.println("200 OK.");
			
		}else
			System.out.println("200 Not ok.");
		bis.close();
		dis.close();
		fis.close();
	}
	


	public static void action03(String dir, String filename) throws Exception {
		// Read 0x539cf000 then save into Addr_Table
		fis = new FileInputStream(dir + filename);
		dis = new DataInputStream(fis);
		bis = new BufferedInputStream(dis);
//		for test
//		fos = new FileOutputStream(dir +filename+"_0x539cf000.TXT");
//		dos = new DataOutputStream(fos);
//		pw = new PrintWriter(dos);
//      end of test
		bis.skip(0x539cf000);
		byte[] bb=new byte[4];
		for(int i=0;i<Addr_Table_Capacity;i++){
			bis.read(bb);
			Addr_Table[i]=StringUtil.reversedVal(bb, 0);
//			
//			pw.println(Addr_Table[i]);
//			
		}
		bis.close();
		dis.close();
		fis.close();
//		清空log文件
		fos = new FileOutputStream(dir + filename + "_W_AUC_DATA.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_COMMON_SER_DATA.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_CS_SER_DATA.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_CS_BSG_DATA.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_CS_BSG_CF_DATA.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_CS_BSG_CBCWCL_DATA.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_ISDN_DATA.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_IMSI_DATA.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_PS_SER_DATA.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_PS_OPTSER_DATA.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_SUB_DYN_CS_DATA.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_SUB_DYN_PS_DATA.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_SCMSG_DATA.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_SID_DATA.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_IMSIBASICDYNINFO.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_EPSSTAINFO.TXT", false);
		fos = new FileOutputStream(dir + filename + "_W_IMSIAPNDYNINFO.TXT", false);
		fos.close();

	}
	
	public static void action04(String dir, String filename) throws Exception {
		// Read 0x2000 then save into a_Table
		fis = new FileInputStream(dir + filename);
		dis = new DataInputStream(fis);
		bis = new BufferedInputStream(dis);
		
		fos = new FileOutputStream(dir +filename+"_a_Table.TXT");
		dos = new DataOutputStream(fos);
		pw = new PrintWriter(dos);

		bis.skip(0x2000);
		byte[] bb=new byte[56];
		for (int i=0;i<200;i++){
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
			a9[i]=(bb[36]&0xff)+(bb[37]&0xff)*0x100+(bb[38]&0xff)*0x10000;
			pw.write("0x"+Integer.toHexString(i)+", 0x"+Long.toHexString(a0[i])+", 0x"+Long.toHexString(a1[i])+", 0x"+Long.toHexString(a2[i])+", 0x"+Long.toHexString(a3[i])+", 0x"+Long.toHexString(a4[i])+", 0x"+Long.toHexString(a5[i])+", 0x"+Long.toHexString(a6[i])+", 0x"+Long.toHexString(a7[i])+", 0x"+Long.toHexString(a8[i])+", 0x"+Long.toHexString(a9[i])+"\n");
		}
		pw.flush();
		
		pw.close();
		dos.close();
		fos.close();

		for (int i=0;i<200;i++){

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
		bis.close();
		dis.close();
		fis.close();
	}

	public static void action05(String dir, String filename) throws Exception {
		// Table_Id check table_name, and save into Database
		String Table_Name;
		StringBuffer sb;
		for(int Table_Id=0;Table_Id<200;Table_Id++){
//			System.out.println("Table_Id:"+Table_Id);
			fis = new FileInputStream(dir + filename);
			dis = new DataInputStream(fis);
			bis = new BufferedInputStream(dis);
			if (a3[Table_Id]==-1||a9[Table_Id]==0) continue;
			bis.skip(Addr_Table[a9[Table_Id]]+8);
			byte[] bb=new byte[0x20];
			bis.read(bb);
			sb=new StringBuffer("");
			for (int i=0;i<0x20;i++){
				if((bb[i]&0xff)==0)break;
				sb.append((char)bb[i]);
			}
			Table_Name=sb.toString();
			
				if("---------------------".equals(Table_Name)) STAT_RESULT_DATA(dir, filename, Table_Id);
			
				else if("STAT_RESULT_DATA".equals(Table_Name)) STAT_RESULT_DATA(dir, filename, Table_Id);
			
				else if("W_AUC_DATA".equals(Table_Name))W_AUC_DATA(dir, filename, Table_Id); 
				
				else if("W_COMMON_SER_DATA".equals(Table_Name))W_COMMON_SER_DATA(dir, filename, Table_Id); 
				
				else if("W_CS_SER_DATA".equals(Table_Name))W_CS_SER_DATA(dir, filename, Table_Id); 

				else if("W_CS_BSG_DATA".equals(Table_Name))W_CS_BSG_DATA(dir, filename, Table_Id); 

				else if("W_CS_BSG_CF_DATA".equals(Table_Name))W_CS_BSG_CF_DATA(dir, filename, Table_Id); 

				else if("W_CS_BSG_CBCWCL_DATA".equals(Table_Name))W_CS_BSG_CBCWCL_DATA(dir, filename, Table_Id); 

				else if("W_ISDN_DATA".equals(Table_Name))W_ISDN_DATA(dir, filename, Table_Id); 

				else if("W_IMSI_DATA".equals(Table_Name))W_IMSI_DATA(dir, filename, Table_Id);           

				else if("W_PS_SER_DATA".equals(Table_Name))W_PS_SER_DATA(dir, filename, Table_Id); 

				else if("W_PS_OPTSER_DATA".equals(Table_Name))W_PS_OPTSER_DATA(dir, filename, Table_Id); 

				else if("W_SUB_DYN_CS_DATA".equals(Table_Name))W_SUB_DYN_CS_DATA(dir, filename, Table_Id); 

				else if("W_SUB_DYN_PS_DATA".equals(Table_Name))W_SUB_DYN_PS_DATA(dir, filename, Table_Id); 

				else if("W_SCMSG_DATA".equals(Table_Name))W_SCMSG_DATA(dir, filename, Table_Id); 

				else if("W_SID_DATA".equals(Table_Name))W_SID_DATA(dir, filename, Table_Id); 

				else if("W_LICENCE_CHECK_DATA".equals(Table_Name))W_LICENCE_CHECK_DATA(dir, filename, Table_Id); 

				else if("W_HLRSN_LICENSE_CHECK_DATA".equals(Table_Name))W_HLRSN_LICENSE_CHECK_DATA(dir, filename, Table_Id); 

				else if("W_IMSIBASICDYNINFO".equals(Table_Name))W_IMSIBASICDYNINFO(dir, filename, Table_Id); 
				
				else if("W_EPSSTAINFO".equals(Table_Name))W_EPSSTAINFO(dir, filename, Table_Id); 

				else if("DSMETATABLE".equals(Table_Name))DSMETATABLE(dir, filename, Table_Id); 

				else if("DSMETANODEVERIFY".equals(Table_Name))DSMETANODEVERIFY(dir, filename, Table_Id); 

				else if("W_IMSIAPNDYNINFO".equals(Table_Name))W_IMSIAPNDYNINFO(dir, filename, Table_Id); 

				else if("DSIDXCHECK".equals(Table_Name))DSIDXCHECK(dir, filename, Table_Id); 

				else if("DSIDXFIELDS".equals(Table_Name))DSIDXFIELDS(dir, filename, Table_Id); 

				else if("US_DATAVERSION".equals(Table_Name))US_DATAVERSION(dir, filename, Table_Id); 

				else if("DSMETAFIELD".equals(Table_Name))DSMETAFIELD(dir, filename, Table_Id); 

				else 
					System.out.println(Integer.toHexString(Table_Id)+":"+Table_Name+" is not supported.");

			bis.close();
			dis.close();
			fis.close();
		}
	}

	private static void DSMETATABLE(String dir, String filename, int Table_Id) {

		String TABLEID="",TABLENAME="",LOADTYPE="",SYNCTYPE="",REDOLOGTYPE="",RECORDNUM="";

		try {
			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into DSMETATABLE (TABLEID,TABLENAME,LOADTYPE,SYNCTYPE,REDOLOGTYPE,RECORDNUM) values(?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point+8);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
			
					bis.read(bb);
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
//					TABLEID,        SN: 0,     Length: 4,     Begin: 0
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					TABLEID=StringUtil.toHex(ary);
//					TABLENAME,        SN: 1,     Length: 12,     Begin: 4
					ary=new byte[12];
					System.arraycopy(bb, 4, ary, 0, 12);
					TABLENAME=StringUtil.toHex(ary);
//					LOADTYPE,        SN: 2,     Length: 2,     Begin: 16
					ary=new byte[2];
					System.arraycopy(bb, 16, ary, 0, 2);
					LOADTYPE=StringUtil.toHex(ary);
//					SYNCTYPE,        SN: 3,     Length: 2,     Begin: 18
					ary=new byte[2];
					System.arraycopy(bb, 18, ary, 0, 2);
					SYNCTYPE=StringUtil.toHex(ary);
//					REDOLOGTYPE,        SN: 4,     Length: 2,     Begin: 20
					ary=new byte[2];
					System.arraycopy(bb, 20, ary, 0, 2);
					REDOLOGTYPE=StringUtil.toHex(ary);
//					RECORDNUM,        SN: 5,     Length: 4,     Begin: 22
					ary=new byte[4];
					System.arraycopy(bb, 22, ary, 0, 4);
					RECORDNUM=StringUtil.toHex(ary);

					stmt.setString(1, TABLEID);
					stmt.setString(2, TABLENAME);
					stmt.setString(3, LOADTYPE);
					stmt.setString(4, SYNCTYPE);
					stmt.setString(5, REDOLOGTYPE);
					stmt.setString(6, RECORDNUM);
					stmt.addBatch();
			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("DSMETATABLE During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}

	private static void DSMETANODEVERIFY(String dir, String filename, int Table_Id) {

		String CLUSTERID="",NODE_TYPE="";

		try {
			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into DSMETANODEVERIFY (CLUSTERID,NODE_TYPE) values(?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point+8);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
			
					bis.read(bb);
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
//					CLUSTERID,        SN: 0,     Length: 2,     Begin: 0
					ary=new byte[2];
					System.arraycopy(bb, 0, ary, 0, 2);
					CLUSTERID=StringUtil.toHex(ary);
//					NODE_TYPE,        SN: 1,     Length: 1,     Begin: 2
					ary=new byte[1];
					System.arraycopy(bb, 2, ary, 0, 1);
					NODE_TYPE=StringUtil.toHex(ary);

					stmt.setString(1, CLUSTERID);
					stmt.setString(2, NODE_TYPE);
					stmt.addBatch();
			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("DSMETANODEVERIFY During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}

	private static void DSMETAFIELD(String dir, String filename, int Table_Id) {

		String FIELDID="",TABLEID="",FIELDNAME="",FIELDTYPE="",FIELDSIZE="",INDEXTYPE="";

		try {
			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into DSMETAFIELD (FIELDID,TABLEID,FIELDNAME,FIELDTYPE,FIELDSIZE,INDEXTYPE) values(?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point+8);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
			
					bis.read(bb);
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
//					FIELDID,        SN: 0,     Length: 4,     Begin: 0
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					FIELDID=StringUtil.toHex(ary);
//					TABLEID,        SN: 1,     Length: 4,     Begin: 4
					ary=new byte[4];
					System.arraycopy(bb, 4, ary, 0, 4);
					TABLEID=StringUtil.toHex(ary);
//					FIELDNAME,        SN: 2,     Length: 12,     Begin: 8
					ary=new byte[12];
					System.arraycopy(bb, 8, ary, 0, 12);
					FIELDNAME=StringUtil.toHex(ary);
//					FIELDTYPE,        SN: 3,     Length: 2,     Begin: 20
					ary=new byte[2];
					System.arraycopy(bb, 20, ary, 0, 2);
					FIELDTYPE=StringUtil.toHex(ary);
//					FIELDSIZE,        SN: 4,     Length: 2,     Begin: 22
					ary=new byte[2];
					System.arraycopy(bb, 22, ary, 0, 2);
					FIELDSIZE=StringUtil.toHex(ary);
//					INDEXTYPE,        SN: 5,     Length: 2,     Begin: 24
					ary=new byte[4];
					System.arraycopy(bb, 24, ary, 0, 2);
					INDEXTYPE=StringUtil.toHex(ary);

					stmt.setString(1, FIELDID);
					stmt.setString(2, TABLEID);
					stmt.setString(3, FIELDNAME);
					stmt.setString(4, FIELDTYPE);
					stmt.setString(5, FIELDSIZE);
					stmt.setString(6, INDEXTYPE);
					stmt.addBatch();
			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("DSMETAFIELD During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}

	private static void STAT_RESULT_DATA(String dir, String filename, int Table_Id) {

		String STAT_NE_TYPE="",  STAT_OBJECT_ID="",  STAT_MUNIT_ID="",  STAT_ENTITY_ID="",  STAT_VALUE="",  SID="";

		try {
			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into STAT_RESULT_DATA (STAT_NE_TYPE,STAT_OBJECT_ID,STAT_MUNIT_ID,STAT_ENTITY_ID,STAT_VALUE,SID) values(?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point+8);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
			
					bis.read(bb);
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
//					STAT_NE_TYPE,        SN: 0,     Length: 1,     Begin: 0
					ary=new byte[1];
					System.arraycopy(bb, 0, ary, 0, 1);
					STAT_NE_TYPE=StringUtil.toHex(ary);
//					STAT_OBJECT_ID,        SN: 1,     Length: 1,     Begin: 1
					ary=new byte[1];
					System.arraycopy(bb, 1, ary, 0, 1);
					STAT_OBJECT_ID=StringUtil.toHex(ary);
//					STAT_MUNIT_ID,        SN: 2,     Length: 4,     Begin: 2
					ary=new byte[4];
					System.arraycopy(bb, 2, ary, 0, 4);
					STAT_MUNIT_ID=StringUtil.toHex(ary);
//					STAT_ENTITY_ID,        SN: 3,     Length: 4,     Begin: 6
					ary=new byte[4];
					System.arraycopy(bb, 6, ary, 0, 4);
					STAT_ENTITY_ID=StringUtil.toHex(ary);
//					STAT_VALUE,        SN: 4,     Length: 4,     Begin: 10
					ary=new byte[4];
					System.arraycopy(bb, 10, ary, 0, 4);
					STAT_VALUE=StringUtil.toHex(ary);
//					SID,        SN: 5,     Length: 8,     Begin: 14
					ary=new byte[8];
					System.arraycopy(bb, 14, ary, 0, 8);
					SID=StringUtil.toHex(ary);

					stmt.setString(1, STAT_NE_TYPE);
					stmt.setString(2, STAT_OBJECT_ID);
					stmt.setString(3, STAT_MUNIT_ID);
					stmt.setString(4, STAT_ENTITY_ID);
					stmt.setString(5, STAT_VALUE);
					stmt.setString(6, SID);
					stmt.addBatch();
			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("STAT_RESULT_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_AUC_DATA(String dir, String filename, int Table_Id) {
		
		String SID = "",IMSI = "",HLR_INDEX="",KI = "",K4_INDEX = "",ALGORITHM = "",CARD_TYPE = "",OPC = "",OP_INDEX = "",AMF_INDEX = "",SQN = "",NUM_AUC = "",TIME_STAMP = "",ENCRYPT_FLAG = "",K2_INDEX = "",TIME_STAMP_G1="",TIME_STAMP_G2="";
		
		try {
			
			fos = new FileOutputStream(dir + filename + "_W_AUC_DATA.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_AUC_DATA (SID,IMSI,HLR_INDEX,KI,K4_INDEX,ALGORITHM,CARD_TYPE,OPC,OP_INDEX,AMF_INDEX,SQN,NUM_AUC,TIME_STAMP,ENCRYPT_FLAG,K2_INDEX,TIME_STAMP_G1,TIME_STAMP_G2) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
//				System.out.println("0x"+Long.toHexString(Next_Point));
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
//				System.out.println("0x"+Long.toHexString(Start_Point));
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;
			
					bis.read(bb);
					
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					
//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					IMSI,        SN: 1,     Length: 8,     Begin: 8
					ary=new byte[8];
					System.arraycopy(bb, 16, ary, 0, 8);
					IMSI=StringUtil.toHex(ary);
					IMSI=IMSI.substring(0, IMSI.indexOf("f"));
//					HLR_INDEX,        SN: 2,     Length: 1,     Begin: 16
					ary=new byte[1];
					System.arraycopy(bb, 24, ary, 0, 1);
					HLR_INDEX=StringUtil.toHex(ary);
//					KI,        SN: 3,     Length: 16,     Begin: 17
					ary=new byte[16];
					System.arraycopy(bb, 25, ary, 0, 16);
					KI=StringUtil.toHex(ary);
//					K4_INDEX,        SN: 4,     Length: 2,     Begin: 33
					ary=new byte[2];
					System.arraycopy(bb, 41, ary, 0, 2);
					K4_INDEX=StringUtil.toHex(ary);
//					ALGORITHM,        SN: 5,     Length: 1,     Begin: 35
					ary=new byte[1];
					System.arraycopy(bb, 43, ary, 0, 1);
					ALGORITHM=StringUtil.toHex(ary);
//					CARD_TYPE,        SN: 6,     Length: 1,     Begin: 36
					ary=new byte[1];
					System.arraycopy(bb, 44, ary, 0, 1);
					CARD_TYPE=StringUtil.toHex(ary);
//					OPC,        SN: 7,     Length: 16,     Begin: 37
					ary=new byte[16];
					System.arraycopy(bb, 45, ary, 0, 16);
					OPC=StringUtil.toHex(ary);
//					OP_INDEX,        SN: 8,     Length: 4,     Begin: 53
					ary=new byte[4];
					System.arraycopy(bb, 61, ary, 0, 4);
					OP_INDEX=StringUtil.toHex(ary);
//					AMF_INDEX,        SN: 9,     Length: 2,     Begin: 57
					ary=new byte[2];
					System.arraycopy(bb, 65, ary, 0, 2);
					AMF_INDEX=StringUtil.toHex(ary);
//					SQN,        SN: 10,     Length: 6,     Begin: 59
					ary=new byte[6];
					System.arraycopy(bb, 67, ary, 0, 6);
					SQN=StringUtil.toHex(ary);
//					NUM_AUC,        SN: 11,     Length: 1,     Begin: 65
					ary=new byte[1];
					System.arraycopy(bb, 73, ary, 0, 1);
					NUM_AUC=StringUtil.toHex(ary);
//					TIME_STAMP,        SN: 12,     Length: 4,     Begin: 66
					ary=new byte[4];
					System.arraycopy(bb, 74, ary, 0, 4);
					TIME_STAMP=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					ENCRYPT_FLAG,        SN: 13,     Length: 1,     Begin: 70
					ary=new byte[1];
					System.arraycopy(bb, 78, ary, 0, 1);
					ENCRYPT_FLAG=StringUtil.toHex(ary);
//					K2_INDEX,        SN: 14,     Length: 1,     Begin: 71
					ary=new byte[1];
					System.arraycopy(bb, 79, ary, 0, 1);
					K2_INDEX=StringUtil.toHex(ary);
//					TIME_STAMP_G1,        SN: 15,     Length: 4,     Begin: 72
					ary=new byte[4];
					System.arraycopy(bb, 80, ary, 0, 4);
					TIME_STAMP_G1=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					TIME_STAMP_G2,        SN: 16,     Length: 4,     Begin: 76
					ary=new byte[4];
					System.arraycopy(bb, 84, ary, 0, 4);
					TIME_STAMP_G2=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
					
//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
		
					stmt.setString(1, SID);
					stmt.setString(2, IMSI);
					stmt.setString(3, HLR_INDEX);
					stmt.setString(4, KI);
					stmt.setString(5, K4_INDEX);
					stmt.setString(6, ALGORITHM);
					stmt.setString(7, CARD_TYPE);
					stmt.setString(8, OPC);
					stmt.setString(9, OP_INDEX);
					stmt.setString(10, AMF_INDEX);
					stmt.setString(11, SQN);
					stmt.setString(12, NUM_AUC);
					stmt.setString(13, TIME_STAMP);
					stmt.setString(14, ENCRYPT_FLAG);
					stmt.setString(15, K2_INDEX);
					stmt.setString(16, TIME_STAMP_G1);
					stmt.setString(17, TIME_STAMP_G2);
					stmt.addBatch();
					
			    }
			    stmt.executeBatch();
			
			bis.close();
			dis.close();
			fis.close();
			}
			
			pw.flush();

			pw.close();
			dos.close();
			fos.close();
			
			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_AUC_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_COMMON_SER_DATA(String dir, String filename, int Table_Id) {

		String SID="",PROFILE_ID="",HLR_INDEX="",IMSI="",MSISDN="",CATEGORY="",NAM="",PROVISION_TS="",SUB_AGE="",SMDP="",LCSTPL_ID="",
			ODBSS="",ODBINFO="",ODBENTER="",ODBIC="",ODBOC="",ODBPOS="",ODBPLMN4="",ODBPLMN3="",ODBPLMN2="",ODBPLMN1="",ODBROAM="",
			ODBMECT="",ODBDECT="",ODBECT="",ODBRCF="",ODBPOSTYPE="",SABLOCKOUT="",SABLOCKIN="",SGSNLOCK="",MSCLOCKOUT="",MSCLOCKIN="",
			ARDPROV="",GERANNOTALLOWED="",UTRANNOTALLOWED="",VLRTPL_ID="",RRR_TPL_ID="",SGSNTPL_ID="",OCSITPL_ID="",VTCSITPL_ID="",
			DCSITPL_ID="",SMSCSITPL_ID="",MTSMSCSITPL_ID="",TIFCSI="",UCSITPL_ID="",TCSITPL_ID="",MCSITPL_ID="",SSCSITPL_ID="",
			GPRSCSITPL_ID="",CHARGE_DETAILS="",GPRS="",TRACE="",RRR="",OKSCTPL_ID="",ATM_STATE="",RZONE="",SMSROUTETPL_ID="",
			UPLCSLCK="",UPLPSLCK="",GANNOTALLOWED="",IHSPAENOTALLOWED="",EUTRANNOTALLOWED="",N3GPPNOTALLOWED="",EPSLOCK="",
			NON3GPPLOCK="",STANDBY_IMSI="",EXPIRY_DATE="",DEFAULTOFA_ID="",STD_CHARGE="",LUCSI_TPL_ID="",M2MNOTIFY="",OPT_GPRSTPL_ID="",
			ICSIND="",ANCHOR="",IM_OCSITPL_ID="",IM_VTCSITPL_ID="",EPS="",SHORTNUMTPL_ID="",USERCATEGORY="",SUBTPL_ID="",OPTGPRS_TPL_ID="",
			ZCLOCK="";

		try {
			
			fos = new FileOutputStream(dir + filename + "_W_COMMON_SER_DATA.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_COMMON_SER_DATA (SID,PROFILE_ID,HLR_INDEX,IMSI,MSISDN,CATEGORY,NAM,PROVISION_TS,SUB_AGE,SMDP," +
					"LCSTPL_ID,ODBSS,ODBINFO,ODBENTER,ODBIC,ODBOC,ODBPOS,ODBPLMN4,ODBPLMN3,ODBPLMN2,ODBPLMN1,ODBROAM,ODBMECT,ODBDECT," +
					"ODBECT,ODBRCF,ODBPOSTYPE,SABLOCKOUT,SABLOCKIN,SGSNLOCK,MSCLOCKOUT,MSCLOCKIN,ARDPROV,GERANNOTALLOWED,UTRANNOTALLOWED," +
					"VLRTPL_ID,RRR_TPL_ID,SGSNTPL_ID,OCSITPL_ID,VTCSITPL_ID,DCSITPL_ID,SMSCSITPL_ID,MTSMSCSITPL_ID,TIFCSI,UCSITPL_ID," +
					"TCSITPL_ID,MCSITPL_ID,SSCSITPL_ID,GPRSCSITPL_ID,CHARGE_DETAILS,GPRS,TRACE,RRR,OKSCTPL_ID,ATM_STATE,RZONE,SMSROUTETPL_ID," +
					"UPLCSLCK,UPLPSLCK,GANNOTALLOWED,IHSPAENOTALLOWED,EUTRANNOTALLOWED,N3GPPNOTALLOWED,EPSLOCK,NON3GPPLOCK,STANDBY_IMSI," +
					"EXPIRY_DATE,DEFAULTOFA_ID,STD_CHARGE,LUCSI_TPL_ID,M2MNOTIFY,OPT_GPRSTPL_ID,ICSIND,ANCHOR,IM_OCSITPL_ID,IM_VTCSITPL_ID," +
					"EPS,SHORTNUMTPL_ID,USERCATEGORY,SUBTPL_ID,OPTGPRS_TPL_ID,ZCLOCK) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
					"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
//				System.out.println("0x"+Long.toHexString(Start_Point));
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;
					
					bis.read(bb);
					
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					PROFILE_ID,        SN: 1,     Length: 1,     Begin: 8
					ary=new byte[1];
					System.arraycopy(bb, 16, ary, 0, 1);
					PROFILE_ID=StringUtil.toHex(ary);
//					HLR_INDEX,        SN: 2,     Length: 1,     Begin: 9
					ary=new byte[1];
					System.arraycopy(bb, 17, ary, 0, 1);
					HLR_INDEX=StringUtil.toHex(ary);
//					IMSI,        SN: 3,     Length: 8,     Begin: 10
					ary=new byte[8];
					System.arraycopy(bb, 18, ary, 0, 8);
					IMSI=StringUtil.toHex(ary);
					IMSI=IMSI.substring(0, IMSI.indexOf("f"));
//					MSISDN,        SN: 4,     Length: 8,     Begin: 18
					ary=new byte[8];
					System.arraycopy(bb, 26, ary, 0, 8);
					MSISDN=StringUtil.toHex(ary);
					MSISDN=MSISDN.substring(0, MSISDN.indexOf("f"));
//					CATEGORY,        SN: 5,     Length: 1,     Begin: 26
					ary=new byte[1];
					System.arraycopy(bb, 34, ary, 0, 1);
					CATEGORY=StringUtil.toHex(ary);
//					NAM,        SN: 6,     Length: 1,     Begin: 27
					ary=new byte[1];
					System.arraycopy(bb, 35, ary, 0, 1);
					NAM=StringUtil.toHex(ary);
//					PROVISION_TS,        SN: 7,     Length: 4,     Begin: 28
					ary=new byte[4];
					System.arraycopy(bb, 36, ary, 0, 4);
					PROVISION_TS=StringUtil.toHex(ary);
//					SUB_AGE,        SN: 8,     Length: 3,     Begin: 32
					ary=new byte[3];
					System.arraycopy(bb, 40, ary, 0, 3);
					SUB_AGE=StringUtil.toHex(ary);
//					SMDP,        SN: 9,     Length: 1,     Begin: 35
					ary=new byte[1];
					System.arraycopy(bb, 43, ary, 0, 1);
					SMDP=StringUtil.toHex(ary);
//					LCSTPL_ID,        SN: 10,     Length: 2,     Begin: 36
					ary=new byte[2];
					System.arraycopy(bb, 44, ary, 0, 2);
					LCSTPL_ID=StringUtil.toHex(ary);
//					ODBSS,        SN: 11,     Length: 1,     Begin: 38
					ary=new byte[1];
					System.arraycopy(bb, 46, ary, 0, 1);
					ODBSS=StringUtil.toHex(ary);
//					ODBINFO,        SN: 12,     Length: 1,     Begin: 39
					ary=new byte[1];
					System.arraycopy(bb, 47, ary, 0, 1);
					ODBINFO=StringUtil.toHex(ary);
//					ODBENTER,        SN: 13,     Length: 1,     Begin: 40
					ary=new byte[1];
					System.arraycopy(bb, 48, ary, 0, 1);
					ODBENTER=StringUtil.toHex(ary);
//					ODBIC,        SN: 14,     Length: 1,     Begin: 41
					ary=new byte[1];
					System.arraycopy(bb, 49, ary, 0, 1);
					ODBIC=StringUtil.toHex(ary);
//					ODBOC,        SN: 15,     Length: 1,     Begin: 42
					ary=new byte[1];
					System.arraycopy(bb, 50, ary, 0, 1);
					ODBOC=StringUtil.toHex(ary);
//					ODBPOS,        SN: 16,     Length: 1,     Begin: 43
					ary=new byte[1];
					System.arraycopy(bb, 51, ary, 0, 1);
					ODBPOS=StringUtil.toHex(ary);
//					ODBPLMN4,        SN: 17,     Length: 1,     Begin: 44
					ary=new byte[1];
					System.arraycopy(bb, 52, ary, 0, 1);
					ODBPLMN4=StringUtil.toHex(ary);
//					ODBPLMN3,        SN: 18,     Length: 1,     Begin: 45
					ary=new byte[1];
					System.arraycopy(bb, 53, ary, 0, 1);
					ODBPLMN3=StringUtil.toHex(ary);
//					ODBPLMN2,        SN: 19,     Length: 1,     Begin: 46
					ary=new byte[1];
					System.arraycopy(bb, 54, ary, 0, 1);
					ODBPLMN2=StringUtil.toHex(ary);
//					ODBPLMN1,        SN: 20,     Length: 1,     Begin: 47
					ary=new byte[1];
					System.arraycopy(bb, 55, ary, 0, 1);
					ODBPLMN1=StringUtil.toHex(ary);
//					ODBROAM,        SN: 21,     Length: 1,     Begin: 48
					ary=new byte[1];
					System.arraycopy(bb, 56, ary, 0, 1);
					ODBROAM=StringUtil.toHex(ary);
//					ODBMECT,        SN: 22,     Length: 1,     Begin: 49
					ary=new byte[1];
					System.arraycopy(bb, 57, ary, 0, 1);
					ODBMECT=StringUtil.toHex(ary);
//					ODBDECT,        SN: 23,     Length: 1,     Begin: 50
					ary=new byte[1];
					System.arraycopy(bb, 58, ary, 0, 1);
					ODBDECT=StringUtil.toHex(ary);
//					ODBECT,        SN: 24,     Length: 1,     Begin: 51
					ary=new byte[1];
					System.arraycopy(bb, 59, ary, 0, 1);
					ODBECT=StringUtil.toHex(ary);
//					ODBRCF,        SN: 25,     Length: 1,     Begin: 52
					ary=new byte[1];
					System.arraycopy(bb, 60, ary, 0, 1);
					ODBRCF=StringUtil.toHex(ary);
//					ODBPOSTYPE,        SN: 26,     Length: 1,     Begin: 53
					ary=new byte[1];
					System.arraycopy(bb, 61, ary, 0, 1);
					ODBPOSTYPE=StringUtil.toHex(ary);
//					SABLOCKOUT,        SN: 27,     Length: 1,     Begin: 54
					ary=new byte[1];
					System.arraycopy(bb, 62, ary, 0, 1);
					SABLOCKOUT=StringUtil.toHex(ary);
//					SABLOCKIN,        SN: 28,     Length: 1,     Begin: 55
					ary=new byte[1];
					System.arraycopy(bb, 63, ary, 0, 1);
					SABLOCKIN=StringUtil.toHex(ary);
//					SGSNLOCK,        SN: 29,     Length: 1,     Begin: 56
					ary=new byte[1];
					System.arraycopy(bb, 64, ary, 0, 1);
					SGSNLOCK=StringUtil.toHex(ary);
//					MSCLOCKOUT,        SN: 30,     Length: 1,     Begin: 57
					ary=new byte[1];
					System.arraycopy(bb, 65, ary, 0, 1);
					MSCLOCKOUT=StringUtil.toHex(ary);
//					MSCLOCKIN,        SN: 31,     Length: 1,     Begin: 58
					ary=new byte[1];
					System.arraycopy(bb, 66, ary, 0, 1);
					MSCLOCKIN=StringUtil.toHex(ary);
//					ARDPROV,        SN: 32,     Length: 1,     Begin: 59
					ary=new byte[1];
					System.arraycopy(bb, 67, ary, 0, 1);
					ARDPROV=StringUtil.toHex(ary);
//					GERANNOTALLOWED,        SN: 33,     Length: 1,     Begin: 60
					ary=new byte[1];
					System.arraycopy(bb, 68, ary, 0, 1);
					GERANNOTALLOWED=StringUtil.toHex(ary);
//					UTRANNOTALLOWED,        SN: 34,     Length: 1,     Begin: 61
					ary=new byte[1];
					System.arraycopy(bb, 69, ary, 0, 1);
					UTRANNOTALLOWED=StringUtil.toHex(ary);
//					VLRTPL_ID,        SN: 35,     Length: 2,     Begin: 62
					ary=new byte[2];
					System.arraycopy(bb, 70, ary, 0, 2);
					VLRTPL_ID=StringUtil.toHex(ary);
//					RRR_TPL_ID,        SN: 36,     Length: 2,     Begin: 64
					ary=new byte[2];
					System.arraycopy(bb, 72, ary, 0, 2);
					RRR_TPL_ID=StringUtil.toHex(ary);
//					SGSNTPL_ID,        SN: 37,     Length: 2,     Begin: 66
					ary=new byte[2];
					System.arraycopy(bb, 74, ary, 0, 2);
					SGSNTPL_ID=StringUtil.toHex(ary);
//					OCSITPL_ID,        SN: 38,     Length: 2,     Begin: 68
					ary=new byte[2];
					System.arraycopy(bb, 76, ary, 0, 2);
					OCSITPL_ID=StringUtil.toHex(ary);
//					VTCSITPL_ID,        SN: 39,     Length: 2,     Begin: 70
					ary=new byte[2];
					System.arraycopy(bb, 78, ary, 0, 2);
					VTCSITPL_ID=StringUtil.toHex(ary);
//					DCSITPL_ID,        SN: 40,     Length: 2,     Begin: 72
					ary=new byte[2];
					System.arraycopy(bb, 80, ary, 0, 2);
					DCSITPL_ID=StringUtil.toHex(ary);
//					SMSCSITPL_ID,        SN: 41,     Length: 2,     Begin: 74
					ary=new byte[2];
					System.arraycopy(bb, 82, ary, 0, 2);
					SMSCSITPL_ID=StringUtil.toHex(ary);
//					MTSMSCSITPL_ID,        SN: 42,     Length: 2,     Begin: 76
					ary=new byte[2];
					System.arraycopy(bb, 84, ary, 0, 2);
					MTSMSCSITPL_ID=StringUtil.toHex(ary);
//					TIFCSI,        SN: 43,     Length: 1,     Begin: 78
					ary=new byte[1];
					System.arraycopy(bb, 86, ary, 0, 1);
					TIFCSI=StringUtil.toHex(ary);
//					UCSITPL_ID,        SN: 44,     Length: 2,     Begin: 79
					ary=new byte[2];
					System.arraycopy(bb, 87, ary, 0, 2);
					UCSITPL_ID=StringUtil.toHex(ary);
//					TCSITPL_ID,        SN: 45,     Length: 2,     Begin: 81
					ary=new byte[2];
					System.arraycopy(bb, 89, ary, 0, 2);
					TCSITPL_ID=StringUtil.toHex(ary);
//					MCSITPL_ID,        SN: 46,     Length: 2,     Begin: 83
					ary=new byte[2];
					System.arraycopy(bb, 91, ary, 0, 2);
					MCSITPL_ID=StringUtil.toHex(ary);
//					SSCSITPL_ID,        SN: 47,     Length: 2,     Begin: 85
					ary=new byte[2];
					System.arraycopy(bb, 93, ary, 0, 2);
					SSCSITPL_ID=StringUtil.toHex(ary);
//					GPRSCSITPL_ID,        SN: 48,     Length: 2,     Begin: 87
					ary=new byte[2];
					System.arraycopy(bb, 95, ary, 0, 2);
					GPRSCSITPL_ID=StringUtil.toHex(ary);
//					CHARGE_DETAILS,        SN: 49,     Length: 1,     Begin: 89
					ary=new byte[1];
					System.arraycopy(bb, 97, ary, 0, 1);
					CHARGE_DETAILS=StringUtil.toHex(ary);
//					GPRS,        SN: 50,     Length: 1,     Begin: 90
					ary=new byte[1];
					System.arraycopy(bb, 98, ary, 0, 1);
					GPRS=StringUtil.toHex(ary);
//					TRACE,        SN: 51,     Length: 1,     Begin: 91
					ary=new byte[1];
					System.arraycopy(bb, 99, ary, 0, 1);
					TRACE=StringUtil.toHex(ary);
//					RRR,        SN: 52,     Length: 1,     Begin: 92
					ary=new byte[1];
					System.arraycopy(bb, 100, ary, 0, 1);
					RRR=StringUtil.toHex(ary);
//					OKSCTPL_ID,        SN: 53,     Length: 2,     Begin: 93
					ary=new byte[2];
					System.arraycopy(bb, 101, ary, 0, 2);
					OKSCTPL_ID=StringUtil.toHex(ary);
//					ATM_STATE,        SN: 54,     Length: 8,     Begin: 95
					ary=new byte[8];
					System.arraycopy(bb, 103, ary, 0, 8);
					ATM_STATE=StringUtil.toHex(ary);
//					RZONE,        SN: 55,     Length: 1,     Begin: 103
					ary=new byte[1];
					System.arraycopy(bb, 111, ary, 0, 1);
					RZONE=StringUtil.toHex(ary);
//					SMSROUTETPL_ID,        SN: 56,     Length: 2,     Begin: 104
					ary=new byte[2];
					System.arraycopy(bb, 112, ary, 0, 2);
					SMSROUTETPL_ID=StringUtil.toHex(ary);
//					UPLCSLCK,        SN: 57,     Length: 1,     Begin: 106
					ary=new byte[1];
					System.arraycopy(bb, 114, ary, 0, 1);
					UPLCSLCK=StringUtil.toHex(ary);
//					UPLPSLCK,        SN: 58,     Length: 1,     Begin: 107
					ary=new byte[1];
					System.arraycopy(bb, 115, ary, 0, 1);
					UPLPSLCK=StringUtil.toHex(ary);
//					GANNOTALLOWED,        SN: 59,     Length: 1,     Begin: 108
					ary=new byte[1];
					System.arraycopy(bb, 116, ary, 0, 1);
					GANNOTALLOWED=StringUtil.toHex(ary);
//					IHSPAENOTALLOWED,        SN: 60,     Length: 1,     Begin: 109
					ary=new byte[1];
					System.arraycopy(bb, 117, ary, 0, 1);
					IHSPAENOTALLOWED=StringUtil.toHex(ary);
//					EUTRANNOTALLOWED,        SN: 61,     Length: 1,     Begin: 110
					ary=new byte[1];
					System.arraycopy(bb, 118, ary, 0, 1);
					EUTRANNOTALLOWED=StringUtil.toHex(ary);
//					N3GPPNOTALLOWED,        SN: 62,     Length: 1,     Begin: 111
					ary=new byte[1];
					System.arraycopy(bb, 119, ary, 0, 1);
					N3GPPNOTALLOWED=StringUtil.toHex(ary);
//					EPSLOCK,        SN: 63,     Length: 1,     Begin: 112
					ary=new byte[1];
					System.arraycopy(bb, 120, ary, 0, 1);
					EPSLOCK=StringUtil.toHex(ary);
//					NON3GPPLOCK,        SN: 64,     Length: 1,     Begin: 113
					ary=new byte[1];
					System.arraycopy(bb, 121, ary, 0, 1);
					NON3GPPLOCK=StringUtil.toHex(ary);
//					STANDBY_IMSI,        SN: 65,     Length: 8,     Begin: 114
					ary=new byte[8];
					System.arraycopy(bb, 122, ary, 0, 8);
					STANDBY_IMSI=StringUtil.toHex(ary);
//					EXPIRY_DATE,        SN: 66,     Length: 4,     Begin: 122
					ary=new byte[4];
					System.arraycopy(bb, 130, ary, 0, 4);
					STANDBY_IMSI=StringUtil.toHex(ary);
//					DEFAULTOFA_ID,        SN: 67,     Length: 2,     Begin: 126
					ary=new byte[2];
					System.arraycopy(bb, 134, ary, 0, 2);
					DEFAULTOFA_ID=StringUtil.toHex(ary);
//					STD_CHARGE,        SN: 68,     Length: 12,     Begin: 128
					ary=new byte[12];
					System.arraycopy(bb, 136, ary, 0, 12);
					STD_CHARGE=StringUtil.toHex(ary);
//					LUCSI_TPL_ID,        SN: 69,     Length: 2,     Begin: 140
					ary=new byte[2];
					System.arraycopy(bb, 148, ary, 0, 2);
					LUCSI_TPL_ID=StringUtil.toHex(ary);
//					M2MNOTIFY,        SN: 70,     Length: 1,     Begin: 142
					ary=new byte[1];
					System.arraycopy(bb, 150, ary, 0, 1);
					M2MNOTIFY=StringUtil.toHex(ary);
//					OPT_GPRSTPL_ID,        SN: 71,     Length: 2,     Begin: 143
					ary=new byte[2];
					System.arraycopy(bb, 151, ary, 0, 2);
					OPT_GPRSTPL_ID=StringUtil.toHex(ary);
//					ICSIND,        SN: 72,     Length: 1,     Begin: 145
					ary=new byte[1];
					System.arraycopy(bb, 153, ary, 0, 1);
					ICSIND=StringUtil.toHex(ary);
//					ANCHOR,        SN: 73,     Length: 1,     Begin: 146
					ary=new byte[1];
					System.arraycopy(bb, 154, ary, 0, 1);
					ANCHOR=StringUtil.toHex(ary);
//					IM_OCSITPL_ID,        SN: 74,     Length: 2,     Begin: 147
					ary=new byte[2];
					System.arraycopy(bb, 155, ary, 0, 2);
					IM_OCSITPL_ID=StringUtil.toHex(ary);
//					IM_VTCSITPL_ID,        SN: 75,     Length: 2,     Begin: 149
					ary=new byte[2];
					System.arraycopy(bb, 157, ary, 0, 2);
					IM_VTCSITPL_ID=StringUtil.toHex(ary);
//					EPS,        SN: 76,     Length: 1,     Begin: 151
					ary=new byte[1];
					System.arraycopy(bb, 159, ary, 0, 1);
					EPS=StringUtil.toHex(ary);
//					SHORTNUMTPL_ID,        SN: 77,     Length: 2,     Begin: 152
					ary=new byte[2];
					System.arraycopy(bb, 160, ary, 0, 2);
					SHORTNUMTPL_ID=StringUtil.toHex(ary);
//					USERCATEGORY,        SN: 78,     Length: 1,     Begin: 154
					ary=new byte[1];
					System.arraycopy(bb, 162, ary, 0, 1);
					USERCATEGORY=StringUtil.toHex(ary);
//					SUBTPL_ID,        SN: 79,     Length: 2,     Begin: 155
					ary=new byte[2];
					System.arraycopy(bb, 163, ary, 0, 2);
					SUBTPL_ID=StringUtil.toHex(ary);
//					OPTGPRS_TPL_ID,        SN: 80,     Length: 2,     Begin: 157
					ary=new byte[2];
					System.arraycopy(bb, 165, ary, 0, 2);
					OPTGPRS_TPL_ID=StringUtil.toHex(ary);
//					ZCLOCK,        SN: 81,     Length: 1,     Begin: 159
					ary=new byte[1];
					System.arraycopy(bb, 167, ary, 0, 1);
					ZCLOCK=StringUtil.toHex(ary);
					
					stmt.setString(1,SID);
					stmt.setString(2,PROFILE_ID);
					stmt.setString(3,HLR_INDEX);
					stmt.setString(4,IMSI);
					stmt.setString(5,MSISDN);
					stmt.setString(6,CATEGORY);
					stmt.setString(7,NAM);
					stmt.setString(8,PROVISION_TS);
					stmt.setString(9,SUB_AGE);
					stmt.setString(10,SMDP);
					stmt.setString(11,LCSTPL_ID);
					stmt.setString(12,ODBSS);
					stmt.setString(13,ODBINFO);
					stmt.setString(14,ODBENTER);
					stmt.setString(15,ODBIC);
					stmt.setString(16,ODBOC);
					stmt.setString(17,ODBPOS);
					stmt.setString(18,ODBPLMN4);
					stmt.setString(19,ODBPLMN3);
					stmt.setString(20,ODBPLMN2);
					stmt.setString(21,ODBPLMN1);
					stmt.setString(22,ODBROAM);
					stmt.setString(23,ODBMECT);
					stmt.setString(24,ODBDECT);
					stmt.setString(25,ODBECT);
					stmt.setString(26,ODBRCF);
					stmt.setString(27,ODBPOSTYPE);
					stmt.setString(28,SABLOCKOUT);
					stmt.setString(29,SABLOCKIN);
					stmt.setString(30,SGSNLOCK);
					stmt.setString(31,MSCLOCKOUT);
					stmt.setString(32,MSCLOCKIN);
					stmt.setString(33,ARDPROV);
					stmt.setString(34,GERANNOTALLOWED);
					stmt.setString(35,UTRANNOTALLOWED);
					stmt.setString(36,VLRTPL_ID);
					stmt.setString(37,RRR_TPL_ID);
					stmt.setString(38,SGSNTPL_ID);
					stmt.setString(39,OCSITPL_ID);
					stmt.setString(40,VTCSITPL_ID);
					stmt.setString(41,DCSITPL_ID);
					stmt.setString(42,SMSCSITPL_ID);
					stmt.setString(43,MTSMSCSITPL_ID);
					stmt.setString(44,TIFCSI);
					stmt.setString(45,UCSITPL_ID);
					stmt.setString(46,TCSITPL_ID);
					stmt.setString(47,MCSITPL_ID);
					stmt.setString(48,SSCSITPL_ID);
					stmt.setString(49,GPRSCSITPL_ID);
					stmt.setString(50,CHARGE_DETAILS);
					stmt.setString(51,GPRS);
					stmt.setString(52,TRACE);
					stmt.setString(53,RRR);
					stmt.setString(54,OKSCTPL_ID);
					stmt.setString(55,ATM_STATE);
					stmt.setString(56,RZONE);
					stmt.setString(57,SMSROUTETPL_ID);
					stmt.setString(58,UPLCSLCK);
					stmt.setString(59,UPLPSLCK);
					stmt.setString(60,GANNOTALLOWED);
					stmt.setString(61,IHSPAENOTALLOWED);
					stmt.setString(62,EUTRANNOTALLOWED);
					stmt.setString(63,N3GPPNOTALLOWED);
					stmt.setString(64,EPSLOCK);
					stmt.setString(65,NON3GPPLOCK);
					stmt.setString(66,STANDBY_IMSI);
					stmt.setString(67,EXPIRY_DATE);
					stmt.setString(68,DEFAULTOFA_ID);
					stmt.setString(69,STD_CHARGE);
					stmt.setString(70,LUCSI_TPL_ID);
					stmt.setString(71,M2MNOTIFY);
					stmt.setString(72,OPT_GPRSTPL_ID);
					stmt.setString(73,ICSIND);
					stmt.setString(74,ANCHOR);
					stmt.setString(75,IM_OCSITPL_ID);
					stmt.setString(76,IM_VTCSITPL_ID);
					stmt.setString(77,EPS);
					stmt.setString(78,SHORTNUMTPL_ID);
					stmt.setString(79,USERCATEGORY);
					stmt.setString(80,SUBTPL_ID);
					stmt.setString(81,OPTGPRS_TPL_ID);
					stmt.setString(82,ZCLOCK);
					stmt.addBatch();
					
//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			pw.flush();

			pw.close();
			dos.close();
			fos.close();
			
			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_COMMON_SER_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_CS_SER_DATA(String dir, String filename, int Table_Id) {

		String SID="",PROFILE_ID="",CS_PROFILE_ID="",HLR_INDEX="",IMSI="",MSISDN="",PROVISION_BS="",BS20="",BS30="",COLR="",COLP="",CLIR="",CLIP="",CFNRC="",CFNRY="",CFB="",CFU="",CFU_DETAILS="",CFB_DETAILS="",CFNRC_DETAILS="",CFNRY_DETAILS="",CFD_DETAILS="",CFU_OFATPL_ID="",CFB_OFATPL_ID="",CFNRC_OFATPL_ID="",CFNRY_OFATPL_ID="",CFD_OFATPL_ID="",SMS_OFATPL_ID="",SMS_FTN="",SMSCFSTATUS="",HOLD="",CW="",MULTIPTY="",BOIC="",BAOC="",BARRINGOFOUTGOINGCALLS="",EMLPP="",BICROAM="",BAIC="",BARRINGOFINCOMINGCALLS="",BOICEXHC="",MCI="",CD="",CNAP="",CCBS_B="",CCBS_A="",MAH="",ECT="",AOCC="",AOCI="",CUG="",MC="",UUS_3="",UUS_2="",UUS_1="",MC_NBR_SB="",MC_NBR_USER="",PROVISION_GROUP_SS="",PLMN_SS="",EMLPP_MAX_PRIORITY="",EMLPP_DEF_PRIORITY="",OTHER_SERVICE_STATUS="",CL_OPTIONS="",CB_DETAILS="",CB_PASSWORD="",CARP_STATUS="",CAPINITVGCSONROAMING="",CAPINITVBSONROAMING="",ACR="",ISTPROV="",IST_ALERT_TIMER="",IST_ALERT_RESPONSE="",NAEACICPROV="",NAEACIC="",MIMSI_SMS="",MIMSI_VOBB="",MIMSI_TYPE="",EOCSI_SK="",ETCSI_SK="",ACC="",ACC_LENGTH="",STYPE="",ROUTECATEGORY="",RBTPROV="",RBT_INDEX="",NRBTPROV="",NRBT_INDEX="",PRE_VOICENUMBER="",SEC_VOICENUMBER="",EXEXROUTECATEGORY="",PLMNSSPROV="",ERBT="",NIR_PROV="",NIR_INDEX="",ACR_STATUS="",EMLPP_COU="",ECPP="",STYPEOPTION="",FRAUDTPL_ID="",FORWARDINGSUPPRESSION="",BEOCSI="";

		try {
			fos = new FileOutputStream(dir + filename + "_W_CS_SER_DATA.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_CS_SER_DATA (SID,PROFILE_ID,CS_PROFILE_ID,HLR_INDEX,IMSI,MSISDN,PROVISION_BS,BS20,BS30,COLR,COLP,CLIR,CLIP,CFNRC,CFNRY,CFB,CFU,CFU_DETAILS,CFB_DETAILS,CFNRC_DETAILS,CFNRY_DETAILS,CFD_DETAILS,CFU_OFATPL_ID,CFB_OFATPL_ID,CFNRC_OFATPL_ID,CFNRY_OFATPL_ID,CFD_OFATPL_ID,SMS_OFATPL_ID,SMS_FTN,SMSCFSTATUS,HOLD,CW,MULTIPTY,BOIC,BAOC,BARRINGOFOUTGOINGCALLS,EMLPP,BICROAM,BAIC,BARRINGOFINCOMINGCALLS,BOICEXHC,MCI,CD,CNAP,CCBS_B,CCBS_A,MAH,ECT,AOCC,AOCI,CUG,MC,UUS_3,UUS_2,UUS_1,MC_NBR_SB,MC_NBR_USER,PROVISION_GROUP_SS,PLMN_SS,EMLPP_MAX_PRIORITY,EMLPP_DEF_PRIORITY,OTHER_SERVICE_STATUS,CL_OPTIONS,CB_DETAILS,CB_PASSWORD,CARP_STATUS,CAPINITVGCSONROAMING,CAPINITVBSONROAMING,ACR,ISTPROV,IST_ALERT_TIMER,IST_ALERT_RESPONSE,NAEACICPROV,NAEACIC,MIMSI_SMS,MIMSI_VOBB,MIMSI_TYPE,EOCSI_SK,ETCSI_SK,ACC,ACC_LENGTH,STYPE,ROUTECATEGORY,RBTPROV,RBT_INDEX,NRBTPROV,NRBT_INDEX,PRE_VOICENUMBER,SEC_VOICENUMBER,EXEXROUTECATEGORY,PLMNSSPROV,ERBT,NIR_PROV,NIR_INDEX,ACR_STATUS,EMLPP_COU,ECPP,STYPEOPTION,FRAUDTPL_ID,FORWARDINGSUPPRESSION,BEOCSI) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;
			
					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					
//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					PROFILE_ID,        SN: 1,     Length: 1,     Begin: 8
					ary=new byte[1];
					System.arraycopy(bb, 16, ary, 0, 1);
					PROFILE_ID=StringUtil.toHex(ary);
//					CS_PROFILE_ID,        SN: 2,     Length: 1,     Begin: 9
					ary=new byte[1];
					System.arraycopy(bb, 17, ary, 0, 1);
					CS_PROFILE_ID=StringUtil.toHex(ary);
//					HLR_INDEX,        SN: 3,     Length: 1,     Begin: 10
					ary=new byte[1];
					System.arraycopy(bb, 18, ary, 0, 1);
					HLR_INDEX=StringUtil.toHex(ary);
//					IMSI,        SN: 4,     Length: 8,     Begin: 11
					ary=new byte[8];
					System.arraycopy(bb, 19, ary, 0, 8);
					IMSI=StringUtil.toHex(ary);
					IMSI=IMSI.substring(0, IMSI.indexOf("f"));
//					MSISDN,        SN: 5,     Length: 8,     Begin: 19
					ary=new byte[8];
					System.arraycopy(bb, 27, ary, 0, 8);
					MSISDN=StringUtil.toHex(ary);
					MSISDN=MSISDN.substring(0, MSISDN.indexOf("f"));
//					PROVISION_BS,        SN: 6,     Length: 7,     Begin: 27
					ary=new byte[7];
					System.arraycopy(bb, 35, ary, 0, 7);
					PROVISION_BS=StringUtil.toHex(ary);
//					BS20,        SN: 7,     Length: 1,     Begin: 34
					ary=new byte[1];
					System.arraycopy(bb, 42, ary, 0, 1);
					BS20=StringUtil.toHex(ary);
//					BS30,        SN: 8,     Length: 1,     Begin: 35
					ary=new byte[1];
					System.arraycopy(bb, 43, ary, 0, 1);
					BS30=StringUtil.toHex(ary);
//					COLR,        SN: 9,     Length: 1,     Begin: 36
					ary=new byte[1];
					System.arraycopy(bb, 44, ary, 0, 1);
					COLR=StringUtil.toHex(ary);
//					COLP,        SN: 10,     Length: 1,     Begin: 37
					ary=new byte[1];
					System.arraycopy(bb, 45, ary, 0, 1);
					COLP=StringUtil.toHex(ary);
//					CLIR,        SN: 11,     Length: 1,     Begin: 38
					ary=new byte[1];
					System.arraycopy(bb, 46, ary, 0, 1);
					CLIR=StringUtil.toHex(ary);
//					CLIP,        SN: 12,     Length: 1,     Begin: 39
					ary=new byte[1];
					System.arraycopy(bb, 47, ary, 0, 1);
					CLIP=StringUtil.toHex(ary);
//					CFNRC,        SN: 13,     Length: 1,     Begin: 40
					ary=new byte[1];
					System.arraycopy(bb, 48, ary, 0, 1);
					CFNRC=StringUtil.toHex(ary);
//					CFNRY,        SN: 14,     Length: 1,     Begin: 41
					ary=new byte[1];
					System.arraycopy(bb, 49, ary, 0, 1);
					CFNRY=StringUtil.toHex(ary);
//					CFB,        SN: 15,     Length: 1,     Begin: 42
					ary=new byte[1];
					System.arraycopy(bb, 50, ary, 0, 1);
					CFB=StringUtil.toHex(ary);
//					CFU,        SN: 16,     Length: 1,     Begin: 43
					ary=new byte[1];
					System.arraycopy(bb, 51, ary, 0, 1);
					CFU=StringUtil.toHex(ary);
//					CFU_DETAILS,        SN: 17,     Length: 2,     Begin: 44
					ary=new byte[2];
					System.arraycopy(bb, 52, ary, 0, 2);
					CFU_DETAILS=StringUtil.toHex(ary);
//					CFB_DETAILS,        SN: 18,     Length: 2,     Begin: 46
					ary=new byte[2];
					System.arraycopy(bb, 54, ary, 0, 2);
					CFB_DETAILS=StringUtil.toHex(ary);
//					CFNRC_DETAILS,        SN: 19,     Length: 2,     Begin: 48
					ary=new byte[2];
					System.arraycopy(bb, 56, ary, 0, 2);
					CFNRC_DETAILS=StringUtil.toHex(ary);
//					CFNRY_DETAILS,        SN: 20,     Length: 2,     Begin: 50
					ary=new byte[2];
					System.arraycopy(bb, 58, ary, 0, 2);
					CFNRY_DETAILS=StringUtil.toHex(ary);
//					CFD_DETAILS,        SN: 21,     Length: 2,     Begin: 52
					ary=new byte[2];
					System.arraycopy(bb, 60, ary, 0, 2);
					CFD_DETAILS=StringUtil.toHex(ary);
//					CFU_OFATPL_ID,        SN: 22,     Length: 2,     Begin: 54
					ary=new byte[2];
					System.arraycopy(bb, 62, ary, 0, 2);
					CFU_OFATPL_ID=StringUtil.toHex(ary);
//					CFB_OFATPL_ID,        SN: 23,     Length: 2,     Begin: 56
					ary=new byte[2];
					System.arraycopy(bb, 64, ary, 0, 2);
					CFB_OFATPL_ID=StringUtil.toHex(ary);
//					CFNRC_OFATPL_ID,        SN: 24,     Length: 2,     Begin: 58
					ary=new byte[2];
					System.arraycopy(bb, 66, ary, 0, 2);
					CFNRC_OFATPL_ID=StringUtil.toHex(ary);
//					CFNRY_OFATPL_ID,        SN: 25,     Length: 2,     Begin: 60
					ary=new byte[2];
					System.arraycopy(bb, 68, ary, 0, 2);
					CFNRY_OFATPL_ID=StringUtil.toHex(ary);
//					CFD_OFATPL_ID,        SN: 26,     Length: 2,     Begin: 62
					ary=new byte[2];
					System.arraycopy(bb, 70, ary, 0, 2);
					CFD_OFATPL_ID=StringUtil.toHex(ary);
//					SMS_OFATPL_ID,        SN: 27,     Length: 2,     Begin: 64
					ary=new byte[2];
					System.arraycopy(bb, 72, ary, 0, 2);
					SMS_OFATPL_ID=StringUtil.toHex(ary);
//					SMS_FTN,        SN: 28,     Length: 15,     Begin: 66
					ary=new byte[15];
					System.arraycopy(bb, 74, ary, 0, 15);
					SMS_FTN=StringUtil.toHex(ary);
//					SMSCFSTATUS,        SN: 29,     Length: 2,     Begin: 81
					ary=new byte[2];
					System.arraycopy(bb, 89, ary, 0, 2);
					SMSCFSTATUS=StringUtil.toHex(ary);
//					HOLD,        SN: 30,     Length: 1,     Begin: 83
					ary=new byte[1];
					System.arraycopy(bb, 91, ary, 0, 1);
					HOLD=StringUtil.toHex(ary);
//					CW,        SN: 31,     Length: 1,     Begin: 84
					ary=new byte[1];
					System.arraycopy(bb, 92, ary, 0, 1);
					CW=StringUtil.toHex(ary);
//					MULTIPTY,        SN: 32,     Length: 1,     Begin: 85
					ary=new byte[1];
					System.arraycopy(bb, 93, ary, 0, 1);
					MULTIPTY=StringUtil.toHex(ary);
//					BOIC,        SN: 33,     Length: 1,     Begin: 86
					ary=new byte[1];
					System.arraycopy(bb, 94, ary, 0, 1);
					BOIC=StringUtil.toHex(ary);
//					BAOC,        SN: 34,     Length: 1,     Begin: 87
					ary=new byte[1];
					System.arraycopy(bb, 95, ary, 0, 1);
					BAOC=StringUtil.toHex(ary);
//					BARRINGOFOUTGOINGCALLS,        SN: 35,     Length: 1,     Begin: 88
					ary=new byte[1];
					System.arraycopy(bb, 96, ary, 0, 1);
					BARRINGOFOUTGOINGCALLS=StringUtil.toHex(ary);
//					EMLPP,        SN: 36,     Length: 1,     Begin: 89
					ary=new byte[1];
					System.arraycopy(bb, 97, ary, 0, 1);
					EMLPP=StringUtil.toHex(ary);
//					BICROAM,        SN: 37,     Length: 1,     Begin: 90
					ary=new byte[1];
					System.arraycopy(bb, 98, ary, 0, 1);
					BICROAM=StringUtil.toHex(ary);
//					BAIC,        SN: 38,     Length: 1,     Begin: 91
					ary=new byte[1];
					System.arraycopy(bb, 99, ary, 0, 1);
					BAIC=StringUtil.toHex(ary);
//					BARRINGOFINCOMINGCALLS,        SN: 39,     Length: 1,     Begin: 92
					ary=new byte[1];
					System.arraycopy(bb, 100, ary, 0, 1);
					BARRINGOFINCOMINGCALLS=StringUtil.toHex(ary);
//					BOICEXHC,        SN: 40,     Length: 1,     Begin: 93
					ary=new byte[1];
					System.arraycopy(bb, 101, ary, 0, 1);
					BOICEXHC=StringUtil.toHex(ary);
//					MCI,        SN: 41,     Length: 1,     Begin: 94
					ary=new byte[1];
					System.arraycopy(bb, 102, ary, 0, 1);
					MCI=StringUtil.toHex(ary);
//					CD,        SN: 42,     Length: 1,     Begin: 95
					ary=new byte[1];
					System.arraycopy(bb, 103, ary, 0, 1);
					CD=StringUtil.toHex(ary);
//					CNAP,        SN: 43,     Length: 1,     Begin: 96
					ary=new byte[1];
					System.arraycopy(bb, 104, ary, 0, 1);
					CNAP=StringUtil.toHex(ary);
//					CCBS_B,        SN: 44,     Length: 1,     Begin: 97
					ary=new byte[1];
					System.arraycopy(bb, 105, ary, 0, 1);
					CCBS_B=StringUtil.toHex(ary);
//					CCBS_A,        SN: 45,     Length: 1,     Begin: 98
					ary=new byte[1];
					System.arraycopy(bb, 106, ary, 0, 1);
					CCBS_A=StringUtil.toHex(ary);
//					MAH,        SN: 46,     Length: 1,     Begin: 99
					ary=new byte[1];
					System.arraycopy(bb, 107, ary, 0, 1);
					MAH=StringUtil.toHex(ary);
//					ECT,        SN: 47,     Length: 1,     Begin: 100
					ary=new byte[1];
					System.arraycopy(bb, 108, ary, 0, 1);
					ECT=StringUtil.toHex(ary);
//					AOCC,        SN: 48,     Length: 1,     Begin: 101
					ary=new byte[1];
					System.arraycopy(bb, 109, ary, 0, 1);
					AOCC=StringUtil.toHex(ary);
//					AOCI,        SN: 49,     Length: 1,     Begin: 102
					ary=new byte[1];
					System.arraycopy(bb, 110, ary, 0, 1);
					AOCI=StringUtil.toHex(ary);
//					CUG,        SN: 50,     Length: 1,     Begin: 103
					ary=new byte[1];
					System.arraycopy(bb, 111, ary, 0, 1);
					CUG=StringUtil.toHex(ary);
//					MC,        SN: 51,     Length: 1,     Begin: 104
					ary=new byte[1];
					System.arraycopy(bb, 112, ary, 0, 1);
					MC=StringUtil.toHex(ary);
//					UUS_3,        SN: 52,     Length: 1,     Begin: 105
					ary=new byte[1];
					System.arraycopy(bb, 113, ary, 0, 1);
					UUS_3=StringUtil.toHex(ary);
//					UUS_2,        SN: 53,     Length: 1,     Begin: 106
					ary=new byte[1];
					System.arraycopy(bb, 114, ary, 0, 1);
					UUS_2=StringUtil.toHex(ary);
//					UUS_1,        SN: 54,     Length: 1,     Begin: 107
					ary=new byte[1];
					System.arraycopy(bb, 115, ary, 0, 1);
					UUS_1=StringUtil.toHex(ary);
//					MC_NBR_SB,        SN: 55,     Length: 1,     Begin: 108
					ary=new byte[1];
					System.arraycopy(bb, 116, ary, 0, 1);
					MC_NBR_SB=StringUtil.toHex(ary);
//					MC_NBR_USER,        SN: 56,     Length: 1,     Begin: 109
					ary=new byte[1];
					System.arraycopy(bb, 117, ary, 0, 1);
					MC_NBR_USER=StringUtil.toHex(ary);
//					PROVISION_GROUP_SS,        SN: 57,     Length: 3,     Begin: 110
					ary=new byte[3];
					System.arraycopy(bb, 118, ary, 0, 3);
					PROVISION_GROUP_SS=StringUtil.toHex(ary);
//					PLMN_SS,        SN: 58,     Length: 2,     Begin: 113
					ary=new byte[2];
					System.arraycopy(bb, 121, ary, 0, 2);
					PLMN_SS=StringUtil.toHex(ary);
//					EMLPP_MAX_PRIORITY,        SN: 59,     Length: 1,     Begin: 115
					ary=new byte[1];
					System.arraycopy(bb, 123, ary, 0, 1);
					EMLPP_MAX_PRIORITY=StringUtil.toHex(ary);
//					EMLPP_DEF_PRIORITY,        SN: 60,     Length: 1,     Begin: 116
					ary=new byte[1];
					System.arraycopy(bb, 124, ary, 0, 1);
					EMLPP_DEF_PRIORITY=StringUtil.toHex(ary);
//					OTHER_SERVICE_STATUS,        SN: 61,     Length: 3,     Begin: 117
					ary=new byte[3];
					System.arraycopy(bb, 125, ary, 0, 3);
					OTHER_SERVICE_STATUS=StringUtil.toHex(ary);
//					CL_OPTIONS,        SN: 62,     Length: 1,     Begin: 120
					ary=new byte[1];
					System.arraycopy(bb, 128, ary, 0, 1);
					CL_OPTIONS=StringUtil.toHex(ary);
//					CB_DETAILS,        SN: 63,     Length: 1,     Begin: 121
					ary=new byte[1];
					System.arraycopy(bb, 129, ary, 0, 1);
					CB_DETAILS=StringUtil.toHex(ary);
//					CB_PASSWORD,        SN: 64,     Length: 4,     Begin: 122
					ary=new byte[4];
					System.arraycopy(bb, 130, ary, 0, 4);
					CB_PASSWORD=StringUtil.toHex(ary);
//					CARP_STATUS,        SN: 65,     Length: 1,     Begin: 126
					ary=new byte[1];
					System.arraycopy(bb, 134, ary, 0, 1);
					CARP_STATUS=StringUtil.toHex(ary);
//					CAPINITVGCSONROAMING,        SN: 66,     Length: 1,     Begin: 127
					ary=new byte[1];
					System.arraycopy(bb, 135, ary, 0, 1);
					CAPINITVGCSONROAMING=StringUtil.toHex(ary);
//					CAPINITVBSONROAMING,        SN: 67,     Length: 1,     Begin: 128
					ary=new byte[1];
					System.arraycopy(bb, 136, ary, 0, 1);
					CAPINITVBSONROAMING=StringUtil.toHex(ary);
//					ACR,        SN: 68,     Length: 2,     Begin: 129
					ary=new byte[2];
					System.arraycopy(bb, 137, ary, 0, 2);
					ACR=StringUtil.toHex(ary);
//					ISTPROV,        SN: 69,     Length: 1,     Begin: 131
					ary=new byte[1];
					System.arraycopy(bb, 139, ary, 0, 1);
					ISTPROV=StringUtil.toHex(ary);
//					IST_ALERT_TIMER,        SN: 70,     Length: 1,     Begin: 132
					ary=new byte[1];
					System.arraycopy(bb, 140, ary, 0, 1);
					IST_ALERT_TIMER=StringUtil.toHex(ary);
//					IST_ALERT_RESPONSE,        SN: 71,     Length: 1,     Begin: 133
					ary=new byte[1];
					System.arraycopy(bb, 141, ary, 0, 1);
					IST_ALERT_RESPONSE=StringUtil.toHex(ary);
//					NAEACICPROV,        SN: 72,     Length: 1,     Begin: 134
					ary=new byte[1];
					System.arraycopy(bb, 142, ary, 0, 1);
					NAEACICPROV=StringUtil.toHex(ary);
//					NAEACIC,        SN: 73,     Length: 2,     Begin: 135
					ary=new byte[2];
					System.arraycopy(bb, 143, ary, 0, 2);
					NAEACIC=StringUtil.toHex(ary);
//					MIMSI_SMS,        SN: 74,     Length: 1,     Begin: 137
					ary=new byte[1];
					System.arraycopy(bb, 145, ary, 0, 1);
					MIMSI_SMS=StringUtil.toHex(ary);
//					MIMSI_VOBB,        SN: 75,     Length: 1,     Begin: 138
					ary=new byte[1];
					System.arraycopy(bb, 146, ary, 0, 1);
					MIMSI_VOBB=StringUtil.toHex(ary);
//					MIMSI_TYPE,        SN: 76,     Length: 1,     Begin: 139
					ary=new byte[1];
					System.arraycopy(bb, 147, ary, 0, 1);
					MIMSI_TYPE=StringUtil.toHex(ary);
//					EOCSI_SK,        SN: 77,     Length: 2,     Begin: 140
					ary=new byte[2];
					System.arraycopy(bb, 148, ary, 0, 2);
					EOCSI_SK=StringUtil.toHex(ary);
//					ETCSI_SK,        SN: 78,     Length: 2,     Begin: 142
					ary=new byte[2];
					System.arraycopy(bb, 150, ary, 0, 2);
					ETCSI_SK=StringUtil.toHex(ary);
//					ACC,        SN: 79,     Length: 1,     Begin: 144
					ary=new byte[1];
					System.arraycopy(bb, 152, ary, 0, 1);
					ACC=StringUtil.toHex(ary);
//					ACC_LENGTH,        SN: 80,     Length: 1,     Begin: 145
					ary=new byte[1];
					System.arraycopy(bb, 153, ary, 0, 1);
					ACC_LENGTH=StringUtil.toHex(ary);
//					STYPE,        SN: 81,     Length: 1,     Begin: 146
					ary=new byte[1];
					System.arraycopy(bb, 154, ary, 0, 1);
					STYPE=StringUtil.toHex(ary);
//					ROUTECATEGORY,        SN: 82,     Length: 1,     Begin: 147
					ary=new byte[1];
					System.arraycopy(bb, 155, ary, 0, 1);
					ROUTECATEGORY=StringUtil.toHex(ary);
//					RBTPROV,        SN: 83,     Length: 1,     Begin: 148
					ary=new byte[1];
					System.arraycopy(bb, 156, ary, 0, 1);
					RBTPROV=StringUtil.toHex(ary);
//					RBT_INDEX,        SN: 84,     Length: 1,     Begin: 149
					ary=new byte[1];
					System.arraycopy(bb, 157, ary, 0, 1);
					RBT_INDEX=StringUtil.toHex(ary);
//					NRBTPROV,        SN: 85,     Length: 1,     Begin: 150
					ary=new byte[1];
					System.arraycopy(bb, 158, ary, 0, 1);
					NRBTPROV=StringUtil.toHex(ary);
//					NRBT_INDEX,        SN: 86,     Length: 2,     Begin: 151
					ary=new byte[2];
					System.arraycopy(bb, 159, ary, 0, 2);
					NRBT_INDEX=StringUtil.toHex(ary);
//					PRE_VOICENUMBER,        SN: 87,     Length: 8,     Begin: 153
					ary=new byte[8];
					System.arraycopy(bb, 161, ary, 0, 8);
					PRE_VOICENUMBER=StringUtil.toHex(ary);
//					SEC_VOICENUMBER,        SN: 88,     Length: 8,     Begin: 161
					ary=new byte[8];
					System.arraycopy(bb, 169, ary, 0, 8);
					SEC_VOICENUMBER=StringUtil.toHex(ary);
//					EXEXROUTECATEGORY,        SN: 89,     Length: 4,     Begin: 169
					ary=new byte[4];
					System.arraycopy(bb, 177, ary, 0, 4);
					EXEXROUTECATEGORY=StringUtil.toHex(ary);
//					PLMNSSPROV,        SN: 90,     Length: 1,     Begin: 173
					ary=new byte[1];
					System.arraycopy(bb, 181, ary, 0, 1);
					PLMNSSPROV=StringUtil.toHex(ary);
//					ERBT,        SN: 91,     Length: 1,     Begin: 174
					ary=new byte[1];
					System.arraycopy(bb, 182, ary, 0, 1);
					ERBT=StringUtil.toHex(ary);
//					NIR_PROV,        SN: 92,     Length: 1,     Begin: 175
					ary=new byte[1];
					System.arraycopy(bb, 183, ary, 0, 1);
					NIR_PROV=StringUtil.toHex(ary);
//					NIR_INDEX,        SN: 93,     Length: 2,     Begin: 176
					ary=new byte[2];
					System.arraycopy(bb, 184, ary, 0, 2);
					NIR_INDEX=StringUtil.toHex(ary);
//					ACR_STATUS,        SN: 94,     Length: 1,     Begin: 178
					ary=new byte[1];
					System.arraycopy(bb, 186, ary, 0, 1);
					ACR_STATUS=StringUtil.toHex(ary);
//					EMLPP_COU,        SN: 95,     Length: 1,     Begin: 179
					ary=new byte[1];
					System.arraycopy(bb, 187, ary, 0, 1);
					EMLPP_COU=StringUtil.toHex(ary);
//					ECPP,        SN: 96,     Length: 1,     Begin: 180
					ary=new byte[1];
					System.arraycopy(bb, 188, ary, 0, 1);
					ECPP=StringUtil.toHex(ary);
//					STYPEOPTION,        SN: 97,     Length: 1,     Begin: 181
					ary=new byte[1];
					System.arraycopy(bb, 189, ary, 0, 1);
					STYPEOPTION=StringUtil.toHex(ary);
//					FRAUDTPL_ID,        SN: 98,     Length: 2,     Begin: 182
					ary=new byte[2];
					System.arraycopy(bb, 190, ary, 0, 2);
					FRAUDTPL_ID=StringUtil.toHex(ary);
//					FORWARDINGSUPPRESSION,        SN: 99,     Length: 1,     Begin: 184
					ary=new byte[1];
					System.arraycopy(bb, 192, ary, 0, 1);
					FORWARDINGSUPPRESSION=StringUtil.toHex(ary);
//					BEOCSI,        SN: 100,     Length: 2,     Begin: 185
					ary=new byte[2];
					System.arraycopy(bb, 193, ary, 0, 2);
					BEOCSI=StringUtil.toHex(ary);

					stmt.setString(1, SID);
					stmt.setString(2, PROFILE_ID);
					stmt.setString(3, CS_PROFILE_ID);
					stmt.setString(4, HLR_INDEX);
					stmt.setString(5, IMSI);
					stmt.setString(6, MSISDN);
					stmt.setString(7, PROVISION_BS);
					stmt.setString(8, BS20);
					stmt.setString(9, BS30);
					stmt.setString(10, COLR);
					stmt.setString(11, COLP);
					stmt.setString(12, CLIR);
					stmt.setString(13, CLIP);
					stmt.setString(14, CFNRC);
					stmt.setString(15, CFNRY);
					stmt.setString(16, CFB);
					stmt.setString(17, CFU);
					stmt.setString(18, CFU_DETAILS);
					stmt.setString(19, CFB_DETAILS);
					stmt.setString(20, CFNRC_DETAILS);
					stmt.setString(21, CFNRY_DETAILS);
					stmt.setString(22, CFD_DETAILS);
					stmt.setString(23, CFU_OFATPL_ID);
					stmt.setString(24, CFB_OFATPL_ID);
					stmt.setString(25, CFNRC_OFATPL_ID);
					stmt.setString(26, CFNRY_OFATPL_ID);
					stmt.setString(27, CFD_OFATPL_ID);
					stmt.setString(28, SMS_OFATPL_ID);
					stmt.setString(29, SMS_FTN);
					stmt.setString(30, SMSCFSTATUS);
					stmt.setString(31, HOLD);
					stmt.setString(32, CW);
					stmt.setString(33, MULTIPTY);
					stmt.setString(34, BOIC);
					stmt.setString(35, BAOC);
					stmt.setString(36, BARRINGOFOUTGOINGCALLS);
					stmt.setString(37, EMLPP);
					stmt.setString(38, BICROAM);
					stmt.setString(39, BAIC);
					stmt.setString(40, BARRINGOFINCOMINGCALLS);
					stmt.setString(41, BOICEXHC);
					stmt.setString(42, MCI);
					stmt.setString(43, CD);
					stmt.setString(44, CNAP);
					stmt.setString(45, CCBS_B);
					stmt.setString(46, CCBS_A);
					stmt.setString(47, MAH);
					stmt.setString(48, ECT);
					stmt.setString(49, AOCC);
					stmt.setString(50, AOCI);
					stmt.setString(51, CUG);
					stmt.setString(52, MC);
					stmt.setString(53, UUS_3);
					stmt.setString(54, UUS_2);
					stmt.setString(55, UUS_1);
					stmt.setString(56, MC_NBR_SB);
					stmt.setString(57, MC_NBR_USER);
					stmt.setString(58, PROVISION_GROUP_SS);
					stmt.setString(59, PLMN_SS);
					stmt.setString(60, EMLPP_MAX_PRIORITY);
					stmt.setString(61, EMLPP_DEF_PRIORITY);
					stmt.setString(62, OTHER_SERVICE_STATUS);
					stmt.setString(63, CL_OPTIONS);
					stmt.setString(64, CB_DETAILS);
					stmt.setString(65, CB_PASSWORD);
					stmt.setString(66, CARP_STATUS);
					stmt.setString(67, CAPINITVGCSONROAMING);
					stmt.setString(68, CAPINITVBSONROAMING);
					stmt.setString(69, ACR);
					stmt.setString(70, ISTPROV);
					stmt.setString(71, IST_ALERT_TIMER);
					stmt.setString(72, IST_ALERT_RESPONSE);
					stmt.setString(73, NAEACICPROV);
					stmt.setString(74, NAEACIC);
					stmt.setString(75, MIMSI_SMS);
					stmt.setString(76, MIMSI_VOBB);
					stmt.setString(77, MIMSI_TYPE);
					stmt.setString(78, EOCSI_SK);
					stmt.setString(79, ETCSI_SK);
					stmt.setString(80, ACC);
					stmt.setString(81, ACC_LENGTH);
					stmt.setString(82, STYPE);
					stmt.setString(83, ROUTECATEGORY);
					stmt.setString(84, RBTPROV);
					stmt.setString(85, RBT_INDEX);
					stmt.setString(86, NRBTPROV);
					stmt.setString(87, NRBT_INDEX);
					stmt.setString(88, PRE_VOICENUMBER);
					stmt.setString(89, SEC_VOICENUMBER);
					stmt.setString(90, EXEXROUTECATEGORY);
					stmt.setString(91, PLMNSSPROV);
					stmt.setString(92, ERBT);
					stmt.setString(93, NIR_PROV);
					stmt.setString(94, NIR_INDEX);
					stmt.setString(95, ACR_STATUS);
					stmt.setString(96, EMLPP_COU);
					stmt.setString(97, ECPP);
					stmt.setString(98, STYPEOPTION);
					stmt.setString(99, FRAUDTPL_ID);
					stmt.setString(100, FORWARDINGSUPPRESSION);
					stmt.setString(101, BEOCSI);
					stmt.addBatch();
					
//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			pw.flush();

			pw.close();
			dos.close();
			fos.close();
			
			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_CS_SER_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_CS_BSG_DATA(String dir, String filename, int Table_Id) {

		String SID="",PROFILE_ID="",CS_PROFILE_ID="",BSG="";

		try {
			fos = new FileOutputStream(dir + filename + "_W_CS_BSG_DATA.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_CS_BSG_DATA (SID,PROFILE_ID,CS_PROFILE_ID,BSG) values(?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;
			
					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					PROFILE_ID,        SN: 1,     Length: 1,     Begin: 8
					ary=new byte[1];
					System.arraycopy(bb, 16, ary, 0, 1);
					PROFILE_ID=StringUtil.toHex(ary);
//					CS_PROFILE_ID,        SN: 2,     Length: 1,     Begin: 9
					ary=new byte[1];
					System.arraycopy(bb, 17, ary, 0, 1);
					CS_PROFILE_ID=StringUtil.toHex(ary);
//					BSG,        SN: 3,     Length: 1,     Begin: 10
					ary=new byte[1];
					System.arraycopy(bb, 18, ary, 0, 1);
					BSG=StringUtil.toHex(ary);

					stmt.setString(1, SID);
					stmt.setString(2, PROFILE_ID);
					stmt.setString(3, CS_PROFILE_ID);
					stmt.setString(4, BSG);
					stmt.addBatch();

//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			pw.flush();

			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_CS_BSG_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_CS_BSG_CF_DATA(String dir, String filename, int Table_Id) {

		String SID="",PROFILE_ID="",CS_PROFILE_ID="",BSG="",CF_SS_CODE="",CF_FTN="",CF_STATUS="",SHORTFTN="";

		try {
			fos = new FileOutputStream(dir + filename + "_W_CS_BSG_CF_DATA.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_CS_BSG_CF_DATA (SID,PROFILE_ID,CS_PROFILE_ID,BSG,CF_SS_CODE,CF_FTN,CF_STATUS,SHORTFTN) values(?,?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;
			
					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

					//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					PROFILE_ID,        SN: 1,     Length: 1,     Begin: 8
					ary=new byte[1];
					System.arraycopy(bb, 16, ary, 0, 1);
					PROFILE_ID=StringUtil.toHex(ary);
//					CS_PROFILE_ID,        SN: 2,     Length: 1,     Begin: 9
					ary=new byte[1];
					System.arraycopy(bb, 17, ary, 0, 1);
					CS_PROFILE_ID=StringUtil.toHex(ary);
//					BSG,        SN: 3,     Length: 1,     Begin: 10
					ary=new byte[1];
					System.arraycopy(bb, 18, ary, 0, 1);
					BSG=StringUtil.toHex(ary);
//					CF_SS_CODE,        SN: 4,     Length: 1,     Begin: 11
					ary=new byte[1];
					System.arraycopy(bb, 19, ary, 0, 1);
					CF_SS_CODE=StringUtil.toHex(ary);
//					CF_FTN,        SN: 5,     Length: 15,     Begin: 12
					ary=new byte[15];
					System.arraycopy(bb, 20, ary, 0, 15);
					CF_FTN=StringUtil.toHex(ary);
					CF_FTN=CF_FTN.substring(2, CF_FTN.indexOf("f"));
//					CF_STATUS,        SN: 6,     Length: 2,     Begin: 27
					ary=new byte[2];
					System.arraycopy(bb, 35, ary, 0, 2);
					CF_STATUS=StringUtil.toHex(ary);
//					SHORTFTN,        SN: 7,     Length: 1,     Begin: 29
					ary=new byte[1];
					System.arraycopy(bb, 37, ary, 0, 1);
					SHORTFTN=StringUtil.toHex(ary);

					stmt.setString(1, SID);
					stmt.setString(2, PROFILE_ID);
					stmt.setString(3, CS_PROFILE_ID);
					stmt.setString(4, BSG);
					stmt.setString(5, CF_SS_CODE);
					stmt.setString(6, CF_FTN);
					stmt.setString(7, CF_STATUS);
					stmt.setString(8, SHORTFTN);
					stmt.addBatch();
					
//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			pw.flush();

			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_CS_BSG_CF_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_CS_BSG_CBCWCL_DATA(String dir, String filename, int Table_Id) {

		String SID="",PROFILE_ID="",CS_PROFILE_ID="",BSG="",CBCWCL_SS_CODE="",CBCWCL_STATUS="";

		try {
			fos = new FileOutputStream(dir + filename + "_W_CS_BSG_CBCWCL_DATA.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_CS_BSG_CBCWCL_DATA (SID,PROFILE_ID,CS_PROFILE_ID,BSG,CBCWCL_SS_CODE,CBCWCL_STATUS) values(?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;
			
					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					PROFILE_ID,        SN: 1,     Length: 1,     Begin: 8
					ary=new byte[1];
					System.arraycopy(bb, 16, ary, 0, 1);
					PROFILE_ID=StringUtil.toHex(ary);
//					CS_PROFILE_ID,        SN: 2,     Length: 1,     Begin: 9
					ary=new byte[1];
					System.arraycopy(bb, 17, ary, 0, 1);
					CS_PROFILE_ID=StringUtil.toHex(ary);
//					BSG,        SN: 3,     Length: 1,     Begin: 10
					ary=new byte[1];
					System.arraycopy(bb, 18, ary, 0, 1);
					BSG=StringUtil.toHex(ary);
//					CBCWCL_SS_CODE,        SN: 4,     Length: 1,     Begin: 11
					ary=new byte[1];
					System.arraycopy(bb, 19, ary, 0, 1);
					CBCWCL_SS_CODE=StringUtil.toHex(ary);
//					CBCWCL_STATUS,        SN: 5,     Length: 1,     Begin: 12
					ary=new byte[1];
					System.arraycopy(bb, 20, ary, 0, 1);
					CBCWCL_STATUS=StringUtil.toHex(ary);

					stmt.setString(1, SID);
					stmt.setString(2, PROFILE_ID);
					stmt.setString(3, CS_PROFILE_ID);
					stmt.setString(4, BSG);
					stmt.setString(5, CBCWCL_SS_CODE);
					stmt.setString(6, CBCWCL_STATUS);
					stmt.addBatch();
					
//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			pw.flush();

			pw.close();
			dos.close();
			fos.close();
			
			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_CS_BSG_CBCWCL_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_ISDN_DATA(String dir, String filename, int Table_Id) {

		String SID="",MSISDN="",BC_IE="",INDICATOR="",DEF_CALL="",IMSI="",CURRENT_PSI_INDEX="";

		try {
			fos = new FileOutputStream(dir + filename + "_W_ISDN_DATA.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_ISDN_DATA (SID,MSISDN,BC_IE,INDICATOR,DEF_CALL,IMSI,CURRENT_PSI_INDEX) values(?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;

					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					MSISDN,        SN: 1,     Length: 8,     Begin: 8
					ary=new byte[8];
					System.arraycopy(bb, 16, ary, 0, 8);
					MSISDN=StringUtil.toHex(ary);
					MSISDN=MSISDN.substring(0, MSISDN.indexOf("f"));
//					BC_IE,        SN: 2,     Length: 17,     Begin: 16
					ary=new byte[17];
					System.arraycopy(bb, 24, ary, 0, 17);
					BC_IE=StringUtil.toHex(ary);
//					INDICATOR,        SN: 3,     Length: 1,     Begin: 33
					ary=new byte[1];
					System.arraycopy(bb, 41, ary, 0, 1);
					INDICATOR=StringUtil.toHex(ary);
//					DEF_CALL,        SN: 4,     Length: 1,     Begin: 34
					ary=new byte[1];
					System.arraycopy(bb, 42, ary, 0, 1);
					DEF_CALL=StringUtil.toHex(ary);
//					IMSI,        SN: 5,     Length: 8,     Begin: 35
					ary=new byte[8];
					System.arraycopy(bb, 43, ary, 0, 8);
					IMSI=StringUtil.toHex(ary);
					IMSI=IMSI.substring(0, IMSI.indexOf("f"));
//					CURRENT_PSI_INDEX,        SN: 6,     Length: 1,     Begin: 43
					ary=new byte[1];
					System.arraycopy(bb, 51, ary, 0, 1);
					CURRENT_PSI_INDEX=StringUtil.toHex(ary);

					stmt.setString(1, SID);
					stmt.setString(2, MSISDN);
					stmt.setString(3, BC_IE);
					stmt.setString(4, INDICATOR);
					stmt.setString(5, DEF_CALL);
					stmt.setString(6, IMSI);
					stmt.setString(7, CURRENT_PSI_INDEX);
					stmt.addBatch();
					
//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			pw.flush();

			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_ISDN_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_IMSI_DATA(String dir, String filename, int Table_Id) {

		String SID="",IMSI="",IMSI_INDEX="",CALL_INDEX="",MSISDN="";

		try {
			fos = new FileOutputStream(dir + filename + "_W_IMSI_DATA.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_IMSI_DATA (SID,IMSI,IMSI_INDEX,CALL_INDEX,MSISDN) values(?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;

					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					IMSI,        SN: 1,     Length: 8,     Begin: 8
					ary=new byte[8];
					System.arraycopy(bb, 16, ary, 0, 8);
					IMSI=StringUtil.toHex(ary);
					IMSI=IMSI.substring(0, IMSI.indexOf("f"));
//					IMSI_INDEX,        SN: 2,     Length: 1,     Begin: 16
					ary=new byte[1];
					System.arraycopy(bb, 24, ary, 0, 1);
					IMSI_INDEX=StringUtil.toHex(ary);
//					CALL_INDEX,        SN: 3,     Length: 1,     Begin: 17
					ary=new byte[1];
					System.arraycopy(bb, 25, ary, 0, 1);
					CALL_INDEX=StringUtil.toHex(ary);
//					MSISDN,        SN: 4,     Length: 8,     Begin: 18
					ary=new byte[8];
					System.arraycopy(bb, 26, ary, 0, 8);
					MSISDN=StringUtil.toHex(ary);
					MSISDN=MSISDN.substring(0, MSISDN.indexOf("f"));

					stmt.setString(1, SID);
					stmt.setString(2, IMSI);
					stmt.setString(3, IMSI_INDEX);
					stmt.setString(4, CALL_INDEX);
					stmt.setString(5, MSISDN);
					stmt.addBatch();
					
//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			pw.flush();

			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_IMSI_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_PS_SER_DATA(String dir, String filename, int Table_Id) {

		String SID="",PROFILE_ID="",CONTEXT_ID="",PDP_TYPE="",PDP_ADD="",ADD_INDICATOR="",QOS_SUBSCRIBED="",EXTQOS_SUBSCRIBED="",EXT2QOS_SUBSCRIBED="",VPLMN_ALLOWED="",APN="",CHARGE_DETAILS="",PDP_ADDIPV4="",STD_CHARGE="",EXT3QOS_SUBSCRIBED="";

		try {
			fos = new FileOutputStream(dir + filename + "_W_PS_SER_DATA.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_PS_SER_DATA (SID,PROFILE_ID,CONTEXT_ID,PDP_TYPE,PDP_ADD,ADD_INDICATOR,QOS_SUBSCRIBED,EXTQOS_SUBSCRIBED,EXT2QOS_SUBSCRIBED,VPLMN_ALLOWED,APN,CHARGE_DETAILS,PDP_ADDIPV4,STD_CHARGE,EXT3QOS_SUBSCRIBED) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;

					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					PROFILE_ID,        SN: 1,     Length: 1,     Begin: 8
					ary=new byte[1];
					System.arraycopy(bb, 16, ary, 0, 1);
					PROFILE_ID=StringUtil.toHex(ary);
//					CONTEXT_ID,        SN: 2,     Length: 1,     Begin: 9
					ary=new byte[1];
					System.arraycopy(bb, 17, ary, 0, 1);
					CONTEXT_ID=StringUtil.toHex(ary);
//					PDP_TYPE,        SN: 3,     Length: 1,     Begin: 10
					ary=new byte[1];
					System.arraycopy(bb, 18, ary, 0, 1);
					PDP_TYPE=StringUtil.toHex(ary);
//					PDP_ADD,        SN: 4,     Length: 40,     Begin: 11
					ary=new byte[40];
					System.arraycopy(bb, 19, ary, 0, 40);
					PDP_ADD=StringUtil.toHex(ary);
//					ADD_INDICATOR,        SN: 5,     Length: 1,     Begin: 51
					ary=new byte[1];
					System.arraycopy(bb, 59, ary, 0, 1);
					ADD_INDICATOR=StringUtil.toHex(ary);
//					QOS_SUBSCRIBED,        SN: 6,     Length: 3,     Begin: 52
					ary=new byte[3];
					System.arraycopy(bb, 60, ary, 0, 3);
					QOS_SUBSCRIBED=StringUtil.toHex(ary);
//					EXTQOS_SUBSCRIBED,        SN: 7,     Length: 9,     Begin: 55
					ary=new byte[9];
					System.arraycopy(bb, 63, ary, 0, 9);
					EXTQOS_SUBSCRIBED=StringUtil.toHex(ary);
//					EXT2QOS_SUBSCRIBED,        SN: 8,     Length: 3,     Begin: 64
					ary=new byte[3];
					System.arraycopy(bb, 72, ary, 0, 3);
					EXT2QOS_SUBSCRIBED=StringUtil.toHex(ary);
//					VPLMN_ALLOWED,        SN: 9,     Length: 1,     Begin: 67
					ary=new byte[1];
					System.arraycopy(bb, 75, ary, 0, 1);
					VPLMN_ALLOWED=StringUtil.toHex(ary);
//					APN,        SN: 10,     Length: 63,     Begin: 68
					ary=new byte[63];
					System.arraycopy(bb, 76, ary, 0, 63);
					APN=StringUtil.toHex(ary);
					StringBuffer sb=new StringBuffer("");
					for (int j=0;j<63;j++){
						if((ary[j]&0xff)==0) break;
						sb.append((char)ary[j]);
					}
					APN=sb.toString();
//					CHARGE_DETAILS,        SN: 11,     Length: 1,     Begin: 131
					ary=new byte[1];
					System.arraycopy(bb, 139, ary, 0, 1);
					CHARGE_DETAILS=StringUtil.toHex(ary);
//					PDP_ADDIPV4,        SN: 12,     Length: 4,     Begin: 132
					ary=new byte[4];
					System.arraycopy(bb, 140, ary, 0, 4);
					PDP_ADDIPV4=StringUtil.toHex(ary);
//					STD_CHARGE,        SN: 13,     Length: 12,     Begin: 136
					ary=new byte[12];
					System.arraycopy(bb, 144, ary, 0, 12);
					STD_CHARGE=StringUtil.toHex(ary);
//					EXT3QOS_SUBSCRIBED,        SN: 14,     Length: 2,     Begin: 148
					ary=new byte[2];
					System.arraycopy(bb, 156, ary, 0, 2);
					EXT3QOS_SUBSCRIBED=StringUtil.toHex(ary);

					stmt.setString(1, SID);
					stmt.setString(2, PROFILE_ID);
					stmt.setString(3, CONTEXT_ID);
					stmt.setString(4, PDP_TYPE);
					stmt.setString(5, PDP_ADD);
					stmt.setString(6, ADD_INDICATOR);
					stmt.setString(7, QOS_SUBSCRIBED);
					stmt.setString(8, EXTQOS_SUBSCRIBED);
					stmt.setString(9, EXT2QOS_SUBSCRIBED);
					stmt.setString(10, VPLMN_ALLOWED);
					stmt.setString(11, APN);
					stmt.setString(12, CHARGE_DETAILS);
					stmt.setString(13, PDP_ADDIPV4);
					stmt.setString(14, STD_CHARGE);
					stmt.setString(15, EXT3QOS_SUBSCRIBED);
					stmt.addBatch();
					
//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			pw.flush();

			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_PS_SER_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_PS_OPTSER_DATA(String dir, String filename, int Table_Id) {

		String SID="",PROFILE_ID="",OPT_CONTEXT_ID="",HLR_INDEX="",PDP_TYPE="",PDP_ADD="",ADD_INDICATOR="",QOSTPL_ID="",VPLMN_ALLOWED="",APNTPL_ID="",CHARGE_DETAILS="",PDP_ADDIPV4="",EPS_QOSTPL_ID="",DEFAULT_FLAG="",WILDCARD_FLAG="",APN_TYPE="",STD_CHARGE="",SIPTO="";

		try {
			fos = new FileOutputStream(dir + filename + "_W_PS_OPTSER_DATA.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_PS_OPTSER_DATA (SID,PROFILE_ID,OPT_CONTEXT_ID,HLR_INDEX,PDP_TYPE,PDP_ADD,ADD_INDICATOR,QOSTPL_ID,VPLMN_ALLOWED,APNTPL_ID,CHARGE_DETAILS,PDP_ADDIPV4,EPS_QOSTPL_ID,DEFAULT_FLAG,WILDCARD_FLAG,APN_TYPE,STD_CHARGE,SIPTO) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;

					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					PROFILE_ID,        SN: 1,     Length: 1,     Begin: 8
					ary=new byte[1];
					System.arraycopy(bb, 16, ary, 0, 1);
					PROFILE_ID=StringUtil.toHex(ary);
//					OPT_CONTEXT_ID,        SN: 2,     Length: 1,     Begin: 9
					ary=new byte[1];
					System.arraycopy(bb, 17, ary, 0, 1);
					OPT_CONTEXT_ID=StringUtil.toHex(ary);
//					HLR_INDEX,        SN: 3,     Length: 1,     Begin: 10
					ary=new byte[1];
					System.arraycopy(bb, 18, ary, 0, 1);
					HLR_INDEX=StringUtil.toHex(ary);
//					PDP_TYPE,        SN: 4,     Length: 1,     Begin: 11
					ary=new byte[1];
					System.arraycopy(bb, 19, ary, 0, 1);
					PDP_TYPE=StringUtil.toHex(ary);
//					PDP_ADD,        SN: 5,     Length: 40,     Begin: 12
					ary=new byte[40];
					System.arraycopy(bb, 20, ary, 0, 40);
					PDP_ADD=StringUtil.toHex(ary);
//					ADD_INDICATOR,        SN: 6,     Length: 1,     Begin: 52
					ary=new byte[1];
					System.arraycopy(bb, 60, ary, 0, 1);
					ADD_INDICATOR=StringUtil.toHex(ary);
//					QOSTPL_ID,        SN: 7,     Length: 2,     Begin: 53
					ary=new byte[2];
					System.arraycopy(bb, 61, ary, 0, 2);
					QOSTPL_ID=StringUtil.toHex(ary);
//					VPLMN_ALLOWED,        SN: 8,     Length: 1,     Begin: 55
					ary=new byte[1];
					System.arraycopy(bb, 63, ary, 0, 1);
					VPLMN_ALLOWED=StringUtil.toHex(ary);
//					APNTPL_ID,        SN: 9,     Length: 2,     Begin: 56
					ary=new byte[2];
					System.arraycopy(bb, 64, ary, 0, 2);
					APNTPL_ID=StringUtil.toHex(ary);
//					CHARGE_DETAILS,        SN: 10,     Length: 1,     Begin: 58
					ary=new byte[1];
					System.arraycopy(bb, 66, ary, 0, 1);
					CHARGE_DETAILS=StringUtil.toHex(ary);
//					PDP_ADDIPV4,        SN: 11,     Length: 4,     Begin: 59
					ary=new byte[4];
					System.arraycopy(bb, 67, ary, 0, 4);
					PDP_ADDIPV4=StringUtil.toHex(ary);
//					EPS_QOSTPL_ID,        SN: 12,     Length: 2,     Begin: 63
					ary=new byte[2];
					System.arraycopy(bb, 71, ary, 0, 2);
					EPS_QOSTPL_ID=StringUtil.toHex(ary);
//					DEFAULT_FLAG,        SN: 13,     Length: 1,     Begin: 65
					ary=new byte[1];
					System.arraycopy(bb, 73, ary, 0, 1);
					DEFAULT_FLAG=StringUtil.toHex(ary);
//					WILDCARD_FLAG,        SN: 14,     Length: 1,     Begin: 66
					ary=new byte[1];
					System.arraycopy(bb, 74, ary, 0, 1);
					WILDCARD_FLAG=StringUtil.toHex(ary);
//					APN_TYPE,        SN: 15,     Length: 1,     Begin: 67
					ary=new byte[1];
					System.arraycopy(bb, 75, ary, 0, 1);
					APN_TYPE=StringUtil.toHex(ary);
//					STD_CHARGE,        SN: 16,     Length: 12,     Begin: 68
					ary=new byte[12];
					System.arraycopy(bb, 76, ary, 0, 12);
					STD_CHARGE=StringUtil.toHex(ary);
//					SIPTO,        SN: 17,     Length: 1,     Begin: 80
					ary=new byte[1];
					System.arraycopy(bb, 88, ary, 0, 1);
					SIPTO=StringUtil.toHex(ary);

					stmt.setString(1, SID);
					stmt.setString(2, PROFILE_ID);
					stmt.setString(3, OPT_CONTEXT_ID);
					stmt.setString(4, HLR_INDEX);
					stmt.setString(5, PDP_TYPE);
					stmt.setString(6, PDP_ADD);
					stmt.setString(7, ADD_INDICATOR);
					stmt.setString(8, QOSTPL_ID);
					stmt.setString(9, VPLMN_ALLOWED);
					stmt.setString(10, APNTPL_ID);
					stmt.setString(11, CHARGE_DETAILS);
					stmt.setString(12, PDP_ADDIPV4);
					stmt.setString(13, EPS_QOSTPL_ID);
					stmt.setString(14, DEFAULT_FLAG);
					stmt.setString(15, WILDCARD_FLAG);
					stmt.setString(16, APN_TYPE);
					stmt.setString(17, STD_CHARGE);
					stmt.setString(18, SIPTO);
					stmt.addBatch();
					
//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			pw.flush();

			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_PS_OPTSER_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_SUB_DYN_CS_DATA(String dir, String filename, int Table_Id) {

		String SID="",IMSI="",SUB_DYN_CS_ID="",HLR_INDEX="",MSC_NUM="",VLR_NUM="",UNSUP_TS_ATMSC="",UNSUP_BS="",UNSUP_SS="",UNSUP_ODB_ATMSC="",VLRINTERNATIONAL="",VLRINHPLMN="",MSPURGEDATMSC="",VLRINLOCAL="",VLRINAREA="",MS_STATUS_ATMSC="",CHECKSS="",PLMNSS_STATE="",LMSI="",IMEISV="",UPL_TIME="",PURGE_TIME_ATMSC="",TIME_STAMP="",LOCATION_ID="",LSFLAG="",CCU_MODULE_NO="",FSM_INSTANCE_NO="",TIME_STAMP_REGCF="",NUM_REGCF="",NUM_UPL="",TIME_STAMP_UPL="",NUM_REGINTERCF="",TIME_STAMP_REGINTERCF="",TIME_STAMP_G1="",TIME_STAMP_G2="",TIME_STAMP_G3="",V_GMLC_ADDTYPE="",V_GMLC_ADDRESS="",IMSSF_NUM="",DYNLICFLAG="",MTRF_SUPPORTED="";

		try {
			fos = new FileOutputStream(dir + filename + "_W_SUB_DYN_CS_DATA.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_SUB_DYN_CS_DATA (SID,IMSI,SUB_DYN_CS_ID,HLR_INDEX,MSC_NUM,VLR_NUM,UNSUP_TS_ATMSC,UNSUP_BS,UNSUP_SS,UNSUP_ODB_ATMSC,VLRINTERNATIONAL,VLRINHPLMN,MSPURGEDATMSC,VLRINLOCAL,VLRINAREA,MS_STATUS_ATMSC,CHECKSS,PLMNSS_STATE,LMSI,IMEISV,UPL_TIME,PURGE_TIME_ATMSC,TIME_STAMP,LOCATION_ID,LSFLAG,CCU_MODULE_NO,FSM_INSTANCE_NO,TIME_STAMP_REGCF,NUM_REGCF,NUM_UPL,TIME_STAMP_UPL,NUM_REGINTERCF,TIME_STAMP_REGINTERCF,TIME_STAMP_G1,TIME_STAMP_G2,TIME_STAMP_G3,V_GMLC_ADDTYPE,V_GMLC_ADDRESS,IMSSF_NUM,DYNLICFLAG,MTRF_SUPPORTED) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;
			
					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					IMSI,        SN: 1,     Length: 8,     Begin: 8
					ary=new byte[8];
					System.arraycopy(bb, 16, ary, 0, 8);
					IMSI=StringUtil.toHex(ary);
					IMSI=IMSI.substring(0, IMSI.indexOf("f"));
//					SUB_DYN_CS_ID,        SN: 2,     Length: 1,     Begin: 16
					ary=new byte[1];
					System.arraycopy(bb, 24, ary, 0, 1);
					SUB_DYN_CS_ID=StringUtil.toHex(ary);
//					HLR_INDEX,        SN: 3,     Length: 1,     Begin: 17
					ary=new byte[1];
					System.arraycopy(bb, 25, ary, 0, 1);
					HLR_INDEX=StringUtil.toHex(ary);
//					MSC_NUM,        SN: 4,     Length: 8,     Begin: 18
					ary=new byte[8];
					System.arraycopy(bb, 26, ary, 0, 8);
					MSC_NUM=StringUtil.toHex(ary);
					MSC_NUM=MSC_NUM.substring(0, MSC_NUM.indexOf("f"));
//					VLR_NUM,        SN: 5,     Length: 8,     Begin: 26
					ary=new byte[8];
					System.arraycopy(bb, 34, ary, 0, 8);
					VLR_NUM=StringUtil.toHex(ary);
					VLR_NUM=VLR_NUM.substring(0, VLR_NUM.indexOf("f"));
//					UNSUP_TS_ATMSC,        SN: 6,     Length: 4,     Begin: 34
					ary=new byte[4];
					System.arraycopy(bb, 42, ary, 0, 4);
					UNSUP_TS_ATMSC=StringUtil.toHex(ary);
//					UNSUP_BS,        SN: 7,     Length: 7,     Begin: 38
					ary=new byte[7];
					System.arraycopy(bb, 46, ary, 0, 7);
					UNSUP_BS=StringUtil.toHex(ary);
//					UNSUP_SS,        SN: 8,     Length: 9,     Begin: 45
					ary=new byte[9];
					System.arraycopy(bb, 53, ary, 0, 9);
					UNSUP_SS=StringUtil.toHex(ary);
//					UNSUP_ODB_ATMSC,        SN: 9,     Length: 4,     Begin: 54
					ary=new byte[4];
					System.arraycopy(bb, 62, ary, 0, 4);
					UNSUP_ODB_ATMSC=StringUtil.toHex(ary);
//					VLRINTERNATIONAL,        SN: 10,     Length: 1,     Begin: 58
					ary=new byte[1];
					System.arraycopy(bb, 66, ary, 0, 1);
					VLRINTERNATIONAL=StringUtil.toHex(ary);
//					VLRINHPLMN,        SN: 11,     Length: 1,     Begin: 59
					ary=new byte[1];
					System.arraycopy(bb, 67, ary, 0, 1);
					VLRINHPLMN=StringUtil.toHex(ary);
//					MSPURGEDATMSC,        SN: 12,     Length: 1,     Begin: 60
					ary=new byte[1];
					System.arraycopy(bb, 68, ary, 0, 1);
					MSPURGEDATMSC=StringUtil.toHex(ary);
//					VLRINLOCAL,        SN: 13,     Length: 1,     Begin: 61
					ary=new byte[1];
					System.arraycopy(bb, 69, ary, 0, 1);
					VLRINLOCAL=StringUtil.toHex(ary);
//					VLRINAREA,        SN: 14,     Length: 1,     Begin: 62
					ary=new byte[1];
					System.arraycopy(bb, 70, ary, 0, 1);
					VLRINAREA=StringUtil.toHex(ary);
//					MS_STATUS_ATMSC,        SN: 15,     Length: 6,     Begin: 63
					ary=new byte[6];
					System.arraycopy(bb, 71, ary, 0, 6);
					MS_STATUS_ATMSC=StringUtil.toHex(ary);
//					CHECKSS,        SN: 16,     Length: 1,     Begin: 69
					ary=new byte[1];
					System.arraycopy(bb, 77, ary, 0, 1);
					CHECKSS=StringUtil.toHex(ary);
//					PLMNSS_STATE,        SN: 17,     Length: 1,     Begin: 70
					ary=new byte[1];
					System.arraycopy(bb, 78, ary, 0, 1);
					PLMNSS_STATE=StringUtil.toHex(ary);
//					LMSI,        SN: 18,     Length: 4,     Begin: 71
					ary=new byte[4];
					System.arraycopy(bb, 79, ary, 0, 4);
					LMSI=StringUtil.toHex(ary);
//					IMEISV,        SN: 19,     Length: 8,     Begin: 75
					ary=new byte[8];
					System.arraycopy(bb, 83, ary, 0, 8);
					IMEISV=StringUtil.toHex(ary);
//					UPL_TIME,        SN: 20,     Length: 4,     Begin: 83
					ary=new byte[4];
					System.arraycopy(bb, 91, ary, 0, 4);
					UPL_TIME=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					PURGE_TIME_ATMSC,        SN: 21,     Length: 4,     Begin: 87
					ary=new byte[4];
					System.arraycopy(bb, 95, ary, 0, 4);
					PURGE_TIME_ATMSC=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					TIME_STAMP,        SN: 22,     Length: 4,     Begin: 91
					ary=new byte[4];
					System.arraycopy(bb, 99, ary, 0, 4);
					TIME_STAMP=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					LOCATION_ID,        SN: 23,     Length: 1,     Begin: 95
					ary=new byte[1];
					System.arraycopy(bb, 103, ary, 0, 1);
					LOCATION_ID=StringUtil.toHex(ary);
//					LSFLAG,        SN: 24,     Length: 1,     Begin: 96
					ary=new byte[1];
					System.arraycopy(bb, 104, ary, 0, 1);
					LSFLAG=StringUtil.toHex(ary);
//					CCU_MODULE_NO,        SN: 25,     Length: 2,     Begin: 97
					ary=new byte[2];
					System.arraycopy(bb, 105, ary, 0, 2);
					CCU_MODULE_NO=StringUtil.toHex(ary);
//					FSM_INSTANCE_NO,        SN: 26,     Length: 4,     Begin: 99
					ary=new byte[4];
					System.arraycopy(bb, 107, ary, 0, 4);
					FSM_INSTANCE_NO=StringUtil.toHex(ary);
//					TIME_STAMP_REGCF,        SN: 27,     Length: 4,     Begin: 103
					ary=new byte[4];
					System.arraycopy(bb, 111, ary, 0, 4);
					TIME_STAMP_REGCF=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					NUM_REGCF,        SN: 28,     Length: 1,     Begin: 107
					ary=new byte[1];
					System.arraycopy(bb, 115, ary, 0, 1);
					NUM_REGCF=StringUtil.toHex(ary);
//					NUM_UPL,        SN: 29,     Length: 1,     Begin: 108
					ary=new byte[1];
					System.arraycopy(bb, 116, ary, 0, 1);
					NUM_UPL=StringUtil.toHex(ary);
//					TIME_STAMP_UPL,        SN: 30,     Length: 4,     Begin: 109
					ary=new byte[4];
					System.arraycopy(bb, 117, ary, 0, 4);
					TIME_STAMP_UPL=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					NUM_REGINTERCF,        SN: 31,     Length: 1,     Begin: 113
					ary=new byte[1];
					System.arraycopy(bb, 121, ary, 0, 1);
					NUM_REGINTERCF=StringUtil.toHex(ary);
//					TIME_STAMP_REGINTERCF,        SN: 32,     Length: 4,     Begin: 114
					ary=new byte[4];
					System.arraycopy(bb, 122, ary, 0, 4);
					TIME_STAMP_REGINTERCF=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					TIME_STAMP_G1,        SN: 33,     Length: 4,     Begin: 118
					ary=new byte[4];
					System.arraycopy(bb, 126, ary, 0, 4);
					TIME_STAMP_G1=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					TIME_STAMP_G2,        SN: 34,     Length: 4,     Begin: 122
					ary=new byte[4];
					System.arraycopy(bb, 130, ary, 0, 4);
					TIME_STAMP_G2=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					TIME_STAMP_G3,        SN: 35,     Length: 4,     Begin: 126
					ary=new byte[4];
					System.arraycopy(bb, 134, ary, 0, 4);
					TIME_STAMP_G3=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					V_GMLC_ADDTYPE,        SN: 36,     Length: 1,     Begin: 130
					ary=new byte[1];
					System.arraycopy(bb, 138, ary, 0, 1);
					V_GMLC_ADDTYPE=StringUtil.toHex(ary);
//					V_GMLC_ADDRESS,        SN: 37,     Length: 16,     Begin: 131
					ary=new byte[16];
					System.arraycopy(bb, 139, ary, 0, 16);
					V_GMLC_ADDRESS=StringUtil.toHex(ary);
//					IMSSF_NUM,        SN: 38,     Length: 8,     Begin: 147
					ary=new byte[8];
					System.arraycopy(bb, 155, ary, 0, 8);
					IMSSF_NUM=StringUtil.toHex(ary);
//					DYNLICFLAG,        SN: 39,     Length: 1,     Begin: 155
					ary=new byte[1];
					System.arraycopy(bb, 163, ary, 0, 1);
					DYNLICFLAG=StringUtil.toHex(ary);
//					MTRF_SUPPORTED,        SN: 40,     Length: 1,     Begin: 156
					ary=new byte[1];
					System.arraycopy(bb, 164, ary, 0, 1);
					MTRF_SUPPORTED=StringUtil.toHex(ary);

					stmt.setString(1, SID);
					stmt.setString(2, IMSI);
					stmt.setString(3, SUB_DYN_CS_ID);
					stmt.setString(4, HLR_INDEX);
					stmt.setString(5, MSC_NUM);
					stmt.setString(6, VLR_NUM);
					stmt.setString(7, UNSUP_TS_ATMSC);
					stmt.setString(8, UNSUP_BS);
					stmt.setString(9, UNSUP_SS);
					stmt.setString(10, UNSUP_ODB_ATMSC);
					stmt.setString(11, VLRINTERNATIONAL);
					stmt.setString(12, VLRINHPLMN);
					stmt.setString(13, MSPURGEDATMSC);
					stmt.setString(14, VLRINLOCAL);
					stmt.setString(15, VLRINAREA);
					stmt.setString(16, MS_STATUS_ATMSC);
					stmt.setString(17, CHECKSS);
					stmt.setString(18, PLMNSS_STATE);
					stmt.setString(19, LMSI);
					stmt.setString(20, IMEISV);
					stmt.setString(21, UPL_TIME);
					stmt.setString(22, PURGE_TIME_ATMSC);
					stmt.setString(23, TIME_STAMP);
					stmt.setString(24, LOCATION_ID);
					stmt.setString(25, LSFLAG);
					stmt.setString(26, CCU_MODULE_NO);
					stmt.setString(27, FSM_INSTANCE_NO);
					stmt.setString(28, TIME_STAMP_REGCF);
					stmt.setString(29, NUM_REGCF);
					stmt.setString(30, NUM_UPL);
					stmt.setString(31, TIME_STAMP_UPL);
					stmt.setString(32, NUM_REGINTERCF);
					stmt.setString(33, TIME_STAMP_REGINTERCF);
					stmt.setString(34, TIME_STAMP_G1);
					stmt.setString(35, TIME_STAMP_G2);
					stmt.setString(36, TIME_STAMP_G3);
					stmt.setString(37, V_GMLC_ADDTYPE);
					stmt.setString(38, V_GMLC_ADDRESS);
					stmt.setString(39, IMSSF_NUM);
					stmt.setString(40, DYNLICFLAG);
					stmt.setString(41, MTRF_SUPPORTED);
					stmt.addBatch();

//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}

			pw.flush();

			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_SUB_DYN_CS_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_SUB_DYN_PS_DATA(String dir, String filename, int Table_Id) {

		String SID="",IMSI="",SUB_DYN_PS_ID="",HLR_INDEX="",SGSN_NUM="",SGSN_ADDRESS="",SGSN_ADDTYPE="",SGSNINTERNATIONAL="",SGSNINHPLMN="",MSPURGEDATSGSN="",SGSNINLOCAL="",SGSNINAREA="",MS_STATUS_ATSGSN="",UNSUP_TS_ATSGSN="",UNSUP_ODB_ATSGSN="",GPRSUPL_TIME="",PURGE_TIME_ATSGSN="",TIME_STAMP="",LOCATION_ID="",TIME_STAMP_G1="",TIME_STAMP_G2="",V_GMLC_ADDTYPE="",V_GMLC_ADDRESS="";

		try {
			fos = new FileOutputStream(dir + filename + "_W_SUB_DYN_PS_DATA.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_SUB_DYN_PS_DATA (SID,IMSI,SUB_DYN_PS_ID,HLR_INDEX,SGSN_NUM,SGSN_ADDRESS,SGSN_ADDTYPE,SGSNINTERNATIONAL,SGSNINHPLMN,MSPURGEDATSGSN,SGSNINLOCAL,SGSNINAREA,MS_STATUS_ATSGSN,UNSUP_TS_ATSGSN,UNSUP_ODB_ATSGSN,GPRSUPL_TIME,PURGE_TIME_ATSGSN,TIME_STAMP,LOCATION_ID,TIME_STAMP_G1,TIME_STAMP_G2,V_GMLC_ADDTYPE,V_GMLC_ADDRESS) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;

					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					IMSI,        SN: 1,     Length: 8,     Begin: 8
					ary=new byte[8];
					System.arraycopy(bb, 16, ary, 0, 8);
					IMSI=StringUtil.toHex(ary);
					IMSI=IMSI.substring(0, IMSI.indexOf("f"));
//					SUB_DYN_PS_ID,        SN: 2,     Length: 1,     Begin: 16
					ary=new byte[1];
					System.arraycopy(bb, 24, ary, 0, 1);
					SUB_DYN_PS_ID=StringUtil.toHex(ary);
//					HLR_INDEX,        SN: 3,     Length: 1,     Begin: 17
					ary=new byte[1];
					System.arraycopy(bb, 25, ary, 0, 1);
					HLR_INDEX=StringUtil.toHex(ary);
//					SGSN_NUM,        SN: 4,     Length: 8,     Begin: 18
					ary=new byte[8];
					System.arraycopy(bb, 26, ary, 0, 8);
					SGSN_NUM=StringUtil.toHex(ary);
					SGSN_NUM=SGSN_NUM.substring(0, SGSN_NUM.indexOf("f"));
//					SGSN_ADDRESS,        SN: 5,     Length: 16,     Begin: 26
					ary=new byte[16];
					System.arraycopy(bb, 34, ary, 0, 16);
					SGSN_ADDRESS=StringUtil.toHex(ary);
					if(!SGSN_ADDRESS.substring(0,8).equals("ffffffff")){
						SGSN_ADDRESS=""+(ary[0]&0xff)+"."+""+(ary[1]&0xff)+"."+""+(ary[2]&0xff)+"."+""+(ary[3]&0xff);
					}
//					SGSN_ADDTYPE,        SN: 6,     Length: 1,     Begin: 42
					ary=new byte[1];
					System.arraycopy(bb, 50, ary, 0, 1);
					SGSN_ADDTYPE=StringUtil.toHex(ary);
//					SGSNINTERNATIONAL,        SN: 7,     Length: 1,     Begin: 43
					ary=new byte[1];
					System.arraycopy(bb, 51, ary, 0, 1);
					SGSNINTERNATIONAL=StringUtil.toHex(ary);
//					SGSNINHPLMN,        SN: 8,     Length: 1,     Begin: 44
					ary=new byte[1];
					System.arraycopy(bb, 52, ary, 0, 1);
					SGSNINHPLMN=StringUtil.toHex(ary);
//					MSPURGEDATSGSN,        SN: 9,     Length: 1,     Begin: 45
					ary=new byte[1];
					System.arraycopy(bb, 53, ary, 0, 1);
					MSPURGEDATSGSN=StringUtil.toHex(ary);
//					SGSNINLOCAL,        SN: 10,     Length: 1,     Begin: 46
					ary=new byte[1];
					System.arraycopy(bb, 54, ary, 0, 1);
					SGSNINLOCAL=StringUtil.toHex(ary);
//					SGSNINAREA,        SN: 11,     Length: 1,     Begin: 47
					ary=new byte[1];
					System.arraycopy(bb, 55, ary, 0, 1);
					SGSNINAREA=StringUtil.toHex(ary);
//					MS_STATUS_ATSGSN,        SN: 12,     Length: 4,     Begin: 48
					ary=new byte[4];
					System.arraycopy(bb, 56, ary, 0, 4);
					MS_STATUS_ATSGSN=StringUtil.toHex(ary);
//					UNSUP_TS_ATSGSN,        SN: 13,     Length: 4,     Begin: 52
					ary=new byte[4];
					System.arraycopy(bb, 60, ary, 0, 4);
					UNSUP_TS_ATSGSN=StringUtil.toHex(ary);
//					UNSUP_ODB_ATSGSN,        SN: 14,     Length: 4,     Begin: 56
					ary=new byte[4];
					System.arraycopy(bb, 64, ary, 0, 4);
					UNSUP_ODB_ATSGSN=StringUtil.toHex(ary);
//					GPRSUPL_TIME,        SN: 15,     Length: 4,     Begin: 60
					ary=new byte[4];
					System.arraycopy(bb, 68, ary, 0, 4);
					GPRSUPL_TIME=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					PURGE_TIME_ATSGSN,        SN: 16,     Length: 4,     Begin: 64
					ary=new byte[4];
					System.arraycopy(bb, 72, ary, 0, 4);
					PURGE_TIME_ATSGSN=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					TIME_STAMP,        SN: 17,     Length: 4,     Begin: 68
					ary=new byte[4];
					System.arraycopy(bb, 76, ary, 0, 4);
					TIME_STAMP=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					LOCATION_ID,        SN: 18,     Length: 1,     Begin: 72
					ary=new byte[1];
					System.arraycopy(bb, 80, ary, 0, 1);
					LOCATION_ID=StringUtil.toHex(ary);
//					TIME_STAMP_G1,        SN: 19,     Length: 4,     Begin: 73
					ary=new byte[4];
					System.arraycopy(bb, 81, ary, 0, 4);
					TIME_STAMP_G1=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					TIME_STAMP_G2,        SN: 20,     Length: 4,     Begin: 77
					ary=new byte[4];
					System.arraycopy(bb, 85, ary, 0, 4);
					TIME_STAMP_G2=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					V_GMLC_ADDTYPE,        SN: 21,     Length: 1,     Begin: 81
					ary=new byte[1];
					System.arraycopy(bb, 89, ary, 0, 1);
					V_GMLC_ADDTYPE=StringUtil.toHex(ary);
//					V_GMLC_ADDRESS,        SN: 22,     Length: 16,     Begin: 82
					ary=new byte[16];
					System.arraycopy(bb, 90, ary, 0, 16);
					V_GMLC_ADDRESS=StringUtil.toHex(ary);

					stmt.setString(1, SID);
					stmt.setString(2, IMSI);
					stmt.setString(3, SUB_DYN_PS_ID);
					stmt.setString(4, HLR_INDEX);
					stmt.setString(5, SGSN_NUM);
					stmt.setString(6, SGSN_ADDRESS);
					stmt.setString(7, SGSN_ADDTYPE);
					stmt.setString(8, SGSNINTERNATIONAL);
					stmt.setString(9, SGSNINHPLMN);
					stmt.setString(10, MSPURGEDATSGSN);
					stmt.setString(11, SGSNINLOCAL);
					stmt.setString(12, SGSNINAREA);
					stmt.setString(13, MS_STATUS_ATSGSN);
					stmt.setString(14, UNSUP_TS_ATSGSN);
					stmt.setString(15, UNSUP_ODB_ATSGSN);
					stmt.setString(16, GPRSUPL_TIME);
					stmt.setString(17, PURGE_TIME_ATSGSN);
					stmt.setString(18, TIME_STAMP);
					stmt.setString(19, LOCATION_ID);
					stmt.setString(20, TIME_STAMP_G1);
					stmt.setString(21, TIME_STAMP_G2);
					stmt.setString(22, V_GMLC_ADDTYPE);
					stmt.setString(23, V_GMLC_ADDRESS);
					stmt.addBatch();

//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			pw.flush();

			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_SUB_DYN_PS_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_SCMSG_DATA(String dir, String filename, int Table_Id) {

		String SID="",MSISDN="",SC_ADD="";

		try {
			fos = new FileOutputStream(dir + filename + "_W_SCMSG_DATA.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_SCMSG_DATA (SID,MSISDN,SC_ADD) values(?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;

					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					MSISDN,        SN: 1,     Length: 8,     Begin: 8
					ary=new byte[8];
					System.arraycopy(bb, 16, ary, 0, 8);
					MSISDN=StringUtil.toHex(ary);
					MSISDN=MSISDN.substring(0, MSISDN.indexOf("f"));
//					SC_ADD,        SN: 2,     Length: 8,     Begin: 16
					ary=new byte[8];
					System.arraycopy(bb, 24, ary, 0, 8);
					SC_ADD=StringUtil.toHex(ary);
					SC_ADD=SC_ADD.substring(0, SC_ADD.indexOf("f"));

					stmt.setString(1, SID);
					stmt.setString(2, MSISDN);
					stmt.setString(3, SC_ADD);
					stmt.addBatch();

//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			pw.flush();

			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_SCMSG_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_SID_DATA(String dir, String filename, int Table_Id) {

		String SID="",HLR_INDEX="",TIME_STAMP="";

		try {
			fos = new FileOutputStream(dir + filename + "_W_SID_DATA.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_SID_DATA (SID,HLR_INDEX,TIME_STAMP) values(?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;

					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					HLR_INDEX,        SN: 1,     Length: 1,     Begin: 8
					ary=new byte[1];
					System.arraycopy(bb, 16, ary, 0, 1);
					HLR_INDEX=StringUtil.toHex(ary);
//					TIME_STAMP,        SN: 2,     Length: 4,     Begin: 9
					ary=new byte[4];
					System.arraycopy(bb, 17, ary, 0, 4);
					TIME_STAMP=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
					
					stmt.setString(1, SID);
					stmt.setString(2, HLR_INDEX);
					stmt.setString(3, TIME_STAMP);
					stmt.addBatch();

//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			pw.flush();

			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_SID_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_LICENCE_CHECK_DATA(String dir, String filename, int Table_Id) {

		String LIC_NE_TYPE="",LIC_ITEM_ID="",LIC_VALUE="",SID="";

		try {
			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_LICENCE_CHECK_DATA (LIC_NE_TYPE,LIC_ITEM_ID,LIC_VALUE,SID) values(?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point+8);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
			
					bis.read(bb);
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
//					LIC_NE_TYPE,        SN: 0,     Length: 1,     Begin: 0
					ary=new byte[1];
					System.arraycopy(bb, 0, ary, 0, 1);
					LIC_NE_TYPE=StringUtil.toHex(ary);
//					LIC_ITEM_ID,        SN: 1,     Length: 1,     Begin: 1
					ary=new byte[1];
					System.arraycopy(bb, 1, ary, 0, 1);
					LIC_ITEM_ID=StringUtil.toHex(ary);
//					LIC_VALUE,        SN: 2,     Length: 4,     Begin: 2
					ary=new byte[4];
					System.arraycopy(bb, 2, ary, 0, 4);
					LIC_VALUE=StringUtil.toHex(ary);
//					SID,        SN: 3,     Length: 8,     Begin: 6
					ary=new byte[8];
					System.arraycopy(bb, 6, ary, 0, 8);
					SID=StringUtil.toHex(ary);

					stmt.setString(1, LIC_NE_TYPE);
					stmt.setString(2, LIC_ITEM_ID);
					stmt.setString(3, LIC_VALUE);
					stmt.setString(4, SID);
			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_LICENCE_CHECK_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_HLRSN_LICENSE_CHECK_DATA(String dir, String filename, int Table_Id) {

		String LIC_NE_TYPE="",LIC_ITEM_ID="",HLR_INDEX="",LIC_VALUE="",SID="";

		try {
			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_HLRSN_LICENSE_CHECK_DATA (LIC_NE_TYPE,LIC_ITEM_ID,HLR_INDEX,LIC_VALUE,SID) values(?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point+8);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
			
					bis.read(bb);
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
//					LIC_NE_TYPE,        SN: 0,     Length: 1,     Begin: 0
					ary=new byte[1];
					System.arraycopy(bb, 0, ary, 0, 1);
					LIC_NE_TYPE=StringUtil.toHex(ary);
//					LIC_ITEM_ID,        SN: 1,     Length: 1,     Begin: 1
					ary=new byte[1];
					System.arraycopy(bb, 1, ary, 0, 1);
					LIC_ITEM_ID=StringUtil.toHex(ary);
//					HLR_INDEX,        SN: 2,     Length: 1,     Begin: 2
					ary=new byte[1];
					System.arraycopy(bb, 2, ary, 0, 1);
					HLR_INDEX=StringUtil.toHex(ary);
//					LIC_VALUE,        SN: 3,     Length: 4,     Begin: 3
					ary=new byte[4];
					System.arraycopy(bb, 3, ary, 0, 4);
					LIC_VALUE=StringUtil.toHex(ary);
//					SID,        SN: 4,     Length: 8,     Begin: 7
					ary=new byte[8];
					System.arraycopy(bb, 7, ary, 0, 8);
					SID=StringUtil.toHex(ary);

					stmt.setString(1, LIC_NE_TYPE);
					stmt.setString(2, LIC_ITEM_ID);
					stmt.setString(3, HLR_INDEX);
					stmt.setString(4, LIC_VALUE);
					stmt.setString(5, SID);
					stmt.addBatch();
			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_HLRSN_LICENSE_CHECK_DATA During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_IMSIBASICDYNINFO(String dir, String filename, int Table_Id) {

		String SID="",SUB_DYN_EPS_ID="",HLR_INDEX="",IMSI="",RATTYPE="",MMEHOST="",MMEREALM="",SGSNHOST="",SGSNREALM="",SGSNNUMBER="",MMEVPLMNID="",SGSNVPLMNID="",PURGEDONMME="",PURGEDONSGSN="",IMEI="",IMEISV="",LOCAREARESFLAG="",MMEFEATURELIST="",SGSNFEATURELIST="",MMEULRFLAG="",SGSNULRFLAG="",MMEIDRDSRSUCCESS="",SGSNIDRDSRSUCCESS="",MMETIMESTAMP="",S4SGSNTIMESTAMP="",TIME_STAMP="",LOCATION_ID="",VOLTESTATE="",MSROAMINMME="",MSROAMINSGSN="",TIME_STAMP_G1="",TIME_STAMP_G2="",MMEVGMLC="",SGSNVGMLC="",URRP_MME="",URRP_SGSN="",IP_SM_GW_ADD="",UNRI="",UNRR="",USER_TAI="";

		try {
			fos = new FileOutputStream(dir + filename + "_W_IMSIBASICDYNINFO.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_IMSIBASICDYNINFO (SID,SUB_DYN_EPS_ID,HLR_INDEX,IMSI,RATTYPE,MMEHOST,MMEREALM,SGSNHOST,SGSNREALM,SGSNNUMBER,MMEVPLMNID,SGSNVPLMNID,PURGEDONMME,PURGEDONSGSN,IMEI,IMEISV,LOCAREARESFLAG,MMEFEATURELIST,SGSNFEATURELIST,MMEULRFLAG,SGSNULRFLAG,MMEIDRDSRSUCCESS,SGSNIDRDSRSUCCESS,MMETIMESTAMP,S4SGSNTIMESTAMP,TIME_STAMP,LOCATION_ID,VOLTESTATE,MSROAMINMME,MSROAMINSGSN,TIME_STAMP_G1,TIME_STAMP_G2,MMEVGMLC,SGSNVGMLC,URRP_MME,URRP_SGSN,IP_SM_GW_ADD,UNRI,UNRR,USER_TAI) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;

					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					SUB_DYN_EPS_ID,        SN: 1,     Length: 1,     Begin: 8
					ary=new byte[1];
					System.arraycopy(bb, 16, ary, 0, 1);
					SUB_DYN_EPS_ID=StringUtil.toHex(ary);
//					HLR_INDEX,        SN: 2,     Length: 1,     Begin: 9
					ary=new byte[1];
					System.arraycopy(bb, 17, ary, 0, 1);
					HLR_INDEX=StringUtil.toHex(ary);
//					IMSI,        SN: 3,     Length: 8,     Begin: 10
					ary=new byte[8];
					System.arraycopy(bb, 18, ary, 0, 8);
					IMSI=StringUtil.toHex(ary);
					IMSI=IMSI.substring(0, IMSI.indexOf("f"));
//					RATTYPE,        SN: 4,     Length: 2,     Begin: 18
					ary=new byte[2];
					System.arraycopy(bb, 26, ary, 0, 2);
					RATTYPE=StringUtil.toHex(ary);
//					MMEHOST,        SN: 5,     Length: 12,     Begin: 20
					ary=new byte[12];
					System.arraycopy(bb, 28, ary, 0, 12);
					MMEHOST=StringUtil.toHex(ary);
//					MMEREALM,        SN: 6,     Length: 12,     Begin: 32
					ary=new byte[12];
					System.arraycopy(bb, 40, ary, 0, 12);
					MMEREALM=StringUtil.toHex(ary);
//					SGSNHOST,        SN: 7,     Length: 12,     Begin: 44
					ary=new byte[12];
					System.arraycopy(bb, 52, ary, 0, 12);
					SGSNHOST=StringUtil.toHex(ary);
//					SGSNREALM,        SN: 8,     Length: 12,     Begin: 56
					ary=new byte[12];
					System.arraycopy(bb, 64, ary, 0, 12);
					SGSNREALM=StringUtil.toHex(ary);
//					SGSNNUMBER,        SN: 9,     Length: 8,     Begin: 68
					ary=new byte[8];
					System.arraycopy(bb, 76, ary, 0, 8);
					SGSNNUMBER=StringUtil.toHex(ary);
//					MMEVPLMNID,        SN: 10,     Length: 3,     Begin: 76
					ary=new byte[3];
					System.arraycopy(bb, 84, ary, 0, 3);
					MMEVPLMNID=StringUtil.toHex(ary);
//					SGSNVPLMNID,        SN: 11,     Length: 3,     Begin: 79
					ary=new byte[3];
					System.arraycopy(bb, 87, ary, 0, 3);
					SGSNVPLMNID=StringUtil.toHex(ary);
//					PURGEDONMME,        SN: 12,     Length: 1,     Begin: 82
					ary=new byte[1];
					System.arraycopy(bb, 90, ary, 0, 1);
					PURGEDONMME=StringUtil.toHex(ary);
//					PURGEDONSGSN,        SN: 13,     Length: 1,     Begin: 83
					ary=new byte[1];
					System.arraycopy(bb, 91, ary, 0, 1);
					PURGEDONSGSN=StringUtil.toHex(ary);
//					IMEI,        SN: 14,     Length: 8,     Begin: 84
					ary=new byte[8];
					System.arraycopy(bb, 92, ary, 0, 8);
					IMEI=StringUtil.toHex(ary);
//					IMEISV,        SN: 15,     Length: 1,     Begin: 92
					ary=new byte[1];
					System.arraycopy(bb, 100, ary, 0, 1);
					IMEISV=StringUtil.toHex(ary);
//					LOCAREARESFLAG,        SN: 16,     Length: 1,     Begin: 93
					ary=new byte[1];
					System.arraycopy(bb, 101, ary, 0, 1);
					LOCAREARESFLAG=StringUtil.toHex(ary);
//					MMEFEATURELIST,        SN: 17,     Length: 4,     Begin: 94
					ary=new byte[4];
					System.arraycopy(bb, 102, ary, 0, 4);
					MMEFEATURELIST=StringUtil.toHex(ary);
//					SGSNFEATURELIST,        SN: 18,     Length: 4,     Begin: 98
					ary=new byte[4];
					System.arraycopy(bb, 106, ary, 0, 4);
					SGSNFEATURELIST=StringUtil.toHex(ary);
//					MMEULRFLAG,        SN: 19,     Length: 4,     Begin: 102
					ary=new byte[4];
					System.arraycopy(bb, 110, ary, 0, 4);
					MMEULRFLAG=StringUtil.toHex(ary);
//					SGSNULRFLAG,        SN: 20,     Length: 4,     Begin: 106
					ary=new byte[4];
					System.arraycopy(bb, 114, ary, 0, 4);
					SGSNULRFLAG=StringUtil.toHex(ary);
//					MMEIDRDSRSUCCESS,        SN: 21,     Length: 1,     Begin: 110
					ary=new byte[1];
					System.arraycopy(bb, 118, ary, 0, 1);
					MMEIDRDSRSUCCESS=StringUtil.toHex(ary);
//					SGSNIDRDSRSUCCESS,        SN: 22,     Length: 1,     Begin: 111
					ary=new byte[1];
					System.arraycopy(bb, 119, ary, 0, 1);
					SGSNIDRDSRSUCCESS=StringUtil.toHex(ary);
//					MMETIMESTAMP,        SN: 23,     Length: 4,     Begin: 112
					ary=new byte[4];
					System.arraycopy(bb, 120, ary, 0, 4);
					MMETIMESTAMP=StringUtil.toHex(ary);
//					S4SGSNTIMESTAMP,        SN: 24,     Length: 4,     Begin: 116
					ary=new byte[4];
					System.arraycopy(bb, 124, ary, 0, 4);
					S4SGSNTIMESTAMP=StringUtil.toHex(ary);
//					TIME_STAMP,        SN: 25,     Length: 4,     Begin: 120
					ary=new byte[4];
					System.arraycopy(bb, 128, ary, 0, 4);
					TIME_STAMP=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					LOCATION_ID,        SN: 26,     Length: 1,     Begin: 124
					ary=new byte[1];
					System.arraycopy(bb, 132, ary, 0, 1);
					LOCATION_ID=StringUtil.toHex(ary);
//					VOLTESTATE,        SN: 27,     Length: 1,     Begin: 125
					ary=new byte[1];
					System.arraycopy(bb, 133, ary, 0, 1);
					VOLTESTATE=StringUtil.toHex(ary);
//					MSROAMINMME,        SN: 28,     Length: 1,     Begin: 126
					ary=new byte[1];
					System.arraycopy(bb, 134, ary, 0, 1);
					MSROAMINMME=StringUtil.toHex(ary);
//					MSROAMINSGSN,        SN: 29,     Length: 1,     Begin: 127
					ary=new byte[1];
					System.arraycopy(bb, 135, ary, 0, 1);
					MSROAMINSGSN=StringUtil.toHex(ary);
//					TIME_STAMP_G1,        SN: 30,     Length: 4,     Begin: 128
					ary=new byte[4];
					System.arraycopy(bb, 136, ary, 0, 4);
					TIME_STAMP_G1=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					TIME_STAMP_G2,        SN: 31,     Length: 4,     Begin: 132
					ary=new byte[4];
					System.arraycopy(bb, 140, ary, 0, 4);
					TIME_STAMP_G2=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					MMEVGMLC,        SN: 32,     Length: 18,     Begin: 136
					ary=new byte[18];
					System.arraycopy(bb, 144, ary, 0, 18);
					MMEVGMLC=StringUtil.toHex(ary);
//					SGSNVGMLC,        SN: 33,     Length: 18,     Begin: 154
					ary=new byte[18];
					System.arraycopy(bb, 162, ary, 0, 18);
					SGSNVGMLC=StringUtil.toHex(ary);
//					URRP_MME,        SN: 34,     Length: 4,     Begin: 172
					ary=new byte[4];
					System.arraycopy(bb, 180, ary, 0, 4);
					URRP_MME=StringUtil.toHex(ary);
//					URRP_SGSN,        SN: 35,     Length: 4,     Begin: 176
					ary=new byte[4];
					System.arraycopy(bb, 184, ary, 0, 4);
					URRP_SGSN=StringUtil.toHex(ary);
//					IP_SM_GW_ADD,        SN: 36,     Length: 8,     Begin: 180
					ary=new byte[8];
					System.arraycopy(bb, 188, ary, 0, 8);
					IP_SM_GW_ADD=StringUtil.toHex(ary);
//					UNRI,        SN: 37,     Length: 1,     Begin: 188
					ary=new byte[1];
					System.arraycopy(bb, 196, ary, 0, 1);
					UNRI=StringUtil.toHex(ary);
//					UNRR,        SN: 38,     Length: 1,     Begin: 189
					ary=new byte[1];
					System.arraycopy(bb, 197, ary, 0, 1);
					UNRR=StringUtil.toHex(ary);
//					USER_TAI,        SN: 39,     Length: 5,     Begin: 190
					ary=new byte[5];
					System.arraycopy(bb, 198, ary, 0, 5);
					USER_TAI=StringUtil.toHex(ary);

					stmt.setString(1 ,SID);
					stmt.setString(2 ,SUB_DYN_EPS_ID);
					stmt.setString(3 ,HLR_INDEX);
					stmt.setString(4 ,IMSI);
					stmt.setString(5 ,RATTYPE);
					stmt.setString(6 ,MMEHOST);
					stmt.setString(7 ,MMEREALM);
					stmt.setString(8 ,SGSNHOST);
					stmt.setString(9 ,SGSNREALM);
					stmt.setString(10,SGSNNUMBER);
					stmt.setString(11,MMEVPLMNID);
					stmt.setString(12,SGSNVPLMNID);
					stmt.setString(13,PURGEDONMME);
					stmt.setString(14,PURGEDONSGSN);
					stmt.setString(15,IMEI);
					stmt.setString(16,IMEISV);
					stmt.setString(17,LOCAREARESFLAG);
					stmt.setString(18,MMEFEATURELIST);
					stmt.setString(19,SGSNFEATURELIST);
					stmt.setString(20,MMEULRFLAG);
					stmt.setString(21,SGSNULRFLAG);
					stmt.setString(22,MMEIDRDSRSUCCESS);
					stmt.setString(23,SGSNIDRDSRSUCCESS);
					stmt.setString(24,MMETIMESTAMP);
					stmt.setString(25,S4SGSNTIMESTAMP);
					stmt.setString(26,TIME_STAMP);
					stmt.setString(27,LOCATION_ID);
					stmt.setString(28,VOLTESTATE);
					stmt.setString(29,MSROAMINMME);
					stmt.setString(30,MSROAMINSGSN);
					stmt.setString(31,TIME_STAMP_G1);
					stmt.setString(32,TIME_STAMP_G2);
					stmt.setString(33,MMEVGMLC);
					stmt.setString(34,SGSNVGMLC);
					stmt.setString(35,URRP_MME);
					stmt.setString(36,URRP_SGSN);
					stmt.setString(37,IP_SM_GW_ADD);
					stmt.setString(38,UNRI);
					stmt.setString(39,UNRR);
					stmt.setString(40,USER_TAI);
					stmt.addBatch();
					
//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			pw.flush();

			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_IMSIBASICDYNINFO During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	private static void W_EPSSTAINFO(String dir, String filename, int Table_Id) {

		String SID="",PROFILE_ID="",EPS_PROFILE_ID="",HLR_INDEX="",STNSR="",APNOI="",TGPPAMBRMAXUL="",TGPPAMBRMAXDL="",RATFREQSELPRI="",PLMNTPLID="",ICSIND="",DIAMNODETPL_ID="",NON3GPPSUPP="",NON3GPPRATTYPE="",MIP6FEAVEC="",SESSIONTIMEOUT="",CSGTPLID="",EGR="",EGRHLRSN="",MPS="",RELAY="",TAUTIMER="",MDT="";


		try {
			fos = new FileOutputStream(dir + filename + "_W_EPSSTAINFO.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_EPSSTAINFO (SID,PROFILE_ID,EPS_PROFILE_ID,HLR_INDEX,STNSR,APNOI,TGPPAMBRMAXUL,TGPPAMBRMAXDL,RATFREQSELPRI,PLMNTPLID,ICSIND,DIAMNODETPL_ID,NON3GPPSUPP,NON3GPPRATTYPE,MIP6FEAVEC,SESSIONTIMEOUT,CSGTPLID,EGR,EGRHLRSN,MPS,RELAY,TAUTIMER,MDT) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;

					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					PROFILE_ID,        SN: 1,     Length: 1,     Begin: 8
					ary=new byte[1];
					System.arraycopy(bb, 16, ary, 0, 1);
					PROFILE_ID=StringUtil.toHex(ary);
//					EPS_PROFILE_ID,        SN: 2,     Length: 1,     Begin: 9
					ary=new byte[1];
					System.arraycopy(bb, 17, ary, 0, 1);
					EPS_PROFILE_ID=StringUtil.toHex(ary);
//					HLR_INDEX,        SN: 3,     Length: 1,     Begin: 10
					ary=new byte[1];
					System.arraycopy(bb, 18, ary, 0, 1);
					HLR_INDEX=StringUtil.toHex(ary);
//					STNSR,        SN: 4,     Length: 8,     Begin: 11
					ary=new byte[8];
					System.arraycopy(bb, 19, ary, 0, 8);
					STNSR=StringUtil.toHex(ary);
//					APNOI,        SN: 5,     Length: 12,     Begin: 19
					ary=new byte[12];
//					System.out.println("Table_Id"+Table_Id);
//					System.out.println("a7[Table_Id]"+a7[Table_Id]);
//					System.out.println("bb.length"+bb.length);
					System.arraycopy(bb, 27, ary, 0, 12);
					APNOI=StringUtil.toHex(ary);
//					TGPPAMBRMAXUL,        SN: 6,     Length: 4,     Begin: 31
					ary=new byte[4];
					System.arraycopy(bb, 39, ary, 0, 4);
					TGPPAMBRMAXUL=StringUtil.toHex(ary);
//					TGPPAMBRMAXDL,        SN: 7,     Length: 4,     Begin: 35
					ary=new byte[4];
					System.arraycopy(bb, 43, ary, 0, 4);
					TGPPAMBRMAXDL=StringUtil.toHex(ary);
//					RATFREQSELPRI,        SN: 8,     Length: 4,     Begin: 39
					ary=new byte[4];
					System.arraycopy(bb, 47, ary, 0, 4);
					RATFREQSELPRI=StringUtil.toHex(ary);
//					PLMNTPLID,        SN: 9,     Length: 2,     Begin: 43
					ary=new byte[2];
					System.arraycopy(bb, 51, ary, 0, 2);
					PLMNTPLID=StringUtil.toHex(ary);
//					ICSIND,        SN: 10,     Length: 1,     Begin: 45
					ary=new byte[1];
					System.arraycopy(bb, 53, ary, 0, 1);
					ICSIND=StringUtil.toHex(ary);
//					DIAMNODETPL_ID,        SN: 11,     Length: 2,     Begin: 46
					ary=new byte[2];
					System.arraycopy(bb, 54, ary, 0, 2);
					DIAMNODETPL_ID=StringUtil.toHex(ary);
//					NON3GPPSUPP,        SN: 12,     Length: 1,     Begin: 48
					ary=new byte[1];
					System.arraycopy(bb, 56, ary, 0, 1);
					NON3GPPSUPP=StringUtil.toHex(ary);
//					NON3GPPRATTYPE,        SN: 13,     Length: 1,     Begin: 49
					ary=new byte[1];
					System.arraycopy(bb, 57, ary, 0, 1);
					NON3GPPRATTYPE=StringUtil.toHex(ary);
//					MIP6FEAVEC,        SN: 14,     Length: 1,     Begin: 50
					ary=new byte[1];
					System.arraycopy(bb, 58, ary, 0, 1);
					MIP6FEAVEC=StringUtil.toHex(ary);
//					SESSIONTIMEOUT,        SN: 15,     Length: 4,     Begin: 51
					ary=new byte[4];
					System.arraycopy(bb, 59, ary, 0, 4);
					SESSIONTIMEOUT=StringUtil.toHex(ary);
//					CSGTPLID,        SN: 16,     Length: 2,     Begin: 55
					ary=new byte[2];
					System.arraycopy(bb, 63, ary, 0, 2);
					CSGTPLID=StringUtil.toHex(ary);
//					EGR,        SN: 17,     Length: 1,     Begin: 57
					ary=new byte[1];
					System.arraycopy(bb, 65, ary, 0, 1);
					EGR=StringUtil.toHex(ary);
//					EGRHLRSN,        SN: 18,     Length: 1,     Begin: 58
					ary=new byte[1];
					System.arraycopy(bb, 66, ary, 0, 1);
					EGRHLRSN=StringUtil.toHex(ary);
//					MPS,        SN: 19,     Length: 1,     Begin: 59
					ary=new byte[1];
					System.arraycopy(bb, 67, ary, 0, 1);
					MPS=StringUtil.toHex(ary);
//					RELAY,        SN: 20,     Length: 1,     Begin: 60
					ary=new byte[1];
					System.arraycopy(bb, 68, ary, 0, 1);
					RELAY=StringUtil.toHex(ary);
//					TAUTIMER,        SN: 21,     Length: 4,     Begin: 61
					ary=new byte[4];
					System.arraycopy(bb, 69, ary, 0, 4);
					TAUTIMER=StringUtil.toHex(ary);
//					MDT,        SN: 22,     Length: 1,     Begin: 65
					ary=new byte[1];
					System.arraycopy(bb, 73, ary, 0, 1);
					MDT=StringUtil.toHex(ary);

					stmt.setString(1, SID);
					stmt.setString(2, PROFILE_ID);
					stmt.setString(3, EPS_PROFILE_ID);
					stmt.setString(4, HLR_INDEX);
					stmt.setString(5, STNSR);
					stmt.setString(6, APNOI);
					stmt.setString(7, TGPPAMBRMAXUL);
					stmt.setString(8, TGPPAMBRMAXDL);
					stmt.setString(9, RATFREQSELPRI);
					stmt.setString(10, PLMNTPLID);
					stmt.setString(11, ICSIND);
					stmt.setString(12, DIAMNODETPL_ID);
					stmt.setString(13, NON3GPPSUPP);
					stmt.setString(14, NON3GPPRATTYPE);
					stmt.setString(15, MIP6FEAVEC);
					stmt.setString(16, SESSIONTIMEOUT);
					stmt.setString(17, CSGTPLID);
					stmt.setString(18, EGR);
					stmt.setString(19, EGRHLRSN);
					stmt.setString(20, MPS);
					stmt.setString(21, RELAY);
					stmt.setString(22, TAUTIMER);
					stmt.setString(23, MDT);
					stmt.addBatch();
					
//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			pw.flush();

			pw.close();
			dos.close();
			fos.close();
			

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_EPSSTAINFO During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	
	private static void W_IMSIAPNDYNINFO(String dir, String filename, int Table_Id) {

		String SID="",IMSI="",SERSELECTION="",HLR_INDEX="",CONTEXTID="",MIPHAHOST="",MIPHAREALM="",MIPHAADDRIPV4="",MIPHAADDRIPV6="",WILDCARDFLAG="",VNI="",TIME_STAMP="",LOCATION_ID="";


		try {
			fos = new FileOutputStream(dir + filename + "_W_IMSIAPNDYNINFO.TXT", true);
			dos = new DataOutputStream(fos);
			pw = new PrintWriter(dos);

			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into W_IMSIAPNDYNINFO (SID,IMSI,SERSELECTION,HLR_INDEX,CONTEXTID,MIPHAHOST,MIPHAREALM,MIPHAADDRIPV4,MIPHAADDRIPV6,WILDCARDFLAG,VNI,TIME_STAMP,LOCATION_ID) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
					long addr1,addr2;

					bis.read(bb);
//					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					addr1=StringUtil.reversedVal(ary, 0);
					System.arraycopy(bb, 4, ary, 0, 4);
					addr2=StringUtil.reversedVal(ary, 0);
					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;

//					SID,        SN: 0,     Length: 8,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 8, ary, 0, 8);
					SID=StringUtil.toHex(ary);
//					IMSI,        SN: 1,     Length: 8,     Begin: 8
					ary=new byte[8];
					System.arraycopy(bb, 16, ary, 0, 8);
					IMSI=StringUtil.toHex(ary);
					IMSI=IMSI.substring(0, IMSI.indexOf("f"));
//					SERSELECTION,        SN: 2,     Length: 12,     Begin: 16
					ary=new byte[12];
					System.arraycopy(bb, 24, ary, 0, 12);
					SERSELECTION=StringUtil.toHex(ary);
//					HLR_INDEX,        SN: 3,     Length: 1,     Begin: 28
					ary=new byte[1];
					System.arraycopy(bb, 36, ary, 0, 1);
					HLR_INDEX=StringUtil.toHex(ary);
//					CONTEXTID,        SN: 4,     Length: 1,     Begin: 29
					ary=new byte[1];
					System.arraycopy(bb, 37, ary, 0, 1);
					CONTEXTID=StringUtil.toHex(ary);
//					MIPHAHOST,        SN: 5,     Length: 12,     Begin: 30
					ary=new byte[12];
					System.arraycopy(bb, 38, ary, 0, 12);
					MIPHAHOST=StringUtil.toHex(ary);
//					MIPHAREALM,        SN: 6,     Length: 12,     Begin: 42
					ary=new byte[12];
					System.arraycopy(bb, 50, ary, 0, 12);
					MIPHAREALM=StringUtil.toHex(ary);
//					MIPHAADDRIPV4,        SN: 7,     Length: 4,     Begin: 54
					ary=new byte[4];
					System.arraycopy(bb, 62, ary, 0, 4);
					MIPHAADDRIPV4=StringUtil.toHex(ary);
//					MIPHAADDRIPV6,        SN: 8,     Length: 16,     Begin: 58
					ary=new byte[16];
					System.arraycopy(bb, 66, ary, 0, 16);
					MIPHAADDRIPV6=StringUtil.toHex(ary);
//					WILDCARDFLAG,        SN: 9,     Length: 1,     Begin: 74
					ary=new byte[1];
					System.arraycopy(bb, 82, ary, 0, 1);
					WILDCARDFLAG=StringUtil.toHex(ary);
//					VNI,        SN: 10,     Length: 12,     Begin: 75
					ary=new byte[12];
					System.arraycopy(bb, 83, ary, 0, 12);
					VNI=StringUtil.toHex(ary);
//					TIME_STAMP,        SN: 11,     Length: 4,     Begin: 87
					ary=new byte[4];
					System.arraycopy(bb, 95, ary, 0, 4);
					TIME_STAMP=sdf.format(StringUtil.reversedVal(ary, 0)*1000L);
//					LOCATION_ID,        SN: 12,     Length: 1,     Begin: 91
					ary=new byte[1];
					System.arraycopy(bb, 99, ary, 0, 1);
					LOCATION_ID=StringUtil.toHex(ary);

					stmt.setString(1, SID);
					stmt.setString(2, IMSI);
					stmt.setString(3, SERSELECTION);
					stmt.setString(4, HLR_INDEX);
					stmt.setString(5, CONTEXTID);
					stmt.setString(6, MIPHAHOST);
					stmt.setString(7, MIPHAREALM);
					stmt.setString(8, MIPHAADDRIPV4);
					stmt.setString(9, MIPHAADDRIPV6);
					stmt.setString(10, WILDCARDFLAG);
					stmt.setString(11, VNI);
					stmt.setString(12, TIME_STAMP);
					stmt.setString(13, LOCATION_ID);
					stmt.addBatch();
					
//					pw.println("0x"+Long.toHexString(addr1)+",0x"+Long.toHexString(addr2)+":"+StringUtil.toHex(bb));

			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			pw.flush();

			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("W_IMSIAPNDYNINFO During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	
	private static void DSIDXCHECK(String dir, String filename, int Table_Id) {

		String INDEXID="",INDEXNAME="",TABLENAME="",ISPK="",DSACTION="",REFINDEX="";


		try {
			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into DSIDXCHECK (INDEXID,INDEXNAME,TABLENAME,ISPK,DSACTION,REFINDEX) values(?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point+8);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
			
					bis.read(bb);
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
//					INDEXID,        SN: 0,     Length: 4,     Begin: 0
					ary=new byte[8];
					System.arraycopy(bb, 0, ary, 0, 4);
					INDEXID=StringUtil.toHex(ary);
//					INDEXNAME,        SN: 1,     Length: 12,     Begin: 4
					ary=new byte[12];
					System.arraycopy(bb, 4, ary, 0, 12);
					INDEXNAME=StringUtil.toHex(ary);
//					TABLENAME,        SN: 2,     Length: 12,     Begin: 16
					ary=new byte[12];
					System.arraycopy(bb, 16, ary, 0, 12);
					TABLENAME=StringUtil.toHex(ary);
//					ISPK,        SN: 3,     Length: 1,     Begin: 28
					ary=new byte[1];
					System.arraycopy(bb, 28, ary, 0, 1);
					ISPK=StringUtil.toHex(ary);
//					DSACTION,        SN: 4,     Length: 1,     Begin: 29
					ary=new byte[1];
					System.arraycopy(bb, 29, ary, 0, 1);
					DSACTION=StringUtil.toHex(ary);
//					REFINDEX,        SN: 5,     Length: 4,     Begin: 30
					ary=new byte[4];
					System.arraycopy(bb, 30, ary, 0, 4);
					REFINDEX=StringUtil.toHex(ary);

					stmt.setString(1, INDEXID);
					stmt.setString(2, INDEXNAME);
					stmt.setString(3, TABLENAME);
					stmt.setString(4, ISPK);
					stmt.setString(5, DSACTION);
					stmt.setString(6, REFINDEX);
					stmt.addBatch();
			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("DSIDXCHECK During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	
	private static void DSIDXFIELDS(String dir, String filename, int Table_Id) {

		String INDEXID="",TABLENAME="",FIELDNAME="",QUERY_PRIOR="";


		try {
			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into DSIDXFIELDS (INDEXID,TABLENAME,FIELDNAME,QUERY_PRIOR) values(?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point+8);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
			
					bis.read(bb);
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
//					INDEXID,        SN: 0,     Length: 4,     Begin: 0
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					INDEXID=StringUtil.toHex(ary);
//					TABLENAME,        SN: 1,     Length: 12,     Begin: 4
					ary=new byte[12];
					System.arraycopy(bb, 4, ary, 0, 12);
					TABLENAME=StringUtil.toHex(ary);
//					FIELDNAME,        SN: 2,     Length: 12,     Begin: 16
					ary=new byte[12];
					System.arraycopy(bb, 16, ary, 0, 12);
					FIELDNAME=StringUtil.toHex(ary);
//					QUERY_PRIOR,        SN: 3,     Length: 1,     Begin: 28
					ary=new byte[1];
					System.arraycopy(bb, 28, ary, 0, 1);
					QUERY_PRIOR=StringUtil.toHex(ary);

					stmt.setString(1, INDEXID);
					stmt.setString(2, TABLENAME);
					stmt.setString(3, FIELDNAME);
					stmt.setString(4, QUERY_PRIOR);
					stmt.addBatch();
			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("DSIDXFIELDS During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	
	private static void US_DATAVERSION(String dir, String filename, int Table_Id) {

		String APPTYPE="",APPNAME="",VERSION="",TIME="",DESCRIPTION="",FLAG="";


		try {
			long begin_time, end_time;
			begin_time = System.currentTimeMillis();
			
			Connection conn=null;
			PreparedStatement stmt=null;
			conn=DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into US_DATAVERSION (APPTYPE,APPNAME,VERSION,TIME,DESCRIPTION,FLAG) values(?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			long Start_Point;
			Long Next_Point=a3[Table_Id];
			FileInputStream fis ;
			DataInputStream dis ;
			BufferedInputStream bis ;
			byte[] bb=new byte[a7[Table_Id]];
			byte[] address=new byte[0x20];
			while(Next_Point>0){
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Next_Point);
				bis.read(address);
				if(Next_Point==StringUtil.reversedVal(address, 0)) {
					bis.close();
					dis.close();
					fis.close();
					break;
				}
				Next_Point=StringUtil.reversedVal(address, 0);
				Start_Point=StringUtil.reversedVal(address, 0x10);
				bis.close();
				dis.close();
				fis.close();
				
				fis = new FileInputStream(dir + filename);
				dis = new DataInputStream(fis);
				bis = new BufferedInputStream(dis);
				bis.skip(Start_Point+8);
				for(int i=0;i<a8[Table_Id];i++){
					byte[] ary;
			
					bis.read(bb);
					if((bb[0]&0xff)==0 && (bb[1]&0xff)==0 && (bb[2]&0xff)==0 && (bb[3]&0xff)==0) continue;
//					APPTYPE,        SN: 0,     Length: 4,     Begin: 0
					ary=new byte[4];
					System.arraycopy(bb, 0, ary, 0, 4);
					APPTYPE=StringUtil.toHex(ary);
//					APPNAME,        SN: 1,     Length: 12,     Begin: 4
					ary=new byte[12];
					System.arraycopy(bb, 4, ary, 0, 12);
					APPNAME=StringUtil.toHex(ary);
//					VERSION,        SN: 2,     Length: 12,     Begin: 16
					ary=new byte[12];
					System.arraycopy(bb, 16, ary, 0, 12);
					VERSION=StringUtil.toHex(ary);
//					TIME,        SN: 3,     Length: 12,     Begin: 28
					ary=new byte[12];
					System.arraycopy(bb, 28, ary, 0, 12);
					TIME=StringUtil.toHex(ary);
//					DESCRIPTION,        SN: 4,     Length: 12,     Begin: 40
					ary=new byte[12];
					System.arraycopy(bb, 40, ary, 0, 12);
					DESCRIPTION=StringUtil.toHex(ary);
//					FLAG,        SN: 5,     Length: 2,     Begin: 52
					ary=new byte[2];
					System.arraycopy(bb, 52, ary, 0, 2);
					FLAG=StringUtil.toHex(ary);

					stmt.setString(1, APPTYPE);
					stmt.setString(2, APPNAME);
					stmt.setString(3, VERSION);
					stmt.setString(4, TIME);
					stmt.setString(5, DESCRIPTION);
					stmt.setString(6, FLAG);
					stmt.addBatch();
			    }
			    stmt.executeBatch();
			bis.close();
			dis.close();
			fis.close();
			}
			
			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println("US_DATAVERSION During:   " + (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

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
