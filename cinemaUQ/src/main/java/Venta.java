import java.time.LocalDate;
import java.time.LocalTime;

public class Venta {
    private String codigo;
    private Cliente cliente;
    private Funcion funcion;
    private LocalDate fecha;
    private LocalTime hora;
    private double valorTotal;
    private DetalleVenta detalleVenta;
    private EstadoVenta estadoVenta;

    public Venta(String codigo, Cliente cliente, Funcion funcion, LocalDate fecha, LocalTime hora, double valorTotal, DetalleVenta detalleVenta, EstadoVenta estadoVenta) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.funcion = funcion;
        this.fecha = fecha;
        this.hora = hora;
        this.valorTotal = valorTotal;
        this.detalleVenta = detalleVenta;
        this.estadoVenta = estadoVenta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    @Override
    public String toString() {
        return "Venta: " +
                "código: " + codigo +
                ", cliente: " + cliente +
                ", función: " + funcion +
                ", fecha: " + fecha +
                ", hora: " + hora +
                ", valor total: " + valorTotal +
                ", detalle de venta: " + detalleVenta +
                ", estado de venta: " + estadoVenta;
    }
}
