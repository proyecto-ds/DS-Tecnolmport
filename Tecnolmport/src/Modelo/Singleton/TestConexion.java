/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Singleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rogencio
 */
public class TestConexion {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
         Conexion c = Conexion.getInstance();
         c.conectar();
         PreparedStatement ps = c.getConnection().prepareStatement("SELECT * FROM Producto");
         ResultSet result = ps.executeQuery();
         while(result.next())
             System.out.println(result.getString("idproducto")+" "+result.getString("nombre"));
         c.desconectar();
    }
    
}
