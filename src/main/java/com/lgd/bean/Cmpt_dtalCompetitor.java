package com.lgd.bean;

import java.io.Serializable;

public class Cmpt_dtalCompetitor implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9028975623443846491L;
	private Integer fid;
	private String competition;
	private String competitor;
	private String course;
	
	public Cmpt_dtalCompetitor() {
		// TODO Auto-generated constructor stub
	}

	public Cmpt_dtalCompetitor(Integer fid, String competition, String competitor, String course) {
		super();
		this.fid = fid;
		this.competition = competition;
		this.competitor = competitor;
		this.course = course;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getCompetition() {
		return competition;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	public String getCompetitor() {
		return competitor;
	}

	public void setCompetitor(String competitor) {
		this.competitor = competitor;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cmpt_dtalCompetitor [fid=" + fid + ", competition=" + competition + ", competitor=" + competitor
				+ ", course=" + course + "]";
	}
	
	
}
