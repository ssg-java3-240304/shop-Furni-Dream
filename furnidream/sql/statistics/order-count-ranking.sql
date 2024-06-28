# [모든 기간/전체 상품] 상품별 주문량 순위 내림차순으로 가져오기
## 1. 주문완료인 주문 번호 가져오기
select order_code
from tbl_order
where order_status = 5;

## 2. 주문완료 상태인 주문 번호로 상품번호 가져오기
select product_id
from tbl_order_product
where order_code in (select order_code
                     from tbl_order
                     where order_status = 5);

## 3. [2.]번 데이터에서 상품번호로 그룹화하고 상품에 대한 주문수량 내림차순으로 가져오기
select product_id, SUM(quantity)
from tbl_order_product
where order_code in (select order_code
                     from tbl_order
                     where order_status = 5)
group by product_id
order by SUM(quantity) desc;

## 4. 최종 [3.]번 데이터에서 상품 테이블과 조인하여 추가 데이터(이름, 카테고리)를 가져오기
select product_code, product_name, category, SUM(o.quantity) quantity
from (select product_id, SUM(quantity) quantity
      from tbl_order_product
      where order_code in (select order_code
                           from tbl_order
                           where order_status = 5)
      group by product_id) o
         JOIN tbl_product p on o.product_id = p.product_id
group by p.product_code, product_name, category
order by quantity desc;



## 테스트
## 50, 51, 52
select *
from tbl_product
where product_code = 'SOFA013';

## 50, 51, 52 총 주문수량 6개
select product_id, SUM(quantity)
from tbl_order_product
where order_code in (select order_code
                     from tbl_order
                     where order_status = 5)
group by product_id
having product_id in (50, 51, 52)
order by SUM(quantity) desc;

# [분기별/전체 상품] (year, quarter 변수로 변경 필수!!!)
select product_code, product_name, category, SUM(o.quantity) quantity
from (select product_id, SUM(quantity) quantity
      from tbl_order_product
      where order_code in (select order_code
                           from tbl_order
                           where order_status = 5
                             and YEAR(created_at) = 2024
                             and QUARTER(created_at) = 2)
      group by product_id) o
         JOIN tbl_product p on o.product_id = p.product_id
group by p.product_code, product_name, category
order by quantity desc;


## 분기별 완료된 주문 코드, 날짜 확인
select order_code, created_at, order_status
from tbl_order
where order_status = 5
  and YEAR(created_at) = 2023
  and QUARTER(created_at) = 2;

# [월별/전체 상품]   (year, month 변수로 변경 필수!!!)
select product_code, product_name, category, SUM(o.quantity) quantity
from (select product_id, SUM(quantity) quantity
      from tbl_order_product
      where order_code in (select order_code
                           from tbl_order
                           where order_status = 5
                             and YEAR(created_at) = 2024
                             and MONTH(created_at) = 4)
      group by product_id) o
         JOIN tbl_product p on o.product_id = p.product_id
group by p.product_code, product_name, category
order by quantity desc;

## 월별 완료된 주문코드, 날짜 확인
select order_code, created_at, order_status
from tbl_order
where order_status = 5
  and YEAR(created_at) = 2023
  and MONTH(created_at) = 5;


# --------------------------------------------------------------------

# [모든 기간/카테고리]  (category 변수로 변경 필수!!!)
select product_code, product_name, category, SUM(o.quantity) quantity
from (select product_id, SUM(quantity) quantity
      from tbl_order_product
      where order_code in (select order_code
                           from tbl_order
                           where order_status = 5)
      group by product_id) o
         JOIN (select * from tbl_product where category = '소파') p on o.product_id = p.product_id
group by p.product_code, product_name, category
order by quantity desc;


# [분기별/카테고리] 상품별 주문량 순위 내림차순으로 가져오기 (category, year, quarter 변수로 변경 필수!!!)
select product_code, product_name, category, SUM(o.quantity) quantity
from (select product_id, SUM(quantity) quantity
      from tbl_order_product
      where order_code in (select order_code
                           from tbl_order
                           where order_status = 5
                             and YEAR(created_at) = 2024
                             and QUARTER(created_at) = 2)
      group by product_id) o
         JOIN (select * from tbl_product where category = '소파') p on o.product_id = p.product_id
group by p.product_code, product_name, category
order by quantity desc;

# [월별/카테고리] 상품별 주문량 순위 내림차순으로 가져오기  (category, year, month 변수로 변경 필수!!!)
select product_code, product_name, category, SUM(o.quantity) quantity
from (select product_id, SUM(quantity) quantity
      from tbl_order_product
      where order_code in (select order_code
                           from tbl_order
                           where order_status = 5
                             and YEAR(created_at) = 2024
                             and MONTH(created_at) = 4)
      group by product_id) o
         JOIN (select * from tbl_product where category = '소파') p on o.product_id = p.product_id
group by p.product_code, product_name, category
order by quantity desc;


# 원가 추가
# alter table tbl_order_product ADD cost_price int NOT NULL DEFAULT 1000;
# ALTER TABLE tbl_order_product ALTER cost_price DROP DEFAULT;
# SELECT COLUMN_NAME, COLUMN_DEFAULT
# FROM INFORMATION_SCHEMA.COLUMNS
# WHERE TABLE_NAME = 'tbl_order_product'
#   AND TABLE_SCHEMA = 'furnidb'
#   AND COLUMN_NAME = 'net_profit';
#
# ALTER TABLE tbl_order_product
#     CHANGE net_profit cost_price int;