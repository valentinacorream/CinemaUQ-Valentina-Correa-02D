public class Sala {
    private String codigo;
    private int numero;
    private int capacidad;
    private EstadoSala estadoSala;

    public Sala(String codigo, int numero, int capacidad, EstadoSala estadoSala) {
        this.codigo = codigo;
        this.numero = numero;
        this.capacidad = capacidad;
        this.estadoSala = estadoSala;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public EstadoSala getEstadoSala() {
        return estadoSala;
    }

    public void setEstadoSala(EstadoSala estadoSala) {
        this.estadoSala = estadoSala;
    }

    @Override
    public String toString() {
        return "Sala: " +
                "código: " + codigo +
                ", número: " + numero +
                ", capacidad: " + capacidad +
                ", estado de sala:" + estadoSala;
    }
}
