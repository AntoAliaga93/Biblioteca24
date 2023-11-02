
package biblioteca24.accesoADatos;

import biblioteca24.Entidades.Categoria;
import biblioteca24.Entidades.Ejemplar;
import biblioteca24.Entidades.EstadoEjemplar;
import biblioteca24.Entidades.Lector;
import biblioteca24.Entidades.Libro;
import biblioteca24.Entidades.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class PrestamoData {
   
    private Connection con = null;
    private EjemplarData eD = new EjemplarData();
    private LectorData lD = new LectorData();
 
    public PrestamoData(){
        con = Conexion.getConexion();
    }
    
    public boolean verificarFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return fechaInicio.plusDays(7).isEqual(fechaFin);
    }

    public void guardarPrestamo(Prestamo prestamo) {
        String sql = "INSERT INTO prestamo (fechaInicio, fechaFin, idEjemplar, nroSocio, estado) "
                       + "VALUES (?, ?, ?, ?, ?)";
        try {   
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(prestamo.getFechaInicio()));
            ps.setDate(2, Date.valueOf(prestamo.getFechaFin()));
            ps.setInt(3, prestamo.getEjemplar().getIdEjemplar());
            ps.setInt(4, prestamo.getLector().getNroSocio());
            ps.setBoolean(5, prestamo.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                prestamo.setIdPrestamo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Préstamo guardado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla prestamo");
        }
    }
    public List<Prestamo> obtenerLibrosPrestados(LocalDate fecha) {
        ArrayList<Prestamo> librosPrestados = new ArrayList<>();
        String sql = "SELECT * FROM prestamo WHERE fechaInicio <= ? AND fechaFin >= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ps.setDate(2, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Prestamo prestamo = new Prestamo();
                prestamo.setIdPrestamo(rs.getInt("idPrestamo"));
                prestamo.setFechaInicio(rs.getDate("fechaInicio").toLocalDate()); 
                prestamo.setFechaFin(rs.getDate("fechaFin").toLocalDate()); 
                Ejemplar ejemplar = eD.obtenerEjemplarXid(rs.getInt("idEjemplar"));
                prestamo.setEjemplar(ejemplar);
                Lector lector = lD.buscarporNroSocio(rs.getInt("nroSocio"));
                prestamo.setLector(lector);
                prestamo.setEstado(rs.getBoolean("estado"));
                librosPrestados.add(prestamo);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los libros prestados en la fecha: " + ex.getMessage());
        }

        return librosPrestados;
    }

      public List<Prestamo> obtenerPrestamosPorNroSocio(int nroSocio) {
        List<Prestamo> prestamos = new ArrayList<>();

        String sql = "SELECT * FROM prestamo WHERE nroSocio = ? AND estado = 1"; 

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nroSocio);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idPrestamo = rs.getInt("idPrestamo");
                LocalDate fechaInicio = rs.getDate("fechaInicio").toLocalDate();
                LocalDate fechaFin = rs.getDate("fechaFin").toLocalDate();
                int idEjemplar = rs.getInt("idEjemplar");

              
                Ejemplar ejemplar = eD.obtenerEjemplarXid(idEjemplar);
                Lector lector = lD.buscarporNroSocio(nroSocio);
                boolean estado = true; 

                Prestamo prestamo = new Prestamo(idPrestamo, fechaInicio, fechaFin, ejemplar, lector, estado);
                prestamos.add(prestamo);
            }
        } catch (SQLException ex) {
            // Manejo de errores
            ex.printStackTrace();
        }

        return prestamos;
    }

    public List<Prestamo> obtenerPrestamosVencidos(int nroSocio) {
        List<Prestamo> prestamosVencidos = new ArrayList<>();
        LocalDate fechaActual = LocalDate.now();

        String sql = "SELECT * FROM prestamo WHERE nroSocio = ? AND fechaFin < ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nroSocio);
            ps.setDate(2, Date.valueOf(fechaActual));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Prestamo prestamo = new Prestamo();
                Lector lector = lD.buscarporNroSocio(rs.getInt("nroSocio"));
                prestamo.setLector(lector);
                prestamo.setIdPrestamo(rs.getInt("idPrestamo"));
                prestamo.setFechaInicio(rs.getDate("fechaInicio").toLocalDate()); 
                prestamo.setFechaFin(rs.getDate("fechaFin").toLocalDate()); 
                Ejemplar ejemplar = eD.obtenerEjemplarXid(rs.getInt("idEjemplar"));
                prestamo.setEjemplar(ejemplar);
                prestamo.setEstado(rs.getBoolean("estado"));
                prestamosVencidos.add(prestamo);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla préstamo");
        }
        return prestamosVencidos;
    }

    private int obtenerIdPrestamoActivo(Ejemplar ejemplar) {
        int idPrestamo = -1; //si no lo encuentra

        try {
            String sql = "SELECT idPrestamo FROM prestamo WHERE idEjemplar = ? AND estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ejemplar.getIdEjemplar());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idPrestamo = rs.getInt("idPrestamo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder al préstamo" );
        }
        return idPrestamo;
    }
    
    public void devolverLibro(Ejemplar ejemplar) {

        int idPrestamo = obtenerIdPrestamoActivo(ejemplar);
        if (idPrestamo != -1) {
            eD.incrementarEjemplaresDisponibles(ejemplar);
            JOptionPane.showMessageDialog(null, "Libro devuelto exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un préstamo activo para este ejemplar.");
        }
    }
    

 }
