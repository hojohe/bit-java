----------------------
--JOIN
----------------------
-- cartesian Product : 연결조건(증거조건)이 잘못되거나 의도적으로 조건을
-- 주지 않은 경우 m * n 의 결과가 반환되는 조인
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
--오리지널
----------
-- 테이블 alias 사용하기
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
 
-- Canada 에 근무하는 사원의 지역명, 부서명, 사원명 출력하시오
select emp.last_name
	 , dep.department_name
	 , loc.city
  from employees emp, departments dep, locations loc, countries ctr
 where ctr.country_id = loc.country_id
   and loc.location_id = dep.location_id
   and dep.department_id = emp.department_id
   and ctr.country_name = 'Canada';
   
-- 각 사원의 job_id에 해당하는 최대 받을 수 있는 급여와
-- 최소 급여가 얼마인지 출력하시오
select emp.last_name
	 , emp.job_id
	 , job.job_title
	 , job.min_salary
	 , job.max_salary 
  from employees emp, jobs job
 where emp.job_id = job.job_id;


-- Oracle 9i 부터 지원 
-------------
--INNER JOIN
------------- 
-- 테이블 ALIAS 사용하기
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
 
-- Canada 에 근무하는 사원의 지역명, 부서명, 사원명 출력하시오
select emp.last_name
	 , dep.department_name
	 , loc.city
  from employees emp
inner join departments dep on dep.department_id = emp.department_id
inner join locations loc on loc.location_id = dep.location_id
inner join countries ctr on ctr.country_id = loc.country_id
 where ctr.country_name = 'Canada';
   
-- 각 사원의 job_id에 해당하는 최대 받을 수 있는 급여와
-- 최소 급여가 얼마인지 출력하시오
select emp.last_name
	 , emp.job_id
	 , job.job_title
	 , job.min_salary
	 , job.max_salary 
  from employees emp
inner join jobs job
 on emp.job_id = job.job_id;

-- 사원의 급여와 급여등급을 화면에 출력
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
select e.last_name as 사원명
     , m.last_name as 관리자명
  from employees e, employees m
 where e.manager_id = m.employee_id;
-- self join -> inner join 결과가 다르다
select e.last_name as 사원명
     , m.last_name as 관리자명
  from employees e
inner join employees m on e.employee_id = m.employee_id;

-------------
-- OUTER JOIN
-------------
select e.last_name as 사원명
     , m.last_name as 관리자명
  from employees e, employees m
 where e.manager_id = m.employee_id(+);

-- 관리자가 없는 사원은 "관리자없음"을 출력한다.
select e.last_name as 사원명
     , nvl(m.last_name, '관리자명') as 관리자명
  from employees e, employees m
 where e.manager_id = m.employee_id(+);

-------------
-- OUTER JOIN
-------------
-- full (oracle 9부터 추가됨 양쪽에 (+)) 
-- right 오른쪽에(+)
-- left 왼쪽에(+)
select e.last_name as 사원명
     , nvl(m.last_name, '관리자없음') as 관리자명
  from employees e
  left outer join employees m
 	on e.manager_id = m.employee_id;
 	
--------------
-- SET 연산자
--------------
union -> 정렬하고 중복 제거 결과를 줌
union all -> 정렬하지 않고 중복되는 결과를 줌

-- 합집합(중복O). 모든 결과를 출력한다(중복 포함)
select no, data
  from tc_seta
union all
select no, data
  from tc_setb
  
-- 합집합(중복X). 중첩된 데이터는 한번만 출력, 자동 정렬됨
select no, data
  from tc_seta
union
select no, data
  from tc_setb;
  
-- 차집합. 앞의 결과에서 뒤의 결과를 뺀 결과를 출력
select no, data
  from tc_seta
minus
select no, data
  from tc_setb;
  
-- 교집합. 결과의 공통 데이터를 출력
select no, data
  from tc_seta
intersect
select no, data
  from tc_setb;

  
-- 주의 1. 컬럼의 개수가 동일해야 한다.
-- 주의 2. 같은 열 데이터 타입이 동일해야 한다.
-- 주의 3. 일반적으로 order by 절은 마지막에 위치해야 한다.
-- 주의 4. 컬럼명은 첫번째 SQL문의 컬럼명이 사용된다.
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
  
  
-- Chen 사원과 같은 부서에 있는 사원들의 평균 급여를 출력하시오
select avg(salary)
  from employees
 where department_id = chen 사원의 부서번호;
 
-- Chen 사원의 부서번호를 출력하시오
select department_id
  from employees
 where last_name = 'Chen'

-- 서브쿼리의 결과행이 하나인 것 : 스칼라 서브쿼리, Singlt Row SubQuery
select avg(salary)
  from employees
 where department_id = (select department_id
  						  from employees
 						 where last_name = 'Chen');
 						 
-- 서브쿼리의 결과행이 여러개인 경우 : Multi Row SubQuery
-- Multi Row SubQuery 일 경우에는 관련된 연산자를 이용
-- (in, all, any) 
select avg(salary)
  from employees
 where department_id in (select department_id
  						   from employees
 						  where last_name = 'King');
 						  
-- 30번 부서의 평균 급여보다 급여를 많이 받는 사원의 정보를 출력
select last_name, salary
  from employees
 where salary > (select avg(salary)
				   from employees
 				  where department_id = 30)
order by salary desc


-- 30번 부서의 사원들이 받는 급여보다 급여를 많이 받는 사원의 정보를 출력
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

-- 각 부서에서 가장 작은 급여를 받는 사원의 정보를 출력하시오
-- MultiColumn SubQuery : 서브쿼리의 결과가 여러개의 컬럼이 반환
select department_id, last_name, salary
  from employees
 where (department_id, salary) in (select department_id, min(salary)
  									 from employees
								   group by department_id)
order by department_id


-- 서브쿼리가 사용되는 다양한 위치
-- insert 절에서의 SubQuery
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

-- select 절에서의 SubQuery
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
 
-- 사원중에서 급여를 많이 받는 상위 5명을 출력하시오
select last_name, salary
  from employees
 where rownum < 6
order by salary desc;

-- 사원중에서 급여를 많이 받는 상위 4번째 사원명을 출력하시오
-- rownum 값을 1부터 순차적으로 맞는조건일때 다음 번호로 넘어간다.
-- 1에 맞는 조건이 없었기 때문에 4까지 갈 수 없다.
select last_name, salary
  from employees
 where rownum = 4
 
-- from 절에서의 SubQuery : inLine View
-- rownum의 이름을 임의의 이름으로 변경한 다음 부분범위 가져오기
select *
  from (select rownum rnum, last_name, salary 
      	  from employees
      	order by salary desc)
 where rnum = 4;
 
-- 페이징 처리 쿼리
select *
  from (select rownum rnum, last_name, salary 
      	  from employees
      	order by salary desc)
 where rnum between 11 and 20
order by rnum;

-- 서브쿼리를 이용한 테이블 생성 - 테이블 구조와 데이터를 복사
create table employees_copy
as
select * from employees;

-- 테이블 구조만 가져오기. 결과가 0이면 된다.
create table employees_copy
as
select * from employees where 1 != 1;


-- 테이블에 데이터를 서브쿼리를 이용해서 입력하기
insert into employees_copy
select * from employees_copy;

-- oracle : rownum과 between A and B
-- rownum 없는 곳 : order by 후에 limit 게시물 조회해올 크기 offset 어디부터위치

