CREATE database kurshibernate;
use kurshibernate;
DROP TABLE IF EXISTS `Product`;
CREATE TABLE `Product` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `description` VARCHAR(800) NULL,
  `created` DATETIME,
  `updated` DATETIME,
  `price` DECIMAL(5,2),
  `type` VARCHAR(10),
  PRIMARY KEY (`id`)
);