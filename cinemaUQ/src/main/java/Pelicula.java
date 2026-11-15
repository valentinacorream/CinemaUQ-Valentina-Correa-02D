public class Pelicula {
    private String codigo;
    private String nombre;
    private String genero;
    private int duracion;
    private Clasificacion clasificacion;
    private EstadoPelicula estadoPelicula;

    public Pelicula(String codigo, String nombre, String genero, int duracion, Clasificacion clasificacion, EstadoPelicula estadoPelicula) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.estadoPelicula = estadoPelicula;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public EstadoPelicula getEstadoPelicula() {
        return estadoPelicula;
    }

    public void setEstadoPelicula(EstadoPelicula estadoPelicula) {
        this.estadoPelicula = estadoPelicula;
    }

    @Override
    public String toString() {
        return "Pelicula: " +
                "código: " + codigo +
                ", nombre: " + nombre +
                ", genero: " + genero +
                ", duración: " + duracion +
                ", clasificación: " + clasificacion +
                ", estado de película: " + estadoPelicula;
    }
}
