package com.eeit48.webProject.service;

public class Member {
	
	private String member_id;
	private String user_name;
	private String password;
	private String email;
//	private String birthday;
	private String tel;
	private String addr;
	
	



	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public String getbirthday() {
//		return birthday;
//	}
//	public void setbirthday(String birthday) {
//		this.birthday = birthday;
//	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
