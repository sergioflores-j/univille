-- MySQL Script generated by MySQL Workbench
-- sáb 28 set 2019 13:22:06 -03
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema taskservice
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema taskservice
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `taskservice` DEFAULT CHARACTER SET utf8 ;
USE `taskservice` ;

-- -----------------------------------------------------
-- Table `taskservice`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taskservice`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);


-- -----------------------------------------------------
-- Table `taskservice`.`tasks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taskservice`.`tasks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `completed` TINYINT(1) NULL DEFAULT 0,
  `deleted` TINYINT(1) NULL DEFAULT 0,
  `priority` INT NULL DEFAULT 0,
  `due_date` TIMESTAMP NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_tasks_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `taskservice`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
