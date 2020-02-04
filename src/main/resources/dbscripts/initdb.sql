-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema expocalendar
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema expocalendar
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `expocalendar` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `expocalendar` ;

-- -----------------------------------------------------
-- Table `expocalendar`.`accounts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `expocalendar`.`accounts` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `balance` INT(10) NULL DEFAULT NULL,
  `role` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `expocalendar`.`expositions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `expocalendar`.`expositions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `hall_id` INT(11) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(300) NOT NULL,
  `img` VARCHAR(208) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (hall_id)
 REFERENCES halls(id),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 42
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `expocalendar`.`halls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `expocalendar`.`halls` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `theme` VARCHAR(100) NOT NULL,
  `ticket_price` INT(11) NOT NULL,
  `date_from` DATE NOT NULL,
  `date_to` DATE NOT NULL,
  `img` VARCHAR(208) NOT NULL,
  `description` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE ,
  UNIQUE INDEX `theme_UNIQUE` (`theme` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `expocalendar`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `expocalendar`.`orders` (
  `order_key` INT(11) NOT NULL AUTO_INCREMENT,
  `account_id` INT(11) NOT NULL,
  `hall_id` INT(11) NOT NULL,
  `date_valid` DATE NOT NULL,
  `hall_theme` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`order_key`),
  FOREIGN KEY (hall_id)
 REFERENCES halls(id),
  FOREIGN KEY (account_id)
 REFERENCES accounts(id),
  UNIQUE INDEX `order_key_UNIQUE` (`order_key` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
