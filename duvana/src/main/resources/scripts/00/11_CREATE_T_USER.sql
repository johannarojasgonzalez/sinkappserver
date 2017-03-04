CREATE TABLE t_user (
usr_id BIGINT,
usr_imi_number VARCHAR(100),
usr_creation_date DATE,
usr_update_date DATE,
PRIMARY KEY (usr_id),
UNIQUE (usr_imi_number)
);



