delete from Person
where id not in
(
    select min_id
    from (
        select email, min(id) min_id
        from Person
        group by email
    ) a
)