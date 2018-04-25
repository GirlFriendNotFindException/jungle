package com.lgd.bean;

import java.io.Serializable;

/**
 * 
 * --比赛记录打分表
create table scoring(
	fid int  primary key auto_increment,
	cmpt_fid int references comptition(fid),
	compititor varchar(30) not null, 
	judges varchar(30) not null ,
	course varchar(30) references course(name),
	grade smallint 
);
 *
 */
public class Scoring implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3346102656558758293L;
	/**
	 * 
	 */
	private Integer fid;
	private Integer cmpt_fid;
	private Integer compititor;
	private Integer judges;
	private Integer course;
	private Integer grade;
	
	public Scoring() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Integer getFid() {
		return fid;
	}



	public void setFid(Integer fid) {
		this.fid = fid;
	}



	public Integer getCmpt_fid() {
		return cmpt_fid;
	}



	public void setCmpt_fid(Integer cmpt_fid) {
		this.cmpt_fid = cmpt_fid;
	}



	public Integer getCompititor() {
		return compititor;
	}



	public void setCompititor(Integer compititor) {
		this.compititor = compititor;
	}



	public Integer getJudges() {
		return judges;
	}



	public void setJudges(Integer judges) {
		this.judges = judges;
	}



	public Integer getCourse() {
		return course;
	}



	public void setCourse(Integer course) {
		this.course = course;
	}



	public Integer getGrade() {
		return grade;
	}



	public void setGrade(Integer grade) {
		this.grade = grade;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Scoring(Integer fid, Integer cmpt_fid, Integer compititor, Integer judges, Integer course, Integer grade) {
		super();
		this.fid = fid;
		this.cmpt_fid = cmpt_fid;
		this.compititor = compititor;
		this.judges = judges;
		this.course = course;
		this.grade = grade;
	}



	@Override
	public String toString() {
		return "Scoring [fid=" + fid + ", cmpt_fid=" + cmpt_fid + ", compititor=" + compititor + ", judges=" + judges
				+ ", course=" + course + ", grade=" + grade + "]";
	}
	
	
	
}
