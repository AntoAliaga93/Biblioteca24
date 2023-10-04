
package biblioteca24.accesoADatos;

import biblioteca24.Entidades.Libro;
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

public class LibroData {
    
    private Connection con = null;
    
    public LibroData(){
        con = Conexion.getConexion();
    }
    
    public void guardarLibro(Libro libro){
    
    String sql = "INSERT INTO libro (titulo, autor, año, tipo, editorial, estado) "
            + " VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnio());
            ps.setString(4, libro.getTipo());
            ps.setString(5, libro.getEditorial());
            ps.setBoolean(6, libro.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()){
                libro.setIsbn(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Libro guardado");
            }
            ps.close();
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro");
        }
    }
    
    public void modificarLibro(Libro libro){
        String sql = "UPDATE libro SET titulo = ?, autor = ?, año = ?, tipo = ?, editorial = ?, estado = ? "
                + " WHERE isbn = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnio());
            ps.setString(4, libro.getTipo());
            ps.setString(5, libro.getEditorial());
            ps.setBoolean(6, libro.isEstado());
            ps.setInt(7,libro.getIsbn());
            
            int exito = ps.executeUpdate();
            
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "Libro modificado");
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a la tabla libro");
        }
    }
    
    public void bajaLibro(String titulo){
    
    String sql = "UPDATE libro SET estado = 0 WHERE titulo = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, titulo);
            int exito = ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Libro dado de baja");
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a la tabla libro");
        }
    
    }
    
    public Libro buscarLibro(String titulo){
        String sql = "SELECT autor, año, tipo, editorial FROM libro "
                + " WHERE titulo = ? AND estado = 1";
        Libro libro = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, titulo);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
               libro = new Libro();
               libro.setTitulo(titulo);
               libro.setAutor(rs.getString("autor"));
               libro.setAnio(rs.getInt("año"));
               libro.setTipo(rs.getString("tipo"));
               libro.setEditorial(rs.getString("editorial"));
               libro.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe ese libro");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro");
        }
        return libro;
    }
    
    public List<Libro> busquedaPorAutor(String autor){
        ArrayList<Libro> librosEncont = new ArrayList <>();
        String sql = "SELECT * FROM libro WHERE autor = ?  ";
        
               try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, autor);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAnio(rs.getInt("año"));
                libro.setTipo(rs.getString("tipo"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setEstado(rs.getBoolean("estado"));
                
                librosEncont.add(libro);
            }
            if(librosEncont.isEmpty()){
                JOptionPane.showMessageDialog(null, "No existe registros del autor");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro");
        }
        return librosEncont; 
    }
    
    public List <Libro> listarLibros(){
        String sql = "SELECT * FROM libro "
         + "WHERE estado = 1 ";
        ArrayList<Libro> libros = new ArrayList <>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Libro libro = new Libro();
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("año"));
                libro.setTipo(rs.getString("tipo"));
                libro.setEditorial(rs.getString("editorial"));
                
                libros.add(libro);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro");
        }
        return libros;   
    }
}
