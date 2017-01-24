create table t86_group (
    id varchar2(3),
    sal number,
    job_id varchar2(2),
    dept_id number
);  

insert into t86_group values('a', 1000, 'SA', 10);  
insert into t86_group values('b', 2000, 'CM', 30);  
insert into t86_group values('c', 3000, 'CM', 20);  
insert into t86_group values('d', 4000, 'LA', 10);  
insert into t86_group values('e', 3000, 'SA', 30);
insert into t86_group values('f', 2000, 'SA', 10); 



SA 10 1000 A
SA 10 2000 F
SA 30 3000 E
--------------
CM 30 2000 B
CM 20 3000 C
--------------
LA 10 40000 D

-- job_id별 사원수를 출력하시오
select job_id, count(*) as cnt
  from t86_group
group by job_id
order by cnt


select dept_id, job_id, max(sal) as max
  from t86_group
group by dept_id, job_id
order by dept_id, job_id, max