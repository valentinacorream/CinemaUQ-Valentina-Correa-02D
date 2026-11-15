import java.time.LocalDate;
import java.util.List;

public interface IGesReporte {

    int generarEntradasVendidas();
    double calcularTotalIngresos();
    String mostrarPeliMasVendida();
    String mostrarCupoFuncion(Funcion funcion);
    List<Funcion> mostrarFunPorFecha(LocalDate fecha);
}
