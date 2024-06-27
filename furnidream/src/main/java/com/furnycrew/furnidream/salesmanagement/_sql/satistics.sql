select * from tbl_order order by created_at;

select * from tbl_order order by order_code;
select * from tbl_order;
select * from tbl_order_product;
select * from tbl_order_canceled;
select * from tbl_product;
select * from tbl_customer;


select p.product_name,
       (select sum(op.quantity * op.price)
        from tbl_product p
                 left join tbl_order_product op
                           on p.product_id = op.product_id
                 left join tbl_order o
                           on op.order_code = o.order_code
                 left join tbl_customer c
                           on o.customer_id = c.customer_id
        where c.age >=10 and c.age<20
        group by p.product_name, c.age)

from tbl_product p
         left join tbl_order_product op on p.product_id = op.product_id
         left join tbl_order o on op.order_code = o.order_code
         left join tbl_customer c on o.customer_id = c.customer_id
group by p.product_name
order by p.product_name;

# select sum(op.quantity * op.price)
# from tbl_product p
#          left join tbl_order_product op
#                    on p.product_id = op.product_id
#          left join tbl_order o
#                    on op.order_code = o.order_code
#          left join tbl_customer c
#                    on o.customer_id = c.customer_id
# where c.age >=10 and c.age<20
# group by p.product_name, c.age;


select * from tbl_customer;
select * from tbl_order left join tbl_customer on tbl_order.customer_id = tbl_customer.customer_id
where age >= 10 and age <20;

select
    *
from tbl_order o
         left join tbl_order_product op
                   using (order_code)
         left join tbl_order_canceled using (order_code);

-- 일자별 매출 합계
select
    date_format(o.created_at, '%Y-%m-%d') 주문일자,
    sum(op.quantity) 주문건수,
    sum(op.quantity * op.price) 결제금액,
    ifnull(sum(oc.refund_amount), 0) 환불합계,
    sum(op.quantity * op.price) - ifnull(sum(oc.refund_amount), 0) 매출합계
from tbl_order o
         left join tbl_order_product op
                   using (order_code)
         left join tbl_order_canceled oc using (order_code)
group by
    date_format(created_at, '%Y-%m-%d')
order by 주문일자;

-- 월별 매출 합계
select
    date_format(o.created_at, '%Y-%m') 주문일자,
    sum(op.quantity) 주문건수,
    sum(op.quantity * op.price) 결제금액,
    ifnull(sum(oc.refund_amount), 0) 환불합계,
    sum(op.quantity * op.price) - ifnull(sum(oc.refund_amount), 0) 매출합계

from tbl_order o
         left join tbl_order_product op
                   using (order_code)
         left join tbl_order_canceled oc using (order_code)
group by
    date_format(created_at, '%Y-%m')
order by 주문일자;

-- 분기별
select
    concat(date_format(o.created_at, '%Y'), '-',quarter(o.created_at), '분기') dateQuater,
    sum(op.quantity) 주문건수,
    sum(op.quantity * op.price) 결제금액,
    ifnull(sum(oc.refund_amount), 0) 환불합계,
    sum(op.quantity * op.price) - ifnull(sum(oc.refund_amount), 0) 매출합계

from tbl_order o
         left join tbl_order_product op
                   using (order_code)
         left join tbl_order_canceled oc using (order_code)
group by
    dateQuater
order by
    dateQuater;

-- 연령대별
# SELECT
#     p.product_name AS productName,
#     (select format(sum(op.price * op.quantity), 0)
#      from tbl_order_product op
#             left join tbl_order o
#                     on op.order_code = o.order_code
#             left join tbl_customer c
#                     on o.customer_id = c.customer_id
#      where
#          c.age >= 10 and c.age < 20),
# #      group by
# #         op.product_id )AS  teenager,
#     (select sum(op.price * op.quantity)
#      from tbl_order_product op
#               left join tbl_order o
#                         on op.order_code = o.order_code
#               left join tbl_customer c
#                         on o.customer_id = c.customer_id
#      where
#          c.age >= 20 and c.age < 30) AS twenties,
#     (select sum(op.price * op.quantity)
#      from tbl_order_product op
#               left join tbl_order o
#                         on op.order_code = o.order_code
#               left join tbl_customer c
#                         on o.customer_id = c.customer_id
#      where
#          c.age >= 30 and c.age < 40) AS thirties,
#     (select sum(op.price * op.quantity)
#      from tbl_order_product op
#               left join tbl_order o
#                         on op.order_code = o.order_code
#               left join tbl_customer c
#                         on o.customer_id = c.customer_id
#      where
#          c.age >= 40 and c.age < 50) AS forties,
#     (select sum(op.price * op.quantity)
#      from tbl_order_product op
#               left join tbl_order o
#                         on op.order_code = o.order_code
#               left join tbl_customer c
#                         on o.customer_id = c.customer_id
#      where
#          c.age >= 50) AS fifties,
#     SUM(op.quantity * op.price) AS totalSales
# FROM
#     tbl_order o
#         LEFT JOIN tbl_order_product op ON o.order_code = op.order_code
#         LEFT JOIN tbl_customer c ON o.customer_id = c.customer_id
#         LEFT JOIN tbl_product p
#                 ON op.product_id = p.product_id
# GROUP BY
#     p.product_name,
#     c.
# ORDER BY
#     productName DESC;

-- 연령별 매출 조회 / 합계
SELECT
    p.product_name,
    format(SUM(CASE WHEN c.age >= 20 AND c.age < 25 THEN o.total_price ELSE 0 END), 0) AS '20-24세',
    format(SUM(CASE WHEN c.age >= 25 AND c.age < 30 THEN o.total_price ELSE 0 END), 0) AS '25-29세',
    format(SUM(CASE WHEN c.age >= 30 AND c.age < 35 THEN o.total_price ELSE 0 END), 0) AS '30-34세',
    format(SUM(CASE WHEN c.age >= 35 AND c.age < 40 THEN o.total_price ELSE 0 END), 0) AS '35-39세',
    format(SUM(CASE WHEN c.age >= 40 AND c.age < 45 THEN o.total_price ELSE 0 END), 0) AS '40-44세',
    SUM(o.total_price) AS 매출합계
FROM
tbl_order o
    left join tbl_customer c ON o.customer_id = c.customer_id
    right join tbl_order_product op ON o.order_code = op.order_code
    left join tbl_product p ON op.product_id = p.product_id
GROUP BY
    p.product_name
ORDER BY
    p.product_name;



-- 상품별 매출 내역
select
    p.product_name,
    (select sum(op.quantity * op.price)
    from tbl_order_product op left join tbl_order o on op.order_code = o.order_code
    left join tbl_customer c on o.customer_id = c.customer_id where c.gender = 'M' group by p.product_name) 남자매출액 ,
    sum(o.total_price)

from tbl_order o
         left join tbl_order_canceled oc
                   using (order_code)
         left join tbl_order_product op
                   using (order_code)
         left join tbl_product p
                   using (product_id)
group by
    p.product_name
order by
    p.product_name ;

SELECT
    p.product_name,
    SUM(CASE WHEN c.gender = 'M' THEN op.quantity * op.price ELSE 0 END) AS 남자매출액,

    SUM(CASE WHEN c.gender = 'W' THEN op.quantity * op.price ELSE 0 END) AS 여자매출액,
    SUM(o.total_price) AS 총매출액
FROM
    tbl_order o
        LEFT JOIN tbl_order_product op ON o.order_code = op.order_code
        LEFT JOIN tbl_customer c ON o.customer_id = c.customer_id
        LEFT JOIN tbl_product p ON op.product_id = p.product_id
GROUP BY
    p.product_name
ORDER BY
    p.product_name;

select * from tbl_customer join tbl_order where gender = 'M'
select * from tbl_customer join tbl_order where gender = 'W';

-- 성별

select
    p.product_name,
    sum(op.quantity),
    sum(o.total_price)

from
    tbl_order_product op left join tbl_order o using(order_code)
left join tbl_product p using (product_id)
group by
    p.product_name
order by
    p.product_name;