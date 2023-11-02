
package biblioteca24.accesoADatos;

import biblioteca24.Entidades.Ejemplar;
import biblioteca24.Entidades.EstadoEjemplar;
import biblioteca24.Entidades.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class EjemplarData {
    
     private Connection con = null;
     private LibroData lib_D;
     
     public EjemplarData(){
         con = Conexion.getConexion();
         lib_D = new LibroData();
     }

    public void agregarEjemplar(Ejemplar ejemplar) {
        try {
            String sql = "INSERT INTO ejemplar (isbn, estado) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ejemplar.getLibro().getIsbn());
            ps.setString(2, ejemplar.getEstado() + "");
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ejemplar.setIdEjemplar(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ejemplar guardado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar");
        }
    }
    
   
     public List<Ejemplar> buscarEjemplares(int isbn){
         List<Ejemplar> ejemplares = new ArrayList<>();
         String sql = "SELECT idEjemplar, estado FROM ejemplar WHERE isbn = ?";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, isbn);
             ResultSet rs = ps.executeQuery();
             Libro libro =  lib_D.buscarXisbn(isbn);
             
             while(rs.next()){
             int idEjemplar = rs.getInt("idEjemplar");
             EstadoEjemplar estado = EstadoEjemplar.valueOf(rs.getString("estado"));
            
             Ejemplar ejemplar = new Ejemplar(idEjemplar, libro, estado);
             ejemplares.add(ejemplar);
             }
             for (Ejemplar ejemplar : ejemplares) {
                ejemplar.getLibro().setIsbn(isbn);
            }
             ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar");
         }
         return ejemplares;
     }
                
     public List <Ejemplar> listarEjemplares(){
         String sql = "SELECT * FROM ejemplar ";
         ArrayList <Ejemplar> ejemplares = new ArrayList<>();
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 Ejemplar ejemplar = new Ejemplar();
                 ejemplar.setIdEjemplar(rs.getInt("idEjemplar"));
                 Libro libro = lib_D.buscarXisbn(rs.getInt("isbn"));
                 ejemplar.setLibro(libro);
                 ejemplar.setEstado(EstadoEjemplar.valueOf(rs.getString("estado")));
                 ejemplares.add(ejemplar);
             }
             ps.close();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar");
         }
         return ejemplares;
     }
     
    public Libro obtenerLibroDeEjemplar(int idEjemplar) {
       String sql = "SELECT isbn FROM ejemplar WHERE idEjemplar = ?";
       try{ 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEjemplar);
            ResultSet rs = ps.executeQuery();
           if (rs.next()) {
               int isbn = rs.getInt("isbn");
               return lib_D.buscarXisbn(isbn); //llamo al metodo para buscar por isbn
           }
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar");
       }
       return null; // Manejo de errores o si no se encuentra el libro
    }

     
     public int obtenerNroEjemplaresDisponibles(int isbn){
         int ejem_disponibles = 0;
         String sql = "SELECT COUNT(*)FROM ejemplar WHERE isbn = ? AND estado = 'DISPONIBLE'";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, isbn);
             ResultSet rs = ps.executeQuery();
             if(rs.next()){
                 ejem_disponibles = rs.getInt(1);
             }
             ps.close();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplares");
         }
     return ejem_disponibles;
     
     }
     public int obtenerIdEjemplarDisponible(int isbn) {
        int idEjemplarDisponible = -1; // no se encontro nada 

        String sql = "SELECT idEjemplar FROM ejemplar WHERE isbn = ? AND estado = 'DISPONIBLE' LIMIT 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, isbn);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idEjemplarDisponible = rs.getInt("idEjemplar");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplares");
        }

        return idEjemplarDisponible;
    }
     public Ejemplar obtenerEjemplarXid(int idEjemplar){
         Ejemplar ejemplar = null;
         String sql = "SELECT * FROM ejemplar WHERE idEjemplar = ?";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, idEjemplar);
             ResultSet rs = ps.executeQuery();
             if(rs.next()){
                 int isbn = rs.getInt("isbn");
                 EstadoEjemplar estado = EstadoEjemplar.valueOf(rs.getString("estado"));
                 Libro libro = lib_D.buscarXisbn(isbn);
                 ejemplar = new Ejemplar(idEjemplar, libro, estado);
             }
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar");
         }
         return ejemplar;
     }

     public void actualizarEjemplar(Ejemplar ejemplar){
         String sql = "UPDATE ejemplar e JOIN libro l "
                 + "ON e.isbn = l.isbn SET estado = 'PRESTADO', l.cantEjemplar = l.cantEjemplar -1 "
                 + "WHERE e.idEjemplar = ?";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, ejemplar.getIdEjemplar());
             int exito = ps.executeUpdate();
             if(exito > 0){
               JOptionPane.showMessageDialog(null, "Cantidad de ejemplares actualizado");
             }
             ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al actualizar el estado del ejemplar");
         }
     }
     
      public void incrementarEjemplaresDisponibles(Ejemplar ejemplar) {
        try {
            String sql = "UPDATE ejemplar e JOIN libro l "
                    + "ON e.isbn = l.isbn SET estado = 'DISPONIBLE', l.cantEjemplar = l.cantEjemplar + 1"
                    + " WHERE e.idEjemplar = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ejemplar.getIdEjemplar());
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
     
     public void modificarEjemplar(Ejemplar ejemplar){
         String sql = "UPDATE ejemplar SET estado = ? WHERE idEjemplar = ?";
         try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ejemplar.getEstado()+"");
            ps.setInt(2, ejemplar.getIdEjemplar());

            int exito = ps.executeUpdate();
            if (exito > 0) {
                JOptionPane.showMessageDialog(null, "Ejemplar actualizado");
            } 
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar");
        }   
    }
}
