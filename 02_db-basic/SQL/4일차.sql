-----------------------------------------------------
������(sequence) : ������ȣ ������
���밴ü
��� ���̺����� ������ ����� ������
�Ϲ������δ� Ư�� ���̺��� Ư�� �÷����� ���
-----------------------------------------------------
-- ������ �����ϱ�
-- ���� �ɼ��� �������� ���� ���
-- ���� : 1, ���� : 1
create sequence s_board_no;

-- ������ ���������� ������ȣ ��� : nextVal
-- ��������.nextVal
select s_board_no.nextVal from dual;

-- ������ �����ϱ�
drop sequence s_board_no;

-- �������� �̿��� �Խñ� ���
insert into tb_board(no, title, writer, content)
values(s_board_no.nextVal, '����', '�۾���', '����');

select * from tb_board
order by no;

-- �������� �ߺ�ó���� �����ϴ�. ������ ���ÿ� ���������� �ߺ����� �ʰ� �������� ���ش�. ��� sql�� �� �׷���?
-- ������ ���� �ɼ� cache : �������� �޸𸮿� ���� �÷�����! ������ ��û�� �� �����ش�. * �⺻���� ���� �� ������
-- �ٽ� �޸𸮿� ������ �ø��� �⺻���� ���ĺ��� ä���ȴ�.

-----------------------------------------------------
-- alter : ���̺� ����
-- �÷� �߰�, �÷� ����, �÷� ����(Ÿ��, ũ��, defalut, not null)
-- add : �÷� �߰��� ���
-- drop : �÷� ������ ���
-- modify : �÷� ����� ���

alter table ���̺��
add (�÷�...)

alter table ���̺��
drop (�÷�...)

alter table ���̺��
modify (�÷�...)

-- 9i���� �÷��� �̸� ����
alter table ���̺��
rename column A to B;
-----------------------------------------------------
create table t_alter (
	nama varchar2(10),
	age varchar2(3)
);

-- email �÷� �߰�
alter table t_alter
add (email varchar2(30), domain varchar2(100));

alter table t_alter
rename column nama to name;


-- ������ ���� �� �ʵ� ������ �ð� �ҿ�ȴ�. 
-- ����io(������ ��ȸ ����)�� ��� �߻��ϱ� ������ db�� ��������. 
-- �÷� ���� ȿ���� ���� ���� �����ʹ� ������ �ʰ� ���̺� ������ �ٲ��ָ� ������ ȿ���� ����
-- set unused column
-- ���� �ð��ܿ� drop unused column�鸸 ���ִ°͵� �ִ�. 
alter table t_alter
drop (email, domain);

-- �÷� ����
alter table t_alter
modify (age number(3));

insert into t_alter(name, age)
values('test', 22);

select * from t_alter;

-- �÷� ũ�� ����
alter table t_alter
modify (age number(5));

-- �÷� ũ�� ���� : ORA-01440: ���� �Ǵ� �ڸ����� ����� ���� ��� �־�� �մϴ�
-- �÷� ũ�� ���ҽÿ��� �����Ͱ� ����� ������. null�� ���¿��� ����
-- ������ �׻� ����
alter table t_alter
modify (age number(3));

-----------------------------------------------------
-- Ʈ����� : transaction
-- �ϳ��� Ʈ����� : �������� ���� �������� dml �۾���
	-- save point
	-- �뷮 ������ ó���� ���� ���� save point a1 �� �����ؼ� �߰��߰� ���� ����Ʈ�� �����Ѵ�. 
	-- rollback to a1 �ѹ��Ҷ� ���δ� �ѹ��� �ƴ� save point�� �����ؼ� �ѹ� ��ų �� �ִ�.
-----------------------------------------------------
create table t_tran(
	id varchar2(3),
	msg varchar2(100)
); 

SQL> insert into t_tran values('a', 'aaa');

1 ���� ���� ����������ϴ�.

SQL> select * from t_tran;

ID
------
MSG
-----------------------------------------------

a
aaa


SQL> commit;

Ŀ���� �Ϸ�Ǿ����ϴ�.

SQL> select * from t_tran;

ID
------
MSG
-----------------------------------------------

a
aaa


SQL> update t_tran set msg = 'bbb' where id = 'a';

1 ���� ���ŵǾ����ϴ�.

SQL> select * from t_tran;

ID
------
MSG
-----------------------------------------------

a
bbb


SQL> commit;

Ŀ���� �Ϸ�Ǿ����ϴ�.

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
