select a.request_at as Day, round(sum(case when status in ('cancelled_by_driver', 'cancelled_by_client') then 1 else 0 end) / sum(1), 2) as 'Cancellation Rate'
from Trips a, Users b, Users c
where a.client_id = b.users_id
and b.role = 'client'
and b.banned = 'No'
and a.driver_id = c.users_id
and c.role = 'driver'
and c.banned = 'No'
and a.request_at >= '2013-10-01'
and a.request_at <= '2013-10-03'
group by a.request_at