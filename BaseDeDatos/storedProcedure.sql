USE `TecnolmportDS` ;

delimiter $
create procedure login (in nUsuario varchar(15), in pass varchar(20), out sRol varchar(30), out perm varchar(20))
	begin
		set sRol = null;
        set perm = null;
		select rol, permisoA into sRol, perm
		from Empleado e
		where e.usuario = nUsuario  and e.clave = pass;
	end $
delimiter ;

delimiter $$
create procedure obtenerEmpleados()
	begin
		select e.idEmpleado, e.nombre, e.apellido, e.permisoA, e.usuario, e.clave, e.rol, e.salario, e.direccion, e.email, e.telefono, e.estado, l.tipo
        from Empleado e, Local l
        where e.id_Local = l.idLocal
        order by e.nombre,e.apellido desc;
	end $$
delimiter ;
call obtenerEmpleados
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
create procedure obtenerRepartidorDisponible()
	begin
		SELECT e.nombre FROM Empleado e  
        WHERE e.idEmpleado  NOT IN (
			SELECT r.id__Empleado 
			FROM Ruta r 
			WHERE e.idEmpleado = r.id__Empleado) and e.rol='repartidor';
	end $$
delimiter ;

delimiter $$
create procedure obtenerRutaEntrega()
	begin
		SELECT r.idRuta, r.zona, e.nombre, e.apellido 
        FROM ruta r, empleado e 
        where r.id__Empleado = e.idEmpleado;
	end $$
delimiter ;

delimiter $$
create procedure obtenerPedidos()
	begin
		 select pe.idPedido, pe.observaciones, pe.estado, pe.fechaPedido , e.nombre as Gerente, pr.nombre as Producto , lo.nombre as Local 
 from Pedido pe join Empleado e on pe.id_Empleado = e.idEmpleado join
							DetallePedido  dp on pe.idPedido = dp.id_Pedido  join Producto pr on dp.id_Producto =  pr.idProducto join local lo on e.id_Local = lo.idLocal 
where    pe.id_Empleado = e.idEmpleado   ;
	end $$
delimiter ;


delimiter $$
create procedure obtenerEnvio()
	begin
		SELECT e.idEnvio, e.id_Venta, e.direccion, e.descripcion, e.fechaInicio, e.fechaFin, e.estado
        FROM Envio e;
	end $$
delimiter ;

delimiter $$
create procedure obtenerRutas()
	begin
		SELECT r.idRuta, r.zona, e.nombre, e.apellido
        FROM Ruta r, Empleado e
        where r.id__Empleado = e.idEmpleado;
	end $$
delimiter ;

delimiter $$
create procedure obtenerVentas()
	begin
		select ve.idVenta , ve.fechaVenta, ve.esCotizacion , ve.total , e.nombre as Vendedor , p.nombre as Producto, en.direccion as DireccionEnvio , lo.nombre as Local 
		from venta ve join Envio en on ve.idVenta = en.id_Venta  join Empleado e on ve.id_Empleado = e.idEmpleado 
			join Local lo on ve.id_Local = lo.idLocal   join DetalleVenta dv on ve.idVenta = dv.id_Venta   join Producto p on  p.idProducto = dv.id_Producto ;
	end $$
delimiter ;

delimiter $$
create procedure obtenerPedidosNovedad()
	begin
		 select pe.idPedido, pe.observaciones, pe.estado, pe.fechaPedido , e.nombre as Gerente, pr.nombre as Producto , lo.nombre as Local 
 from Pedido pe join Empleado e on pe.id_Empleado = e.idEmpleado join
							DetallePedido  dp on pe.idPedido = dp.id_Pedido  join Producto pr on dp.id_Producto =  pr.idProducto join local lo on e.id_Local = lo.idLocal 
where    pe.id_Empleado = e.idEmpleado   ;
	end $$
delimiter ;

delimiter $$
create procedure obtenerEnvioEstado(in ids varchar(20))
	begin
		select * from envio where estado=ids;
	end $$
delimiter ;

delimiter $$
create procedure obtenerEntrega()
	begin 
		SELECT e.idEntrega, env.idEnvio ,e.fecha, e.direccion,env.descripcion 
        from Entrega e, Envio env where e.estado=4 and e.idEntrega=env.id_Entrega;
	end $$
delimiter ;

#procedure para obtener el id del local y del id del usuario pasando el usuario del empleado
delimiter $$
create procedure obtenerLocalUserId(in usuario varchar(20))
	begin
		  select  e.idEmpleado,lo.nombre 
			from Empleado e join Local lo on e.id_Local = lo.idLocal
			where e.usuario= usuario;
	end $$
delimiter ;


delimiter $$
create procedure actualizarPermiso(in id varchar(20), in perm varchar(20))
	begin
		update Empleado
        set
            permisoA = perm
		where idEmpleado = id;
	end $$
delimiter ;
//Ingresar Pedido
delimiter $$
create procedure ingresarPedido( in idPe varchar(20), in obse varchar(60), in fechaPe DateTime, in emple varchar(15), out idPed varchar(20))
	begin
		DECLARE idP varchar(20);
		DECLARE idEmple varchar(20);
        set idP = (select lpad(conv(floor(rand()*pow(36,8)), 10, 36), 6, 0));
        select idp into idPed;
        set idEmple = (select idEmpleado
						from Empleado
						where usuario = emple);
		insert into Pedido(idPedido, observaciones,estado,fechaPedido,id_Empleado) 
			values(idP,obse,'1',fechaPe,idEmple);
	end $$
delimiter ;

//Ingresar detallePedido
delimiter $$
create procedure ingresarDetallePedido(in idPe varchar(20), in idPr varchar(20), in cant int)
	begin
		DECLARE idDe varchar(20);
        set idDe = (select lpad(conv(floor(rand()*pow(36,8)), 10, 36), 6, 0));
		insert into DetallePedido() 
			values(idDe,idPe,idPr,cant);
	end $$
delimiter ;

