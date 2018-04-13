package com.lgd.bean;

import java.io.Serializable;

/**
 * 
 * --参赛者
create table compititor(
	fid int primary key auto_increment,
	name varchar(30) not null,
	sex varchar(4), 
	age  smallint ,
	description varchar(4000)
)
 *
 */
public class Competitor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3164209685550953986L;
	
	
	private Integer fid;
	private String name;
	private String sex;
	private Integer age;
	private String description;
	
	public Competitor() {
		// TODO Auto-generated constructor stub
	}

	public Competitor(Integer fid, String name, String sex, Integer age, String description) {
		super();
		this.fid = fid;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.description = description;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Competitor [fid=" + fid + ", name=" + name + ", sex=" + sex + ", age=" + age + ", description="
				+ description + "]";
	}
	
	
}
