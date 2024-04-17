-- 코드를 입력하세요
SELECT I.ANIMAL_ID,I.ANIMAL_TYPE, I.NAME
from ANIMAL_INS I join ANIMAL_OUTS o
on I.ANIMAL_ID = O.ANIMAL_ID
where I.SEX_UPON_INTAKE LIKE 'Intact%'
AND (O.SEX_UPON_OUTCOME LIKE 'Neutered%' 
OR O.SEX_UPON_OUTCOME LIKE 'Spayed%')
order by I.ANIMAL_ID