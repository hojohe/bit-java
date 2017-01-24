-----------------------------------------
--WHERE
-----------------------------------------
-- between a and b : a와 b 사이의 값을 선택한다 (a, b 포함)

-- 급여가 10000 이상이고 15000 이하인 사원의 정보를 출력
select *
  from employees
 where salary >= 10000
   and salary <= 15000;

select *
  from employees
 where salary between 10000 and 15000;
 
-- IN 연산자 : 컬럼명 in (값, ...);

 -- 사원의 부서가 90, 100, 110, 120, 130, 150에 소속된 사원의 정보를 출력
select *
  from employees
 where department_id in (90, 100, 110, 120, 130, 150);

-- Like 연산자 : 컬럼명 like '패턴', %(0개 이상 문자), _(한개 문자)

 -- 사원의 이름이 L로 시작하는 사원 정보를 출력
 select *
   from employees
  where last_name like 'L%';
 
-- 이메일이 D로 시작하고 T로 끝나는 사원의 정보
 select *
   from employees
  where email like 'D%T';

-- 이름이 'King'인 사원의 정보를 출력
select *
  from employees
 where last_name = 'King';
 
-- IS NULL 연산자
-- null 은 "미정의 값"
-- null 과의 산술연산의 결과는 null
select last_name, salary, commission_pct
  from employees;

select last_name, salary, commission_pct
  from employees
 where commission_pct is null;

select last_name
     , salary
     , case when commission_pct is null then (salary * 15)
            else (salary * 15 + salary * 15 * commission_pct) end as 연봉
  from employees;
   
select last_name
	, salary
	, salary * 15 + salary * 15 * nvl(commission_pct, 0) as year_sal
  from employees;	
  
  

-----------------------------------------------
--ORDER BY : ASC(오름차순), DESC(내림차순)
--ORDER BY 표현식 | 컬럼명 [ASC(디폴트:생략가능) | DESC]
-----------------------------------------------
-- 급여가 높은 사원부터 화면에 출력하시오
select last_name, salary
  from employees
order by salary desc;

-- 급여가 낮은 사원부터 화면에 출력하시오
select last_name, salary
  from employees
order by salary;
   
-- 사원의 정보를 출력합니다(이름, 부서번호, 급여)
-- 단, 부서번호 순으로 출력하세오. 부서번호가 같은 사원들은 급여순으로 출력합니다.
select last_name, department_id, salary
  from employees
order by department_id, salary;

-- 연봉이 많은 사원부터 출력하시오
select last_name
	, salary
	, salary * 15 + salary * 15 * nvl(commission_pct, 0) as year_sal
  from employees
order by year_sal desc;


-- distinct : 중복된 결과를 제거
select department_id
  from employees;
  
select distinct(department_id)
  from employees
order by department_id;


-----------------------------------------------
--GROUP BY : 데이터를 소그룹으로 묶는다.
--그룹 함수: 여러개의 데이터를 받아서 하나의 결과를 반환
--		: COUNT(표현식 | 컬럼명), SUM(포현식 | 컬럼명), MAX(표현식 | 컬럼명)
--		: MIN(표현식 | 컬럼명), AVG(표현식 | 컬럼명)
--		: null 값 배제 -> sum(nvl(commission_pct,0)) = nvl 불필요
-----------------------------------------------

select count(last_name), sum(salary), max(salary), min(salary), avg(salary)
	 , sum(commission_pct)
  from employees;


-- 50번 부서의 사원들의 급여중에서 가장 많은 급여가 얼마인지 출력
select max(salary)
  from employees
 where department_id = 50;


-- 부서별로 급여 출력
select department_id, max(salary) as max_sal
  from employees
group by department_id
order by max_sal desc;
 
 
-----------------------------------------------
--HAVING : 그룹에 대한 제약을 처리한다.(조건)--
-----------------------------------------------
select department_id, max(salary) as max_sal
  from employees
group by department_id
having max(salary) >= 10000
order by max_sal desc;

-- 부서별 평균 급여를 출력합니다.
-- 단, 100번보다 큰 부서는 제외하고 부서의 평균 급여가 5000이상인 부서만 출력합니다.
-- 부서번호 순으로 출력합니다.
select department_id, avg(salary)
  from employees
where department_id < 100
group by department_id
having avg(salary) >= 5000 
order by department_id;


--실행순서
FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY


-----------------------------------------------
--내장함수 : DBMS에서 기본적으로 제공되는 함수(단일행, 그룹행)
-----------------------------------------------
단일행 - 문자, 숫자, 날짜, 변환형, 기차
-- 문자 함수
select last_name, lower(last_name), upper(last_name), concat(last_name, '사원')
  from employees;
--concat(last_name, '사원') = last_name || '사원'


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
	 , translate(last_name,'Ab', 'uk') -- 글자 하나당
	 , replace(last_name,'Ab', 'uk')   -- 단어 통으로
  from employees;


-- 숫자형 함수
select abs(100), abs(-100)
  from dual;

-- ceil  = 입력된 값보다 크거나 같으면서 가장작은 정수
-- floor = 입력된 값보다 작거나 같으면서 가장큰 정수
-- sign  = 양수 음수 구분 
select ceil(1.1), floor(1.1), sign(-12), sign(0), sign(12)
  from dual;
  
-- round = 반올림
-- trunc = 버림
select round(73.727), round(73.727,2), round(73.727,-2)
	 , trunc(73.727), trunc(73.727,2), trunc(73.727,-2)
  from dual;

  
-- 날짜 함수
select sysdate, add_months(sysdate, 2), add_months(sysdate, -1)
  from dual;
  
-- 각 사원의 입사일로 부터 1년이 되는 날짜를 출력하시오.
select * from employees;

select last_name, hire_date, add_months(hire_date, 12)
  from employees;
  
select last_name, hire_date, trunc(months_between(sysdate, hire_date))
  from employees;

select sysdate, last_day(sysdate)
  from dual;

-- 날짜 +- 숫자 = 날짜, 날짜 +- 날짜 = 숫자
select sysdate, sysdate + (1/24 * 5), sysdate -7
  from dual;

-- 각 사원의 근무일수를 출력하시오.
select trunc((sysdate - 1) - hire_date), hire_date
  from employees;

  
-- 변환형 함수
-- to_date : 문자 -> 날짜
-- to_number : 문자 -> 숫자
-- to_char : 날짜 -> 문자, 숫자 -> 문자
select to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')
	 , to_date('20161120')
  from dual;

insert into tb_board(no, title, writer, content, reg_date)
values(6, 'a', 'b', 'c', '20161230');
select * from tb_board;

-- 패턴문자 : 9(자리수), 0(자리수-남는 자리에 0을 표시), ","
select to_char(1000, '999,999,999,999')
	 , to_number('51,000', '99,999')
  from dual;

-- 사원중에서 5월에 입사한 사원들의 정보만 출력하시오
select *
  from employees
 where substr(to_char(hire_date,'yyyy-mm-dd'),6,2) = '05';

select *
  from employees
 where to_char(hire_date,'mm') = to_char(sysdate, 'mm');
 
 
-- 기타함수 : decode, case ~ end - 기본적인 통계 정보 추출시..
select job_id, decode(job_id, 'IT_PROG', '개발자'
							, 'SA_MAN', '세일즈'
							, '그냥 직원') as job_type
  from employees;

  
select job_id
     , case when job_id = 'IT_PROG' then '개발자'
			when job_id = 'SA_MAN'  then '세일즈'
			else '그냥 직원' 
	   end as job_type
  from employees;
  

  
select last_name
	 , salary
     , case when salary >= 10000 then '우후...'
			when salary between 5000 and 10000  then '아이...'
			else '에이...' 
	   end as salary_
  from employees
order by salary
  


  
  
  
  
  
  
  
 
