select a.name as Customers
from Customers a
where not exists (select 1 from Orders b where a.id = b.customerId)