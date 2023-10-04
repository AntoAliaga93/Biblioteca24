
package biblioteca24.Entidades;

public class Ejemplar {
    private int idEjemplar;
    private Libro libro;
    private int cantEjemplar;
    private boolean estado;

    public Ejemplar() {
    }

    public Ejemplar(Libro libro, int cantEjemplar, boolean estado) {
        this.libro = libro;
        this.cantEjemplar = cantEjemplar;
        this.estado = estado;
    }

    public Ejemplar(int idEjemplar, Libro libro, int cantEjemplar, boolean estado) {
        this.idEjemplar = idEjemplar;
        this.libro = libro;
        this.cantEjemplar = cantEjemplar;
        this.estado = estado;
    }

    public int getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getCantEjemplar() {
        return cantEjemplar;
    }

    public void setCantEjemplar(int cantEjemplar) {
        this.cantEjemplar = cantEjemplar;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
