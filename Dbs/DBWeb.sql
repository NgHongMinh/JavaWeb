use web;

CREATE TABLE category (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL unique,
    status int DEFAULT NULL
);

DROP TABLE category;
ALTER TABLE category AUTO_INCREMENT = 1;
INSERT INTO category (name) VALUES ('Shirt');
INSERT INTO category (name) VALUES ('Pants');
INSERT INTO category (name) VALUES ('Hand Made');

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    price DOUBLE,
    quantity int,
    image LONGTEXT,
    description LONGTEXT,
    c_id int DEFAULT NULL,
    status int DEFAULT NULL,
    KEY `c_id` (`c_id`),
	CONSTRAINT `product_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `category` (`id`)
);
DROP TABLE product;
ALTER TABLE products AUTO_INCREMENT = 1;



CREATE TABLE account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user VARCHAR(50) NOT NULL UNIQUE,
    pass VARCHAR(50) NOT NULL, 
    isSell int DEFAULT NULL,
    isAdmin int DEFAULT NULL
);

DROP TABLE account;
ALTER TABLE account AUTO_INCREMENT = 1;

