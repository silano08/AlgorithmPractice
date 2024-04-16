-- 코드를 작성해주세요

select E1.ID, COUNT(E2.ID) CHILD_COUNT
from ECOLI_DATA E1 left join ECOLI_DATA E2 on E1.ID = E2.PARENT_ID
group by E1.ID
order by E1.ID

# select E1.ID,E1.PARENT_ID,E2.ID,E2.PARENT_ID
# from ECOLI_DATA E1 left join ECOLI_DATA E2 on E1.ID = E2.PARENT_ID
# where 
