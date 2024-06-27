# 주문 상태
select order_status, COUNT(order_status)
from tbl_order
group by order_status;

SELECT CASE order_status
           WHEN 1 THEN 'pending'
           WHEN 2 THEN 'processing'
           WHEN 3 THEN 'shipped'
           WHEN 4 THEN 'delivered'
           WHEN 5 THEN 'completed'
           WHEN 6 THEN 'cancelled'
           END             AS order_status,
       COUNT(order_status) AS status_count
FROM tbl_order
GROUP BY order_status
order by tbl_order.order_status;


