package com.RDNH.bean;

public class Team {
	
	private String name;
	private int isHome;
	private int shoots;//�诲��ㄦ��
	private int shootOnTargets;//灏�姝ｆ��
	private int noShootOnTargets;//灏�����
	private int hitDoorFrame;//�讳腑�ㄦ���
	private int throughPass;//�村�����
	private int offSide;//瓒�浣�
	private int steal;//�㈡��
	private int freekick;//浠绘����
	private int fouls;//�荤��瑙���
	private int corner;//瑙���
	private int throwball;//��澶���
	private int longball;//�夸�
	private float passSuccessRate;//浼���������
	private float midPassSuccessRate;//浼�涓�������
	private float stealSuccessRate;//�㈡��������
	private float headerSuccessRate;//澶寸��������
	private float ballControlRate;//�х����
	
	public Team() {
		// TODO Auto-generated constructor stub
		name="";
		isHome=0;
		shoots=0;
		shootOnTargets=0;
		noShootOnTargets=0;
		hitDoorFrame=0;
		throughPass=0;
		offSide=0;
		steal=0;
		freekick=0;
		fouls=0;
		corner=0;
		throwball=0;
		longball=0;
		passSuccessRate=0;
		midPassSuccessRate=0;
		stealSuccessRate=0;
		headerSuccessRate=0;
		ballControlRate=0;
	}
	
	public int getIsHome() {
		return isHome;
	}

	public void setIsHome(int isHome) {
		this.isHome = isHome;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getShoots() {
		return shoots;
	}
	public void setShoots(int shots) {
		this.shoots = shots;
	}
	public int getShootOnTargets() {
		return shootOnTargets;
	}
	public void setShootOnTargets(int shotOnTargets) {
		this.shootOnTargets = shotOnTargets;
	}
	public int getNoShootOnTargets() {
		return noShootOnTargets;
	}
	public void setNoShootOnTargets(int noShotOnTargets) {
		this.noShootOnTargets = noShotOnTargets;
	}
	public int getHitDoorFrame() {
		return hitDoorFrame;
	}
	public void setHitDoorFrame(int hitDoorFrame) {
		this.hitDoorFrame = hitDoorFrame;
	}
	public int getThroughPass() {
		return throughPass;
	}
	public void setThroughPass(int throughPass) {
		this.throughPass = throughPass;
	}
	public int getOffSide() {
		return offSide;
	}
	public void setOffSide(int offSide) {
		this.offSide = offSide;
	}
	public int getSteal() {
		return steal;
	}
	public void setSteal(int steal) {
		this.steal = steal;
	}
	public int getFreekick() {
		return freekick;
	}
	public void setFreekick(int freekick) {
		this.freekick = freekick;
	}
	public int getFouls() {
		return fouls;
	}
	public void setFouls(int fouls) {
		this.fouls = fouls;
	}
	public int getCorner() {
		return corner;
	}
	public void setCorner(int corner) {
		this.corner = corner;
	}
	public int getThrowball() {
		return throwball;
	}
	public void setThrowball(int throwball) {
		this.throwball = throwball;
	}
	public int getLongball() {
		return longball;
	}
	public void setLongball(int longball) {
		this.longball = longball;
	}
	public float getPassSuccessRate() {
		return passSuccessRate;
	}
	public void setPassSuccessRate(float passSuccessRate) {
		this.passSuccessRate = passSuccessRate;
	}
	public float getMidPassSuccessRate() {
		return midPassSuccessRate;
	}
	public void setMidPassSuccessRate(float midPassSuccessRate) {
		this.midPassSuccessRate = midPassSuccessRate;
	}
	public float getStealSuccessRate() {
		return stealSuccessRate;
	}
	public void setStealSuccessRate(float stealSuccessRate) {
		this.stealSuccessRate = stealSuccessRate;
	}
	public float getHeaderSuccessRate() {
		return headerSuccessRate;
	}
	public void setHeaderSuccessRate(float headerSuccessRate) {
		this.headerSuccessRate = headerSuccessRate;
	}
	public float getBallControlRate() {
		return ballControlRate;
	}
	public void setBallControlRate(float ballControlRate) {
		this.ballControlRate = ballControlRate;
	}
}

