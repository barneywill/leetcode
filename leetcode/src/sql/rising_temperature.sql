select a.id
from Weather a, Weather b
where a.recordDate > b.recordDate
and a.temperature > b.temperature
and datediff(a.recordDate, b.recordDate) = 1