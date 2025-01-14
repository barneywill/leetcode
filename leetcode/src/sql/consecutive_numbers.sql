select distinct(num) ConsecutiveNums
from
(
    select id, num, lag(num, 1) over(order by id) as lag1, lag(num, 2) over(order by id) as lag2
    from Logs
    order by id
) a
where a.num = a.lag1 and a.num = a.lag2