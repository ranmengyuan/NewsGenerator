package com.RDNH.news;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.RDNH.bean.LiveMessage;
import com.RDNH.bean.Player;
import com.RDNH.dao.AwayTeamDAO;
import com.RDNH.dao.HomeTeamDAO;
import com.RDNH.dao.LiveMessageDAO;
import com.RDNH.dao.RankDAO;
import com.RDNH.dao.TeamDAO;
import com.RDNH.helper.CreateTable;
import com.RDNH.helper.connectionPool;

public class FormNews {

	/**
	 * 生成新闻标题
	 */
	public void title(LiveMessageDAO goal,TeamDAO team,RankDAO rank,int i) {
//		connectionPool cp = new connectionPool();
//		LiveMessageDAO goal = new LiveMessageDAO(cp);
//		TeamDAO team = new TeamDAO(cp);
//		RankDAO rank = new RankDAO(cp);
		String[] name = new String[2];
		int[] score = new int[2];
		int[] info1 = new int[3];
		int[] info2 = new int[3];
		name = team.getTeam(i);
		score = goal.getScore(i);
		info1 = rank.getRank(name[0]);
		info2 = rank.getRank(name[1]);
		if (info1[0] < info2[0]) {
			String temp;
			int temp1 = 0;

			temp = name[0];
			name[0] = name[1];
			name[1] = temp;

			temp1 = score[0];
			score[0] = score[1];
			score[1] = temp1;

			temp1 = info1[0];
			info1[0] = info2[0];
			info2[0] = temp1;

			temp1 = info1[1];
			info1[1] = info2[1];
			info2[1] = temp1;

			temp1 = info1[2];
			info1[2] = info2[2];
			info2[2] = temp1;
		}
		if (info1[0] != info2[0] && score[0] < score[1]) {
			System.out.println(name[1] + "轻松拿下" + name[0]);
		} else if (info1[0] != info2[0] && score[0] == score[1]) {
			System.out.println(name[0] + "鏖战" + name[1] + "以" + score[0] + ":" + score[1] + "战平");
		} else if (info1[0] != info2[0] && score[0] > score[1]) {
			System.out.println(name[0] + "以" + score[0] + ":" + score[1] + "打脸" + name[1]);
		} else if (info1[0] == info2[0] && score[0] == score[1]) {
			System.out.println(name[0] + "对阵宿敌" + name[1] + "难分胜负");
		} else if (info1[0] == info2[0] && score[0] < score[1]) {
			System.out.println(name[1] + "小宇宙爆发，" + score[1] + ":" + score[0] + "拿下" + name[0]);
		} else if (info1[0] == info2[0] && score[0] < score[1]) {
			System.out.println(name[0] + "被宿敌" + name[1] + "以" + score[0] + ":" + score[1] + "斩杀");
		}
	}

	/**
	 * 获得一场比赛的时间信息
	 */
	public String getTime(ArrayList<String> text) {
		int i = 0;
		int min = 0;
		int max = 1;
		String time = null;
		for (i = 0; i < text.size(); i++) {
			if (text.get(i).contains("北京时间") == true) {
				time = text.get(i);
				break;
			}
		}
		if (time != null) {
			int m = 0;
			for (m = 0; m < time.length(); m++) {
				if (time.charAt(m) == '北') {
					min = m;
				} else if (time.contains("：") == true) {
					if (time.charAt(m) == '：') {
						max = m + 3;
						break;
					}
				} else if (time.contains("分") == true) {
					if (time.charAt(m) == '分') {
						max = m + 1;
						break;
					}
				} else if (time.contains("点") == true) {
					if (time.charAt(m) == '点') {
						max = m + 1;
						break;
					}
				} else {
					if (time.charAt(m) == '日' || time.charAt(m) == '号') {
						max = m + 1;
						break;
					}
				}
			}
			if (m == time.length())
				max = time.length();
			time = time.substring(min, max);
		}
		return time;
	}

	public String[] getInfo(ArrayList<String> text) {
		int i = 0;
		String[] info = new String[2];
		info[0] = null;
		info[1] = null;
		if (text != null) {
			for (i = 0; i < text.size(); i++) {
				if ((text.get(i).contains("英超") == true)) {
					info[0] = "英超";
					int min = 0;
					int max = 1;
					for (int j = 0; j < text.get(i).length(); j++) {
						if (text.get(i).charAt(j) == '超') {
							if (j < text.get(i).length() - 1 && text.get(i).charAt(j + 1) == '第') {
								min = j + 1;
							} else if (j < text.get(i).length() - 3 && text.get(i).charAt(j + 3) == '第')
								min = j + 3;
							else
								break;
						} else if (text.get(i).charAt(j) == '轮') {
							max = j + 1;
							break;
						}
					}
					if (min != 0 && max != 1) {
						info[1] = text.get(i).substring(min, max);
						break;
					}
				} else if ((text.get(i).contains("西甲") == true)) {
					info[0] = "西甲";
					int min = 0;
					int max = 1;
					for (int j = 0; j < text.get(i).length(); j++) {
						if (text.get(i).charAt(j) == '甲') {
							if (j < text.get(i).length() - 1 && text.get(i).charAt(j + 1) == '第') {
								min = j + 1;
							} else if (j < text.get(i).length() - 3 && text.get(i).charAt(j + 3) == '第')
								min = j + 3;
							else
								break;
						} else if (text.get(i).charAt(j) == '轮') {
							max = j + 1;
							break;
						}
					}
					if (min != 0 && max != 1) {
						info[1] = text.get(i).substring(min, max);
						break;
					}
				} else if ((text.get(i).contains("第") == true && text.get(i).contains("轮") == true)) {
					int min = 0;
					int max = 1;
					for (int j = 0; j < text.get(i).length(); j++) {
						if (text.get(i).charAt(j) == '第') {
							min = j;
						} else if (text.get(i).charAt(j) == '轮') {
							max = j + 1;
							break;
						}
					}
					if (max - min < 6 && min != 0 && max != 1) {
						info[1] = text.get(i).substring(min, max);
					}
				} else if ((text.get(i).contains("欧冠") == true)) {
					info[0] = "欧冠";
					int min = 0;
					int max = 1;
					for (int j = 0; j < text.get(i).length(); j++) {
						if (text.get(i).charAt(j) == '冠') {
							min = j + 1;
						} else if (text.get(i).charAt(j) == '赛') {
							max = j + 1;
							break;
						}
					}
					if (max - min < 8) {
						info[1] = text.get(i).substring(min, max);
						break;
					}
				}
			}
		}
		return info;
	}

	/**
	 * 生成第一段
	 */
	public void firstSentence(LiveMessageDAO live,TeamDAO team,int i) {
//		connectionPool cp = new connectionPool();
//		LiveMessageDAO live = new LiveMessageDAO(cp);
//		TeamDAO team = new TeamDAO(cp);
		ArrayList<String> text = new ArrayList<String>();
		String[] name = new String[2];
		text = live.getTextFirst(i);
		name = team.getTeam(i);
		String time = getTime(text);
		String[] info = getInfo(text);
		if (time != null && info[0] != null && info[1] != null)
			System.out.println(time + "," + info[0] + info[1] + name[0] + "主场对战" + name[1] + "。");
		else if (time == null && info[0] != null && info[1] != null)
			System.out.println(info[0] + info[1] + name[0] + "主场对战" + name[1] + "。");
		else if (time == null && info[0] == null && info[1] != null)
			System.out.println("联赛" + name[0] + "主场对战" + name[1] + "。");
		else if (time == null && info[0] != null && info[1] == null)
			System.out.println(info[0] + "联赛" + name[0] + "主场对战" + name[1] + "。");
		else if (time != null && info[0] != null && info[1] == null)
			System.out.println(time + "," + info[0] + "联赛" + name[0] + "主场对战" + name[1] + "。");
		else if (time != null && info[0] == null)
			System.out.println(time + "," + name[0] + "主场对战" + name[1] + "。");
	}

	/**
	 * 得到一个球队的守门员
	 * 
	 * @param team
	 * @return
	 */
	public String getGoalkeeper(ArrayList<Player> team) {
		String name = null;
		for (int i = 0; i < team.size(); i++) {
			if (team.get(i).getPlace().equals("门将") == true) {
				name = team.get(i).getName();
				break;
			}
		}
		return name;
	}

	/**
	 * 获得一个球队射门次数最多的几个球员
	 * 
	 * @param team
	 * @return
	 */
	public ArrayList<String> getShootPlayer(ArrayList<Player> team) {
		ArrayList<String> player = new ArrayList<String>();
		for (int i = 0; i < team.size() - 1; i++) {
			for (int j = 0; j < team.size() - i - 1; j++) {
				if (team.get(j).getShoot() < team.get(j + 1).getShoot()) {
					Player tempName = new Player();
					tempName.copy(team.get(j));
					team.get(j).copy(team.get(j + 1));
					team.get(j + 1).copy(tempName);
				}
			}
		}
		int i = 0;
		while (i != team.size()) {
			player.add(team.get(i).getName());
			if (i > 3)
				break;
			i++;
		}
		return player;
	}

	/**
	 * 获得一个球队进球的几个球员
	 * 
	 * @param team
	 * @return
	 */
	public ArrayList<String> getGoalPlayer(ArrayList<Player> team) {
		ArrayList<String> player = new ArrayList<String>();
		for (int i = 0; i < team.size(); i++) {
			if (team.get(i).getGoal() != 0) {
				player.add(team.get(i).getName());
			}
		}
		return player;
	}

	/**
	 * 生成第二段的新闻概况
	 */
	public void secondSentence(TeamDAO team,LiveMessageDAO goal,AwayTeamDAO awayTeam,HomeTeamDAO homeTeam,int i) {
//		connectionPool cp = new connectionPool();
//		TeamDAO team = new TeamDAO(cp);
//		LiveMessageDAO goal = new LiveMessageDAO(cp);
//		AwayTeamDAO awayTeam = new AwayTeamDAO(cp);
//		HomeTeamDAO homeTeam = new HomeTeamDAO(cp);
		ArrayList<Player> away = new ArrayList<Player>();
		ArrayList<Player> home = new ArrayList<Player>();
		int[] score = new int[2];
		int[] shoot = new int[2];
		String[] name = new String[2];
		shoot = team.getTeamShoots(i);
		name = team.getTeam(i);
		score = goal.getScore(i);
		away = awayTeam.getAwayTeam(i);
		home = homeTeam.getHomeTeam(i);
		ArrayList<String> shootplayer = new ArrayList<String>();
		ArrayList<String> goalplayer = new ArrayList<String>();
		if (score[0] != score[1]) {
			if (score[0] > score[1]) {
				goalplayer = getGoalPlayer(home);
				for (int j = 0; j < goalplayer.size(); j++)
					System.out.print(goalplayer.get(j) + ",");
				System.out.print("主场发威，有所斩获，");
				System.out.println(name[0] + "主场以" + score[0] + "-" + score[1] + "战胜" + name[1] + "。");
			} else {
				goalplayer = getGoalPlayer(away);
				for (int j = 0; j < goalplayer.size(); j++)
					System.out.print(goalplayer.get(j) + ",");
				System.out.print("客场发挥出色，为球队进球，");
				System.out.println(name[0] + "主场以" + score[0] + "-" + score[1] + "负于" + name[1] + "。");
			}
		} else if (score[0] == score[1]) {
			if (shoot[0] > shoot[1]) {
				String goalkeeper = getGoalkeeper(away);
				System.out.print("全场比赛" + name[0] + "射门次数多达" + shoot[0] + "次,");
				shootplayer = getShootPlayer(home);
				for (int j = 0; j < shootplayer.size(); j++)
					System.out.print(shootplayer.get(j) + ",");
				System.out.print("均有极佳的进球机会，");
				System.out.println("但是" + name[1] + "门将" + goalkeeper + "表现出色" + name[0] + "无奈只能接受" + score[0] + "-"
						+ score[1] + "的结果" + "。");
			} else if (shoot[0] < shoot[1]) {
				String goalkeeper = getGoalkeeper(home);
				System.out.print("全场比赛" + name[1] + "射门次数多达" + shoot[1] + "次,");
				shootplayer = getShootPlayer(away);
				for (int j = 0; j < shootplayer.size(); j++)
					System.out.print(shootplayer.get(j) + ",");
				System.out.println("均有机会进球,但是" + name[0] + "门将" + goalkeeper + "表现出色" + name[1] + "无奈只能接受" + score[1]
						+ "-" + score[0] + "的结果" + "。");
			} else {
				System.out.print("全场比赛" + name[1] + "射门次数多达" + shoot[1] + "次,");
				shootplayer = getShootPlayer(away);
				for (int j = 0; j < shootplayer.size(); j++)
					System.out.print(shootplayer.get(j) + ",");
				shootplayer = getShootPlayer(home);
				for (int j = 0; j < shootplayer.size(); j++)
					System.out.print(shootplayer.get(j) + ",");
				System.out.println("均有机会进球,但是" + "双方门将" + "表现出色" + name[1] + "与" + "握手言和" + "。");
			}
		}
	}

	/**
	 * 获得射门时的直播文本
	 */
	public void getShootText(LiveMessageDAO live,int game) {
//		connectionPool cp = new connectionPool();
//		LiveMessageDAO live = new LiveMessageDAO(cp);
		ArrayList<LiveMessage> message = new ArrayList<LiveMessage>();
		message = live.getTextBody(game);
		int i = 0;
		try {
			String filename = "//Volumes//Transcend//Java//RDNH//dictionary.txt";
			InputStreamReader isr = new InputStreamReader(new FileInputStream(filename), "UTF-8");
			BufferedReader reader = new BufferedReader(isr);
			ArrayList<String> line = new ArrayList<String>();
			line.add(reader.readLine());
			while (line.get(i) != null) {
				i++;
				line.add(reader.readLine());
			}
			for (int j = 0; j < message.size(); j++) {
				for (int m = 0; m < line.size() - 1; m++) {
					String temp1 = message.get(j).getText();
					String temp2 = line.get(m);
					if (temp1.contains(temp2) == true) {
						if (message.get(j).getStart() == 1) {
							System.out.println("上半场，第" + message.get(j).getTime() + "分钟," + message.get(j).getText());
						} else if (message.get(j).getStart() == 2) {
							System.out.println("下半场，第" + message.get(j).getTime() + "分钟," + message.get(j).getText());
						}
						j++;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 生成新闻的主体部分
	 */
	public void body(LiveMessageDAO live,int i) {
		getShootText(live,i);
	}

	/**
	 * 生成最后一段的球员信息
	 */
	public void lastSentence(AwayTeamDAO awayTeam,HomeTeamDAO homeTeam,TeamDAO team,int i) {
//		connectionPool cp = new connectionPool();
//		AwayTeamDAO awayTeam = new AwayTeamDAO(cp);
//		HomeTeamDAO homeTeam = new HomeTeamDAO(cp);
		String[] name = new String[2];
//		TeamDAO team = new TeamDAO(cp);
		ArrayList<Player> away = new ArrayList<Player>();
		ArrayList<Player> home = new ArrayList<Player>();
		String lastAway = null;
		String lastHome = null;
		lastAway = null;
		lastHome = null;
		name = team.getTeam(i);
		away = awayTeam.getAwayTeam(i);
		home = homeTeam.getHomeTeam(i);
		lastAway = name[0] + "首发：";
		lastHome = name[1] + "首发：";
		for (int j = 0; j < away.size(); j++) {
			if (away.get(j).isFirst() == 1) {
				if (away.get(j).getTime() == 90) {
					lastAway = lastAway + away.get(j).getNumber() + "-" + away.get(j).getName() + ";";
				} else {
					for (int k = 0; k < away.size(); k++) {
						if (away.get(k).getTime() + away.get(j).getTime() == 90) {
							lastAway = lastAway + away.get(j).getNumber() + "-" + away.get(j).getName() + "("
									+ away.get(k).getTime() + "'," + away.get(k).getName() + ")" + ";";
							break;
						}
					}
				}
			}
		}
		for (int j = 0; j < home.size(); j++) {
			if (home.get(j).isFirst() == 1) {
				if (home.get(j).getTime() == 90) {
					lastHome = lastHome + home.get(j).getNumber() + "-" + home.get(j).getName() + ";";
				} else {
					for (int k = 0; k < home.size(); k++) {
						if (home.get(k).getTime() + home.get(j).getTime() == 90) {
							lastHome = lastHome + home.get(j).getNumber() + "-" + home.get(j).getName() + "("
									+ home.get(k).getTime() + "'," + home.get(k).getName() + ")" + ";";
							break;
						}
					}
				}
			}
		}
		System.out.println(lastAway);
		System.out.println(lastHome);
		System.out.println();
	}

}
