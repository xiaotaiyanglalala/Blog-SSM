package com.open.blog.entity;

import java.util.List;

public class AdminUser {

	private int uid;
	private String username;
	private String password;
	private String phone;
	private String email;
	private String crtime;
	private String state;
	private int rid;
	private List<Role> roles;
	private Role role;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCrtime() {
		return crtime;
	}
	public void setCrtime(String crtime) {
		this.crtime = crtime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "AdminUser [uid=" + uid + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", email=" + email + ", crtime=" + crtime + ", state=" + state + ", roles=" + roles + ", role=" + role
				+ ", getUid()=" + getUid() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail() + ", getCrtime()=" + getCrtime()
				+ ", getState()=" + getState() + ", getRoles()=" + getRoles() + ", getRole()=" + getRole() + "]";
	}
	
	
}
