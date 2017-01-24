========
1��
========
create table tb_text (
    text_no number(5) not null
    , title varchar2(500) not null
    , content varchar2(4000) not null
    , user_id varchar2(16)
    , reg_time date not null
    , read_count number(5) not null
    , recom_count number(5) not null
);

create table tb_user (
    user_id varchar2(16) not null
    , password varchar2(16) null
    , email varchar2(60)
);

select * from tb_user

create table tb_read_recom (
    text_no number(5) not null
    , user_id varchar2(16) not null
    , the_time date not null
);

========
2��
========
insert into tb_user(user_id, password, email)
values('root', 'abcd1234', 'root@noname.com');
insert into tb_user(user_id, password, email)
values('user1', 'abcd1234', 'root@noname.com');
insert into tb_user(user_id, password, email)
values('user2', 'abcd1234', '');
insert into tb_user(user_id, password, email)
values('user3', 'abcd1234', '');

========
3��
========
update tb_user
   set password = '12341234'
 where user_id = 'user1';

select * from tb_user
 where user_id = 'user1';

========
4��
========
update tb_user
   set email = 'user3@noname.com'
 where user_id = 'user3';

select * from tb_user
 where user_id = 'user3';

========
5��
========
insert into tb_text(text_no, title, content, reg_time, read_count, recom_count )
values(1, '�����Ϸ�', '�� �� ������', sysdate, 0, 0);

========
6��
========
insert into tb_text(text_no, title, content, reg_time, read_count, recom_count )
values(2, '�����Ϸ�', '�� �� ���Ҵ�', sysdate, 0, 0);

========
7��
========
insert into tb_text(text_no, title, content, reg_time, read_count, recom_count )
values(3, '�����Ϸ�', '�� ���̶� ���� �����ϱ�?', sysdate, 0, 0);


   select a.text_no, a.user_id, count(b.*)
     from tb_text a
left join tb_read_recom b 
        on a.text_no = b.text_no and a.user_id = b.user_id
    where a.user_id <> 'user2'
      and a.text_no = 1
      
========
8��
========
update tb_text
   set read_count = read_count + 1
 where user_id <> 'user3'
   and text_no = 1

========
9��
========
update tb_text
   set read_count = read_count + 1
 where user_id <> 'user1'
   and text_no = 1


========
10��
========
update tb_text
   set recom_count = recom_count + 1
 where text_no = 1
   and user_id <> 'user2'
   and (select count(0) from tb_read_recom where text_no = 1) = 0

insert into tb_read_recom(text_no, user_id, the_time) 
values(1, 'master2', sysdate)


========
11��
========
update tb_text
   set recom_count = recom_count + 1
 where text_no = 1
   and user_id <> 'user3'
   and (select count(0) from tb_read_recom where text_no = 1) = 0
   
insert into tb_read_recom(text_no, user_id, the_time) 
values(1, 'master3', sysdate)