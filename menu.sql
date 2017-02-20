# To run it:
# mysql -u root -p < menu.sql
# enter pwd: goodyear123!@#

DROP DATABASE IF EXISTS menu_db;
CREATE DATABASE menu_db;
USE menu_db;
CREATE TABLE objects(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255),
	val TEXT
);
INSERT INTO objects (name, val) VALUES ("menu", "INVALIDVAL");


