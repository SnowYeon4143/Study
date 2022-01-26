package com.kh.app17.vo;

import java.sql.Date;

public class GalleryVo {

	private int no;
	private String title;
	private String content;
	private String fname;
	private long fsize;
	private String ftype;
	private Date enrollDate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public long getFsize() {
		return fsize;
	}
	public void setFsize(long fsize) {
		this.fsize = fsize;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	@Override
	public String toString() {
		return "GalleryVo [no=" + no + ", title=" + title + ", content=" + content + ", fname=" + fname + ", fsize="
				+ fsize + ", ftype=" + ftype + ", enrollDate=" + enrollDate + "]";
	}
	
}
