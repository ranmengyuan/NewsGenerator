package com.RDNH.bean;

public class BaseInfo {
	private String name;
	private int winSum;
	private int shootSum;
	
	public BaseInfo() {
		super();
		this.winSum = 0;
		this.shootSum = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWinSum() {
		return winSum;
	}
	public void setWinSum(int winSum) {
		this.winSum = winSum;
	}
	public int getShootSum() {
		return shootSum;
	}
	public void setShootSum(int shootSum) {
		this.shootSum = shootSum;
	}
	public void copy(BaseInfo temp)
	{
		this.name=temp.name;
		this.winSum=temp.winSum;
		this.shootSum=temp.shootSum;
	}
	

}
