-- -----------------------------------------------------
-- Schema proyecto_sena
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `proyecto_sena` ;

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
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `proyecto_sena`.`productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto_sena`.`productos` ;

CREATE TABLE IF NOT EXISTS `proyecto_sena`.`productos` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `cod_barras` VARCHAR(255) NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `unidad_medida` VARCHAR(255) NOT NULL,
  `precio` FLOAT(15,2) NOT NULL DEFAULT 0.00,
  `fecha_vencimiento` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `proyecto_sena`.`inventario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto_sena`.`inventario` ;

CREATE TABLE IF NOT EXISTS `proyecto_sena`.`inventario` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `fecha_registro` DATETIME NULL DEFAULT NULL,
  `nota` VARCHAR(255) NULL DEFAULT NULL,
  `cantidad` INT(11) NULL DEFAULT NULL,
  `producto_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK8x46qgr3a08qk6y9e1vr6m26v`
    FOREIGN KEY (`producto_id`)
    REFERENCES `proyecto_sena`.`productos` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


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

USE `proyecto_sena`;

DELIMITER $$

USE `proyecto_sena`$$
DROP TRIGGER IF EXISTS `proyecto_sena`.`after_product_insert` $$
USE `proyecto_sena`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `proyecto_sena`.`after_product_insert`
AFTER INSERT ON `proyecto_sena`.`productos`
FOR EACH ROW
BEGIN
    -- Insertar un registro en la tabla de inventario
    INSERT INTO inventario (fecha_registro, nota, cantidad, producto_id)
    VALUES (NOW(), "", 0, NEW.id);
END$$

DELIMITER ;