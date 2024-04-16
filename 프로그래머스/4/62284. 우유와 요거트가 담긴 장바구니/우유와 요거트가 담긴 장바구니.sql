-- 코드를 입력하세요
# SELECT CART_ID,NAME
# FROM CART_PRODUCTS 
# WHERE NAME = 'Milk'


select distinct m.CART_ID
from (select CART_ID, NAME
from CART_PRODUCTS
where NAME = 'Milk'
     order by ID) m 
join (select CART_ID, NAME
from CART_PRODUCTS
where NAME = 'Yogurt'
     order by ID) y
on m.CART_ID = y.CART_ID