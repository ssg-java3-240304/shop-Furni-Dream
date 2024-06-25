select * from tbl_order order by created_at;

select * from tbl_order;
select * from tbl_order_product;
select * from tbl_order_canceled;
select * from tbl_product;

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


-- 상품별 매출 내역
select
    p.product_name,
    sum(op.quantity) 판매수량,
    sum(o.total_price)

from tbl_order o
         left join tbl_order_canceled oc
                   using (order_code)
         left join tbl_order_product op
                   using (order_code)
         left join tbl_product p
                   using (product_id)
group by
    product_id
order by
    판매수량 desc ;

-- 연령대별
select

from tbl_order o
    left join  tbl_customer c
        on o.customer_id = c.customer_id
-- 성별

select
    p.product_name,
    p.color,
    sum(op.quantity),
    sum(o.total_price)

from tbl_order_product op left join tbl_order o using(order_code)
left join tbl_product p using (product_id)
group by
    p.product_id
order by
    product_name,
    p.color;