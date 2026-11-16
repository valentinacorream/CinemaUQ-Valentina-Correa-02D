import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Funcion {
    private String codigo;
    private Pelicula pelicula;
    private Sala sala;
    private LocalDate fecha;
    private LocalTime hora;
    private double valorBase;
    private EstadoFuncion estadoFuncion;
    private List<Venta> listVentas;

    public Funcion(String codigo, Pelicula pelicula, Sala sala, LocalDate fecha, LocalTime hora, double valorBase, EstadoFuncion estadoFuncion) {
        this.codigo = codigo;
        this.pelicula = pelicula;
        this.sala = sala;
        this.fecha = fecha;
        this.hora = hora;
        this.valorBase = valorBase;
        this.estadoFuncion = estadoFuncion;

        listVentas= new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
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

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public EstadoFuncion getEstadoFuncion() {
        return estadoFuncion;
    }

    public void setEstadoFuncion(EstadoFuncion estadoFuncion) {
        this.estadoFuncion = estadoFuncion;
    }

    public List<Venta> getListVentas() {
        return listVentas;
    }

    public void setListVentas(List<Venta> listVentas) {
        this.listVentas = listVentas;
    }

    @Override
    public String toString() {
        return "Función: " +
                "código: " + codigo +
                ", película: " + pelicula +
                ", sala: " + sala +
                ", fecha: " + fecha +
                ", hora de la función: " + hora +
                ", valor base: " + valorBase +
                ", estado de función: " + estadoFuncion;
    }

    //Verificar venta
    public boolean verificarVenta(String codigo) {
        boolean existe = false;
        for (Venta venta : listVentas) {
            if (venta.getCodigo().equals(codigo)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //Agregar venta
    public boolean agregarVenta(Venta venta) {
        boolean agregado = false;
        boolean existe = verificarVenta(venta.getCodigo());

        if (estadoFuncion != EstadoFuncion.PROGRAMADA) {
            return agregado;
        }
        if (existe == false) {
            listVentas.add(venta);
            agregado = true;
        }
        return agregado;
    }

    //Consultar venta
    public Venta consultarVenta(String codigo) {
        Venta encontrada = null;
        for (Venta venta : listVentas) {
            if (venta.getCodigo().equals(codigo)) {
                encontrada = venta;
                break;
            }
        }
        return encontrada;
    }

    //Cancelar venta
    public boolean cancelarVenta(String codigo) {
        boolean cancelada = false;
        boolean existe= verificarVenta(codigo);

        if (existe == false) {
            throw new VentaNoEncontradaException(
                    "No existe una venta con ese código"
            );
        }else {
            for (Venta venta : listVentas) {
                if (venta.getCodigo().equals(codigo)) {
                    if (venta.getEstadoVenta() == EstadoVenta.ACTIVA) {
                        venta.setEstadoVenta(EstadoVenta.CANCELADA);
                        cancelada = true;
                    }
                    break;
                }
            }
        }
        return cancelada;
    }
}
