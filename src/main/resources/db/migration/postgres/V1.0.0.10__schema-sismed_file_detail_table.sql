-- -----------------------------------------------------
-- Table sismed_file_detail
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS sismed.sismed_file_detail (
    id int NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    actor_type varchar(255) NULL,
	consecutive int NOT NULL,
	consecutive_number int NULL,
	enabling_code varchar(255) NULL,
	expedient varchar(255) NULL,
	file_type varchar(255) NULL,
	first_ium varchar(255) NULL,
	invoice_max_price varchar(255) NULL,
	invoice_min_price varchar(255) NULL,
	max_price float NULL,
	min_price float NULL,
	"month" varchar(255) NULL,
	record_type int NULL,
	second_ium varchar(255) NULL,
	third_ium varchar(255) NULL,
	total_amount float NULL,
	total_price float NULL,
	transaction_type varchar(255) NULL,
	unit_invoice varchar(255) NULL,
	sismed_file_id int NOT NULL,
	CONSTRAINT sismed_file_detail_pkey PRIMARY KEY (id),
	CONSTRAINT document_type_FK FOREIGN KEY (sismed_file_id) REFERENCES sismed.sismed_file (id));