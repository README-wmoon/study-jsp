package com.jspex.beans;

public class MemberVO {
	private int num;
	private String name;
	private String brithday;
	
	public MemberVO() {
		this.name ="이름이 없습니다.";
		this.brithday = "생일이 등록되지 않았습니다.";	
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrithday() {
		return brithday;
	}
	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}
}
