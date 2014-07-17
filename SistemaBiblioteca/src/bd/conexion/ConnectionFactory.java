package bd.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	//referencia statica a si mismo (singleton)
    private static ConnectionFactory instance = new ConnectionFactory();
    
    private String BD = "sistemabiblioteca";
    private String HOST = "localhost:3306";
    private String DRIVER_CLASS = "org.gjt.mm.mysql.Driver";
    private String URL = "jdbc:mysql://"+HOST+"/"+BD;;
    private String USER = "sistBiblioteca";
    private String PASSWORD = "bregre";
    
    private Connection connection = null;
     
    //constructor
    private ConnectionFactory() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    private Connection createConnection() {
    	Connection connection = null;
	        try {
	            connection = DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (SQLException e) {
	        	System.err.println(e);
	            System.out.println("ERROR: No es posible conectarse a la Base Datos.");
	        }
        return connection;
    }   
     
    public static Connection getConnection() {
        return instance.createConnection();
    }
}