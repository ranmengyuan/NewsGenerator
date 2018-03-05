package com.RDNH.news;

import java.sql.SQLException;
import java.util.ArrayList;

import com.RDNH.bean.BaseInfo;
import com.RDNH.bean.Player;
import com.RDNH.dao.LiveMessageDAO;
import com.RDNH.dao.RankDAO;
import com.RDNH.dao.TeamDAO;
import com.RDNH.helper.connectionPool;

public class Rank {
	
		/**
	 * 判断是否线性表中是否已经存在这个球队
	 */
	int find(ArrayList<BaseInfo> info,String name)
	{
		int index=-1;
		int i=0;
		for(i=0;i<info.size();i++){
			if(name.equals(info.get(i).getName())==true)
			{
				index=i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * 进行排名
	 */
	public ArrayList<BaseInfo> range(ArrayList<BaseInfo> info)
	{
		int i=0;
		int j=0;
		BaseInfo temp=new BaseInfo();
		for(i=0;i<info.size()-1;i++){
			for(j=0;j<info.size()-1-i;j++){
				if(info.get(j).getWinSum()<info.get(j+1).getWinSum()){
					temp.copy(info.get(j));
					info.get(j).copy(info.get(j+1));
					info.get(j+1).copy(temp);
				}
				else if(info.get(j).getWinSum()==info.get(j+1).getWinSum()&&info.get(j).getShootSum()<info.get(j+1).getShootSum()){
					temp.copy(info.get(j));
					info.get(j).copy(info.get(j+1));
					info.get(j+1).copy(temp);
				}
			}
		}
		return info;
	}
	
	
	/**
	 * 根据比赛战纪，对球队进行排名
	 * @throws Exception 
	 */
	public void getRank() throws Exception
	{
		ArrayList<BaseInfo> info=new ArrayList<BaseInfo>();
		connectionPool cp=new connectionPool();		
		TeamDAO team=new TeamDAO(cp);
		RankDAO ope=new RankDAO(cp);
		LiveMessageDAO goal=new LiveMessageDAO(cp);
		String[] name=new String[2];
		int[] score=new int[2];
		int[] shoots=new int[2];
		for(int i=1;i<31;i++){
			BaseInfo tempInfo1=new BaseInfo();
			BaseInfo tempInfo2=new BaseInfo();
			name=team.getTeam(i);
			score=goal.getScore(i);
			shoots=team.getTeamShoots(i);
			tempInfo1.setName(name[0]);
			tempInfo2.setName(name[1]);
			if(score[0]>score[1]){
				tempInfo1.setWinSum(1);
				tempInfo2.setWinSum(0);	
			}
			else if(score[0]<score[1]){
				tempInfo1.setWinSum(0);
				tempInfo2.setWinSum(1);	
			}
			else if(score[0]==score[1]){
				tempInfo1.setWinSum(1);
				tempInfo2.setWinSum(1);	
			}
			if(shoots[0]>shoots[1]){
				tempInfo1.setShootSum(1);
				tempInfo2.setShootSum(0);
			}
			else if(shoots[0]<shoots[1]){
				tempInfo1.setShootSum(0);
				tempInfo2.setShootSum(1);
			}
			else if(shoots[0]==shoots[1])
			{
				tempInfo1.setShootSum(1);
				tempInfo2.setShootSum(1);
			}
			int index=find(info,name[0]);
			if(index!=-1){
				int temp=0;
				if(tempInfo1.getWinSum()==1){
					temp=info.get(index).getWinSum();
					temp++;
					info.get(index).setWinSum(temp);
				}
				if(tempInfo1.getShootSum()==1){
					temp=info.get(index).getShootSum();
					temp++;
					info.get(index).setShootSum(temp);
				}
			}
			else if(find(info,name[0])==-1)
				info.add(tempInfo1);
			index=find(info,name[1]);
			if(index!=-1){
				index=find(info,name[1]);
				int temp=0;
				if(tempInfo2.getWinSum()==1){
					temp=info.get(index).getWinSum();
					temp++;
					info.get(index).setWinSum(temp);
				}
				if(tempInfo2.getShootSum()==1){
					temp=info.get(index).getShootSum();
					temp++;
					info.get(index).setShootSum(temp);
				}
			}
			else if(find(info,name[1])==-1)
				info.add(tempInfo2);
		}
		ArrayList<BaseInfo> result=range(info);
		for(int i=0;i<result.size();i++)
			ope.insertRankTable(result.get(i));
		
		
	}
}
