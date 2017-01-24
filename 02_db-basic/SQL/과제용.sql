

select emp.first_name, emp.salary, loc.city
  from employees emp
inner join departments dep on emp.department_id = dep.department_id  
inner join locations loc on  loc.location_id = dep.location_id
 where loc.city like '%attle%'
   and salary >= 15000 

   
   
select department_id
		, department_name
		, manager_id
  from departments
 where department_id = 110