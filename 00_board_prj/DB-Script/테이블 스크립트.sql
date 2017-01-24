create table tb_board_file (
	file_no number(6) primary key,
	no number(6) not null,
	ori_name varchar2(100) not null,
	system_name varchar2(100) not null,
	file_path varchar2(50) not null,
	file_size number not null
);

create sequence s_board_file_no;

/* 댓글 */
create table tb_comment(
	comment_no number(10) primary key
	, no number(6) not null
	, id varchar2(200)
	, comments varchar2(2000)
	, reg_date date default sysdate
)
drop table tb_comment

create sequence s_board_comment_no;


insert into tb_comment(comment_no, no, id, comments, reg_date)
values(s_board_comment_no.nextVal, 1, 'root', '안녕??', sysdate);

SELECT * FROM TB_COMMENT

delete from tb_comment
select * from tb_comment;


select * from tb_user

create table tb_user
(
	user_id ,
	password,
	email
)



select * from tb_board
