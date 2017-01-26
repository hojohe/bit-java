create table tb_user (
	user_id varchar2(20) primary key,
	password varchar2(20) not null,
	email varchar2(100)
);

insert into tb_user(user_id, password, email) values('a', '1', 'a@a.com');

create table tb_board_file (
	file_no number(6) primary key,
	no number(6) not null,
	ori_name varchar2(100) not null,
	system_name varchar2(100) not null,
	file_path varchar2(50) not null,
	file_size number not null
);

alter table tb_board_file modify(file_path varchar2(200));

create sequence s_board_file_no;

select * from tb_board_file;

create table tb_board_comment (
	comment_no number(6) primary key,
	no number(6) not null,
	content varchar2(200) not null,
	user_id varchar2(20) not null,
	reg_date date default sysdate
);

create sequence s_board_comment_no;


s_board_no

select * from tb_board
select no, 
	   title, 
	   writer, 
	   content, 
	   reg_date
  from tb_board
 order by reg_date desc
 
 
 select * from tb_board_comment
 
 
 delete 
		  from tb_board_comment
		 where comment_no = 88
		 
		 
		 select to_char(reg_date, 'yyyy-mm-dd hh:mm:ss') from tb_board
		 order by no desc