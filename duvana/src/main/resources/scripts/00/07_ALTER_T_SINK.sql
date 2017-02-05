ALTER TABLE t_sink
ADD CONSTRAINT fk_statut
FOREIGN KEY (snk_statut_id)
REFERENCES t_sink_statut(sst_id);

ALTER TABLE t_sink
ADD CONSTRAINT fk_address
FOREIGN KEY (snk_address_id)
REFERENCES t_address(adr_id);

ALTER TABLE t_sink
ADD CONSTRAINT fk_type
FOREIGN KEY (snk_type_id)
REFERENCES t_sink_statut(sty_id);