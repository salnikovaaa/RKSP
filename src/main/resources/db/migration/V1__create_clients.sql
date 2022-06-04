CREATE TABLE clients
(
    id UUID PRIMARY KEY ,
    name VARCHAR(64) ,
    email VARCHAR(64) NOT NULL,
    phone_number VARCHAR(64) NOT NULL
);



INSERT INTO clients VALUES ( 'c4d0d142-cade-11ec-9d64-0442ac120402', 'Alex', 'alex@gmail.com', '87894517748');

INSERT INTO clients VALUES ( 'c4d0d142-cade-11ec-9d64-0442ac127402', 'Sasha', 'alexxx@gmail.com', '87897777748');

INSERT INTO clients VALUES ( 'c4d0d142-cade-11ec-9d64-0442ac420402', 'Anna', 'anna@gmail.com', '8764517748');

INSERT INTO clients VALUES ( 'c4d0d142-cade-11ec-9d64-0742ac120402', 'Alena', 'alena@gmail.com', '84894517748');