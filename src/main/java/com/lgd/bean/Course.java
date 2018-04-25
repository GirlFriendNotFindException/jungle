package com.lgd.bean;

import java.io.Serializable;
import java.util.Date;

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
	private String fnumber;
	private String name;
	private Double weight;
	private String creator;
	private Date createdate   ;
	private String description;
	
	private String courseDescription;
	private String coursename;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}


	
	public Course(Integer fid, String fnumber, String name, Double weight, String creator, Date createdate,
			String description, String courseDescription, String coursename) {
		super();
		this.fid = fid;
		this.fnumber = fnumber;
		this.name = name;
		this.weight = weight;
		this.creator = creator;
		this.createdate = createdate;
		this.description = description;
		this.courseDescription = courseDescription;
		this.coursename = coursename;
	}



	public String getCourseDescription() {
		return courseDescription;
	}



	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}



	public String getCoursename() {
		return coursename;
	}



	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}



	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getFnumber() {
		return fnumber;
	}

	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Course [fid=" + fid + ", fnumber=" + fnumber + ", name=" + name + ", weight=" + weight + ", creator="
				+ creator + ", createdate=" + createdate + ", description=" + description + ", courseDescription="
				+ courseDescription + ", coursename=" + coursename + "]";
	}

	

}
