package com.lgd.bean;

import java.io.Serializable;

/**
 * --评委
create table judges(
	fid int primary key auto_increment,
	name varchar(30) not null,
	sex varchar(4), 
	weight double ,    --权重   处理一票否决   或者必须某位评委通过   或设置某位评委权重  默认值0 
					   --为0的评委平分剩下的权重
	description varchar(4000)
)
 * 
 */

public class Judges implements Serializable{

	private static final long serialVersionUID = -3551096070342942278L;
	/**
	 * 
	 */
	private Integer fid;
	private String name;
	private String sex;
	private Double weight;
	private String description;
	
	public Judges() {
		// TODO Auto-generated constructor stub
	}

	public Judges(Integer fid, String name, String sex, Double weight, String description) {
		super();
		this.fid = fid;
		this.name = name;
		this.sex = sex;
		this.weight = weight;
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

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Judges [fid=" + fid + ", name=" + name + ", sex=" + sex + ", weight=" + weight + ", description="
				+ description + "]";
	}
	
}
