import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String codigo;
    private Cliente cliente;
    private Funcion funcion;
    private LocalDate fecha;
    private LocalTime hora;
    private double valorTotal;
    private DetalleVenta detalleVenta;
    private EstadoVenta estadoVenta;
    private List<DetalleVenta> listDetalleVentas;

    public Venta(String codigo, Cliente cliente, Funcion funcion, LocalDate fecha, LocalTime hora, double valorTotal, DetalleVenta detalleVenta, EstadoVenta estadoVenta) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.funcion = funcion;
        this.fecha = fecha;
        this.hora = hora;
        this.valorTotal = valorTotal;
        this.detalleVenta = detalleVenta;
        this.estadoVenta = estadoVenta;

        listDetalleVentas= new ArrayList<>();
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

    public List<DetalleVenta> getListDetalleVentas() {
        return listDetalleVentas;
    }

    public void setListDetalleVentas(List<DetalleVenta> listDetalleVentas) {
        this.listDetalleVentas = listDetalleVentas;
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
                ", estado de venta: " + estadoVenta+
                ", detalle de venta: " + detalleVenta +
                ", lista detalles: "+listDetalleVentas;
    }

    //Verificar detalle de venta
    public boolean verificarDetalle(String codigoAsiento) {
        boolean existe = false;
        for (DetalleVenta detalle : listDetalleVentas) {
            if (detalle.getAsiento().getCodigo().equals(codigoAsiento)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //Agregar detalle de Venta
    public boolean agregarDetalle(DetalleVenta detalle) {
        boolean agregado = false;
        boolean existe = verificarDetalle(detalle.getAsiento().getCodigo());

        if (estadoVenta == EstadoVenta.ACTIVA && existe == false) {
            boolean ocupado = false;

            // Comprobar si el asiento seleccionado está ocupado
            for (Venta venta : funcion.getListVentas()) {
                if (venta.getEstadoVenta() == EstadoVenta.ACTIVA) {
                    for (DetalleVenta detalleVenta : venta.getListDetalleVentas()) {
                        if (detalleVenta.getAsiento().getCodigo()
                                .equals(detalle.getAsiento().getCodigo())) {
                            ocupado = true;
                            break;
                        }
                    }
                }

                if (ocupado == true) {
                    break;
                }
            }
            if (ocupado == true) {
                throw new AsientoOcupadoException(
                        "El asiento seleccionado ya está ocupado"
                );
            } else {
                int disponibles = 0;

                // Contar los asientos disponibles de la función
                for (Asiento asiento : funcion.getSala().getListAsientos()) {
                    boolean asientoOcupado = false;
                    for (Venta venta : funcion.getListVentas()) {
                        if (venta.getEstadoVenta() == EstadoVenta.ACTIVA) {
                            for (DetalleVenta detalleVenta : venta.getListDetalleVentas()) {
                                if (detalleVenta.getAsiento().getCodigo()
                                        .equals(asiento.getCodigo())) {
                                    asientoOcupado = true;
                                    break;
                                }
                            }
                        }
                        if (asientoOcupado == true) {
                            break;
                        }
                    }
                    if (asientoOcupado == false) {
                        disponibles = disponibles + 1;
                    }
                }
                // Comprobar si quedan asientos disponibles
                if (disponibles == 0) {
                    throw new SinAsientosDisponiblesException(
                            "La función no tiene asientos disponibles"
                    );
                } else {
                    listDetalleVentas.add(detalle);
                    agregado = true;
                    calcularValorTotal();
                }
            }
        }
        return agregado;
    }

    //Calcular valor total
    public double calcularValorTotal() {
        double total = 0;
        for (DetalleVenta detalle : listDetalleVentas) {
            total = total + detalle.getValorPagado();
        }
        valorTotal = total;
        return total;
    }
}
