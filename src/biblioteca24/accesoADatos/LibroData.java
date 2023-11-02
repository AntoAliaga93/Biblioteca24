
package biblioteca24.accesoADatos;

import biblioteca24.Entidades.Categoria;
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
        if (libroExiste(libro)) {
            JOptionPane.showMessageDialog(null, "El libro ya existe en la base de datos.");
            return; //salgo
        }
        String sql = "INSERT INTO libro (titulo, autor, categoria, editorial, año, cantEjemplar, disponible) "
            + " VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getCategoria()+"");
            ps.setString(4, libro.getEditorial());
            ps.setInt(5, libro.getAnio());
            ps.setInt(6, libro.getCantEjemplar());
            ps.setBoolean(7, libro.isDisponible());
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
    public boolean libroExiste(Libro libro) {
        try {
            String sql = "SELECT isbn FROM libro WHERE titulo = ?";
            PreparedStatement ps  = con.prepareStatement(sql);
            ps.setString(1, libro.getTitulo());
            ResultSet verificar_rs = ps.executeQuery();

            return verificar_rs.next(); // Devuelve true si el libro ya existe, false si no existe
        } catch (SQLException ex) {
            ex.printStackTrace(); //imprime el seguimiento de la excepción
            return false; // Devuelve false en caso de error
        }
    }
    
    public void modificarLibro(Libro libro){
        String sql = "UPDATE libro SET titulo = ?, autor = ?, categoria = ?, editorial = ?, año = ?, cantEjemplar = ?"
                + " WHERE isbn = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getCategoria()+"");
            ps.setString(4, libro.getEditorial());
            ps.setInt(5, libro.getAnio());
            ps.setInt(6, libro.getCantEjemplar());
            ps.setInt(7,libro.getIsbn());
            
            int exito = ps.executeUpdate();
            
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "Libro modificado");
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a la tabla libro");
        }
    }
    public void bajaLibro(int isbn){
    
        String sql = "UPDATE libro SET disponible = 0 WHERE isbn = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, isbn);
            int exito = ps.executeUpdate();
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "Libro dado de baja");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla libro");
        }
    }
     
    public Libro buscarLibro(String titulo){
        String sql = "SELECT isbn, autor, categoria, editorial, año, cantEjemplar FROM libro "
            + " WHERE titulo = ? AND disponible = 1 ";
        Libro libro = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, titulo);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
               libro = new Libro();
               libro.setIsbn(rs.getInt("isbn"));
               libro.setTitulo(titulo);
               libro.setAutor(rs.getString("autor"));
               libro.setCategoria(Categoria.valueOf(rs.getString("categoria")));
               libro.setEditorial(rs.getString("editorial"));
               libro.setAnio(rs.getInt("año"));
               libro.setCantEjemplar(rs.getInt("cantEjemplar"));
               libro.setDisponible(true);
               
            }else{
                JOptionPane.showMessageDialog(null, "No existe ese libro");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro");
        }
        return libro;
    }
    
    public Libro buscarXisbn(int isbn){
        String sql = "SELECT titulo, autor, categoria, editorial, año, cantEjemplar FROM libro "
                + " WHERE isbn = ? AND disponible = 1";
        Libro libro = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, isbn);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                libro = new Libro();
                libro.setIsbn(isbn);
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                libro.setEditorial(rs.getString("editorial"));
                libro.setAnio(rs.getInt("año"));
                libro.setCantEjemplar(rs.getInt("cantEjemplar"));
                libro.setDisponible(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe ese libro");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro");
        }
        return libro;
    }
    
    public List<Libro> librosPorAutor(String autor){
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
                libro.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                libro.setEditorial(rs.getString("editorial"));
                libro.setAnio(rs.getInt("año"));
                libro.setCantEjemplar(rs.getInt("cantEjemplar"));
                libro.setDisponible(rs.getBoolean("disponible"));
                
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
        String sql = "SELECT * FROM libro WHERE disponible = 1";
        ArrayList<Libro> libros = new ArrayList <>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Libro libro = new Libro();
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                libro.setEditorial(rs.getString("editorial"));
                libro.setAnio(rs.getInt("año"));
                libro.setCantEjemplar(rs.getInt("cantEjemplar"));
                libro.setDisponible(rs.getBoolean("disponible"));
                
                libros.add(libro);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro");
        }
        return libros;   
    }
    
    public List<Libro> buscarLibrosPorCategoria(Categoria categoria) {
    String sql = "SELECT * FROM libro WHERE categoria = ? AND disponible = 1";
    List<Libro> libros = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, categoria.name()); // Convierte la categoría a su nombre en forma de cadena
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro();
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("año"));
                libro.setCantEjemplar(rs.getInt("cantEjemplar"));
                libro.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                libro.setEditorial(rs.getString("editorial"));
                libro.setDisponible(true); 
                libros.add(libro);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro");
        }
        return libros;
    }
    public boolean disponibilidadLibro(int isbn) {
    Libro libroEncon = buscarXisbn(isbn);
    return libroEncon != null && libroEncon.isDisponible();
    }
    
}
