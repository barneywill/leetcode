
select b.name Department, a.name as Employee, a.salary as Salary
from Employee a, Department b,
(
    select departmentId, max(salary) maxSalary
    from Employee
    group by departmentId
) c
where a.departmentId = b.id
and a.departmentId = c.departmentId
and a.salary = c.maxSalary
