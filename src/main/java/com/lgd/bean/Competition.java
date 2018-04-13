package com.lgd.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * --赛事
create table comptition(
	fid int primary key auto_increment,
	name varchar(30) not null,
	venue varchar(50) ,   --举办地点
	organizers varchar(50),  --举办方
	holdDate date,
	description varchar(4000)
);
 *
 */
public class Competition implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6429455540190481802L;
	/**
	 * 
	 */
	
	
	
	private Integer fid;
	private String name;
	private String venue;
	private String organizers;
	private Date date;
	private String description;
	
	public Competition() {
		// TODO Auto-generated constructor stub
	}

	public Competition(Integer fid, String name, String venue, String organizers, Date date, String description) {
		super();
		this.fid = fid;
		this.name = name;
		this.venue = venue;
		this.organizers = organizers;
		this.date = date;
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

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getOrganizers() {
		return organizers;
	}

	public void setOrganizers(String organizers) {
		this.organizers = organizers;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Competition [fid=" + fid + ", name=" + name + ", venue=" + venue + ", organizers=" + organizers
				+ ", date=" + date + ", description=" + description + "]";
	}
	
}
