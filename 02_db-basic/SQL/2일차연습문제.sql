select *
  from s_emp;
  
-----
--1번
-----
select name, title, dept_id, salary
  from s_emp
 where dept_id in ('112', '118')
   and title in ('과장', '사원')
   and salary between 1500 and 4000
order by salary desc
   
-----
--2번
-----
select name, title, salary
  from s_emp
 where manager_id is null
 
-----
--3번
-----
select name, title, salary
  from s_emp
 where title like '%부장'
   and salary >= 3000
order by name

-----
--4번
-----
select name, title, salary
  from s_emp
 where dept_id in (112,113,117,118)
   and salary between 2300 and 3000

-----
--5번
-----  
select name, title, salary, start_date
  from s_emp
 where regexp_like (title, '부장|과장')
   and to_char(start_date, 'mm') = '03'
   
-----
--6번
-----
select name, title, salary, salary * 16 as salary_year ,salary * 16 + 1000 as plus1000
  from s_emp
order by salary


-----
--7번
-----
select name, title || '의 급여 ' || salary as commend
  from s_emp
order by id

-----
--8번
-----
select *
  from s_emp
 where manager_id is not null
   and commission_pct is not null
   and salary >= 2500
order by name, salary

-----
--9번
-----
select dept_id, min(salary) as salary_min
  from s_emp
group by dept_id
order by dept_id

------
--10번
------
select title, min(salary) as salary_min
  from s_emp
where title not like '%부장'
group by title

------
--11번
------
select title, avg(salary) as salary_avg
  from s_emp
group by title

------
--12번
------
select title, count(*) as cnt
  from s_emp
group by title

------
--13번
------
select title, max(salary) as salary_max
  from s_emp
group by title
having max(salary) > 2000

------
--14번
------
select title, min(salary) as salary_min
  from s_emp
where title not like '%부장'
group by title
order by salary_min desc

------
--15번
------
select title, avg(salary) as salary_avg
  from s_emp
 where title != '사원'
group by title
order by salary_avg

------
--16번
------
select title, sum(salary) as salary_sum
  from s_emp
 where title != '사원'
group by title
having sum(salary) >= 2000
order by salary_sum desc

------
--17번
------
select title, name
	 , upper(substr(mailid, 1, 1)) 
	|| lower(substr(mailid, 2, length(mailid))) as ch_mailid
	 , mailid
  from s_emp

 
------
--18번
------
select name
  from s_emp
 where length(name) > 2
 
------
--19번
------
select name
	 , to_char(trunc(months_between(sysdate, start_date)) * salary, '999,999,999') as salary_tot
  from s_emp

 
 
------
--20번
------
select name
     , case when to_char(commission_pct) is null then '커미션없음'
            else to_char(commission_pct)
       end as commission
  from s_emp

 
------
--21번
------
select title, name
	 , case when title = '사원' then to_char(salary + (salary * 0.1), '999,999,999') 
	  		when title = '과장' then to_char(salary + (salary * 0.2), '999,999,999') 
	   else to_char(salary + (salary * 0.1), '999,999,999') 
	   end as salary
  from s_emp
order by id, name, salary


------
--22번
------
select id, name, title, salary, trunc(salary / 100) as salary_trunc
    , rpad('*', trunc(salary / 100), '*') as result
  from s_emp
order by result desc
 
------
--23번
------
select a.dept_id as 부서번호
  	 , max(a.사원) as 사원
  	 , max(a.과장) as 과장
  	 , sum(a.기타) as 기타
  	 , sum(a.부서합계) as 부서합계
  from (
	select dept_id
		 , case when title = '사원' then sum(salary) 
		   else 0
		   end as 사원
		 , case when title = '과장' then sum(salary) 
		   else 0
		   end as 과장
		 , case when title not in('사원', '과장') then sum(salary)
		   else 0
		   end as 기타
	     , sum(salary) as 부서합계
	  from s_emp
	group by dept_id, title
) a
group by a.dept_id
order by a.dept_id




select dept_id
		 , case when title = '사원' then sum(salary) 
		   else 0
		   end as 사원
		 , case when title = '과장' then sum(salary) 
		   else 0
		   end as 과장
		 , case when title not in('사원', '과장') then sum(salary)
		   else 0
		   end as 기타
	     , sum(salary) as 부서합계
   from s_emp
group by dept_id, title
having sum(기타), sum(부서합계)


