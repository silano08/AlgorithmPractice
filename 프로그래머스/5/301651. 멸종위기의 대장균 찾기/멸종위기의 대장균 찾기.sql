with RECURSIVE Hierarchy as (
    select
    ID,
    PARENT_ID,
    1 as Level
    from 
    ECOLI_DATA 
    where 
    PARENT_ID is NULL
    
    UNION ALL
    
    select
    e.ID,
    e.PARENT_ID,
    h.Level + 1
    from
    ECOLI_DATA e
    inner join Hierarchy h on e.PARENT_ID = h.ID
)
SELECT
    count(h1.Level) as count,
    h1.Level as GENERATION
from Hierarchy h1
left Join Hierarchy h2
on h1.ID = h2.PARENT_ID
where h2.ID is null
group by GENERATION
ORDER BY
    h1.Level;