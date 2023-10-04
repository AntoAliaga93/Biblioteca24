
package biblioteca24.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String BD = "biblioteca24";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    
    private static Connection con;

    private Conexion() {
    }
    public static Connection getConexion(){
        if (con==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                con = DriverManager.getConnection(URL+BD,USUARIO,PASSWORD);
     
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Error al cargar los drivers");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos");
            }
        }
        return con;
    }
    
}
