-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema informeedb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema informeedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `informeedb` DEFAULT CHARACTER SET utf8 ;
USE `informeedb` ;

-- -----------------------------------------------------
-- Table `informeedb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `informeedb`.`user` (
  `email` VARCHAR(10) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `lastName` VARCHAR(20) NOT NULL,
  `employeeNo` INT NOT NULL,
  `password` VARCHAR(45) NULL,
  `usercol` VARCHAR(45) NULL,
  `userState` INT NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `informeedb`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `informeedb`.`role` (
  `roleId` INT NOT NULL,
  `roleType` VARCHAR(20) NOT NULL,
  `roleDesc` VARCHAR(45) NULL,
  PRIMARY KEY (`roleId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `informeedb`.`userRole`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `informeedb`.`userRole` (
  `userEmail` VARCHAR(10) NOT NULL,
  `roleId` INT NOT NULL,
  PRIMARY KEY (`userEmail`, `roleId`),
  INDEX `fk_userRole_role1_idx` (`roleId` ASC),
  CONSTRAINT `fk_userRole_user`
    FOREIGN KEY (`userEmail`)
    REFERENCES `informeedb`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userRole_role1`
    FOREIGN KEY (`roleId`)
    REFERENCES `informeedb`.`role` (`roleId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `informeedb`.`referral`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `informeedb`.`referral` (
  `refEmail` VARCHAR(10) NOT NULL,
  `userEmail` VARCHAR(10) NOT NULL,
  `refName` VARCHAR(20) NOT NULL,
  `refLastName` VARCHAR(20) NOT NULL,
  `refState` INT NOT NULL,
  `refCVDoc` BLOB NOT NULL,
  PRIMARY KEY (`refEmail`),
  INDEX `fk_referral_user1_idx` (`userEmail` ASC),
  CONSTRAINT `fk_referral_user1`
    FOREIGN KEY (`userEmail`)
    REFERENCES `informeedb`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `informeedb`.`jobPosition`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `informeedb`.`jobPosition` (
  `positionId` INT NOT NULL,
  `positionTitle` VARCHAR(30) NOT NULL,
  `positionDescription` VARCHAR(50) NULL,
  PRIMARY KEY (`positionId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `informeedb`.`jobPositionVacancy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `informeedb`.`jobPositionVacancy` (
  `positionId` INT NOT NULL,
  `vacancyDate` DATE NOT NULL,
  `vacancyState` INT NOT NULL,
  PRIMARY KEY (`positionId`, `vacancyDate`),
  CONSTRAINT `fk_jobPositionVacancy_jobPosition1`
    FOREIGN KEY (`positionId`)
    REFERENCES `informeedb`.`jobPosition` (`positionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `informeedb`.`jobPositionReferral`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `informeedb`.`jobPositionReferral` (
  `refEmail` VARCHAR(10) NOT NULL,
  `positionId` INT NOT NULL,
  `vacancyDate` DATE NOT NULL,
  PRIMARY KEY (`refEmail`, `positionId`, `vacancyDate`),
  INDEX `fk_jobPositionReferral4_jobPositionVacancy1_idx` (`positionId` ASC, `vacancyDate` ASC),
  CONSTRAINT `fk_jobPositionReferral4_referral1`
    FOREIGN KEY (`refEmail`)
    REFERENCES `informeedb`.`referral` (`refEmail`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_jobPositionReferral4_jobPositionVacancy1`
    FOREIGN KEY (`positionId` , `vacancyDate`)
    REFERENCES `informeedb`.`jobPositionVacancy` (`positionId` , `vacancyDate`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
