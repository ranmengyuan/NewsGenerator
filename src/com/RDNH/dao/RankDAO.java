package com.RDNH.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.RDNH.bean.BaseInfo;
import com.RDNH.helper.connectionPool;

public class RankDAO {
	connectionPool cp;
	Connection conn;
	public RankDAO(connectionPool cp){
		this.cp=cp;
		try {
			this.conn=cp.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 在BaseInfo表中插入球队排名
	 * @param info
	 * @throws SQLException
	 */
	public void insertRankTable(BaseInfo info) throws SQLException {
		PreparedStatement stmt=null; 
		String sql = "insert into BaseInfo(name,winSum,shootSum)VALUES('"+info.getName()+"','"+info.getWinSum()+"','"+info.getShootSum()+"')";           
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			stmt.close();
		}
		catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();		
			System.out.println(info.getName()+"  "+info.getWinSum()+"  "+info.getShootSum());
		}finally {			
			cp.returnConnection(conn);			
		}
	}
	/**
	 * 获得球队的排名以及不败场数和射门次数多的场数
	 * @param game
	 * @return
	 */
	public int[] getRank(String name){
		ResultSet ret = null;
		PreparedStatement stmt=null;
		int[] info=new int[3];
		String sql ="select ID,winSum,shootSum from BaseInfo where name='"+name+"'";
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			ret=stmt.executeQuery();
			 while (ret.next()) {  
	            	   info[0]=ret.getInt(1);
	            	   info[1]=ret.getInt(2);
	            	   info[2]=ret.getInt(3);
	            }          
			ret.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return info;
	}
}
