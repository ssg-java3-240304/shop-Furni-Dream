# [모든 기간/전체] 상품별 순수익 내림차순으로 가져오기
select product_code, product_name, category, SUM(o.net_profit) net_profit
from (select product_id, SUM((price - cost_price) * quantity) net_profit
      from tbl_order_product
      where order_code in (select order_code
                           from tbl_order
                           where order_status = 5)
      group by product_id) o
         JOIN tbl_product p on o.product_id = p.product_id
group by p.product_code, product_name, category
order by net_profit desc;


## 16개 75번상품 16,784,000원
select product_id, SUM((price - cost_price) * quantity) net_profit
from tbl_order_product
where order_code in (select order_code
                     from tbl_order
                     where order_status = 5)
  and product_id = 75
group by product_id;

# [분기별/전체] 상품별 순수익 내림차순으로 가져오기 (year, quarter로 변수 변경 필수!!!)
select product_code, product_name, category, SUM(o.net_profit) net_profit
from (select product_id, SUM((price - cost_price) * quantity) net_profit
      from tbl_order_product
      where order_code in (select order_code
                           from tbl_order
                           where order_status = 5
                             and YEAR(created_at) = 2024
                             and QUARTER(created_at) = 2)
      group by product_id) o
         JOIN tbl_product p on o.product_id = p.product_id
group by p.product_code, product_name, category
order by net_profit desc;


# [월별/전체] 상품별 순수익 내림차순으로 가져오기 (year, month로 변수 변경 필수!!!)
select product_code, product_name, category, SUM(o.net_profit) net_profit
from (select product_id, SUM((price - cost_price) * quantity) net_profit
      from tbl_order_product
      where order_code in (select order_code
                           from tbl_order
                           where order_status = 5
                             and YEAR(created_at) = 2024
                             and MONTH(created_at) = 4)
      group by product_id) o
         JOIN tbl_product p on o.product_id = p.product_id
group by p.product_code, product_name, category
order by net_profit desc;

# [모든 기간/카테고리] 상품별 순수익 내림차순으로 가져오기 (category 변수 변경 필수!!!)
select product_code, product_name, category, SUM(o.net_profit) net_profit
from (select product_id, SUM((price - cost_price) * quantity) net_profit
      from tbl_order_product
      where order_code in (select order_code
                           from tbl_order
                           where order_status = 5)
      group by product_id) o
         JOIN (select * from tbl_product where category = '소파') p on o.product_id = p.product_id
group by p.product_code, product_name, category
order by net_profit desc;

# [분기별/카테고리] 상품별 순수익 내림차순으로 가져오기 (category, year, quarter 변수 변경 필수!!!)
select product_code, product_name, category, SUM(o.net_profit) net_profit
from (select product_id, SUM((price - cost_price) * quantity) net_profit
      from tbl_order_product
      where order_code in (select order_code
                           from tbl_order
                           where order_status = 5
                             and YEAR(created_at) = 2024
                             and QUARTER(created_at) = 2)
      group by product_id) o
         JOIN (select * from tbl_product where category = '소파') p on o.product_id = p.product_id
group by p.product_code, product_name, category
order by net_profit desc;


# [월별/카테고리] 상품별 순수익 내림차순으로 가져오기 (category, year, month 변수 변경 필수!!!)
select product_code, product_name, category, SUM(o.net_profit) net_profit
from (select product_id, SUM((price - cost_price) * quantity) net_profit
      from tbl_order_product
      where order_code in (select order_code
                           from tbl_order
                           where order_status = 5
                             and YEAR(created_at) = 2023
                             and MONTH(created_at) = 12)
      group by product_id) o
         JOIN (select * from tbl_product where category = '소파') p on o.product_id = p.product_id
group by p.product_code, product_name, category
order by net_profit desc;

# "소파, 2023, 12", "침대, 2024, 1","의자, 2024, 4"