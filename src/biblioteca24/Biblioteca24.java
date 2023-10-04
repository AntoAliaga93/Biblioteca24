/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca24;

import biblioteca24.Entidades.Libro;
import biblioteca24.accesoADatos.Conexion;
import biblioteca24.accesoADatos.LibroData;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anto
 */
public class Biblioteca24 {

    public static void main(String[] args) {
       //Guardar libro
         LibroData lb = new LibroData();
//         Libro libro = new Libro("asdafasf", "Maria Elena Walsh", 1965, "Infantil", "niidea", true);
//         lb.guardarLibro(libro);
      //--------------
      //Modificar libro
//       lb.modificarLibro(libro);
     //Buscar libro
       /* Libro libroencontrado = lb.buscarLibro("Manuelita");
        System.out.println("autor: "+ libroencontrado.getAutor());
        System.out.println("año: "+ libroencontrado.getAnio());
        System.out.println("tipo: "+ libroencontrado.getTipo());
        System.out.println("editorial: "+ libroencontrado.getEditorial());
        System.out.println("estado: "+ libroencontrado.isEstado());*/
       
    //Lista libros
    /*    for (Libro libro : lb.listarLibros()) {
            System.out.println(libro.getIsbn());
            System.out.println(libro.getTitulo());
            System.out.println(libro.getAutor());
            System.out.println(libro.getAnio());
        } */
    //Busqueda por autor 
    List<Libro> librosporA = lb.busquedaPorAutor("Maria Elena Walsh");
        for (Libro libro : librosporA) {
            System.out.println("isbn: "+ libro.getIsbn());
            System.out.println("titulo: "+libro.getTitulo());
            System.out.println("año: "+ libro.getAnio());
        }
   }
    
}
