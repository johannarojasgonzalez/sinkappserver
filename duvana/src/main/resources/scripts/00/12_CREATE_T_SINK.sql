CREATE TABLE t_sink (
snk_id BIGINT  AUTO_INCREMENT,
snk_reference VARCHAR(150),
snk_image_before LONGBLOB,
snk_image_after LONGBLOB,
snk_address_id BIGINT,
snk_client_id BIGINT,
snk_user_cre_id BIGINT,
snk_user_upd_id BIGINT,
snk_status_id BIGINT,
snk_type_id BIGINT,
snk_length BIGINT,
snk_pipeline_diameter_id BIGINT,
snk_pipeline_length BIGINT,
snk_plumb_option_id BIGINT,
snk_creation_date DATE,
snk_update_date DATE,
snk_observations VARCHAR(500),
snk_file_name VARCHAR(500),
PRIMARY KEY (snk_id),
UNIQUE (snk_reference, snk_client_id)
);



