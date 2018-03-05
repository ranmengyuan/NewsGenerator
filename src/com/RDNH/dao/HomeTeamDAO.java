package com.RDNH.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.RDNH.bean.Player;
import com.RDNH.helper.connectionPool;

public class HomeTeamDAO {
	connectionPool cp;
	Connection conn;
	/**
	 * 创建连接
	 * @param cp
	 */
	public HomeTeamDAO(connectionPool cp){
		this.cp=cp;
		try {
			this.conn=cp.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 在HomeTeam中插入数据
	 * @param game
	 * @param line
	 * @throws SQLException
	 */
	public void insertHomeTeam(int game,String[] line) throws SQLException {
		PreparedStatement stmt=null;
		int number=0;
	    int isFirst=0;
	    int time=0;
	    int goal=0;
	    int assists=0;
	    int threatball=0;
	    int shoot=0;
	    int shootOnTarget=0;
	    float shootOnTargetRate=0.0f;
	    int foul=0;
	    int fouled=0;
	    int save=0;
	    if(line[3].equals("首发")==true)
	    	isFirst=1;
	    if(line[9].equals("0")==true)
	    	shootOnTargetRate=0;
	    else
	    	shootOnTargetRate=Float.parseFloat(line[10].substring(0,line[10].length()-1))/100;
	    number=Integer.parseInt(line[0]);
	    time=Integer.parseInt(line[4].substring(0,line[4].length()-1));
	    goal=Integer.parseInt(line[5]);
	    assists=Integer.parseInt(line[6]);
	    threatball=Integer.parseInt(line[7]);
	    shoot=Integer.parseInt(line[8]);
	    shootOnTarget=Integer.parseInt(line[9]);
	    foul=Integer.parseInt(line[11]);
	    fouled=Integer.parseInt(line[12]);
	    save=Integer.parseInt(line[13]);
		String sql = "insert into HomeTeam(game,number,place,name,isFirst,time,goal,assists,threatball,shoot,shootOnTarget,shootOnTargetRate,foul,fouled,save)VALUES('"+game+"','"+number+"','"+line[1]+"','"+line[2]+"','"+isFirst+"','"+time+"','"+goal+"','"+assists+"','"+threatball+"','"+shoot+"','"+shootOnTarget+"','"+shootOnTargetRate+"','"+foul+"','"+fouled+"','"+save+"')";           
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
			System.out.println(game+" "+number+"  "+line[1]+"   "+line[2]+"  "+isFirst+"   "+time+"   "+goal+"   "+assists+"   "+threatball+"   "+shoot+"   "+shootOnTarget+"   "+shootOnTargetRate+"   "+foul+"   "+fouled+"   "+save);
		}finally {			
			cp.returnConnection(conn);			
		}

	}
	/**
	 * 从数据库中获取某一场比赛的数据
	 * @param game
	 * @return
	 */
	public ArrayList<Player> getHomeTeam(int game){
		ResultSet ret = null;
		PreparedStatement stmt=null;
		ArrayList<Player> player=new ArrayList<Player>();
		String sql ="select number,name,place,isFirst,time,goal,shoot from HomeTeam where game='"+game+"'";
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			ret=stmt.executeQuery();
			 while (ret.next()) {  
				 Player temp=new Player();
	               temp.setNumber(ret.getInt(1));
	               temp.setName(ret.getString(2));
	               temp.setPlace(ret.getString(3));
	               temp.setFirst(ret.getInt(4));
	               temp.setTime(ret.getInt(5));
	               temp.setGoal(ret.getInt(6));
	               temp.setShoot(ret.getInt(7));
	               player.add(temp);
	            }          
			ret.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}		
		return player;
	}
}
