package huawei;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import dao.DBUtils;
import decoder.StringUtil;

public class check {

	public static void ret_2(String dir, String hlr_name, String sql, String file_name) {

		try {
			long begin_time, end_time;
			begin_time = System.currentTimeMillis();

			Connection conn = null;
			PreparedStatement stmt = null;
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);
			
			ResultSet rs = null;

			stmt = conn.prepareStatement(sql);

			FileOutputStream fos = new FileOutputStream(file_name);
			DataOutputStream dos = new DataOutputStream(fos);
			PrintWriter pw = new PrintWriter(dos);
			
			rs=stmt.executeQuery();
			while(rs.next()){
				String str1=rs.getString(1);
				String str2=rs.getString(2);
				pw.println(str1+","+str2);
			}
			pw.flush();
			
			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println(file_name +":"+ (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}

	public static void ret_1(String dir, String hlr_name, String sql, String file_name) {

		try {
			long begin_time, end_time;
			begin_time = System.currentTimeMillis();

			Connection conn = null;
			PreparedStatement stmt = null;
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);
			
			ResultSet rs = null;

			stmt = conn.prepareStatement(sql);

			FileOutputStream fos = new FileOutputStream(file_name);
			DataOutputStream dos = new DataOutputStream(fos);
			PrintWriter pw = new PrintWriter(dos);
			
			rs=stmt.executeQuery();
			while(rs.next()){
				String str1=rs.getString(1);
				pw.println(str1);
			}
			pw.flush();
			
			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println(file_name +":"+ (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}

	public static void ret(String dir, String hlr_name, String sql, String file_name) {

		try {
			long begin_time, end_time;
			begin_time = System.currentTimeMillis();

			Connection conn = null;
			PreparedStatement stmt = null;
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);
			
			ResultSet rs = null;
			ResultSetMetaData m=null;
			int columns=0;

			stmt = conn.prepareStatement(sql);

			FileOutputStream fos = new FileOutputStream(file_name);
			DataOutputStream dos = new DataOutputStream(fos);
			PrintWriter pw = new PrintWriter(dos);
			
			rs=stmt.executeQuery();
			m=rs.getMetaData();
			columns=m.getColumnCount();
			
			while(rs.next()){
				String str1="";
				for(int i=1;i<columns+1;i++)
					str1+=rs.getString(i)+",";
				pw.println(str1);
			}
			pw.flush();
			
			pw.close();
			dos.close();
			fos.close();

			stmt.close();
			conn.close();

			end_time = System.currentTimeMillis();
			System.out.println(file_name +":"+ (end_time - begin_time));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// add this section}
		}

	}
	
}
