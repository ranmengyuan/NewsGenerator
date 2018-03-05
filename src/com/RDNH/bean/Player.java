package com.RDNH.bean;
/*
 * ����绫�
 */

public class Player {
	int number=0;//�����风��
	String name="";//������
	String place="";//�歌��浣�缃�
	int isFirst=0;//����棣���  1�� 0涓���
	int time=0;//�哄�烘�堕��
	int goal=0;//杩�����
	int assists=0;//�╂�绘��
	int threatball=0;//濞�������
	int shoot=0;//灏��ㄦ��
	int shootOnTarget=0;//灏�姝ｆ��
	float shootOnTargetRate=0;//灏�姝ｇ��
	int foul=0;//��瑙���
	int fouled=0;//琚���瑙���
	int save=0;//������
	
	public void copy(Player temp){
		this.number=temp.getNumber();
		this.name=temp.getName();
		this.place=temp.getPlace();
		this.isFirst=temp.getIsFirst();
		this.time=temp.getTime();
		this.goal=temp.getGoal();
		this.assists=temp.getAssists();
		this.threatball=temp.getThreatball();
		this.shoot=temp.getShoot();
		this.shootOnTarget=temp.getShotOnTarget();
		this.shootOnTargetRate=temp.getShotOnTargetRate();
		this.foul=temp.getFoul();
		this.fouled=temp.getFouled();
		this.save=temp.getSave();
	}
	
	public int getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(int isFirst) {
		this.isFirst = isFirst;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int isFirst() {
		return isFirst;
	}
	public void setFirst(int isFirst) {
		this.isFirst = isFirst;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public int getAssists() {
		return assists;
	}
	public void setAssists(int assists) {
		this.assists = assists;
	}
	public int getThreatball() {
		return threatball;
	}
	public void setThreatball(int threatball) {
		this.threatball = threatball;
	}
	public int getShoot() {
		return shoot;
	}
	public void setShoot(int shoot) {
		this.shoot = shoot;
	}
	public int getShotOnTarget() {
		return shootOnTarget;
	}
	public void setShotOnTarget(int shotOnTarget) {
		this.shootOnTarget = shotOnTarget;
	}
	public float getShotOnTargetRate() {
		return shootOnTargetRate;
	}
	public void setShotOnTargetRate(float shotOnTargetRate) {
		this.shootOnTargetRate = shotOnTargetRate;
	}
	public int getFoul() {
		return foul;
	}
	public void setFoul(int foul) {
		this.foul = foul;
	}
	public int getFouled() {
		return fouled;
	}
	public void setFouled(int fouled) {
		this.fouled = fouled;
	}
	public int getSave() {
		return save;
	}
	public void setSave(int save) {
		this.save = save;
	}
	
}
