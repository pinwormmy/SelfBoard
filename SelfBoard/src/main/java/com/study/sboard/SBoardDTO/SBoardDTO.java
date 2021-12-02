package com.study.sboard.SBoardDTO;

import java.sql.Timestamp;

public class SBoardDTO {
	
	private int sno;
	private String writer;
	private String title;
	private String content;
	private Timestamp writingtime; 
	private int view_cnt;
	private String postpassword;
	private int authority; // 로그인 여부에 따른 게시물 권한부여. 관리자 0. 회원1. 비회원2.
	private int countComment;
	
	
	public int getSno() {
		return sno;
	}
	public String getWriter() {
		return writer;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	
	public Timestamp getWritingtime() {
		return writingtime;
	}
	public void setWritingtime(Timestamp writingtime) {
		this.writingtime = writingtime;
	}
	public String getPostpassword() {
		return postpassword;
	}
	public void setPostpassword(String postpassword) {
		this.postpassword = postpassword;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public int getCountComment() {
		return countComment;
	}
	public void setCountComment(int countComment) {
		this.countComment = countComment;
	}
	
	
}
	