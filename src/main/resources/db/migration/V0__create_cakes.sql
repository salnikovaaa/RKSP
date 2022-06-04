CREATE TABLE cakes
(
    id   UUID PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    description VARCHAR(64) NOT NULL,
    price  INT NOT NULL
);

INSERT INTO cakes VALUES ( 'c4d0d142-cade-11ec-9d64-0242ac120002', 'honey', 'delicious', 400);

INSERT INTO cakes VALUES ( 'c4d0d142-cade-11ec-9d64-0242ac120402', 'napoleon', 'delicious', 450);


