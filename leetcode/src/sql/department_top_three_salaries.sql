select a.Department, a.Employee, a.Salary
from 
(
    select a.name as Department, b.name as Employee, b.salary as Salary, 
        dense_rank() over(partition by b.departmentId order by b.salary desc) as rn
    from Department a, Employee b
    where a.id = b.departmentId  
) a
where a.rn <= 3