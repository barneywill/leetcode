CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
        select null as SecondHighestSalary
        from Employee
        having count(distinct salary) < N
        union all
        select salary as SecondHighestSalary
        from
        (
            select salary, dense_rank() over(order by salary desc) as rn
            from Employee
            order by salary desc
        ) a
        where rn = N
        limit 1
  );
END