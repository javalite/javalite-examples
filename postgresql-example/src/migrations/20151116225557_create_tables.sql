DROP TABLE IF EXISTS people;
CREATE TABLE people (id serial PRIMARY KEY, name VARCHAR(56) NOT NULL, last_name VARCHAR(56), dob DATE, graduation_date DATE, created_at TIMESTAMP, updated_at TIMESTAMP);
