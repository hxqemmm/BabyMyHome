
drop table record			--������Ϣ��--
create table record(							--��¼���ϴ�������--
	id  int identity(1000,1) primary key,		--����ID����--
	issuer varchar(20) not null,				--������--
	names varchar(10) not null,					--����--
	sex varchar(10) not null,					--�Ա�--				
	birthday varchar(50) not null,				--����--
	missday varchar(50) not null,				--ʧ��ʱ��--
	relation varchar(10) not null,				--��ϵ--
	native varchar(20) not null,				--����--
	place varchar(20) not null,					--ʧ�ٵص�--
	feature varchar(40) not null,				--����--
	photo varchar(200) not null,				--��Ƭ--
	pass varchar(100) not null,					--ʧ�پ���--					
	replenish varchar(100),						--����˵��--
	state varchar(10) not null,					--�Ƿ��һ�--
	headline varchar(100) not null,				--����--
	times varchar(30) not null,					--����ʱ��--
	audit varchar(20) not null						--���--
);

drop table user_register		--�û�ע���--
create table user_register(  
	id  int identity(1000,1) primary key, 
	phone varchar(30) not null unique,
	password varchar(20) not null,
);

drop table userinfo
create table userinfo(			--�û����ϱ�--
	id  int identity(1000,1) primary key, 
	phone varchar(20) not null unique,		--�ֻ���--
	username varchar(20) not null,			--�û���--
	password varchar(20) not null,			--����--
	headimage varchar(100) not null,		--ͷ��--
	sex varchar(2) not null,				--�Ա�--
	age int not null,						--����--
	QQ varchar(20),							--QQ--
	native varchar(100),					--����--
	sdasd varchar(200),						--����ǩ��--
);

drop table tickling			
create table tickling(		--������--
	id  int identity(1000,1) primary key,	
	names varchar(10) not null,				
	contact varchar(20) not null,			--��ϵ��ʽ--								
	ticklings varchar(500) not null,		--����--			
	date varchar(30) not null		
);

drop table images		--��ҳͼƬ��--
create table images(  	
	id  int identity(1000,1) primary key,
	url varchar(100) not null
);

drop table admin
create table admin(		--����Ա��--
	id  int identity(1000,1) primary key, 
	username varchar(29) not null unique,
	password varchar(20) not null
);

drop table tops
create table tops(		--�����--
	id  int identity(1000,1) primary key, 
	username varchar(29) not null,
	body varchar(1000) not null,
	times varchar(20) not null
);

