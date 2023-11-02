
package biblioteca24.accesoADatos;

import biblioteca24.Entidades.Lector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;


public class LectorData {
    
     private Connection con = null;
     
     public LectorData(){
         con = Conexion.getConexion();
     }
     
     public void guardarLector(Lector lector){
         
        if (lectorExiste(lector.getDni())) {
            JOptionPane.showMessageDialog(null, "El lector ya existe en la base de datos.");
            return; 
        }
         String sql = "INSERT INTO lector (apellido, nombre, dni, domicilio, telefono, email, password, estado) "
                 + " VALUES (?,?,?,?,?,?,?,?)";
         try {
             PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             ps.setString(1, lector.getApellido());
             ps.setString(2, lector.getNombre());
             ps.setInt(3, lector.getDni());
             ps.setString(4, lector.getDomicilio());
             ps.setString(5, lector.getTelefono());
             ps.setString(6, lector.getEmail());
             ps.setString(7, lector.getPassword());
             ps.setBoolean(8, true);
             ps.executeUpdate();
             
             ResultSet rs = ps.getGeneratedKeys();
             
             if(rs.next()){
                 lector.setNroSocio(rs.getInt(1));
                 JOptionPane.showMessageDialog(null, "Lector guardado");
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector");
         }   
     }
     
     public boolean lectorExiste(int nroSocio) {
        try {
            String sql = "SELECT nroSocio FROM lector WHERE nroSocio = ? AND estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nroSocio);
            ResultSet verificar_rs = ps.executeQuery();

            return verificar_rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar si el lector existe: " + ex.getMessage());
            return false; // Devuelve false en caso de error
        }
    }
     public boolean autenticarLector(String email, String password) {
        try {
            // Realiza una consulta a la base de datos para verificar el correo y la contraseña
            String sql = "SELECT * FROM lector WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            // Si se encuentra un registro, la autenticación es exitosa
            if (rs.next()) {
                // Lector autenticado
                return true;
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return false; // Autenticación fallida
    }
     
     public void actualizarLector(Lector lector){
         String sql = "UPDATE lector SET apellido = ?, nombre = ?, dni = ?, domicilio = ?, telefono = ?, "
                 + " email = ?, password = ? WHERE nroSocio = ?";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1,lector.getApellido());
             ps.setString(2, lector.getNombre());
             ps.setInt(3, lector.getDni());
             ps.setString(4, lector.getDomicilio());
             ps.setString(5, lector.getTelefono());
             ps.setString(6, lector.getEmail());
             ps.setString(7, lector.getPassword());
             ps.setInt(8, lector.getNroSocio());
             int exito = ps.executeUpdate();
             
             if(exito == 1){
                 JOptionPane.showMessageDialog(null, "Lector modificado");
             }
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector");
         }
     } 
    
     public void desactivarLector(int dni){
        String sql = "UPDATE lector SET estado = 0 WHERE dni = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int exito = ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Lector desactivado correctamente");
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al acceder a la tabla lector");
        }
    
    }
     
     public void activarLector(int dni){
        String sql = "UPDATE lector SET estado = 1 WHERE dni = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int exito = ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Lector activado correctamente");
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al acceder a la tabla lector");
        }
    
    }
        
     public Lector buscarporNroSocio(int nroSocio){
         String sql = "SELECT apellido, nombre, dni, domicilio, telefono, email FROM lector "
                 + " WHERE nroSocio = ? AND estado = 1";
         Lector lector = null;
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, nroSocio);
             ResultSet rs = ps.executeQuery();
             
             if(rs.next()){
                 lector = new Lector();
                 lector.setNroSocio(nroSocio);
                 lector.setApellido(rs.getString("apellido"));
                 lector.setNombre(rs.getString("nombre"));
                 lector.setDni(rs.getInt("dni"));
                 lector.setDomicilio(rs.getString("domicilio"));
                 lector.setTelefono(rs.getString("telefono"));
                 lector.setEmail(rs.getString("email"));
                 lector.setEstado(true);
             }else{
                 JOptionPane.showMessageDialog(null, "Nro de Socio no encontrado");
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector");
         }
         return lector;
    }
     public Lector buscarporDni(int dni){
         String sql = "SELECT nroSocio, apellido, nombre, domicilio, telefono, email, estado FROM lector "
                 + " WHERE dni = ? ";
         Lector lector = null;
         
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1,dni);
             ResultSet rs = ps.executeQuery();
             
             if(rs.next()){
                 lector = new Lector();
                 lector.setDni(dni);
                 lector.setNroSocio(rs.getInt("nroSocio"));
                 lector.setApellido(rs.getString("apellido"));
                 lector.setNombre(rs.getString("nombre"));
                 lector.setDomicilio(rs.getString("domicilio"));
                 lector.setTelefono(rs.getString("telefono"));
                 lector.setEmail(rs.getString("email"));
                 lector.setEstado(rs.getBoolean("estado"));
             }else{
                  JOptionPane.showMessageDialog(null, "No existe ese dni en la base de datos");
             }
             ps.close();
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector");
         }  
         return lector;
     }
     
    public List<Lector> buscarPorApellido(String apellido) {
        List<Lector> lectores = new ArrayList<>();
        String sql = "SELECT dni, nombre, apellido, estado FROM lector WHERE apellido LIKE ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + apellido + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Lector lector = new Lector();
                lector.setDni(rs.getInt("dni"));
                lector.setNombre(rs.getString("nombre"));
                lector.setApellido(rs.getString("apellido"));
                lector.setEstado(rs.getBoolean("estado"));
                lectores.add(lector);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar lectores por apellido.");
        }

         return lectores;
    }

     
    public Lector obtenerLectorPorEmail(String email) {
        String sql = "SELECT nroSocio, apellido, nombre, dni, domicilio, telefono, password FROM lector WHERE email = ?";
        Lector lector = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                lector = new Lector();
                lector.setEmail(email);
                lector.setNroSocio(rs.getInt("nroSocio"));
                lector.setApellido(rs.getString("apellido"));
                lector.setNombre(rs.getString("nombre"));
                lector.setDni(rs.getInt("dni"));
                lector.setDomicilio(rs.getString("domicilio"));
                lector.setTelefono(rs.getString("telefono"));
                lector.setPassword(rs.getString("password"));
                return lector;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no se encontró un lector con ese email
    }

     public List <Lector> listarLectores(){
         String sql = "SELECT nroSocio, apellido, nombre, dni, domicilio, telefono, email, estado "
                 + " FROM lector";
         ArrayList <Lector> lectores = new ArrayList<>();
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 Lector lector = new Lector();
                 lector.setNroSocio(rs.getInt("nroSocio"));
                 lector.setApellido(rs.getString("apellido"));
                 lector.setNombre(rs.getString("nombre"));
                 lector.setDni(rs.getInt("dni"));
                 lector.setDomicilio(rs.getString("domicilio"));
                 lector.setTelefono(rs.getString("telefono"));
                 lector.setEmail(rs.getString("email"));
                 lector.setEstado(rs.getBoolean("estado"));
                 lectores.add(lector);
             }
             ps.close();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector");
         }
         return lectores;
     }
}
