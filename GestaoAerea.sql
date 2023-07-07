-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gestaoaerea
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gestaoaerea
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gestaoaerea` DEFAULT CHARACTER SET utf8mb4 ;
USE `gestaoaerea` ;

-- -----------------------------------------------------
-- Table `gestaoaerea`.`aeroporto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestaoaerea`.`aeroporto` (
  `cod` INT(11) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `logradouro` VARCHAR(80) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  `complemento` VARCHAR(20) NULL DEFAULT NULL,
  `bairro` VARCHAR(30) NOT NULL,
  `cidade` VARCHAR(30) NOT NULL,
  `estado` CHAR(2) NOT NULL,
  `cep` CHAR(8) NOT NULL,
  PRIMARY KEY (`cod`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gestaoaerea`.`aviao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestaoaerea`.`aviao` (
  `cod` INT(11) NOT NULL AUTO_INCREMENT,
  `fabricante` VARCHAR(30) NOT NULL,
  `modelo` VARCHAR(20) NOT NULL,
  `capacidade` INT(11) NOT NULL,
  PRIMARY KEY (`cod`))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gestaoaerea`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestaoaerea`.`cliente` (
  `cpf` CHAR(11) NOT NULL,
  `nome` VARCHAR(20) NOT NULL,
  `sobrenome` VARCHAR(40) NOT NULL,
  `email` VARCHAR(80) NOT NULL,
  `telefone` CHAR(15) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gestaoaerea`.`companhia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestaoaerea`.`companhia` (
  `cnpj` CHAR(18) NOT NULL,
  `razao_social` VARCHAR(100) NOT NULL,
  `nome_fantasia` VARCHAR(50) NOT NULL,
  `logradouro` VARCHAR(80) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  `complemento` VARCHAR(50) NULL DEFAULT NULL,
  `bairro` VARCHAR(50) NOT NULL,
  `cidade` VARCHAR(50) NOT NULL,
  `estado` CHAR(2) NOT NULL,
  `cep` CHAR(10) NOT NULL,
  PRIMARY KEY (`cnpj`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gestaoaerea`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestaoaerea`.`endereco` (
  `cod_end` INT(11) NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(50) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  `complemento` VARCHAR(20) NULL DEFAULT NULL,
  `bairro` VARCHAR(30) NOT NULL,
  `cidade` VARCHAR(30) NOT NULL,
  `estado` CHAR(2) NOT NULL,
  `cep` CHAR(8) NOT NULL,
  `cpf_cliente` CHAR(11) NOT NULL,
  PRIMARY KEY (`cod_end`),
  INDEX `endereco_cliente` (`cpf_cliente` ASC) VISIBLE,
  CONSTRAINT `endereco_cliente`
    FOREIGN KEY (`cpf_cliente`)
    REFERENCES `gestaoaerea`.`cliente` (`cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gestaoaerea`.`voo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestaoaerea`.`voo` (
  `cod` INT(11) NOT NULL AUTO_INCREMENT,
  `companhia` CHAR(18) NOT NULL,
  `aeroporto_origem` INT(11) NOT NULL,
  `aeroporto_destino` INT(11) NOT NULL,
  `data` DATE NOT NULL,
  `horario` TIME NOT NULL,
  `cod_aviao` INT(11) NOT NULL,
  PRIMARY KEY (`cod`),
  INDEX `voo_companhia` (`companhia` ASC) VISIBLE,
  INDEX `voo_aviao` (`cod_aviao` ASC) VISIBLE,
  INDEX `voo_aeroporto_origem` (`aeroporto_origem` ASC) VISIBLE,
  INDEX `voo_aeroporto_destino` (`aeroporto_destino` ASC) VISIBLE,
  CONSTRAINT `voo_aeroporto_destino`
    FOREIGN KEY (`aeroporto_destino`)
    REFERENCES `gestaoaerea`.`aeroporto` (`cod`),
  CONSTRAINT `voo_aeroporto_origem`
    FOREIGN KEY (`aeroporto_origem`)
    REFERENCES `gestaoaerea`.`aeroporto` (`cod`),
  CONSTRAINT `voo_aviao`
    FOREIGN KEY (`cod_aviao`)
    REFERENCES `gestaoaerea`.`aviao` (`cod`),
  CONSTRAINT `voo_companhia`
    FOREIGN KEY (`companhia`)
    REFERENCES `gestaoaerea`.`companhia` (`cnpj`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gestaoaerea`.`passagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestaoaerea`.`passagem` (
  `numero_blilhete` INT(11) NOT NULL AUTO_INCREMENT,
  `classe` CHAR(1) NOT NULL,
  `poltrona` CHAR(3) NOT NULL,
  `valor` DECIMAL(5,0) NOT NULL,
  `cpf_cliente` CHAR(11) NOT NULL,
  `cod_voo` INT(11) NOT NULL,
  PRIMARY KEY (`numero_blilhete`),
  INDEX `passagem_cliente` (`cpf_cliente` ASC) VISIBLE,
  INDEX `passagem_voo` (`cod_voo` ASC) VISIBLE,
  CONSTRAINT `passagem_cliente`
    FOREIGN KEY (`cpf_cliente`)
    REFERENCES `gestaoaerea`.`cliente` (`cpf`),
  CONSTRAINT `passagem_voo`
    FOREIGN KEY (`cod_voo`)
    REFERENCES `gestaoaerea`.`voo` (`cod`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `gestaoaerea`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestaoaerea`.`usuario` (
  `cpf` CHAR(14) NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `celular` CHAR(15) NOT NULL,
  `senha` VARCHAR(60) NOT NULL,
  `salt` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
