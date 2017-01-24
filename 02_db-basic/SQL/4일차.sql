-----------------------------------------------------
시퀀스(sequence) : 고유번호 생성기
공용객체
어느 테이블에서나 시퀀스 사용이 가능함
일반적으로는 특정 테이블의 특정 컬럼에서 사용
-----------------------------------------------------
-- 시퀀스 생성하기
-- 생성 옵션을 설정하지 않은 경우
-- 시작 : 1, 증가 : 1
create sequence s_board_no;

-- 생성된 시퀀스에서 고유번호 얻기 : nextVal
-- 시퀀스명.nextVal
select s_board_no.nextVal from dual;

-- 시퀀스 삭제하기
drop sequence s_board_no;

-- 시퀀스를 이용한 게시글 등록
insert into tb_board(no, title, writer, content)
values(s_board_no.nextVal, '제목', '글쓴이', '내용');

select * from tb_board
order by no;

-- 시퀀스는 중복처리가 가능하다. 유저가 동시에 접근했을때 중복되지 않게 시퀀스를 따준다. 모든 sql이 다 그런가?
-- 시퀀스 생성 옵션 cache : 시퀀스를 메모리에 먼저 올려놓고! 유저가 요청할 때 나눠준다. * 기본설정 갯수 다 못쓰고
-- 다시 메모리에 시퀀스 올릴때 기본갯수 이후부터 채번된다.

-----------------------------------------------------
-- alter : 테이블 변경
-- 컬럼 추가, 컬럼 삭제, 컬럼 변경(타입, 크기, defalut, not null)
-- add : 컬럼 추가시 사용
-- drop : 컬럼 삭제시 사용
-- modify : 컬럼 변경시 사용

alter table 테이블명
add (컬럼...)

alter table 테이블명
drop (컬럼...)

alter table 테이블명
modify (컬럼...)

-- 9i부터 컬럼의 이름 변경
alter table 테이블명
rename column A to B;
-----------------------------------------------------
create table t_alter (
	nama varchar2(10),
	age varchar2(3)
);

-- email 컬럼 추가
alter table t_alter
add (email varchar2(30), domain varchar2(100));

alter table t_alter
rename column nama to name;


-- 데이터 많을 때 필드 삭제에 시간 소요된다. 
-- 파일io(데이터 조회 삭제)가 계속 발생하기 때문에 db가 느려진다. 
-- 컬럼 삭제 효과를 내기 위해 데이터는 지우지 않고 테이블 구조만 바꿔주면 동일한 효과를 누림
-- set unused column
-- 업무 시간외에 drop unused column들만 해주는것도 있다. 
alter table t_alter
drop (email, domain);

-- 컬럼 변경
alter table t_alter
modify (age number(3));

insert into t_alter(name, age)
values('test', 22);

select * from t_alter;

-- 컬럼 크기 증가
alter table t_alter
modify (age number(5));

-- 컬럼 크기 감소 : ORA-01440: 정도 또는 자리수를 축소할 열은 비어 있어야 합니다
-- 컬럼 크기 감소시에는 데이터가 없어야 가능함. null인 상태에서 가능
-- 증가는 항상 가능
alter table t_alter
modify (age number(3));

-----------------------------------------------------
-- 트랜잭션 : transaction
-- 하나의 트랜잭션 : 논리적으로 묶인 여러개의 dml 작업들
	-- save point
	-- 대량 데이터 처리를 위한 개념 save point a1 을 지정해서 중간중간 저장 포인트를 관리한다. 
	-- rollback to a1 롤백할때 전부다 롤백이 아닌 save point를 지정해서 롤백 시킬 수 있다.
-----------------------------------------------------
create table t_tran(
	id varchar2(3),
	msg varchar2(100)
); 

SQL> insert into t_tran values('a', 'aaa');

1 개의 행이 만들어졌습니다.

SQL> select * from t_tran;

ID
------
MSG
-----------------------------------------------

a
aaa


SQL> commit;

커밋이 완료되었습니다.

SQL> select * from t_tran;

ID
------
MSG
-----------------------------------------------

a
aaa


SQL> update t_tran set msg = 'bbb' where id = 'a';

1 행이 갱신되었습니다.

SQL> select * from t_tran;

ID
------
MSG
-----------------------------------------------

a
bbb


SQL> commit;

커밋이 완료되었습니다.

SQL> select * from t_tran;

ID
------
MSG
-----------------------------------------------

a
bbb


SQL> select * from t_tran;

ID
------
MSG
-----------------------------------------------

a
ccc
