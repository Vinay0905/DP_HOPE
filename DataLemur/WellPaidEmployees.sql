SELECT e.employee_id as employee_id,e.name as employee_name
FROM employee e
inner join employee m 
on e.manager_id=m.employee_id
WHERE e.salary > m.salary
LIMIT 2;