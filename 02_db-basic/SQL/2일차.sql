-----------------------------------------
--WHERE
-----------------------------------------
-- between a and b : a�� b ������ ���� �����Ѵ� (a, b ����)

-- �޿��� 10000 �̻��̰� 15000 ������ ����� ������ ���
select *
  from employees
 where salary >= 10000
   and salary <= 15000;

select *
  from employees
 where salary between 10000 and 15000;
 
-- IN ������ : �÷��� in (��, ...);

 -- ����� �μ��� 90, 100, 110, 120, 130, 150�� �Ҽӵ� ����� ������ ���
select *
  from employees
 where department_id in (90, 100, 110, 120, 130, 150);

-- Like ������ : �÷��� like '����', %(0�� �̻� ����), _(�Ѱ� ����)

 -- ����� �̸��� L�� �����ϴ� ��� ������ ���
 select *
   from employees
  where last_name like 'L%';
 
-- �̸����� D�� �����ϰ� T�� ������ ����� ����
 select *
   from employees
  where email like 'D%T';

-- �̸��� 'King'�� ����� ������ ���
select *
  from employees
 where last_name = 'King';
 
-- IS NULL ������
-- null �� "������ ��"
-- null ���� ��������� ����� null
select last_name, salary, commission_pct
  from employees;

select last_name, salary, commission_pct
  from employees
 where commission_pct is null;

select last_name
     , salary
     , case when commission_pct is null then (salary * 15)
            else (salary * 15 + salary * 15 * commission_pct) end as ����
  from employees;
   
select last_name
	, salary
	, salary * 15 + salary * 15 * nvl(commission_pct, 0) as year_sal
  from employees;	
  
  

-----------------------------------------------
--ORDER BY : ASC(��������), DESC(��������)
--ORDER BY ǥ���� | �÷��� [ASC(����Ʈ:��������) | DESC]
-----------------------------------------------
-- �޿��� ���� ������� ȭ�鿡 ����Ͻÿ�
select last_name, salary
  from employees
order by salary desc;

-- �޿��� ���� ������� ȭ�鿡 ����Ͻÿ�
select last_name, salary
  from employees
order by salary;
   
-- ����� ������ ����մϴ�(�̸�, �μ���ȣ, �޿�)
-- ��, �μ���ȣ ������ ����ϼ���. �μ���ȣ�� ���� ������� �޿������� ����մϴ�.
select last_name, department_id, salary
  from employees
order by department_id, salary;

-- ������ ���� ������� ����Ͻÿ�
select last_name
	, salary
	, salary * 15 + salary * 15 * nvl(commission_pct, 0) as year_sal
  from employees
order by year_sal desc;


-- distinct : �ߺ��� ����� ����
select department_id
  from employees;
  
select distinct(department_id)
  from employees
order by department_id;


-----------------------------------------------
--GROUP BY : �����͸� �ұ׷����� ���´�.
--�׷� �Լ�: �������� �����͸� �޾Ƽ� �ϳ��� ����� ��ȯ
--		: COUNT(ǥ���� | �÷���), SUM(������ | �÷���), MAX(ǥ���� | �÷���)
--		: MIN(ǥ���� | �÷���), AVG(ǥ���� | �÷���)
--		: null �� ���� -> sum(nvl(commission_pct,0)) = nvl ���ʿ�
-----------------------------------------------

select count(last_name), sum(salary), max(salary), min(salary), avg(salary)
	 , sum(commission_pct)
  from employees;


-- 50�� �μ��� ������� �޿��߿��� ���� ���� �޿��� ������ ���
select max(salary)
  from employees
 where department_id = 50;


-- �μ����� �޿� ���
select department_id, max(salary) as max_sal
  from employees
group by department_id
order by max_sal desc;
 
 
-----------------------------------------------
--HAVING : �׷쿡 ���� ������ ó���Ѵ�.(����)--
-----------------------------------------------
select department_id, max(salary) as max_sal
  from employees
group by department_id
having max(salary) >= 10000
order by max_sal desc;

-- �μ��� ��� �޿��� ����մϴ�.
-- ��, 100������ ū �μ��� �����ϰ� �μ��� ��� �޿��� 5000�̻��� �μ��� ����մϴ�.
-- �μ���ȣ ������ ����մϴ�.
select department_id, avg(salary)
  from employees
where department_id < 100
group by department_id
having avg(salary) >= 5000 
order by department_id;


--�������
FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY


-----------------------------------------------
--�����Լ� : DBMS���� �⺻������ �����Ǵ� �Լ�(������, �׷���)
-----------------------------------------------
������ - ����, ����, ��¥, ��ȯ��, ����
-- ���� �Լ�
select last_name, lower(last_name), upper(last_name), concat(last_name, '���')
  from employees;
--concat(last_name, '���') = last_name || '���'


select last_name, first_name
	 , concat(upper(last_name), first_name)
  from employees;


--2016, 12, 29
select last_name
	 , substr(last_name , 1, 3)
	 , substr('20161229', 1, 4) 
	 , substr('20161229', 5, 2)
	 , substr('20161229', 7, 2) 
  from employees;
  

select last_name, length(last_name)
, lpad(last_name, 10, '*'), rpad(last_name, 10, '*')
  from employees;
  
  
select last_name
	 , translate(last_name,'Ab', 'uk') -- ���� �ϳ���
	 , replace(last_name,'Ab', 'uk')   -- �ܾ� ������
  from employees;


-- ������ �Լ�
select abs(100), abs(-100)
  from dual;

-- ceil  = �Էµ� ������ ũ�ų� �����鼭 �������� ����
-- floor = �Էµ� ������ �۰ų� �����鼭 ����ū ����
-- sign  = ��� ���� ���� 
select ceil(1.1), floor(1.1), sign(-12), sign(0), sign(12)
  from dual;
  
-- round = �ݿø�
-- trunc = ����
select round(73.727), round(73.727,2), round(73.727,-2)
	 , trunc(73.727), trunc(73.727,2), trunc(73.727,-2)
  from dual;

  
-- ��¥ �Լ�
select sysdate, add_months(sysdate, 2), add_months(sysdate, -1)
  from dual;
  
-- �� ����� �Ի��Ϸ� ���� 1���� �Ǵ� ��¥�� ����Ͻÿ�.
select * from employees;

select last_name, hire_date, add_months(hire_date, 12)
  from employees;
  
select last_name, hire_date, trunc(months_between(sysdate, hire_date))
  from employees;

select sysdate, last_day(sysdate)
  from dual;

-- ��¥ +- ���� = ��¥, ��¥ +- ��¥ = ����
select sysdate, sysdate + (1/24 * 5), sysdate -7
  from dual;

-- �� ����� �ٹ��ϼ��� ����Ͻÿ�.
select trunc((sysdate - 1) - hire_date), hire_date
  from employees;

  
-- ��ȯ�� �Լ�
-- to_date : ���� -> ��¥
-- to_number : ���� -> ����
-- to_char : ��¥ -> ����, ���� -> ����
select to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')
	 , to_date('20161120')
  from dual;

insert into tb_board(no, title, writer, content, reg_date)
values(6, 'a', 'b', 'c', '20161230');
select * from tb_board;

-- ���Ϲ��� : 9(�ڸ���), 0(�ڸ���-���� �ڸ��� 0�� ǥ��), ","
select to_char(1000, '999,999,999,999')
	 , to_number('51,000', '99,999')
  from dual;

-- ����߿��� 5���� �Ի��� ������� ������ ����Ͻÿ�
select *
  from employees
 where substr(to_char(hire_date,'yyyy-mm-dd'),6,2) = '05';

select *
  from employees
 where to_char(hire_date,'mm') = to_char(sysdate, 'mm');
 
 
-- ��Ÿ�Լ� : decode, case ~ end - �⺻���� ��� ���� �����..
select job_id, decode(job_id, 'IT_PROG', '������'
							, 'SA_MAN', '������'
							, '�׳� ����') as job_type
  from employees;

  
select job_id
     , case when job_id = 'IT_PROG' then '������'
			when job_id = 'SA_MAN'  then '������'
			else '�׳� ����' 
	   end as job_type
  from employees;
  

  
select last_name
	 , salary
     , case when salary >= 10000 then '����...'
			when salary between 5000 and 10000  then '����...'
			else '����...' 
	   end as salary_
  from employees
order by salary
  


  
  
  
  
  
  
  
 
