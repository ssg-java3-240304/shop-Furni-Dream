# [모든 기간/전체] 상품별 순수익 내림차순으로 가져오기
select product_code, product_name, category, SUM(o.net_profit) net_profit
from (select product_id, SUM((price-cost_price)*quantity) net_profit
      from tbl_order_product
      where order_code in (select order_code
                           from tbl_order
                           where order_status = 5)
      group by product_id) o
         JOIN tbl_product p on o.product_id = p.product_id
group by p.product_code, product_name, category
order by net_profit desc;


# 16개 75번상품 16,784,000원
select product_id, SUM((price-cost_price)*quantity) net_profit
from tbl_order_product
where order_code in (select order_code
                     from tbl_order
                     where order_status = 5) and product_id= 75
group by product_id;