CREATE TABLE addresses (
  id  int(11) DEFAULT NULL auto_increment PRIMARY KEY,
  address_type VARCHAR(128),
  address1 VARCHAR(128),
  address2 VARCHAR(128),
  city VARCHAR(128),
  state VARCHAR(128),
  zip VARCHAR(128),
  person_id  int(11),
  created_at DATETIME,
  updated_at DATETIME
)ENGINE=InnoDB;
