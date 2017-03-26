package com.open.blog.entity;

import java.util.List;

public class Role {
	
	private int rid;
	private String name;
	private String introduce;
	private String state;
	private List<AdminUser> users;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<AdminUser> getUsers() {
		return users;
	}
	public void setUsers(List<AdminUser> users) {
		this.users = users;
	}
}
