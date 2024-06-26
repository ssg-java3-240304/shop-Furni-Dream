
drop table if EXISTS tbl_order_canceled CASCADE;
drop table if EXISTS tbl_order_product CASCADE;
DROP TABLE IF EXISTS tbl_order CASCADE;

CREATE TABLE IF NOT EXISTS tbl_order (
                                         `order_code` int auto_increment,
                                         `customer_id` int NOT NULL,
                                         `created_at` datetime default (current_timestamp),
                                         `phone` varchar(15) NOT NULL,
                                         `shipping_address` varchar(100) NOT NULL,
                                         `order_status` int NOT NULL,
                                         `tracking_number` VARCHAR(13) NOT NULL,
                                         `total_price` int NOT NULL,
                                         CONSTRAINT pk_order_code PRIMARY KEY (order_code),
                                         CONSTRAINT fk_order_customer_id FOREIGN KEY (customer_id) REFERENCES tbl_customer (customer_id)
);

CREATE TABLE IF NOT EXISTS tbl_order_product (
                                                 `order_code` int NOT NULL,
                                                 `product_id` int NOT NULL,
                                                 `quantity` int NOT NULL,
                                                 `price` int NOT NULL,
                                                 CONSTRAINT fk_order_product_id FOREIGN KEY (product_id) REFERENCES tbl_product (product_id),
                                                 CONSTRAINT fk_order_product_code FOREIGN KEY (order_code) REFERENCES tbl_order (order_code)
);

CREATE TABLE IF NOT EXISTS tbl_order_canceled (
                                                  `order_code` int NOT NULL,
                                                  `created_at` datetime default (current_timestamp),
                                                  `refund_amount` int NOT NULL,
                                                  CONSTRAINT fk_order_canceled_code FOREIGN KEY (order_code) REFERENCES tbl_order (order_code)
);

DROP PROCEDURE IF EXISTS generate_orders;
create
    definer = furni@`%` procedure generate_orders()
BEGIN
    DECLARE my_order_code INT DEFAULT 1;
    DECLARE my_product_id INT DEFAULT 0;
    DECLARE my_year_interval INT DEFAULT 6;

    START TRANSACTION;

    WHILE my_order_code <= 9000 DO
            -- 랜덤 고객 선택
            SET @customer_id = FLOOR(101 + (RAND() * 80));

            -- 고객 정보 가져오기
            SELECT phone, address INTO @phone, @shipping_address
            FROM tbl_customer
            WHERE customer_id = @customer_id;

            -- 주문 취소율 1%로 설정
            SET @order_status = 6;
            IF 10 < (1 + RAND() * 999) THEN
                    SET @order_status = FLOOR(1 + RAND() * 5);
            END IF;

            -- 랜덤 주문 생성
            INSERT INTO tbl_order (customer_id, created_at, phone, shipping_address, order_status, tracking_number, total_price)
            VALUES (@customer_id,
                    DATE_ADD(
                        DATE_SUB('2024-06-25', INTERVAL FLOOR(RAND() * 365 * my_year_interval) DAY),
                            INTERVAL FLOOR(RAND() * 86400) SECOND), -- 랜덤 날짜 생성
                    @phone,
                    @shipping_address,
                    @order_status, -- 랜덤 주문 상태 생성
                    FLOOR(1000000000000 + RAND() * 9000000000000), -- 랜덤 추적 번호 생성
                    0 -- 초기 total_price는 0으로 설정
                   );

            SET @last_order_code = last_insert_id();

            -- 해당 주문에 랜덤 상품 1개에서 3개 사이로 추가
            SET @num_products = FLOOR(1 + RAND() * 3);
            WHILE @num_products > 0 DO
                    SET @random_product_id = my_product_id * 100 + FLOOR(1 + (RAND() * 98));
                    INSERT INTO tbl_order_product (order_code, product_id,  quantity, price)
                    VALUES (
                               @last_order_code,
                               @random_product_id,
                               FLOOR(1 + RAND() * 3), -- 랜덤 수량 생성
                               (SELECT (retail_price - retail_price * (discount_rate / 100)) as price FROM tbl_product WHERE product_id = @random_product_id) -- 상품의 소매 가격 사용
                           );

                    SET @num_products := @num_products - 1;
                    SET my_product_id := my_product_id + 1;


                    IF my_product_id > 3 THEN
                        SET my_product_id := 0; -- 상품 ID가 400을 넘어가면 다시 처음부터 시작
                    END IF;
            END WHILE;

            UPDATE tbl_order
            SET
                total_price = (select sum(price*quantity) from tbl_order_product where tbl_order_product.order_code = @last_order_code)
            WHERE
                order_code = @last_order_code;

            SET my_order_code = my_order_code + 1;

            -- 주문 취소 테이블 추가
            INSERT INTO tbl_order_canceled(order_code, created_at, refund_amount)
            SELECT order_code, created_at, total_price
            FROM tbl_order
            WHERE order_code = @last_order_code and order_status = 6;

        END WHILE;

    COMMIT;
END;
