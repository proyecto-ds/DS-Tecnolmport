/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rogencio
 */
public class Conexion {
    private static Conexion conexion;
    private Connection connection;
    private final String url = "jdbc:mysql://127.0.0.1:32768/TecnolmportDS?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String user = "root";
    private final String pass = "beto";
    private static final Logger LOGGER = Logger.getLogger("DBConnection Logger");
    //127.0.0.1:32768
    
    private Conexion(){}
    
    public static Conexion getInstance(){
        if(conexion == null)
            conexion = new Conexion();
        return conexion;
    }
    
    /**
     * Método para establecer connection con la Base de datos
     */
    public void conectar() {        
        LOGGER.log(Level.INFO, "Establishing the database connection...");        
        try{
            this.connection = DriverManager.getConnection(url, user, pass);
            LOGGER.log(Level.INFO, "¡The database connection was established successfully!"); 
            
        } catch(Exception e){            
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }
    
    
    /**
     * Método para cerrar la connection a la base de datos.
     */
    public void desconectar(){
	try {
            connection.close();
            
	} catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
	}
    }
    
    public Connection getConnection() {        
        return connection;        
    }
    
    public void setConnection(Connection connexion) {
        this.connection = connexion;
    }
}

