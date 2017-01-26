

select * from tb_user


select * from tb_board_file


create table tb_comment(
	comment_no number(10)
	, id varchar2(200)
	, comments varchar2(2000)
	, reg_date date
)

create sequence s_board_comment_no;

insert into tb_comment(comment_no, id, comments, reg_date)
values(s_board_comment_no.nextVal, 'root', '안녕??', sysdate);

select * from tb_comment;