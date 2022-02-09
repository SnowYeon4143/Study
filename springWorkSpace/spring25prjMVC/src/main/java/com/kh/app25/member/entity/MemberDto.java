package com.kh.app25.member.entity;

import lombok.Data;

//@Data
public class MemberDto {
	private String id;
	private String pwd;
	private String nick;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pwd=" + pwd + ", nick=" + nick + "]";
	}
	
}
