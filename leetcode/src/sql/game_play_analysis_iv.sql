select round(count(distinct case when datediff(a.next_date, a.event_date) = 1 then a.player_id end) / count(distinct a.player_id), 2) as fraction
from
(
    select player_id, event_date, 
        lead(event_date, 1) over(partition by player_id order by event_date) as next_date,
        row_number() over(partition by player_id order by event_date) as rn
    from Activity
) a
where a.rn = 1