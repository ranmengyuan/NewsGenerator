package com.RDNH.bean;
/*
 * �存��淇℃��绫�
 */


public class LiveMessage {
	
	String text="";//��瀛�淇℃��
	int homeTeamScore=0;//涓婚��姣���
	int awayTeamScore=0;//瀹㈤��姣���
	int start=0;//0 ��璧�  1 涓����� 2 涓�����
	int time=0;//绗�������
	
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getHomeTeamScore() {
		return homeTeamScore;
	}
	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	public int getAwayTeamScore() {
		return awayTeamScore;
	}
	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	
}

