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