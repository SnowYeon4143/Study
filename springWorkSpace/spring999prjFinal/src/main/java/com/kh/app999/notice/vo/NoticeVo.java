package com.kh.app999.notice.vo;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVo {
	private long no;
	private String title;
	private String content;
	private long writer; //회원 번호
	private Date enroll;
	private String del; //Y, N
	private String userNick;
}
