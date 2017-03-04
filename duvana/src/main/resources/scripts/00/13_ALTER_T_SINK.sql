ALTER TABLE t_sink
ADD CONSTRAINT fk_status
FOREIGN KEY (snk_status_id)
REFERENCES t_ref_sink_status(rst_id);

ALTER TABLE t_sink
ADD CONSTRAINT fk_address
FOREIGN KEY (snk_address_id)
REFERENCES t_address(adr_id);

ALTER TABLE t_sink
ADD CONSTRAINT fk_type
FOREIGN KEY (snk_type_id)
REFERENCES t_ref_sink_type(rty_id);

ALTER TABLE t_sink
ADD CONSTRAINT fk_client
FOREIGN KEY (snk_client_id)
REFERENCES t_client(cli_id);

ALTER TABLE t_sink
ADD CONSTRAINT fk_pipeline_diameter
FOREIGN KEY (snk_pipeline_diameter_id)
REFERENCES t_ref_sink_diameter(rsd_id);

ALTER TABLE t_sink
ADD CONSTRAINT fk_plumb_option
FOREIGN KEY (snk_plumb_option_id)
REFERENCES t_ref_sink_plumb_option(rsp_id);

ALTER TABLE t_sink
ADD CONSTRAINT fk_user_creation
FOREIGN KEY (snk_user_cre_id)
REFERENCES t_user(usr_id);

ALTER TABLE t_sink
ADD CONSTRAINT fk_user_update
FOREIGN KEY (snk_user_upd_id)
REFERENCES t_user(usr_id);