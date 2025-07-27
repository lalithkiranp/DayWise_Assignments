 CREATE DATABASE inventory_db;
 USE inventory_db;
  CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100),
    quantity INT,
    price DECIMAL(10,2)
 );
