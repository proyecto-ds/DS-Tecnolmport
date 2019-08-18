package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rogencio
 */
public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;
    //private final String driver = "com.mysql.jdbc.Driver";

//    private final String url = "jdbc:mysql://127.0.0.1:32768/TecnolmportDS?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//    private final String user = "root";
//    private final String pass = "beto"; 
//    private final String pass = "1997ra"; 

    private final String url = "jdbc:mysql://localhost:3306/TecnolmportDS?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String user = "root";


    private final String pass = "betoelperro"; 

    //betoelperro
    private static final Logger LOGGER = Logger.getLogger("DBConnection Logger");
    
    
    // private final String url = "jdbc:mysql://localhost:3306/tecnolmport_schemaf?autoReconnect=true&useSSL=false";
    //private final String user = "root";
    //private final String pass = "root"; 
    
    
    
    private DBConnection(){   
    }
    public static DBConnection getInstance(){
        
        if(dbConnection == null){
            
            dbConnection = new DBConnection();
            
        }
        
        return dbConnection;
    }
    
    public Connection getConnection() {
        
        return connection;
        
    }
    public void setConnection(Connection connexion) {
        this.connection = connexion;
    }
    
    /**
     * Método de tipo void para establecer connection con la Base de datos
     */
    public void conectar() {
        
        LOGGER.log(Level.INFO, "Establishing the database connection...");
        
        try{
           // Class.forName(driver);
            this.connection = DriverManager.getConnection(url, user, pass);
            LOGGER.log(Level.INFO, "¡The database connection was established successfully!");
            
        } catch(Exception e){
            
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }
    	
    /**
     * Método para cerrar la connection a la base de datos, no retorna nada
     */
    public void desconectar(){
        
	try {
            connection.close();
            
	} catch (SQLException e) {
            
            LOGGER.log(Level.SEVERE, e.getMessage());
	}
    }
}