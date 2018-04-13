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
public class Cmpt_dtal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3904976016798338635L;
	
	
	private Integer fid;
	private Integer cmpt_fid;
	private Integer compititor;
	private Integer judges;
	
	public Cmpt_dtal() {
		// TODO Auto-generated constructor stub
	}
	
	public Cmpt_dtal(Integer fid, Integer cmpt_fid, Integer compititor, Integer judges) {
		super();
		this.fid = fid;
		this.cmpt_fid = cmpt_fid;
		this.compititor = compititor;
		this.judges = judges;
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

	@Override
	public String toString() {
		return "Cmpt_dtal [fid=" + fid + ", cmpt_fid=" + cmpt_fid + ", compititor=" + compititor + ", judges=" + judges
				+ "]";
	}
	
	
}
