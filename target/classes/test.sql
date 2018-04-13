--实体     评委        参赛者       比赛      

--评委表
create database judges;

use judges;

--评委
create table judges(
	fid int primary key auto_increment,
	name varchar(30) not null,
	sex varchar(4), 
	weight double ,    --权重   处理一票否决   或者必须某位评委通过   或设置某位评委权重  默认值0 
					   --为0的评委平分剩下的权重
	description varchar(4000)
)

--参赛者
create table compititor(
	fid int primary key auto_increment,
	name varchar(30) not null,
	sex varchar(4), 
	age  smallint ,
	description varchar(4000)
)

--定义详细的打分科目项
create table course(
	fid int primary key auto_increment,
	name varchar(30) not null,
	weight double ,   --权重 0< x <=1  所有科目权重之和等于1  
	description  varchar(4000)
)

--赛事
create table comptition(
	fid int primary key auto_increment,
	name varchar(30) not null,
	venue varchar(50) ,   --举办地点
	organizers varchar(50),  --举办方
	holdDate date,
	description varchar(4000)
);

--赛事明细表  记录参赛者以及评委
create table cmpt_dtal(
	fid int  primary key auto_increment,
	cmpt_fid int references comptition(fid) ,   
	compititor int not null, 
	judges int not null 
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
