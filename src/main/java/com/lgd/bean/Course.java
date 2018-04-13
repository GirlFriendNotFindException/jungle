package com.lgd.bean;

import java.io.Serializable;

/**
 * 
 * --定义详细的打分科目项
create table course(
	fid int primary key auto_increment,
	name varchar(30) not null,
	weight double ,   --权重 0< x <=1  所有科目权重之和等于1  
	description  varchar(4000)
)
 *
 */
public class Course implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1502601202940065782L;
	
	
	private Integer fid;
	private String name;
	private Double weight;
	private String description;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(Integer fid, String name, Double weight, String description) {
		super();
		this.fid = fid;
		this.name = name;
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
		return "Course [fid=" + fid + ", name=" + name + ", weight=" + weight + ", description=" + description + "]";
	}
	

}
