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
	private String cmpt_fid;
	private String compititor;
	private String judges;
	private String course;
	private String grade;
	
	public Scoring() {
		// TODO Auto-generated constructor stub
	}

	public Scoring(Integer fid, String cmpt_fid, String compititor, String judges, String course, String grade) {
		super();
		this.fid = fid;
		this.cmpt_fid = cmpt_fid;
		this.compititor = compititor;
		this.judges = judges;
		this.course = course;
		this.grade = grade;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getCmpt_fid() {
		return cmpt_fid;
	}

	public void setCmpt_fid(String cmpt_fid) {
		this.cmpt_fid = cmpt_fid;
	}

	public String getCompititor() {
		return compititor;
	}

	public void setCompititor(String compititor) {
		this.compititor = compititor;
	}

	public String getJudges() {
		return judges;
	}

	public void setJudges(String judges) {
		this.judges = judges;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Scoring [fid=" + fid + ", cmpt_fid=" + cmpt_fid + ", compititor=" + compititor + ", judges=" + judges
				+ ", course=" + course + ", grade=" + grade + "]";
	}
	
	

	


	
	
	
}
