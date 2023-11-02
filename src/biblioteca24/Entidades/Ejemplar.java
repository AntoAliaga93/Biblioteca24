
package biblioteca24.Entidades;

public class Ejemplar {
    private int idEjemplar;
    private Libro libro;
    private EstadoEjemplar estado;

    public Ejemplar() {
    }

    public Ejemplar(Libro libro, EstadoEjemplar estado) {
        this.libro = libro;
        this.estado = estado;
    }

    public Ejemplar(int idEjemplar, Libro libro, EstadoEjemplar estado) {
        this.idEjemplar = idEjemplar;
        this.libro = libro;
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

    public EstadoEjemplar getEstado() {
        return estado;
    }

    public void setEstado(EstadoEjemplar estado) {
        this.estado = estado;
    }  
}
