package com.kh.app16.member.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MemberVo {
	
	private String id;
	private String pwd;
	private String nick;
	private List<MultipartFile> profileList;
	
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
	public List<MultipartFile> getProfileList() {
		return profileList;
	}
	public void setProfileList(List<MultipartFile> profileList) {
		this.profileList = profileList;
	}
	
//	public boolean isFileOk() {
//		if(profileList.get(0).isEmpty() || profileList.size() < 1 || profileList != null || profileList.get(0) != null) {
//			return false;
//		}
//		return true;
//	}
	
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", profileList=" + profileList + "]";
	}
	
}
