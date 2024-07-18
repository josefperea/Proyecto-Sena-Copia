-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema proyecto_sena
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema proyecto_sena
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyecto_sena` DEFAULT CHARACTER SET utf8mb4 ;
USE `proyecto_sena` ;

-- -----------------------------------------------------
-- Table `proyecto_sena`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto_sena`.`clientes` ;

CREATE TABLE IF NOT EXISTS `proyecto_sena`.`clientes` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `documento` VARCHAR(255) NULL DEFAULT NULL,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  `telefono` VARCHAR(255) NULL DEFAULT NULL,
  `direccion` VARCHAR(255) NULL DEFAULT NULL,
  `correo` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `proyecto_sena`.`inventario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto_sena`.`inventario` ;

CREATE TABLE IF NOT EXISTS `proyecto_sena`.`inventario` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  `fecha_registro` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `proyecto_sena`.`productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto_sena`.`productos` ;

CREATE TABLE IF NOT EXISTS `proyecto_sena`.`productos` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `cod_barras` VARCHAR(255) NULL DEFAULT NULL,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  `unidad_medida` VARCHAR(255) NULL DEFAULT NULL,
  `precio` FLOAT(15,2) NOT NULL,
  `fecha_vencimiento` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `proyecto_sena`.`inventario_has_productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto_sena`.`inventario_has_productos` ;

CREATE TABLE IF NOT EXISTS `proyecto_sena`.`inventario_has_productos` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `inventario_id` BIGINT(11) NOT NULL,
  `producto_id` BIGINT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `inventario_has_productos_ibfk_2` (`producto_id` ASC) VISIBLE,
  INDEX `inventario_has_productos_ibfk_1` (`inventario_id` ASC) VISIBLE,
  CONSTRAINT `inventario_has_productos_ibfk_1`
    FOREIGN KEY (`inventario_id`)
    REFERENCES `proyecto_sena`.`inventario` (`id`),
  CONSTRAINT `inventario_has_productos_ibfk_2`
    FOREIGN KEY (`producto_id`)
    REFERENCES `proyecto_sena`.`productos` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `proyecto_sena`.`spring_session`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto_sena`.`spring_session` ;

CREATE TABLE IF NOT EXISTS `proyecto_sena`.`spring_session` (
  `PRIMARY_ID` CHAR(36) NOT NULL,
  `SESSION_ID` CHAR(36) NOT NULL,
  `CREATION_TIME` BIGINT(20) NOT NULL,
  `LAST_ACCESS_TIME` BIGINT(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` INT(11) NOT NULL,
  `EXPIRY_TIME` BIGINT(20) NOT NULL,
  `PRINCIPAL_NAME` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE INDEX `SPRING_SESSION_IX1` (`SESSION_ID` ASC) VISIBLE,
  INDEX `SPRING_SESSION_IX2` (`EXPIRY_TIME` ASC) VISIBLE,
  INDEX `SPRING_SESSION_IX3` (`PRINCIPAL_NAME` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `proyecto_sena`.`spring_session_attributes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto_sena`.`spring_session_attributes` ;

CREATE TABLE IF NOT EXISTS `proyecto_sena`.`spring_session_attributes` (
  `SESSION_PRIMARY_ID` CHAR(36) NOT NULL,
  `ATTRIBUTE_NAME` VARCHAR(200) NOT NULL,
  `ATTRIBUTE_BYTES` BLOB NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`, `ATTRIBUTE_NAME`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK`
    FOREIGN KEY (`SESSION_PRIMARY_ID`)
    REFERENCES `proyecto_sena`.`spring_session` (`PRIMARY_ID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `proyecto_sena`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto_sena`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `proyecto_sena`.`usuarios` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(255) NULL DEFAULT NULL,
  `clave` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
