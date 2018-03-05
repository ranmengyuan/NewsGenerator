package com.RDNH.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.RDNH.helper.connectionPool;

public class TeamDAO {
	connectionPool cp;
	Connection conn;
	public TeamDAO(connectionPool cp){
		this.cp=cp;
		try {
			this.conn=cp.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 在Team表格中插入主场队数据
	 * @param game
	 * @param team1
	 * @throws SQLException
	 */
	public void insertTeamTable1(int game,String[] team1) throws SQLException {
		PreparedStatement stmt=null; 
		String sql = "insert into Team(game,name,isHome,shoots,shootOnTargets,noShootOnTargets,hitDoorFrame,throughPass,offSide,steal,freekick,fouls,corner,throwball,longball,passSuccessRate,midPassSuccessRate,stealSuccessRate,headerSuccessRate,ballControlRate)VALUES('"+game+"','"+team1[0]+"','"+Integer.parseInt("1")+"','"+Integer.parseInt(team1[1])+"','"+Integer.parseInt(team1[2])+"','"+Integer.parseInt(team1[3])+"','"+Integer.parseInt(team1[4])+"','"+Integer.parseInt(team1[5])+"','"+Integer.parseInt(team1[6])+"','"+Integer.parseInt(team1[7])+"','"+Integer.parseInt(team1[8])+"','"+Integer.parseInt(team1[9])+"','"+Integer.parseInt(team1[10])+"','"+Integer.parseInt(team1[11])+"','"+Integer.parseInt(team1[12])+"','"+Float.parseFloat(team1[13].substring(0,team1[13].length()-1))/100+"','"+Float.parseFloat(team1[14].substring(0,team1[14].length()-1))/100+"','"+Float.parseFloat(team1[15].substring(0,team1[15].length()-1))/100+"','"+Float.parseFloat(team1[16].substring(0,team1[16].length()-1))/100+"','"+Float.parseFloat(team1[17].substring(0,team1[17].length()-1))/100+"')";           
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
			System.out.println(game+"  "+team1[0]+"  "+1+"  "+Integer.parseInt(team1[1])+"   "+Integer.parseInt(team1[2])+"   "+Integer.parseInt(team1[3])+"   "+Integer.parseInt(team1[4])+"   "+Integer.parseInt(team1[5])+"   "+Integer.parseInt(team1[6])+"  "+Integer.parseInt(team1[7])+"    "+Integer.parseInt(team1[8])+"    "+Integer.parseInt(team1[9])+"    "+Integer.parseInt(team1[10])+"    "+Integer.parseInt(team1[11])+"    "+Integer.parseInt(team1[12])+"    "+Float.parseFloat(team1[13].substring(0,team1[13].length()-1))/100+"    "+Float.parseFloat(team1[14].substring(0,team1[14].length()-1))/100+"    "+Float.parseFloat(team1[15].substring(0,team1[15].length()-1))/100+"   "+Float.parseFloat(team1[16].substring(0,team1[16].length()-1))/100+"   "+Float.parseFloat(team1[17].substring(0,team1[17].length()-1))/100);
		}finally {			
			cp.returnConnection(conn);			
		}

	}
	/**
	 * 在Team表格中插入客场队数据
	 * @param game
	 * @param team2
	 * @throws SQLException
	 */
	public void insertTeamTable2(int game,String[] team2) throws SQLException {
		PreparedStatement stmt=null; 
		String sql = "insert into Team(game,name,isHome,shoots,shootOnTargets,noShootOnTargets,hitDoorFrame,throughPass,offSide,steal,freekick,fouls,corner,throwball,longball,passSuccessRate,midPassSuccessRate,stealSuccessRate,headerSuccessRate,ballControlRate)VALUES('"+game+"','"+team2[0]+"','"+Integer.parseInt("0")+"','"+Integer.parseInt(team2[1])+"','"+Integer.parseInt(team2[2])+"','"+Integer.parseInt(team2[3])+"','"+Integer.parseInt(team2[4])+"','"+Integer.parseInt(team2[5])+"','"+Integer.parseInt(team2[6])+"','"+Integer.parseInt(team2[7])+"','"+Integer.parseInt(team2[8])+"','"+Integer.parseInt(team2[9])+"','"+Integer.parseInt(team2[10])+"','"+Integer.parseInt(team2[11])+"','"+Integer.parseInt(team2[12])+"','"+Float.parseFloat(team2[13].substring(0,team2[13].length()-1))/100+"','"+Float.parseFloat(team2[14].substring(0,team2[14].length()-1))/100+"','"+Float.parseFloat(team2[15].substring(0,team2[15].length()-1))/100+"','"+Float.parseFloat(team2[16].substring(0,team2[16].length()-1))/100+"','"+Float.parseFloat(team2[17].substring(0,team2[17].length()-1))/100+"')";           
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
			System.out.println(game+"  "+team2[0]+"  "+0+"  "+Integer.parseInt(team2[1])+"   "+Integer.parseInt(team2[2])+"   "+Integer.parseInt(team2[3])+"   "+Integer.parseInt(team2[4])+"   "+Integer.parseInt(team2[5])+"   "+Integer.parseInt(team2[6])+"  "+Integer.parseInt(team2[7])+"    "+Integer.parseInt(team2[8])+"    "+Integer.parseInt(team2[9])+"    "+Integer.parseInt(team2[10])+"    "+Integer.parseInt(team2[11])+"    "+Integer.parseInt(team2[12])+"    "+Float.parseFloat(team2[13].substring(0,team2[13].length()-1))/100+"    "+Float.parseFloat(team2[14].substring(0,team2[14].length()-1))/100+"    "+Float.parseFloat(team2[15].substring(0,team2[15].length()-1))/100+"   "+Float.parseFloat(team2[16].substring(0,team2[16].length()-1))/100+"   "+Float.parseFloat(team2[17].substring(0,team2[17].length()-1))/100);
		}finally {			
			cp.returnConnection(conn);			
		}

	}
	/**
	 * 获得一场比赛球队的名字
	 * @param game
	 * @return
	 */
	public String[] getTeam(int game){
		ResultSet ret = null;
		PreparedStatement stmt=null;
		String[] team=new String[2];
		String sql ="select name,isHome from Team where game='"+game+"'";
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			ret=stmt.executeQuery();
			 while (ret.next()) {  
	               if(ret.getInt(2)==1)
	            	   team[0]=ret.getString(1);
	               else
	            	   team[1]=ret.getString(1);
	            	   
	            }          
			ret.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return team;
	}
	/**
	 * 获得球队一场比赛的所有射门数
	 * @param game
	 * @return
	 */
	public int[] getTeamShoots(int game)
	{
		ResultSet ret = null;
		PreparedStatement stmt=null;
		int[] shoots=new int[2];
		String sql ="select isHome,shoots from Team where game='"+game+"'";
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			ret=stmt.executeQuery();
			 while (ret.next()) {  
				 if(ret.getInt(1)==1)
	            	   shoots[0]=ret.getInt(2);
	               else
	            	   shoots[1]=ret.getInt(2);            	   
	            }          
			ret.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return shoots;
	}
}
