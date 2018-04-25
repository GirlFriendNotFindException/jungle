package com.lgd.bean;

import java.io.Serializable;

/**
 * 
 * --赛事明细表  记录参赛者以及评委
create table cmpt_dtal(
	fid int  primary key auto_increment,
	cmpt_fid int references comptition(fid) ,   
	compititor varchar(30) not null, 
	judges varchar(30) not null 
)

alter table cmpt_dtal modify compititor int;
alter table cmpt_dtal modify judges int;
 *
 */
public class Cmpt_dtalJudges implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3904976016798338635L;
	
	
	private Integer fid;
	private String competition;
	private String judges;
	private String course;
	
	public Cmpt_dtalJudges() {
		// TODO Auto-generated constructor stub
	}


	
	
	public Cmpt_dtalJudges(Integer fid, String competition, String judges, String course) {
		super();
		this.fid = fid;
		this.competition = competition;
		this.judges = judges;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Cmpt_dtalJudges [fid=" + fid + ", competition=" + competition + ", judges=" + judges + ", course="
				+ course + "]";
	}
	
}
