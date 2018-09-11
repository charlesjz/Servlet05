package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
//import entity.*;

public class TestDBUtils implements Serializable{

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
   	 long begin_time, end_time;
	 begin_time=System.currentTimeMillis();

		System.out.println(DBUtils.getConnection());
		Connection conn=null;
		PreparedStatement stmt=null;
		conn=DBUtils.getConnection();
		conn.setAutoCommit(false);
		
		String sql="insert into t02 (hlruid,id,c1) values(?,?,?)";
		stmt=conn.prepareStatement(sql);
		int hlruid=0;
		int id=8;
		String c1="T11";
		for (int i=0;i<1000;i++){
		for(int j=0;j<1000;j++){
//			HOS002 hos002=new HOS002();
//			id=j;
//			hos002.setHLRUID(hlruid);
//			hos002.setID(id);
//			hos002.setC1(c1);
//			list.add(hos002);
//			if(list.size()>=1000){
//				for (int i=0;i<list.size();i++){
//					stmt.setInt(1, list.get(i).getHLRUID());
//					stmt.setInt(2,list.get(i).getID());
//					stmt.setString(3, list.get(i).getC1());
//					stmt.addBatch();
//				}
//					stmt.executeBatch();
//				
//			}
			id=j;
			stmt.setInt(1, hlruid);
			stmt.setInt(2,id+i*1000);
			stmt.setString(3, c1);
			stmt.addBatch();

		}
		stmt.executeBatch();
		}
		
//				stmt.executeBatch();
		
		stmt.close();
		conn.commit();
		
		System.out.println("±£´æ³É¹¦");
		
		conn.close();
		
   	 end_time=System.currentTimeMillis();
     System.out.println("During:   "+(end_time-begin_time));

	}

}
