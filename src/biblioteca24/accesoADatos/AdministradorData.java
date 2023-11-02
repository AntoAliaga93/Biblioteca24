
package biblioteca24.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdministradorData {
    private Connection con = null;

    public AdministradorData() {
        con = Conexion.getConexion();
    }
    
    public boolean autenticarComoAdmin(String usuario, String password){
    
        String sql = "SELECT * FROM administrador WHERE usuario = ? AND password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
