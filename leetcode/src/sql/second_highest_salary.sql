-- working
select null as SecondHighestSalary
from Employee
having count(distinct salary) < 2
union all
select salary as SecondHighestSalary
from
(
    select salary, dense_rank() over(order by salary desc) as rn
    from Employee
    order by salary desc
) a
where rn = 2
limit 1

-- not working
select next_salary as SecondHighestSalary
from
(
	select salary, lead(salary) over (order by salary desc) as next_salary
	from Employee
    order by salary desc
    limit 1
) a
