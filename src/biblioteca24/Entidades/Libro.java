
package biblioteca24.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    
    private int isbn;
    private String titulo;
    private String autor;
    private Categoria categoria;
    private String editorial;
    private int anio;
    private int cantEjemplar;
    private boolean disponible;

    public Libro() {
    }

    public Libro(String titulo, String autor, Categoria categoria, String editorial, int anio, int cantEjemplar, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.editorial = editorial;
        this.anio = anio;
        this.cantEjemplar = cantEjemplar;
        this.disponible = disponible;
    }

    public Libro(int isbn, String titulo, String autor, Categoria categoria, String editorial, int anio, int cantEjemplar, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.editorial = editorial;
        this.anio = anio;
        this.cantEjemplar = cantEjemplar;
        this.disponible = disponible;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantEjemplar() {
        return cantEjemplar;
    }

    public void setCantEjemplar(int cantEjemplar) {
        this.cantEjemplar = cantEjemplar;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Título: " + titulo + " Editorial: " + editorial;
    }
   
    
}
 
