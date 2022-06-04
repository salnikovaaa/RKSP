CREATE TABLE orders
(
    id UUID PRIMARY KEY ,
    client_id UUID  ,
    cake_id UUID  ,
    count  INT NOT NULL,
    total_price  INT NOT NULL
);

INSERT INTO orders VALUES ( 'c4d0d142-cade-11ec-9d61-0442ac120402', 'c4d0d142-cade-11ec-9d64-0442ac127402', 'c4d0d142-cade-11ec-9d64-0242ac120402', 1, 450);