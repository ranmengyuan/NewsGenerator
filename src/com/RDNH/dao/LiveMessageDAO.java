package com.RDNH.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.RDNH.bean.LiveMessage;
import com.RDNH.helper.connectionPool;
/**
 * 创建连接
 * @author ranmengyuan
 *
 */
public class LiveMessageDAO {
	connectionPool cp;
	Connection conn;
	public LiveMessageDAO(connectionPool cp){
		this.cp=cp;
		try {
			this.conn=cp.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 *  在LiveMessage表格中插入数据
	 * @param game
	 * @param line
	 * @throws SQLException
	 */
	public void insertLiveMessage(int game,String[] line) throws SQLException {
		PreparedStatement stmt=null;
 	    int awayTeamScore=0;
 	    int homeTeamScore=0;
 	    int time=0;
 	    int start=0;
 	    homeTeamScore=Integer.parseInt(line[2].split("-")[0]);
 	    awayTeamScore=Integer.parseInt(line[2].split("-")[1]);
 	   String[] temp=line[1].split(" ");
 	    if(line[1].equals("未赛")==true)
 	    {
 	    	time=0;
 	    	start=0;		 	    	
 	    }
 	    else if(line[1].equals("完赛")==true){
 	    	time=0;
 	    	start=4;
 	    }
 	   else if(line[1].equals("中场")==true){
 	    	time=0;
 	    	start=3;
 	    }		 	   
 	    else{
 	    	
	 	    	if(temp[0].equals("上半场")==true){
	 	    		start=1;
	 	    	}
	 	    	else{
	 	    		start=2;
	 	    	}
	 	    	if(temp.length==2)
	 	    		time=Integer.parseInt(temp[1].substring(0,temp[1].length()-1));
	 	    	else
	 	    		time=0;

 	    	
 	    }
		String sql = "insert into LiveMessage(game,text,homeTeamScore,awayTeamScore,start,time)VALUES('"+game+"','"+line[0]+"','"+homeTeamScore+"','"+awayTeamScore+"','"+start+"','"+time+"')";
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
			 System.out.println(game+"   "+line[0]+"   "+homeTeamScore+"   "+awayTeamScore+"    "+start+"    "+time);
		}finally {			
			cp.returnConnection(conn);			
		}

	}
	public int[] getScore(int game)
	{
		ResultSet ret = null;
		PreparedStatement stmt=null;
		int[] score=new int[2];
		String sql ="select homeTeamScore,awayTeamScore from LiveMessage where game='"+game+"'";
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			ret=stmt.executeQuery();
			 while (ret.next()) {  
	            	   score[0]=ret.getInt(1);
	            	   score[1]=ret.getInt(2);            	   
	            }          
			ret.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return score;
	}
	/**
	 * 获取未赛的比赛信息
	 * @param game
	 * @return
	 */
	public ArrayList<String> getTextFirst(int game)
	{
		ResultSet ret = null;
		PreparedStatement stmt=null;
		ArrayList<String> text=new ArrayList<String>();
		String sql ="select text,start from LiveMessage where game='"+game+"'";
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			ret=stmt.executeQuery();
			 while (ret.next()) {
				 if(ret.getInt(2)!=0){
					 break;
				 }
	            	   text.add(ret.getString(1));         	   
	            }          
			ret.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return text;
	}
	/**
	 * 获得比赛时的直播信息
	 * @param game
	 * @return
	 */
	public ArrayList<LiveMessage> getTextBody(int game)
	{
		ResultSet ret = null;
		PreparedStatement stmt=null;
		ArrayList<LiveMessage> text=new ArrayList<LiveMessage>();
		String sql ="select text,homeTeamScore,awayTeamScore,start,time from LiveMessage where game='"+game+"'";
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			ret=stmt.executeQuery();
			 while (ret.next()) {
				 if(ret.getInt(4)!=0){
					 LiveMessage temp=new LiveMessage();
					 temp.setText(ret.getString(1));
					 temp.setHomeTeamScore(ret.getInt(2));
					 temp.setAwayTeamScore(ret.getInt(3));
					 temp.setStart(ret.getInt(4));
					 temp.setTime(ret.getInt(5));
					 text.add(temp); 
				 }         	   
	            }          
			ret.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return text;
	}

}
