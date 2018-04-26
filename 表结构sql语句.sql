
drop table record			--发布信息表--
create table record(							--记录，上传发布表--
	id  int identity(1000,1) primary key,		--主键ID自增--
	issuer varchar(20) not null,				--发布人--
	names varchar(10) not null,					--姓名--
	sex varchar(10) not null,					--性别--				
	birthday varchar(50) not null,				--生日--
	missday varchar(50) not null,				--失踪时间--
	relation varchar(10) not null,				--关系--
	native varchar(20) not null,				--籍贯--
	place varchar(20) not null,					--失踪地点--
	feature varchar(40) not null,				--特征--
	photo varchar(200) not null,				--照片--
	pass varchar(100) not null,					--失踪经过--					
	replenish varchar(100),						--补充说明--
	state varchar(10) not null,					--是否找回--
	headline varchar(100) not null,				--标题--
	times varchar(30) not null,					--发布时间--
	audit varchar(20) not null						--审核--
);

drop table user_register		--用户注册表--
create table user_register(  
	id  int identity(1000,1) primary key, 
	phone varchar(30) not null unique,
	password varchar(20) not null,
);

drop table userinfo
create table userinfo(			--用户资料表--
	id  int identity(1000,1) primary key, 
	phone varchar(20) not null unique,		--手机号--
	username varchar(20) not null,			--用户名--
	password varchar(20) not null,			--密码--
	headimage varchar(100) not null,		--头像--
	sex varchar(2) not null,				--性别--
	age int not null,						--年龄--
	QQ varchar(20),							--QQ--
	native varchar(100),					--籍贯--
	sdasd varchar(200),						--个性签名--
);

drop table tickling			
create table tickling(		--反馈表--
	id  int identity(1000,1) primary key,	
	names varchar(10) not null,				
	contact varchar(20) not null,			--联系方式--								
	ticklings varchar(500) not null,		--内容--			
	date varchar(30) not null		
);

drop table images		--首页图片表--
create table images(  	
	id  int identity(1000,1) primary key,
	url varchar(100) not null
);

drop table admin
create table admin(		--管理员表--
	id  int identity(1000,1) primary key, 
	username varchar(29) not null unique,
	password varchar(20) not null
);

drop table tops
create table tops(		--公告表--
	id  int identity(1000,1) primary key, 
	username varchar(29) not null,
	body varchar(1000) not null,
	times varchar(20) not null
);

