package com.RDNH.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	connectionPool cp;
	Connection conn = null;
	/**
	 * 建立连接
	 * @param cp
	 */
	public CreateTable(connectionPool cp) {
		
		this.cp = cp;
		try {
			this.conn=cp.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * 初始化所有表格
 */
	public void InitalTable() {
		try {
			dropAwayTeamTable();
			dropHomeTeamTable();
			dropLiveMessageTable();
			dropTeamTable();
			createAwayTeamTable();
			createHomeTeamTable();
			createLiveMessageTable();
			createTeamTable();
			dropRankTable();
			createRankTable();
			freePool();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
/**
 * 删除AwayTeam表格
 */
	public void dropAwayTeamTable() {
	
		Statement stmt = null;

		String sql = " drop table if exists AwayTeam";
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			System.out.println("drop AwayTeam table sucess!");
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("drop AwayTeam table failed!");
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cp.returnConnection(conn);
		}
	}
/**
 * 删除HomeTeam表格
 */
	public void dropHomeTeamTable() {

		Statement stmt = null;

		String sql = " drop table if exists HomeTeam";
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			System.out.println("drop HomeTeam table success");
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("drop HomeTeam table failed!");
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cp.returnConnection(conn);
		}
	}
	/**
	 * 删除LiveMessage表格
	 */
	public void dropLiveMessageTable() {

		Statement stmt = null;

		String sql = " drop table if exists LiveMessage";
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			System.out.println("drop LiveMessage table success");
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("drop LiveMessage table failed!");
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cp.returnConnection(conn);
		}
	}
	/**
	 * 删除Team表格
	 */
	public void dropTeamTable() {
		Statement stmt = null;

		String sql = " drop table if exists Team";
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			System.out.println("drop Team table success");
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("drop Team table failed!");
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cp.returnConnection(conn);
		}
	}
	/**
	 * 删除Rank表格
	 */
	public void dropRankTable(){
		Statement stmt = null;

		String sql = " drop table if exists BaseInfo";
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			System.out.println("drop BaseInfo table success");
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("drop BaseInfo table failed!");
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cp.returnConnection(conn);
		}
	}
	
	/**
	 * 创建AwayTable表格，并设置属性
	 * @param args
	 */

	public void createAwayTeamTable() throws SQLException {
		Statement stmt = null;
		String sql = "create table AwayTeam ("
				+ "ID int NOT NULL AUTO_INCREMENT, "
				+"game int, " +"number int, " +"name varchar(255), " +"place varchar(255), " +"isFirst int, " +"time int, " +"goal int, " +"assists int, " +"threatball int, " +"shoot int, " +"shootOnTarget int, " +"shootOnTargetRate float, " +"foul int, " +"fouled int, " +
				"save int,"
				+ "primary key(ID))"
				+ "ENGINE=InnoDB DEFAULT CHARSET=gb2312";
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			stmt.close();
			System.out.println("create AwayTeam table success!");
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("create AwayTeam table failed!");
		} finally {			
			cp.returnConnection(conn);
		}
	}
	/**
	 * 建立HomeTeam表格
	 * @throws SQLException
	 */
	public void createHomeTeamTable() throws SQLException {
		Statement stmt = null;
		String sql = "create table HomeTeam ("
				+ "ID int NOT NULL AUTO_INCREMENT, "
				+"game int, " +"number int, " +"name varchar(255), " +"place varchar(255), " +"isFirst int, " +"time int, " +"goal int, " +"assists int, " +"threatball int, " +"shoot int, " +"shootOnTarget int, " +"shootOnTargetRate float, " +"foul int, " +"fouled int, " +
				"save int,"
				+ "primary key(ID))"
				+ "ENGINE=InnoDB  DEFAULT CHARSET=gb2312";
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			stmt.close();
			System.out.println("create HomeTeam table success!");
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("create HomeTeam table  failed!");
		} finally {			
			cp.returnConnection(conn);
		}
	}
/**
 * 建立LiveMessage表格
 * @throws SQLException
 */
	public void createLiveMessageTable() throws SQLException {
		Statement stmt = null;
		String sql = "create table LiveMessage ("+"ID int  NOT NULL AUTO_INCREMENT, "
				+"game int, " +"text varchar(255), " +"homeTeamScore int, " +"awayTeamScore int, " +"start int, " +"time int, "
				+ "primary key(ID))"
				+ "ENGINE=InnoDB DEFAULT CHARSET=gb2312";
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			stmt.close();
			System.out.println("create LiveMessage table success!");
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("create LiveMessage table failed!");
		} finally {			
			cp.returnConnection(conn);
		}
	}	
	
	/**
	 * 建立球队信息表
	 * @throws SQLException
	 */
	public void createTeamTable() throws SQLException {
		Statement stmt = null;
		String sql = "create table Team ("+"ID int  NOT NULL AUTO_INCREMENT, "
				+"game int, " +"name varchar(255), "+"isHome int, "  +"shoots int, " +"shootOnTargets int, " +"noShootOnTargets int, " +"hitDoorFrame int, "+"throughPass int, "+"offSide int, "+"steal int, "+"freeKick int, "
				+"fouls int, "+"corner int, "+"throwball int, "+"longball int, "+"passSuccessRate float, "+"midPassSuccessRate float, "+"stealSuccessRate float, "+"headerSuccessRate float, "+"ballControlRate float, "
				+ "primary key(ID))"
				+ "ENGINE=InnoDB DEFAULT CHARSET=gb2312";
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			stmt.close();
			System.out.println("create Team table success!");
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("create Team table failed!");
		} finally {			
			cp.returnConnection(conn);
		}
	}	
	/**
	 * 建立球队排名
	 * @throws SQLException
	 */
	public void createRankTable() throws SQLException{
		Statement stmt = null;
		String sql = "create table BaseInfo ("+"ID int  NOT NULL AUTO_INCREMENT, "
				+"name varchar(255), "+"winSum int, "  +"shootSum int, " 
				+ "primary key(ID))"
				+ "ENGINE=InnoDB DEFAULT CHARSET=gb2312";
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
			stmt.close();
			System.out.println("create Rank table success!");
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("create Rank table failed!");
		} finally {			
			cp.returnConnection(conn);
		}
	}
	
	
	/**
	 * 释放连接池
	 */
	public void freePool() {
		try {
			cp.closeConnectionPool();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

