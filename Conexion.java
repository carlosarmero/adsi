package Modelo;
//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

private final String user = "root";
private final String password = "";
private final String url = "jdbc:mysql://localhost:3306/grancol?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=America/Mexico_City";
private Connection con = null; 

public Connection getConexion(){
   
    try {
          Class.forName("com.mysql.jdbc.Driver");
          con = (Connection) DriverManager.getConnection (this.url, this.user, this.password );
          
    } catch (SQLException e){
          System.out.println("no conexion");
    }
    
    catch (ClassNotFoundException ex) {
          Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    return  con;
    
 }
}