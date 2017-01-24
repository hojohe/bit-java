select *
  from s_emp;
  
-----
--1��
-----
select name, title, dept_id, salary
  from s_emp
 where dept_id in ('112', '118')
   and title in ('����', '���')
   and salary between 1500 and 4000
order by salary desc
   
-----
--2��
-----
select name, title, salary
  from s_emp
 where manager_id is null
 
-----
--3��
-----
select name, title, salary
  from s_emp
 where title like '%����'
   and salary >= 3000
order by name

-----
--4��
-----
select name, title, salary
  from s_emp
 where dept_id in (112,113,117,118)
   and salary between 2300 and 3000

-----
--5��
-----  
select name, title, salary, start_date
  from s_emp
 where regexp_like (title, '����|����')
   and to_char(start_date, 'mm') = '03'
   
-----
--6��
-----
select name, title, salary, salary * 16 as salary_year ,salary * 16 + 1000 as plus1000
  from s_emp
order by salary


-----
--7��
-----
select name, title || '�� �޿� ' || salary as commend
  from s_emp
order by id

-----
--8��
-----
select *
  from s_emp
 where manager_id is not null
   and commission_pct is not null
   and salary >= 2500
order by name, salary

-----
--9��
-----
select dept_id, min(salary) as salary_min
  from s_emp
group by dept_id
order by dept_id

------
--10��
------
select title, min(salary) as salary_min
  from s_emp
where title not like '%����'
group by title

------
--11��
------
select title, avg(salary) as salary_avg
  from s_emp
group by title

------
--12��
------
select title, count(*) as cnt
  from s_emp
group by title

------
--13��
------
select title, max(salary) as salary_max
  from s_emp
group by title
having max(salary) > 2000

------
--14��
------
select title, min(salary) as salary_min
  from s_emp
where title not like '%����'
group by title
order by salary_min desc

------
--15��
------
select title, avg(salary) as salary_avg
  from s_emp
 where title != '���'
group by title
order by salary_avg

------
--16��
------
select title, sum(salary) as salary_sum
  from s_emp
 where title != '���'
group by title
having sum(salary) >= 2000
order by salary_sum desc

------
--17��
------
select title, name
	 , upper(substr(mailid, 1, 1)) 
	|| lower(substr(mailid, 2, length(mailid))) as ch_mailid
	 , mailid
  from s_emp

 
------
--18��
------
select name
  from s_emp
 where length(name) > 2
 
------
--19��
------
select name
	 , to_char(trunc(months_between(sysdate, start_date)) * salary, '999,999,999') as salary_tot
  from s_emp

 
 
------
--20��
------
select name
     , case when to_char(commission_pct) is null then 'Ŀ�̼Ǿ���'
            else to_char(commission_pct)
       end as commission
  from s_emp

 
------
--21��
------
select title, name
	 , case when title = '���' then to_char(salary + (salary * 0.1), '999,999,999') 
	  		when title = '����' then to_char(salary + (salary * 0.2), '999,999,999') 
	   else to_char(salary + (salary * 0.1), '999,999,999') 
	   end as salary
  from s_emp
order by id, name, salary


------
--22��
------
select id, name, title, salary, trunc(salary / 100) as salary_trunc
    , rpad('*', trunc(salary / 100), '*') as result
  from s_emp
order by result desc
 
------
--23��
------
select a.dept_id as �μ���ȣ
  	 , max(a.���) as ���
  	 , max(a.����) as ����
  	 , sum(a.��Ÿ) as ��Ÿ
  	 , sum(a.�μ��հ�) as �μ��հ�
  from (
	select dept_id
		 , case when title = '���' then sum(salary) 
		   else 0
		   end as ���
		 , case when title = '����' then sum(salary) 
		   else 0
		   end as ����
		 , case when title not in('���', '����') then sum(salary)
		   else 0
		   end as ��Ÿ
	     , sum(salary) as �μ��հ�
	  from s_emp
	group by dept_id, title
) a
group by a.dept_id
order by a.dept_id




select dept_id
		 , case when title = '���' then sum(salary) 
		   else 0
		   end as ���
		 , case when title = '����' then sum(salary) 
		   else 0
		   end as ����
		 , case when title not in('���', '����') then sum(salary)
		   else 0
		   end as ��Ÿ
	     , sum(salary) as �μ��հ�
   from s_emp
group by dept_id, title
having sum(��Ÿ), sum(�μ��հ�)


