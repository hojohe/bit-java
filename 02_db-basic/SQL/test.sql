-- 1.불렛 테이블
create table t_bullet(
	bullet_no number(2) not null, 
	bullet_name varchar2(15) not null,
	bullet_img_path varchar2(100) not null, 
	constraint pk_bullet primary key (bullet_no)
);

-- 2.회원 테이블 
create table t_user(
	user_no number(6) not null, 
	id varchar2(50) not null,
	pass varchar2(16) not null,
   	nick_name varchar2(20) not null,
	auto_type char(1) default 'N',
	prof_img_path varchar2(200),
	corv_img_path varchar2(200),
	reg_date date,
	mod_date date,
	constraint pk_user primary key (user_no)
);

-- 3.피드 테이블
create table t_feed(
	feed_no number(6) not null,
    user_no number(6) not null,
    bullet_no number(2) not null,
    feed_type number(1) not null,
    feed_dday number(3), 
    start_date date,
    end_date date,
    feed_title varchar2(90) not null,
    feed_content varchar2(2000),    
    reg_date date,
    mod_date date,
    delete_yn char(1) default ‘N’,
    alert_date date,
    alert_date date,
    alert_schedule number(1),-- 1:매일, 2:주간
    conf_yn char(1) default 'N',
    conf_img_path varchar2(100),
    hash_tag varchar2(2000),
    conf_content varchar2(2000),
    constraint pk_feed primary key (feed_no),
    foreign key(user_no) references t_user(user_no),
    foreign key(bullet_no) references t_bullet(bullet_no)   
);  

-- 4.피드 상세(별점 등) 테이블
create table t_feed_detail(
    detail_no number(6) not null,
    feed_no number(6) not null,
    user_no number(6) not null,
    days number(3) not null,
    percent number(3) default 0,
    constraint pk_detail_no primary key (detail_no),
    foreign key(feed_no) references t_feed(feed_no),   
    foreign key(user_no) references t_user(user_no)   
);

-- 5.스토리 댓글 테이블 (=응원하기) 
create table t_feed_comment(
	comment_no number(6) not null,
    feed_no number(6) not null,
    user_no number(6) not null,
    comments varchar2(100),
    constraint pk_comment_no primary key (comment_no),
    foreign key(feed_no) references t_feed(feed_no),
    foreign key(user_no) references t_user(user_no)
);

-- 6.인증하기 테이블
create table t_feed_confirm(
    
    constraint pk_feed_confirm primary key (feed_no, user_no),
    foreign key(user_no) references t_user(user_no)   
);

