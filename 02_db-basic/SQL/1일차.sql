-- ���� ������� ��ü ���̺� ��� ����
select * 
  from tab;
  
-- CREATE : ���̺� �����ϱ�
-- ���̺��, �÷��� ���������� �빮�ڷ� ����
-- ������ ó���� ���� �����
create table ���̺�� (
	�÷���  Ÿ��(ũ��),
	�÷���  Ÿ��(ũ��)
);

create table Member -> ���������� MEMBER
���̺�� ��Ģ -> t_�տ� ���̰ų� �Ǵ� tb_, tc_, ...
         -> �ܾ�� �ܾ� ���̿� "_"�� �߰��Ѵ�. 
         -> �ܾ ����ؼ� ����� ��� 3�� �Ǵ� 4�ڸ� �����
         
�Խ����� ǥ���ϴ� ���̺� ���� ��Ʈ��Ʈ(SQL) �ۼ��ϱ�
���� : BoardVO Ŭ����

CREATE TABLE TB_BOARD (
	NO NUMBER(6),
	WRITER VARCHAR2(30),
	TITLE VARCHAR2(200),
	CONTENT VARCHAR2(4000),
	REG_DATE DATE
);

-- ���̺� ����
DROP TABLE TB_BOARD;
delete from tb_board

-- ������ ����
PURGE RECYCLEBIN;

-- �������� : ���̺��� ��������, �÷����� ��������, 
		 : �������� �̸� ����(����� ����) - constraint �������Ǹ�
-- 1. PK : Primary Key - �ϳ��� ���̺� �ϳ��� Ű�� �����Ѵ�.
                       - UNIQUE + NOT NULL
-- 2. UNIQUE           - ���̺����� ���� �����ؾ� �Ѵ�.(null�� ���)
-- 3. NN : NOT NULL    - null ���� ������� �ʴ´�.
-- 4. FK : FOREIGN KEY - �ٸ� ���̺� �Ǵ� �ڱ� �ڽ��� �ٸ� �÷��� ���� ����
-- 5. CK : CHECK       - ���� �Է½� ���� ����
-- ���� : �������� �÷��� ��� ���������� �����Ϸ��� ���̺����� �̿��ؾ� ��
-- default : ���� �Էµ��� ���� ��� �⺻���� ���� ����
create table ���̺�� (
	�÷���  Ÿ��(ũ��) �÷���������,
	�÷���  Ÿ��(ũ��), 
	�÷���  Ÿ��(ũ��) default ��, 
	���̺���������...
);

sysdate : ���� �ð� ������ ��ȯ�ϴ� �Լ�

CREATE TABLE TB_BOARD (
	NO NUMBER(6) constraint pk_no primary key,
	TITLE VARCHAR2(200) not null,
	WRITER VARCHAR2(30) not null,
	CONTENT VARCHAR2(4000) not null,
	REG_DATE DATE default sysdate
);


-- ���̺�� �����ϱ�
RENAME A(���� ���̺��) TO B(������ ���̺��);

RENAME TB_BOARD TO BOARD_TB;

-- ������ ���̺� ���� ���캸��
DESCRIBE ���̺��;
DESC ���̺��;

-- �����÷� ��� �������� ����
CREATE TABLE TB_BOARD (
	NO NUMBER(6) not null,
	TITLE VARCHAR2(200) not null,
	WRITER VARCHAR2(30) not null,
	CONTENT VARCHAR2(4000) not null,
	REG_DATE DATE default sysdate,
	constraint pk_no primary key(NO, TITLE)
);

-- 
create table tb_member (
	id varchar2(20) primary key,
	name varchar2(30) not null,
	pw varchar2(20) not null,
	birth date not null,	
	gender number(1) not null,
	post_no number(6) not null,
	add varchar2(200) not null,
	add_detail varchar2(200) not null,
	tel number(11) not null,
	email varchar2(200) not null, unique,
	phone number(11),
	corp_tel number(11),
	corp_post_no number(6),
	corp_add varchar2(200),
	corp_add varchar2(200),
);


-- INSERT : ������ �Է�
-- �Է½� ������ : ���ڸ� �Է��� ���� �ݵ�� "'"���� ���´�.
insert into tb_board(no, title, writer, content, reg_date)
values(1, '����', '�۾���', '����', sysdate);

insert into tb_board(no, title, writer, content)
values(2, '����2', '�۾���2', '����2');

-- no �÷��� primary key�� �����Ǿ��� ������ �ߺ��� �����ʹ� ������� �ʴ´�.
insert into tb_board(no, title, writer, content)
values(2, '����2', '�۾���2', '����2');

-- NULL �Է��� �� ����.
insert into tb_board(no, title, writer)
values(3, '����3', '�۾���3');

-- �÷����� ������ �������� ���� ��� ��� �÷��� ������ �Է�(����x) 
insert into tb_board
values(3, '����3', '�۾���3', '����3', sysdate);


-- ���� �Ұ��� ������ ����
truncate table tb_board;

-- ������ ���� : update
update ���̺��
   set �÷� = ������ ��
       [, �÷� = ������ ��...]
[������(where)]

-- 1�� �Խù��� ������ �߿�� �����մϴ�.
update tb_board
   set content = '�߿'
where no = 1;

-- 2�� �Խù��� ������ "�����ε�"�� ������ "����"�� �����մϴ�.
update tb_board
   set title = '�����ε�'
       , content = '����'
 where no = 2


=========================
select ��
=========================
-- ��� �÷� ��ȸ�ϱ�
select *		 -- �÷���
  from tb_board; -- ���̺��

-- Ư�� �÷��� ��ȸ�ϱ�
select employee_id, first_name
  from employees;

-- ��� ������ ���
-- ����� ������ ����Ͻÿ�(���� : �޿� * 15)
select last_name, salary, salary * 15
  from employees;

-- �÷��� ��Ī(alias) ��� : �÷� ��Ī, �÷� as ��Ī
select last_name �̸�, salary as �޿�, salary * 15 as ����
  from employees;


-- �ռ�������(||) : �ڹٿ����� "+" ����
String name = "ȫ";
int age = 29;
String msg = name + "���� ���̴� " + age + "�Դϴ�."

-- ???����� �޿��� ???�Դϴ�.
������� : employess
����� �÷� : last_name, salary

select last_name  || '����� �޿��� ' || salary || '�Դϴ�.' AS �������
  from employees;


=========================
WHERE ��
=========================
SELECT : ����� ����
FROM   : EMPLOYEES
WHERE  : SALARY >= 10000
-- ��� �߿��� �޿��� 10,000 �̻��� ����� ������ ����Ͻÿ�
select *
  from employees
 where salary >= 10000  


-- ��� ������ ����մϴ�. ��, 100�� �μ��� �ƴ� ����鸸 ����մϴ�.
select *
  from employees
 where department_id <> 100

-- ���� ���� ��ҹ��ڰ� �񱳵ȴ�.
-- last_name �� 'King'�� ����� ������ ���
select *
  from employees
 where last_name like 'King%'

-- ����� �μ���ȣ�� 100 �̸鼭 �޿��� 10000 �̻��� ����� ������ ���
select * 
  from employees
 where department_id = 100 
   and salary >= 10000  


-- ����� �μ���ȣ�� 100 �Ǵ� 90�� ����� ������ ���
select *
  from employees
 where department_id = 100
    or department_id = 90


-- ����� �μ���ȣ�� 100 �Ǵ� 90 �� ���ԵǾ� �����鼭 �޿��� 10000 �̻��� 
    ����� ������ ���
select *
  from employees
 where (department_id = 100 or department_id = 90)
   and salary >= 10000

-- �޿��� 10000 �̻��� ����� ��
select count(*)
  from employees
 where salary >= 10000;









