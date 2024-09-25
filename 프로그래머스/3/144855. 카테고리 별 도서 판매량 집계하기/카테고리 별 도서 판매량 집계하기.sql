SELECT b.CATEGORY, SUM(bs.SALES) as TOTAL_SALES 
from BOOK b
    inner join BOOK_SALES bs
    on (b.BOOK_ID = bs.BOOK_ID)
where TO_CHAR(SALES_DATE, 'YYYY-MM-DD') LIKE '2022-01%'
group by b.CATEGORY
order by b.CATEGORY;