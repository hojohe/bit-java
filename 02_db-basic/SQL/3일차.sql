----------------------
--JOIN
----------------------
-- cartesian Product : ��������(��������)�� �߸��ǰų� �ǵ������� ������
-- ���� ���� ��� m * n �� ����� ��ȯ�Ǵ� ����
select last_name, department_name
  from employees, departments;

-------------
--EQUIT JOIN
-------------
select employees.last_name
     , departments.department_name
     , employees.department_id
  from employees, departments
 where employees.department_id = departments.department_id;

----------
--��������
----------
-- ���̺� alias ����ϱ�
select e.last_name
     , d.department_name
     , e.department_id
  from employees e, departments d
 where e.department_id = d.department_id;

select dep.department_id
	 , dep.department_name
	 , loc.city
  from departments dep, locations loc
 where dep.location_id = loc.location_id;
 
-- Canada �� �ٹ��ϴ� ����� ������, �μ���, ����� ����Ͻÿ�
select emp.last_name
	 , dep.department_name
	 , loc.city
  from employees emp, departments dep, locations loc, countries ctr
 where ctr.country_id = loc.country_id
   and loc.location_id = dep.location_id
   and dep.department_id = emp.department_id
   and ctr.country_name = 'Canada';
   
-- �� ����� job_id�� �ش��ϴ� �ִ� ���� �� �ִ� �޿���
-- �ּ� �޿��� ������ ����Ͻÿ�
select emp.last_name
	 , emp.job_id
	 , job.job_title
	 , job.min_salary
	 , job.max_salary 
  from employees emp, jobs job
 where emp.job_id = job.job_id;


-- Oracle 9i ���� ���� 
-------------
--INNER JOIN
------------- 
-- ���̺� ALIAS ����ϱ�
select e.last_name
     , d.department_name
     , e.department_id
  from employees e
inner join departments d
 on e.department_id = d.department_id;

select dep.department_id
	 , dep.department_name
	 , loc.city
  from departments dep
inner join locations loc
 on dep.location_id = loc.location_id;
 
-- Canada �� �ٹ��ϴ� ����� ������, �μ���, ����� ����Ͻÿ�
select emp.last_name
	 , dep.department_name
	 , loc.city
  from employees emp
inner join departments dep on dep.department_id = emp.department_id
inner join locations loc on loc.location_id = dep.location_id
inner join countries ctr on ctr.country_id = loc.country_id
 where ctr.country_name = 'Canada';
   
-- �� ����� job_id�� �ش��ϴ� �ִ� ���� �� �ִ� �޿���
-- �ּ� �޿��� ������ ����Ͻÿ�
select emp.last_name
	 , emp.job_id
	 , job.job_title
	 , job.min_salary
	 , job.max_salary 
  from employees emp
inner join jobs job
 on emp.job_id = job.job_id;

-- ����� �޿��� �޿������ ȭ�鿡 ���
select emp.last_name, emp.salary, sgd.grade
  from employees emp, salgrade sgd
 where emp.salary between sgd.min_sal and sgd.max_sal;
 
select emp.last_name, emp.salary, sgd.grade
  from employees emp
inner join salgrade sgd 
	on emp.salary between sgd.min_sal and sgd.max_sal;

-------------
-- SELF JOIN
-------------
select e.last_name as �����
     , m.last_name as �����ڸ�
  from employees e, employees m
 where e.manager_id = m.employee_id;
-- self join -> inner join ����� �ٸ���
select e.last_name as �����
     , m.last_name as �����ڸ�
  from employees e
inner join employees m on e.employee_id = m.employee_id;

-------------
-- OUTER JOIN
-------------
select e.last_name as �����
     , m.last_name as �����ڸ�
  from employees e, employees m
 where e.manager_id = m.employee_id(+);

-- �����ڰ� ���� ����� "�����ھ���"�� ����Ѵ�.
select e.last_name as �����
     , nvl(m.last_name, '�����ڸ�') as �����ڸ�
  from employees e, employees m
 where e.manager_id = m.employee_id(+);

-------------
-- OUTER JOIN
-------------
-- full (oracle 9���� �߰��� ���ʿ� (+)) 
-- right �����ʿ�(+)
-- left ���ʿ�(+)
select e.last_name as �����
     , nvl(m.last_name, '�����ھ���') as �����ڸ�
  from employees e
  left outer join employees m
 	on e.manager_id = m.employee_id;
 	
--------------
-- SET ������
--------------
union -> �����ϰ� �ߺ� ���� ����� ��
union all -> �������� �ʰ� �ߺ��Ǵ� ����� ��

-- ������(�ߺ�O). ��� ����� ����Ѵ�(�ߺ� ����)
select no, data
  from tc_seta
union all
select no, data
  from tc_setb
  
-- ������(�ߺ�X). ��ø�� �����ʹ� �ѹ��� ���, �ڵ� ���ĵ�
select no, data
  from tc_seta
union
select no, data
  from tc_setb;
  
-- ������. ���� ������� ���� ����� �� ����� ���
select no, data
  from tc_seta
minus
select no, data
  from tc_setb;
  
-- ������. ����� ���� �����͸� ���
select no, data
  from tc_seta
intersect
select no, data
  from tc_setb;

  
-- ���� 1. �÷��� ������ �����ؾ� �Ѵ�.
-- ���� 2. ���� �� ������ Ÿ���� �����ؾ� �Ѵ�.
-- ���� 3. �Ϲ������� order by ���� �������� ��ġ�ؾ� �Ѵ�.
-- ���� 4. �÷����� ù��° SQL���� �÷����� ���ȴ�.
select 'data', last_name, salary
  from employees
union all
select 'total', department_name, department_id
  from departments
order by last_name;
  
  
------------------
-- SUBQUERY
------------------ 
select avg(salary)
  from employees
 where department_id = 10;
  
  
-- Chen ����� ���� �μ��� �ִ� ������� ��� �޿��� ����Ͻÿ�
select avg(salary)
  from employees
 where department_id = chen ����� �μ���ȣ;
 
-- Chen ����� �μ���ȣ�� ����Ͻÿ�
select department_id
  from employees
 where last_name = 'Chen'

-- ���������� ������� �ϳ��� �� : ��Į�� ��������, Singlt Row SubQuery
select avg(salary)
  from employees
 where department_id = (select department_id
  						  from employees
 						 where last_name = 'Chen');
 						 
-- ���������� ������� �������� ��� : Multi Row SubQuery
-- Multi Row SubQuery �� ��쿡�� ���õ� �����ڸ� �̿�
-- (in, all, any) 
select avg(salary)
  from employees
 where department_id in (select department_id
  						   from employees
 						  where last_name = 'King');
 						  
-- 30�� �μ��� ��� �޿����� �޿��� ���� �޴� ����� ������ ���
select last_name, salary
  from employees
 where salary > (select avg(salary)
				   from employees
 				  where department_id = 30)
order by salary desc


-- 30�� �μ��� ������� �޴� �޿����� �޿��� ���� �޴� ����� ������ ���
select last_name, salary
  from employees
 where salary > (select max(salary)
				   from employees
 				  where department_id = 30)
order by salary desc

select last_name, salary
  from employees
 where salary >ALL (select salary
				      from employees
 				     where department_id = 30)
order by salary desc
-----------------------------------------------
select last_name, salary
  from employees
 where salary >ANY (select salary
				      from employees
 				     where department_id = 30)
order by salary desc

select last_name, salary
  from employees
 where salary > (select min(salary)
				   from employees
 				  where department_id = 30)
order by salary desc
-----------------------------------------------

-- �� �μ����� ���� ���� �޿��� �޴� ����� ������ ����Ͻÿ�
-- MultiColumn SubQuery : ���������� ����� �������� �÷��� ��ȯ
select department_id, last_name, salary
  from employees
 where (department_id, salary) in (select department_id, min(salary)
  									 from employees
								   group by department_id)
order by department_id


-- ���������� ���Ǵ� �پ��� ��ġ
-- insert �������� SubQuery
insert into tb_board(
	no
	, title
	, writer
	, content
) values (
	(select max(no) + 1 from tb_board)
	, 't'
	, 'w'
	, 'c'
);

-- select �������� SubQuery
select e.last_name
     , e.department_id
     , (select department_name 
          from departments 
         where department_id = e.department_id) as department_name
  from employees e

-- rowNum 
select rownum, last_name, salary
  from employees;

select rownum, last_name, salary
  from employees
 where rownum < 5;
 
-- ����߿��� �޿��� ���� �޴� ���� 5���� ����Ͻÿ�
select last_name, salary
  from employees
 where rownum < 6
order by salary desc;

-- ����߿��� �޿��� ���� �޴� ���� 4��° ������� ����Ͻÿ�
-- rownum ���� 1���� ���������� �´������϶� ���� ��ȣ�� �Ѿ��.
-- 1�� �´� ������ ������ ������ 4���� �� �� ����.
select last_name, salary
  from employees
 where rownum = 4
 
-- from �������� SubQuery : inLine View
-- rownum�� �̸��� ������ �̸����� ������ ���� �κй��� ��������
select *
  from (select rownum rnum, last_name, salary 
      	  from employees
      	order by salary desc)
 where rnum = 4;
 
-- ����¡ ó�� ����
select *
  from (select rownum rnum, last_name, salary 
      	  from employees
      	order by salary desc)
 where rnum between 11 and 20
order by rnum;

-- ���������� �̿��� ���̺� ���� - ���̺� ������ �����͸� ����
create table employees_copy
as
select * from employees;

-- ���̺� ������ ��������. ����� 0�̸� �ȴ�.
create table employees_copy
as
select * from employees where 1 != 1;


-- ���̺� �����͸� ���������� �̿��ؼ� �Է��ϱ�
insert into employees_copy
select * from employees_copy;

-- oracle : rownum�� between A and B
-- rownum ���� �� : order by �Ŀ� limit �Խù� ��ȸ�ؿ� ũ�� offset ��������ġ

