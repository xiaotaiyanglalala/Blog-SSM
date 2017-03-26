package com.open.blog.entity;

import java.util.List;

public class Article {
	
	private int id;
	private int userid;
	private String title;
	private String introduce;
	private String content;
	private int lookNum;
	private String ctime;
	private String source;
	private String state;
	private String author;
	private String omititle;
	private String keyword;
	private int assortid;
	private Assort assort;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLookNum() {
		return lookNum;
	}
	public void setLookNum(int lookNum) {
		this.lookNum = lookNum;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public Assort getAssort() {
		return assort;
	}
	public void setAssort(Assort assort) {
		this.assort = assort;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAssortid() {
		return assortid;
	}
	public void setAssortid(int assortid) {
		this.assortid = assortid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getOmititle() {
		return omititle;
	}
	public void setOmititle(String omititle) {
		this.omititle = omititle;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
