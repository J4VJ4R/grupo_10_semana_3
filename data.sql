USE supermercado;

CREATE TABLE customers (
	id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(100) not null,
    lastname varchar(100) not null,
    identification int,
    telephone varchar(20),
    position varchar(100),
    supermarket_id int,
    FOREIGN KEY (supermarket_id)  REFERENCES supermarkets(id)
    
);

CREATE TABLE supermarkets (
	id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(100) not null,
    city varchar(100) not null
);