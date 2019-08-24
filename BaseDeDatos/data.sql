INSERT INTO `TecnolmportDS`.`Producto`()
	VALUES('001','Teclado',15.55,'equipo','Uso para PC','ASUS',true,'2025-12-31');
INSERT INTO `TecnolmportDS`.`Producto`()
	VALUES('002','Case',50,'equipo','Uso para PC','LG',true,'2025-12-31');
INSERT INTO `tecnolmportDs`.`Producto`()
	VALUES('003','Monitor',75.5,'equipo','Uso para PC','DELL',true,'2025-12-31');
INSERT INTO `TecnolmportDS`.`Producto`()
	VALUES('004','Camara',21,'equipo','Uso para PC','Sony',true,'2025-12-31');
INSERT INTO `TecnolmportDS`.`Producto`()
	VALUES('005','Mouse',15,'equipo','Uso para PC','Genius',true,'2025-12-31');
INSERT INTO `TecnolmportDS`.`Producto`()
	VALUES('006','Procesador',21,'equipo','Uso para Mainboard','Intel',true,'2025-12-31');

INSERT INTO `TecnolmportDS`.`Local` ()
	VALUES ('1','RioCentro','Guayaquil','matriz');
INSERT INTO `TecnolmportDS`.`Local` ()
	VALUES ('2','RioCentro','Norte','sucursal');
INSERT INTO `TecnolmportDS`.`Local` ()
	VALUES ('3','RioCentro','Sur','bodega');

INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0001','001','1',40,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0002','002','1',100,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0003','003','1',30,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0004','004','1',42,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0005','005','1',15,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0006','006','1',150,true);

INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0007','001','2',40,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0008','002','2',100,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0009','003','2',30,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0010','004','2',42,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0011','005','2',15,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0012','006','2',150,true);
    
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0013','001','3',40,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0014','002','3',100,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0015','003','3',30,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0016','004','3',42,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0017','005','3',15,true);
INSERT INTO `TecnolmportDS`.`Inventario` ()
	VALUES ('0018','006','3',150,true);
    
INSERT INTO `TecnolmportDS`.`Empleado` ()
	VALUES ('0987654321','Juan','Jimenez','juanj','123','gerente',null,500,'Guayaquil','juanj@espol.edu.ec','0985764234',true,'1',null);
INSERT INTO `TecnolmportDS`.`Empleado` ()
	VALUES ('0956295703','Byran','Tutiven','brcetuti','123','vendedor',null,500,'Daule','brcetuti@espol.edu.ec','0988097982',true,'2','0987654321');
INSERT INTO `TecnolmportDS`.`Empleado` ()
	VALUES ('0912345678','Roger','Aviles','rogera','123','jefe',null,500,'Guayaquil','rogera@espol.edu.ec','0896385274',true,'3',null);

INSERT INTO `TecnolmportDS`.`Empleado` ()
	VALUES ('0916820199','Ishi','Caicedo',null, null,'repartidor',null,500,'San Martin','ishito26@espol.edu.ec','5935452180',true,'3','0912345678');
INSERT INTO `TecnolmportDS`.`Empleado` ()
	VALUES ('0907082008','Nena','Rodriguez',null, null,'repartidor',null,500,'Naranjal','nena12@espol.edu.ec','5935452180',true,'3','0912345678');
INSERT INTO `TecnolmportDS`.`Empleado` ()
	VALUES ('0909082008','Titan','Saturno',null, null,'repartidor',null,500,'Nobol','titas33@espol.edu.ec','0984125478',true,'3','0912345678');
INSERT INTO `TecnolmportDS`.`Empleado` ()
	VALUES ('0909082010','Thanos','Celestial',null, null,'repartidor',null,500,'Titan','titan6@espol.edu.ec','09841254008',true,'3','0912345678');

INSERT INTO `TecnolmportDS`.`Cliente` ()
	VALUES ('098773521','Darius','Rocafuerte','Boyaca y la 20','darius10@gmail.com','2473825','Villamil Playas',1);
INSERT INTO `TecnolmportDS`.`Cliente` ()
	VALUES ('098773523','Zilean','Campoverde','Sauces 4','zileanR@gmail.com','2473827','Balzar',1);
INSERT INTO `TecnolmportDS`.`Cliente` ()
	VALUES ('098773525','Morgana','Cadenas','Sauces 8','morgCD@hotmail.com','2473829','El Triunfo',1);
INSERT INTO `TecnolmportDS`.`Cliente` ()
	VALUES ('098773527','Teemo','Fire','Trinitaria y la S','tmDaemon@hotmail.com','2473831','Milagro',1);

INSERT INTO `TecnolmportDS`.`Ruta` (`idRuta` , `Zona` , `id__Empleado`)
	VALUES ('1','Norte','0916820199');
INSERT INTO `TecnolmportDS`.`Ruta` (`idRuta` , `Zona` , `id__Empleado`)
	VALUES ('2','Norte','0907082008');   
    
INSERT INTO `TecnolmportDS`.`Pago` (`idPago`, `tipo`)
	VALUES ('001','efectivo');    
INSERT INTO `TecnolmportDS`.`Pago` (`idPago`, `tipo`)
	VALUES ('002','tarjetaCredito');
INSERT INTO `TecnolmportDS`.`Pago` (`idPago`, `tipo`)
	VALUES ('003','PayPal');
    
INSERT INTO `TecnolmportDS`.`Venta` (`idVenta`, `descripcion` , `fechaVenta` , `estado` , `subtotal` , `descuento`, `iva` , `cantidad` , `total` ,
  `esCotizacion` , `id_Local` , `id_Cliente` , `id_Empleado` , `id_Pago`)
	VALUES ('0001','N/A','2019-08-14',1, 21 ,0.0 ,0.0 ,1,21 , 0, 2, '098773521','0956295703','001');
INSERT INTO `TecnolmportDS`.`Venta` (`idVenta`, `descripcion` , `fechaVenta` , `estado` , `subtotal` , `descuento`, `iva` , `cantidad` , `total` ,
  `esCotizacion` , `id_Local` , `id_Cliente` , `id_Empleado` , `id_Pago`)
	VALUES ('0002','Pagado completo','2019-08-14',1, 115.55 ,0.0 ,0.0 ,3,115.55 , 0, 2, '098773523','0956295703','001');
INSERT INTO `TecnolmportDS`.`Venta` (`idVenta`, `descripcion` , `fechaVenta` , `estado` , `subtotal` , `descuento`, `iva` , `cantidad` , `total` ,
  `esCotizacion` , `id_Local` , `id_Cliente` , `id_Empleado` , `id_Pago`)
	VALUES ('0003','Pago tarjeta','2019-08-14',1, 65.55 ,0.0 ,0.0 ,3,65.55 , 0, 2, '098773523','0956295703','002');
    
    
INSERT INTO `TecnolmportDS`.`DetalleVenta` (`idDetalleVenta`, `id_Venta`, `id_Producto` , `cantidad` , `precio`)
	VALUES ('0001','0001','004',1,21);
INSERT INTO `TecnolmportDS`.`DetalleVenta` (`idDetalleVenta`, `id_Venta`, `id_Producto` , `cantidad` , `precio`)
	VALUES ('0002','0002','001',1,15.55);
INSERT INTO `TecnolmportDS`.`DetalleVenta` (`idDetalleVenta`, `id_Venta`, `id_Producto` , `cantidad` , `precio`)
	VALUES ('0003','0002','002',2,100);
INSERT INTO `TecnolmportDS`.`DetalleVenta` (`idDetalleVenta`, `id_Venta`, `id_Producto` , `cantidad` , `precio`)
	VALUES ('0004','0003','001',1,15.55);
INSERT INTO `TecnolmportDS`.`DetalleVenta` (`idDetalleVenta`, `id_Venta`, `id_Producto` , `cantidad` , `precio`)
	VALUES ('0005','0003','002',1,50);
    
INSERT INTO `TecnolmportDS`.`Entrega` (`idEntrega`, `fecha` , `direccion`, `estado` , `id_Ruta`, `novedades`)
	VALUES ('0001','2019-08-14','Samborondon y la 22',1,'1',null);
INSERT INTO `TecnolmportDS`.`Entrega` (`idEntrega`, `fecha` , `direccion`, `estado` , `id_Ruta`, `novedades`)
	VALUES ('0002','2019-08-13','Guayaquil', 1,'2',null);    
INSERT INTO `TecnolmportDS`.`Entrega` (`idEntrega`, `fecha` , `direccion`, `estado` , `id_Ruta`, `novedades`)
	VALUES ('0003','2019-08-14','Guayacanes y la 22',3,'2',null);
    
INSERT INTO `TecnolmportDS`.`Envio` (`idEnvio`, `id_Venta`, `direccion` , `descripcion`, `fechaInicio`, `fechaFin`, `estado`, `id_Entrega`)
	VALUES ('0001','0001','Samborondon y la 22','Casa amarilla con techo rojo','2019-08-14','2019-09-14',1,'0001');
INSERT INTO `TecnolmportDS`.`Envio` (`idEnvio`, `id_Venta`, `direccion` , `descripcion`, `fechaInicio`, `fechaFin`, `estado`, `id_Entrega`)
	VALUES ('0002','0002','Guayacanes y la 22','Casa roja con techo cementado','2019-08-14','2019-09-20',1,'0002');
INSERT INTO `TecnolmportDS`.`Envio` (`idEnvio`, `id_Venta`, `direccion` , `descripcion`, `fechaInicio`, `fechaFin`, `estado`, `id_Entrega`)
	VALUES ('0003','0003','Guayaquil','Casa roja , ventana gris','2019-08-14','2019-09-20',3,'0003');
    
INSERT INTO `TecnolmportDS`.`Pedido` (`idPedido` ,`observaciones` , `estado`, `fechaPedido` ,`fechaEntrega` , `id_Empleado`, `id_Entrega`)
	VALUES ('1','Lo antes posible','1','2019-08-13','2019-08-14','0987654321','0002');

INSERT INTO `TecnolmportDS`.`DetallePedido` ( `idDetallePedido` ,  `id_Pedido` ,  `id_Producto` ,  `cantidad` )
	VALUES ('1','1','004',2);
INSERT INTO `TecnolmportDS`.`DetallePedido` ( `idDetallePedido` ,  `id_Pedido` ,  `id_Producto` ,  `cantidad` )
	VALUES ('2','1','005',3);