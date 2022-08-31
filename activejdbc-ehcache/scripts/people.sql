
DROP TABLE IF EXISTS people;
CREATE TABLE people (id  int(11) NOT NULL auto_increment PRIMARY KEY, name VARCHAR(56) NOT NULL, last_name VARCHAR(56), dob DATE, graduation_date DATE, created_at DATETIME, updated_at DATETIME) ENGINE=InnoDB DEFAULT CHARSET=utf8;
