package com.study.sboard.SBoardVO;

import java.sql.Timestamp;

public class SBoardVO {
	
	private int sno;
	private String writer;
	private String title;
	private String content;
	private Timestamp writingtime; 
	private int view_cnt;
	
	
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
}
	