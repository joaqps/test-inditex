INSERT INTO brand(name)
VALUES('ZARA');

INSERT INTO product(id, name)
VALUES(35455, 'Jacket');

INSERT INTO rate(id, product_id, brand_id, start_date, end_date, priority, price, currency)
VALUES(1, 35455, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 0, 35.50, 'EUR');

INSERT INTO rate(id, product_id, brand_id, start_date, end_date, priority, price, currency)
VALUES(2, 35455, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 1, 25.45, 'EUR');

INSERT INTO rate(id, product_id, brand_id, start_date, end_date, priority, price, currency)
VALUES(3, 35455, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 1, 30.50, 'EUR');

INSERT INTO rate(id, product_id, brand_id, start_date, end_date, priority, price, currency)
VALUES(4, 35455, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 1, 38.95, 'EUR');
