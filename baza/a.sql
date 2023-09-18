-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema let1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema let1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `let1` DEFAULT CHARACTER SET latin1 ;
USE `let1` ;

-- -----------------------------------------------------
-- Table `let1`.`Airline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `let1`.`Airline` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `adresa` VARCHAR(150) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `zemlja` VARCHAR(150) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `sajt` VARCHAR(150) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `email` VARCHAR(150) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `let1`.`Airplane`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `let1`.`Airplane` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Model` VARCHAR(45) NULL DEFAULT NULL,
  `Proizvodjac` VARCHAR(45) NULL DEFAULT NULL,
  `Tip` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `let1`.`Airport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `let1`.`Airport` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(150) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `Code` VARCHAR(3) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `City` VARCHAR(35) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `Country` VARCHAR(35) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `BrojPisti` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `let1`.`Azuriranje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `let1`.`Azuriranje` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `duzina` DOUBLE NULL DEFAULT NULL,
  `brzina` DOUBLE NULL DEFAULT NULL,
  `preostaloVreme` DOUBLE NULL DEFAULT NULL,
  `brojLeta` VARCHAR(45) NULL DEFAULT NULL,
  `Radar` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 30
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `let1`.`Flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `let1`.`Flight` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `BrojLeta` VARCHAR(45) NULL DEFAULT NULL,
  `AirportFrom` VARCHAR(45) NULL DEFAULT NULL,
  `AirportTo` VARCHAR(45) NULL DEFAULT NULL,
  `Start` DATETIME NULL DEFAULT NULL,
  `Time` TIME NULL DEFAULT NULL,
  `Airplane` VARCHAR(45) NULL DEFAULT NULL,
  `PlaniranoVreme` DATETIME NULL DEFAULT NULL,
  `OcekivanoVreme` DATETIME NULL DEFAULT NULL,
  `VremeSletanja` DATETIME NULL DEFAULT NULL,
  `Grad1` VARCHAR(45) NULL DEFAULT NULL,
  `Status` VARCHAR(45) NULL DEFAULT NULL,
  `AvioKompanija` VARCHAR(45) NULL DEFAULT NULL,
  `Grad2` VARCHAR(45) NULL DEFAULT NULL,
  `Izmena` VARCHAR(45) NULL DEFAULT NULL,
  `Carter` INT(11) NULL DEFAULT '0',
  `Najblizi` VARCHAR(45) NULL DEFAULT NULL,
  `Iznajmljeno` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `BrojLeta_UNIQUE` (`BrojLeta` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 99
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `let1`.`Licenca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `let1`.`Licenca` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `licenca` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `surname` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 42
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `let1`.`Posada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `let1`.`Posada` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `p1` VARCHAR(45) NULL DEFAULT NULL,
  `p2` VARCHAR(45) NULL DEFAULT NULL,
  `s1` VARCHAR(45) NULL DEFAULT NULL,
  `s2` VARCHAR(45) NULL DEFAULT NULL,
  `s3` VARCHAR(45) NULL DEFAULT NULL,
  `s4` VARCHAR(45) NULL DEFAULT NULL,
  `s5` VARCHAR(45) NULL DEFAULT NULL,
  `BrojLeta` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 54
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `let1`.`Proizvodjac`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `let1`.`Proizvodjac` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(45) NULL DEFAULT NULL,
  `Grad` VARCHAR(45) NULL DEFAULT NULL,
  `Zemlja` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `let1`.`RadarCentar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `let1`.`RadarCentar` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Let` VARCHAR(45) NULL DEFAULT NULL,
  `Lat` DOUBLE NULL DEFAULT NULL,
  `Lng` DOUBLE NULL DEFAULT NULL,
  `Naziv` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 147
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `let1`.`Rezervacija`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `let1`.`Rezervacija` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(45) NULL DEFAULT NULL,
  `Prezime` VARCHAR(45) NULL DEFAULT NULL,
  `Pasos` VARCHAR(45) NULL DEFAULT NULL,
  `BrojLeta` VARCHAR(45) NULL DEFAULT NULL,
  `Odakle` VARCHAR(45) NULL DEFAULT NULL,
  `Dokle` VARCHAR(45) NULL DEFAULT NULL,
  `IdCard` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `let1`.`TerminalGejt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `let1`.`TerminalGejt` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Terminal` VARCHAR(45) NULL DEFAULT NULL,
  `Gejt` VARCHAR(45) NULL DEFAULT NULL,
  `Airport` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 34
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `let1`.`Tip`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `let1`.`Tip` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(45) NULL DEFAULT NULL,
  `MaxBrojSedista` INT(11) NULL DEFAULT NULL,
  `Licenca` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `let1`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `let1`.`User` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `Surname` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `Pol` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `BirthDay` DATE NULL DEFAULT NULL,
  `Username` VARCHAR(250) CHARACTER SET 'utf8' NOT NULL,
  `Password` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `Email` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `PrihvacenZahtev` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `TipKorisnika` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `Airline` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `Licenca` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Username_UNIQUE` (`Username` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 62
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `let1`.`imagen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `let1`.`imagen` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `img` BLOB NULL DEFAULT NULL,
  `identifikatorAviona` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
