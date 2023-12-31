
package biblioteca24.Entidades;

public class Lector {
    private int nroSocio;
    private String apellido;
    private String nombre;
    private int dni;
    private String domicilio;
    private String telefono;
    private String email;
    private String password;
    private boolean estado;

    public Lector() {
    }

    public Lector(String apellido, String nombre, int dni, String domicilio, String telefono, String email, String password, boolean estado) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.estado = estado;
    }

    public Lector(int nroSocio, String apellido, String nombre, int dni, String domicilio, String telefono, String email, String password, boolean estado) {
        this.nroSocio = nroSocio;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.estado = estado;
    }

    public int getNroSocio() {
        return nroSocio;
    }

    public void setNroSocio(int nroSocio) {
        this.nroSocio = nroSocio;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    } 

    @Override
    public String toString() {
        return "Nro Socio: " + nroSocio + ", Apellido y Nombre: " + apellido + "  " + nombre + ", DNI: " + dni;
    }
    
    
}
