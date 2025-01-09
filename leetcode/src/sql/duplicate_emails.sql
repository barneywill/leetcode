select email as Email
from
(
    select a.email, count(1) cnt
    from Person a
    where email is not null
    group by a.email
    having cnt > 1
) a