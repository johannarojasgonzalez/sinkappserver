CREATE TABLE t_sink (
snk_id BIGINT  AUTO_INCREMENT,
snk_reference VARCHAR(150),
snk_image_before LONGTEXT,
snk_image_after LONGTEXT,
snk_address_id BIGINT,
snk_statut_id BIGINT,
snk_type_id BIGINT,
snk_lenght BIGINT,
snk_pipeline_diameter BIGINT,
snk_pipeline_lengh BIGINT,
snk_observations VARCHAR(500),
PRIMARY KEY (snk_id)
);



