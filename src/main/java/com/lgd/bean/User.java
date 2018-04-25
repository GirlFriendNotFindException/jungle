package com.lgd.bean;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4649163435465339414L;
	private Integer fid;
	private String username;
	private String password;
	private String phone;
	private Integer usertype;
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(Integer fid, String username, String password, String phone, Integer usertype) {
		super();
		this.fid = fid;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.usertype = usertype;
	}



	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
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

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [fid=" + fid + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", usertype=" + usertype + "]";
	}

	
	
	
}
