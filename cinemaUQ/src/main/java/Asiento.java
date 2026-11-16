public class Asiento {
    private String codigo;
    private String fila;
    private int numero;
    private EstadoAsiento estadoAsiento;

    public Asiento(String codigo, String fila, int numero, EstadoAsiento estadoAsiento) {
        this.codigo = codigo;
        this.fila = fila;
        this.numero = numero;
        this.estadoAsiento = EstadoAsiento.DISPONIBLE;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public EstadoAsiento getEstadoAsiento() {
        return estadoAsiento;
    }

    public void setEstadoAsiento(EstadoAsiento estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    @Override
    public String toString() {
        return "Asiento: " +
                "código: " + codigo +
                ", fila: " + fila +
                ", número: " + numero +
                ", estado del asiento: " + estadoAsiento;
    }
}
