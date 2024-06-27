# 월별 매출 통계
select MONTH(created_at) month, SUM(total_price) total_price
from tbl_order
where order_status = 5
  and YEAR(created_at) = 2024
group by MONTH(created_at)
order by MONTH(created_at) month;