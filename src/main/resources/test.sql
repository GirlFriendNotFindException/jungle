--实体     评委        参赛者       比赛      

--评委表
create database judges;

use judges;

--用户类型usertype 0：管理员  1：评委用户
create table user(
	fid int primary key auto_increment,
	username varchar(32),
	password varchar(32),
	phone  varchar(32),
	usertype  int                     
)


--评委
create table judges(
	fid int primary key auto_increment,
	
	name varchar(30) not null,
	sex varchar(4), 
	weight double ,    --权重   处理一票否决   或者必须某位评委通过   或设置某位评委权重  默认值0 
					   --为0的评委平分剩下的权重
	description varchar(4000)
)
alter table judges modify add column fnumber varchar(32) not null unique;
alter table judges  add column contatcInfo varchar(32) not null ;

--参赛者
create table compititor(
	fid int primary key auto_increment,
	name varchar(30) not null,
	sex varchar(4), 
	age  smallint ,
	description varchar(4000)
)
alter table compititor  add column fnumber varchar(32) not null unique;
alter table compititor  add column contatcInfo varchar(32) not null ;

--定义详细的打分科目项
create table course(
	fid int primary key auto_increment,
	name varchar(30) not null,   --计分项名称
	weight double ,   --权重 0< x <=1  所有科目权重之和等于1  
	description  varchar(4000)   --计分项描述
)
alter table course  add  fnumber varchar(32)   not null;   /**not null   策略编号*/
alter table course  add  creator varchar(32)   not null;   /**not null 策略创建者*/
alter table course  add  createdate date  not null;          
alter table course  add  coursename varchar(50)  not null;   
alter table course  add  courseDescription varchar(4000)  ; 

--赛事
create table comptition(
	fid int primary key auto_increment,
	name varchar(30) not null,
	venue varchar(50) ,   --举办地点
	organizers varchar(50),  --举办方
	holdDate date,
	description varchar(4000)
);
alter table comptition  add column fnumber varchar(32) unique not null;  /**not null*/
alter table comptition  add  creator varchar(32) not null;  /**not null*/
alter table comptition  add column state int default 0 ;  /**default 0*/


--赛事明细表  记录参赛者以及评委
create table cmpt_dtalCompetitor(
	fid int  primary key auto_increment,
	competition varchar(32)  ,
	course varchar(32),
	compititor varchar(32) 
)

create table cmpt_dtalJudges(
	fid int  primary key auto_increment,
	competition varchar(32)  ,
	course varchar(32),
	judges varchar(32)  
)

--比赛记录打分表
create table scoring(
	fid int  primary key auto_increment,
	cmpt_fid int references comptition(fid),
	compititor varchar(30) not null, 
	judges int not null ,
	course int references course(name),
	grade smallint 
);
alter table scoring  add column fnumber varchar(32) not null unique not null;
