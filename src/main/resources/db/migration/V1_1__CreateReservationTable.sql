create table reservation(
id BIGINT not null auto_increment,
version BIGINT not null DEFAULT 0,
user_id BIGINT,
parking_space_id BIGINT,
reservation_start DATETIME,
reservation_end DATETIME,
created_date DATETIME,
modified_date DATETIME,
created_by varchar(40) not null,
modified_by varchar(40) not null,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (parking_space_id) REFERENCES parking_space(id));