CREATE TABLE IF NOT EXISTS `country`(
  `id`                INTEGER         PRIMARY KEY AUTO_INCREMENT,
  `version`           INTEGER NOT NULL,
  `code`              SMALLINT        NOT NULL UNIQUE,
  `name`              VARCHAR(255)    NOT NULL);

CREATE TABLE IF NOT EXISTS `doc`(
  `id`                INTEGER         PRIMARY KEY AUTO_INCREMENT,
  `version`           INTEGER NOT NULL,
  `code`              TINYINT         NOT NULL UNIQUE,
  `name`              VARCHAR(255)    NOT NULL);

CREATE TABLE IF NOT EXISTS `organization`(
  `id`                INTEGER         PRIMARY KEY AUTO_INCREMENT,
  `version`           INTEGER NOT NULL,
  `name`              VARCHAR(50)    NOT NULL,
  `full_name`         VARCHAR(255)    NOT NULL,
  `inn`               VARCHAR(10)     NOT NULL,
  `kpp`               VARCHAR(9)      NOT NULL,
  `address`           VARCHAR(255)    NOT NULL,
  `phone`             VARCHAR(50)     NOT NULL DEFAULT '',
  `is_active`         BOOL            NOT NULL DEFAULT 1);

CREATE TABLE IF NOT EXISTS `office`(
  `id`                INTEGER         PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `version`           INTEGER NOT NULL,
  `organization_id`   INTEGER         NOT NULL REFERENCES `organization`(`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  `name`              VARCHAR(255)    NOT NULL,
  `address`           VARCHAR(255)    NOT NULL UNIQUE,
  `phone`             VARCHAR(50)     NOT NULL DEFAULT '',
  `is_active`         BOOL            NOT NULL DEFAULT 1);

CREATE TABLE IF NOT EXISTS `user`(
  `id`                INTEGER         PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `version`           INTEGER NOT NULL,
  `office_id`         INTEGER         NOT NULL  REFERENCES `office`(`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  `first_name`        VARCHAR(50)     NOT NULL,
  `last_name`         VARCHAR(50)     NOT NULL DEFAULT '',
  `middle_name`       VARCHAR(50)     NOT NULL DEFAULT '',
  `position`          VARCHAR(255)    NOT NULL,
  `doc_code`          INTEGER         REFERENCES `doc`(`id`) ON DELETE SET DEFAULT ON UPDATE CASCADE,
  `doc_number`        VARCHAR(255)    NOT NULL DEFAULT '',
  `doc_date`          DATE,
  `citizenship_code`  INTEGER        REFERENCES `country`(`id`) ON DELETE SET DEFAULT ON UPDATE CASCADE,
  `is_identified`     BOOL            NOT NULL DEFAULT 0);

CREATE INDEX `IX_office_organization_id` ON `office`(`organization_id`);

CREATE UNIQUE INDEX `UX_office_id` ON `office`(`id`);

CREATE UNIQUE INDEX `UX_organization_id` ON `organization`(`id`);

CREATE INDEX `UX_user_id` ON `user`(`id`);

