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
	private String fnumber;
	private String sex;
	private Double weight;
	private String contactInfo;
	private String description;
	
	public Judges() {
		// TODO Auto-generated constructor stub
	}




	public Judges(Integer fid, String name, String fnumber, String sex, Double weight, String contactInfo,
			String description) {
		super();
		this.fid = fid;
		this.name = name;
		this.fnumber = fnumber;
		this.sex = sex;
		this.weight = weight;
		this.contactInfo = contactInfo;
		this.description = description;
	}

	

	public String getFnumber() {
		return fnumber;
	}




	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}




	public String getContactInfo() {
		return contactInfo;
	}




	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "Judges [fid=" + fid + ", name=" + name + ", fnumber=" + fnumber + ", sex=" + sex + ", weight=" + weight
				+ ", contactInfo=" + contactInfo + ", description=" + description + "]";
	}




	
	
}
