import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reporte implements IGesReporte{
    private Cinema cinema;

    public Reporte(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public int generarEntradasVendidas() {
        int total = 0;
        for (Funcion funcion : cinema.getListFunciones()) {
            for (Venta venta : funcion.getListVentas()) {
                if (venta.getEstadoVenta() == EstadoVenta.ACTIVA) {
                    for (DetalleVenta detalleVenta : venta.getListDetalleVentas()) {
                        total+= 1;
                    }
                }
            }
        }
        return total;
    }

    @Override
    public double calcularTotalIngresos() {
        double total = 0;
        for (Funcion funcion : cinema.getListFunciones()) {
            for (Venta venta : funcion.getListVentas()) {
                if (venta.getEstadoVenta() == EstadoVenta.ACTIVA) {
                    total+= venta.getValorTotal();
                }
            }
        }
        return total;
    }

    @Override
    public String mostrarPeliMasVendida() {
        String nombre = "";
        int mayor = 0;

        for (Pelicula pelicula : cinema.getListPeliculas()) {
            int total = 0;
            for (Funcion funcion : cinema.getListFunciones()) {
                if (funcion.getPelicula().getCodigo().equals(pelicula.getCodigo())) {
                    for (Venta venta : funcion.getListVentas()) {
                        if (venta.getEstadoVenta() == EstadoVenta.ACTIVA) {

                            for (DetalleVenta detalle : venta.getListDetalleVentas()) {
                                total+= 1;
                            }
                        }
                    }
                }
            }
            if (total > mayor) {
                mayor = total;
                nombre = pelicula.getNombre();
            }
        }
        return nombre;
    }

    @Override
    public String mostrarCupoFuncion(Funcion funcion) {
        String ocupacion= "";
        int ocupados = 0;
        int disponibles = 0;
        for (Asiento asiento : funcion.getSala().getListAsientos()) {
            boolean vendido = false;
            for (Venta venta : funcion.getListVentas()) {
                if (venta.getEstadoVenta() == EstadoVenta.ACTIVA) {
                    for (DetalleVenta detalleVenta : venta.getListDetalleVentas()) {
                        if (detalleVenta.getAsiento().getCodigo().equals(asiento.getCodigo())) {
                            vendido = true;
                            break;
                        }
                    }
                }
                if (vendido == true) {
                    break;
                }
            }
            if (vendido == true) {
                ocupados+= 1;
            } else {
                disponibles+= 1;
            }
        }
        ocupacion+= "Asientos ocupados: "+ ocupados+ "\nAsientos disponibles: "+ disponibles;
        return ocupacion;
    }

    @Override
    public List<Funcion> mostrarFunPorFecha(LocalDate fecha) {
        List<Funcion> funcionesEncontradas = new ArrayList<>();

        for (Funcion funcion : cinema.getListFunciones()) {
            if (funcion.getFecha().equals(fecha) && funcion.getEstadoFuncion() == EstadoFuncion.PROGRAMADA) {
                funcionesEncontradas.add(funcion);
            }
        }
        return funcionesEncontradas;
    }
}
