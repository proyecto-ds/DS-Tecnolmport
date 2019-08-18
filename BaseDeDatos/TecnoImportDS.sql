-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema TecnolmportDS
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `TecnolmportDS` ;

-- -----------------------------------------------------
-- Schema TecnolmportDS
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TecnolmportDS` DEFAULT CHARACTER SET utf8 ;
USE `TecnolmportDS` ;

-- -----------------------------------------------------
-- Table `TecnolmportDS`.`Local`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`Local` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`Local` (
  `idLocal` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(20) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idLocal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`Empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`Empleado` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`Empleado` (
  `idEmpleado` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(15) NULL,
  `clave` VARCHAR(20) NULL,
  `rol` VARCHAR(30) NOT NULL,
  `permisoA` VARCHAR(30) NULL,
  `salario` INT NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `estado` BOOLEAN NOT NULL,
  `id_Local` VARCHAR(20) NOT NULL,
  `Empleado_idEmpleado` VARCHAR(20),
  PRIMARY KEY (`idEmpleado`),
  INDEX `fk_Empleado_Empleado_idx` (`Empleado_idEmpleado` ASC) VISIBLE,
  INDEX `id_Local_idx` (`id_Local` ASC) VISIBLE,
  CONSTRAINT `fk_Empleado_Empleado`
    FOREIGN KEY (`Empleado_idEmpleado`)
    REFERENCES `TecnolmportDS`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_Local`
    FOREIGN KEY (`id_Local`)
    REFERENCES `TecnolmportDS`.`Local` (`idLocal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`Pago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`Pago` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`Pago` (
  `idPago` VARCHAR(20) NOT NULL,
  `tipo` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idPago`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`Cliente` (
  `idCliente` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(20) NOT NULL,
  `apellido` VARCHAR(30) NOT NULL,
  `direccion` VARCHAR(50) NOT NULL,
  `email` VARCHAR(45) NULL,
  `telefono` VARCHAR(30) NOT NULL,
  `ciudad` VARCHAR(30) NOT NULL,
  `estado` TINYINT NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`Venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`Venta` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`Venta` (
  `idVenta` VARCHAR(20) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `fechaVenta` DATETIME NOT NULL,
  `estado` INT NOT NULL,
  `subtotal` FLOAT NOT NULL,
  `descuento` FLOAT NOT NULL,
  `iva` FLOAT NOT NULL,
  `cantidad` INT NOT NULL,
  `total` FLOAT NOT NULL,
  `esCotizacion` TINYINT NOT NULL,
  `id_Local` VARCHAR(20) NOT NULL,
  `id_Cliente` VARCHAR(20) NOT NULL,
  `id_Empleado` VARCHAR(20) NOT NULL,
  `id_Pago` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idVenta`),
  INDEX `idPago_idx` (`id_Pago` ASC) VISIBLE,
  INDEX `idLocal_idx` (`id_Local` ASC) VISIBLE,
  INDEX `idCliente_idx` (`id_Cliente` ASC) VISIBLE,
  INDEX `idEmpleado_idx` (`id_Empleado` ASC) VISIBLE,
  CONSTRAINT `id_Pago`
    FOREIGN KEY (`id_Pago`)
    REFERENCES `TecnolmportDS`.`Pago` (`idPago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_LocalV`
    FOREIGN KEY (`id_Local`)
    REFERENCES `TecnolmportDS`.`Local` (`idLocal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_Cliente`
    FOREIGN KEY (`id_Cliente`)
    REFERENCES `TecnolmportDS`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_Empleado`
    FOREIGN KEY (`id_Empleado`)
    REFERENCES `TecnolmportDS`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`Ruta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`Ruta` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`Ruta` (
  `idRuta` VARCHAR(20) NOT NULL,
  `Zona` VARCHAR(20) NULL,
  `id__Empleado` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idRuta`),
  INDEX `idEmpleado_idx` (`id__Empleado` ASC) VISIBLE,
  CONSTRAINT `id__Empleado`
    FOREIGN KEY (`id__Empleado`)
    REFERENCES `TecnolmportDS`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`Entrega`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`Entrega` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`Entrega` (
  `idEntrega` VARCHAR(20) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `estado` TINYINT NOT NULL,
  `idEmpleado` VARCHAR(20) NOT NULL,
  `id_Ruta` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idEntrega`),
  INDEX `idRuta_idx` (`id_Ruta` ASC) VISIBLE,
  CONSTRAINT `id_Ruta`
    FOREIGN KEY (`id_Ruta`)
    REFERENCES `TecnolmportDS`.`Ruta` (`idRuta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`Envio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`Envio` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`Envio` (
  `idEnvio` VARCHAR(20) NOT NULL,
  `id_Venta` VARCHAR(20) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(80) NOT NULL,
  `fechaInicio` DATETIME NOT NULL,
  `fechaFin` DATETIME NOT NULL,
  `estado` VARCHAR(15) NOT NULL,
  `id_Entrega` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idEnvio`),
  INDEX `idVenta_idx` (`id_Venta` ASC) VISIBLE,
  INDEX `idEntrega_idx` (`id_Entrega` ASC) VISIBLE,
  CONSTRAINT `id_Venta`
    FOREIGN KEY (`id_Venta`)
    REFERENCES `TecnolmportDS`.`Venta` (`idVenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_Entrega`
    FOREIGN KEY (`id_Entrega`)
    REFERENCES `TecnolmportDS`.`Entrega` (`idEntrega`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`Factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`Factura` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`Factura` (
  `idFactura` VARCHAR(20) NOT NULL,
  `fechaEmision` DATETIME NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `estado` TINYINT NOT NULL,
  `id_Venta_` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `id_Venta_idx` (`id_Venta_` ASC) VISIBLE,
  CONSTRAINT `id_Venta_`
    FOREIGN KEY (`id_Venta_`)
    REFERENCES `TecnolmportDS`.`Venta` (`idVenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`Proforma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`Proforma` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`Proforma` (
  `idProforma` VARCHAR(20) NOT NULL,
  `fechaEmision` DATETIME NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `estado` TINYINT NOT NULL,
  `id_venta` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idProforma`),
  INDEX `idVenta_idx` (`id_venta` ASC) VISIBLE,
  CONSTRAINT `id_ventaP`
    FOREIGN KEY (`id_venta`)
    REFERENCES `TecnolmportDS`.`Venta` (`idVenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`Pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`Pedido` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`Pedido` (
  `idPedido` VARCHAR(20) NOT NULL,
  `observaciones` VARCHAR(60) NULL,
  `estado` TINYINT NOT NULL,
  `fechaPedido` DATETIME NOT NULL,
  `fechaEntrega` DATETIME NOT NULL,
  `id_Empleado` VARCHAR(20) NOT NULL,
  `id_Entrega` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `idEmpleado_idx` (`id_Empleado` ASC) VISIBLE,
  INDEX `idEntrega_idx` (`id_Entrega` ASC) VISIBLE,
  CONSTRAINT `id_EmpleadoP`
    FOREIGN KEY (`id_Empleado`)
    REFERENCES `TecnolmportDS`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_EntregaP`
    FOREIGN KEY (`id_Entrega`)
    REFERENCES `TecnolmportDS`.`Entrega` (`idEntrega`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`Producto` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`Producto` (
  `idProducto` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(30) NOT NULL,
  `precio` FLOAT NOT NULL,
  `categoria` VARCHAR(20) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `proveedor` VARCHAR(45) NOT NULL,
  `estado` BOOLEAN NOT NULL,
  `garantia` DATETIME NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`Inventario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`Inventario` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`Inventario` (
  `idInventario` VARCHAR(20) NOT NULL,
  `id_Producto` VARCHAR(20) NOT NULL,
  `id_Local` VARCHAR(20) NOT NULL,
  `stock` INT NOT NULL,
  `estado` BOOLEAN NOT NULL,
  PRIMARY KEY (`idInventario`),
  INDEX `idProducto_idx` (`id_Producto` ASC) VISIBLE,
  INDEX `id_LocalIN_idx` (`id_Local` ASC) VISIBLE,
  CONSTRAINT `id_Producto`
    FOREIGN KEY (`id_Producto`)
    REFERENCES `TecnolmportDS`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_LocalI`
    FOREIGN KEY (`id_Local`)
    REFERENCES `TecnolmportDS`.`Local` (`idLocal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`DetalleVenta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`DetalleVenta` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`DetalleVenta` (
  `idDetalleVenta` VARCHAR(20) NOT NULL,
  `id_Venta` VARCHAR(20) NOT NULL,
  `id_Producto` VARCHAR(20) NOT NULL,
  `cantidad` INT NOT NULL,
  `precio` FLOAT NOT NULL,
  PRIMARY KEY (`idDetalleVenta`),
  INDEX `idProducto_idx` (`id_Producto` ASC) VISIBLE,
  INDEX `idVenta_idx` (`id_Venta` ASC) VISIBLE,
  CONSTRAINT `id_ProductoDV`
    FOREIGN KEY (`id_Producto`)
    REFERENCES `TecnolmportDS`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_VentaDV`
    FOREIGN KEY (`id_Venta`)
    REFERENCES `TecnolmportDS`.`Venta` (`idVenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`DetallePedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`DetallePedido` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`DetallePedido` (
  `idDetallePedido` VARCHAR(20) NOT NULL,
  `id_Pedido` VARCHAR(20) NOT NULL,
  `id_Producto` VARCHAR(20) NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`idDetallePedido`),
  INDEX `idPedido_idx` (`id_Pedido` ASC) VISIBLE,
  INDEX `id_Producto_idx` (`id_Producto` ASC) VISIBLE,
  CONSTRAINT `id_PedidoDP`
    FOREIGN KEY (`id_Pedido`)
    REFERENCES `TecnolmportDS`.`Pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_ProductoDP`
    FOREIGN KEY (`id_Producto`)
    REFERENCES `TecnolmportDS`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`NotaDeCredito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`NotaDeCredito` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`NotaDeCredito` (
  `idNotaDeCredito` VARCHAR(20) NOT NULL,
  `fechaEmision` DATETIME NOT NULL,
  `subtotal` FLOAT NOT NULL,
  `iva` FLOAT NOT NULL,
  `total` FLOAT NOT NULL,
  `id_Vendedor` VARCHAR(20) NOT NULL,
  `id_Cliente` VARCHAR(20) NOT NULL,
  `id_Local` VARCHAR(20) NOT NULL,
  `id_Factura` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idNotaDeCredito`),
  INDEX `idFactura_idx` (`id_Factura` ASC) VISIBLE,
  INDEX `idLocal_idx` (`id_Local` ASC) VISIBLE,
  INDEX `idCliente_idx` (`id_Cliente` ASC) VISIBLE,
  INDEX `idEmpleado_idx` (`id_Vendedor` ASC) VISIBLE,
  CONSTRAINT `id_FacturaNC`
    FOREIGN KEY (`id_Factura`)
    REFERENCES `TecnolmportDS`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_LocalNC`
    FOREIGN KEY (`id_Local`)
    REFERENCES `TecnolmportDS`.`Local` (`idLocal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_ClienteNC`
    FOREIGN KEY (`id_Cliente`)
    REFERENCES `TecnolmportDS`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_EmpleadoNC`
    FOREIGN KEY (`id_Vendedor`)
    REFERENCES `TecnolmportDS`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TecnolmportDS`.`DetalleNotaCredito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TecnolmportDS`.`DetalleNotaCredito` ;

CREATE TABLE IF NOT EXISTS `TecnolmportDS`.`DetalleNotaCredito` (
  `idDetalleNotaCredito` VARCHAR(20) NOT NULL,
  `id_Notacredito` VARCHAR(20) NOT NULL,
  `id_Producto` VARCHAR(20) NOT NULL,
  `cantidad` INT NOT NULL,
  `precio` FLOAT NOT NULL,
  PRIMARY KEY (`idDetalleNotaCredito`),
  INDEX `idProducto_idx` (`id_Producto` ASC) VISIBLE,
  INDEX `idNotaDeCredito_idx` (`id_Notacredito` ASC) VISIBLE,
  CONSTRAINT `id_ProductoDNC`
    FOREIGN KEY (`id_Producto`)
    REFERENCES `TecnolmportDS`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_NotaDeCreditoDNC`
    FOREIGN KEY (`id_Notacredito`)
    REFERENCES `TecnolmportDS`.`NotaDeCredito` (`idNotaDeCredito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

delimiter $
create procedure login (in nUsuario varchar(15), in pass varchar(20), out sRol varchar(30))
	begin
		set sRol = null;
		select rol into sRol
		from Empleado e
		where e.usuario = nUsuario  and e.clave = pass;
	end $
delimiter ;

delimiter $$
create procedure obtenerEmpleados()
	begin
		select e.idEmpleado, e.nombre, e.apellido, e.usuario, e.clave, e.rol, e.salario, e.direccion, e.email, e.telefono, e.estado, l.tipo
        from Empleado e, Local l
        where e.id_Local = l.idLocal
        order by e.nombre,e.apellido desc;
	end $$
delimiter ;

delimiter $$
create procedure actualizarEmpleado(in id varchar(20), in nom varchar(45), in ape varchar (45), in usu varchar(15), in pass varchar(20),in rl varchar(30), in sal int, in dir varchar(45), in mail varchar(45), in tel varchar(45), in est boolean, in tlocal varchar(20))
	begin
		update Empleado e, Local l
        set
			e.nombre = nom,
			e.apellido = ape,
			e.usuario = usu,
            e.clave = pass,
            e.rol = rl,
            e.salario = sal,
            e.direccion = dir,
            e.email = mail,
            e.telefono = tel,
            e.estado = est,
            e.id_Local = l.idLocal
		where idEmpleado = id and l.tipo = tlocal;
	end $$
delimiter ;

delimiter $$
create procedure ingresarEmpleado(in id varchar(20), in nom varchar(45), in ape varchar (45), in usu varchar(15), in pass varchar(20),in rl varchar(30), in sal int, in dir varchar(45), in mail varchar(45), in tel varchar(45), in est boolean, in tlocal varchar(20))
	begin
        insert into Empleado() 
			values(id,nom,ape,usu,pass,rl,null,sal,dir,mail,tel,est,tlocal,null);
    end $$
delimiter ;

delimiter $$
create procedure eliminarEmpleado(in id varchar(20))
	begin
		update Empleado e
        set
            e.estado = false
		where idEmpleado = id;
	end $$
delimiter ;

delimiter $$
create procedure obtenerProductos()
	begin
		select p.idProducto, p.nombre, p.precio, p.categoria, p.descripcion, p.proveedor, p.estado
        from Producto p;
	end $$
delimiter ;

delimiter $$
create procedure ingresarProducto(in id varchar(20), in nom varchar(30), in pre float, in cat varchar(20), in descr varchar(45), in prov varchar(45), in est boolean)
	begin
        insert into Producto() 
			values(id,nom,pre,cat,descr,prov,est,null);
    end $$
delimiter ;

delimiter $$
create procedure actualizarProducto(in id varchar(20), in nom varchar(30), in pre float, in cat varchar(20), in descr varchar(45), in prov varchar(45), in est boolean)
	begin
        update Producto p
        set
			p.nombre = nom,
            p.precio = pre,
            p.categoria = cat,
            p.descripcion = descr,
            p.proveedor = prov,
            p.estado = est	
		where idProducto = id;
    end $$
delimiter ;

delimiter $$
create procedure eliminarProducto(in id varchar(20))
	begin
		update Producto p
        set
            p.estado = false
		where p.idProducto = id;
	end $$
delimiter ;

delimiter $$
create procedure obtenerInventarioLocal(in idlo varchar(20))
	begin
		select i.idInventario, p.idProducto, p.nombre, p.precio, p.categoria, p.descripcion, p.proveedor, i.estado, i.stock
        from Producto p, Inventario i
        where i.id_Local = idlo and p.idProducto = i.id_Producto;
	end $$
delimiter ;


delimiter $$
create procedure ingresarInventario(in idI varchar(20), in idp varchar(20), in loc varchar(20), in stoc int, in est boolean)
	begin
        insert into Inventario() 
			values(idI, idp, loc, stoc, est);
    end $$
delimiter ;

delimiter $$
create procedure actualizarInventario(in idI varchar(20), in idp varchar(20), in loc varchar(20), in stoc int, in est boolean)
	begin
        update Inventario i
        set
			i.id_Producto = idp,
            i.id_Local = loc,
            i.stock = stoc,
            i.estado = est
		where i.idInventario = idI;
    end $$
delimiter ;

delimiter $$
create procedure eliminarInventario(in ids varchar(20))
	begin
		update Inventario
        set
            estado = false
		where idInventario = ids;
	end $$
delimiter ;

delimiter $$
create procedure obtenerLocales()
	begin
		select l.idLocal, l.nombre, l.direccion, l.tipo
        from Local l;
	end $$
delimiter ;

delimiter $$
create procedure obtenerPedidos()
	begin
		 select pe.idPedido, pe.estado, pe.fechaPedido , e.nombre as Gerente, pr.nombre as Producto , lo.nombre as Local 
 from Pedido pe join Empleado e on pe.id_Empleado = e.idEmpleado join
							DetallePedido  dp on pe.idPedido = dp.id_Pedido  join Producto pr on dp.id_Producto =  pr.idProducto join local lo on e.id_Local = lo.idLocal 
where    pe.id_Empleado = e.idEmpleado   ;
	end $$
delimiter ;

drop procedure if exists obtenerPedidos;

call obtenerPedidos();
