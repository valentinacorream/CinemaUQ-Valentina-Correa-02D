import java.time.LocalDate;
import java.util.List;

public class Reporte implements IGesReporte{

    @Override
    public int generarEntradasVendidas() {
        return 0;
    }

    @Override
    public double calcularTotalIngresos() {
        return 0;
    }

    @Override
    public String mostrarPeliMasVendida() {
        return "";
    }

    @Override
    public String mostrarCupoFuncion(Funcion funcion) {
        return "";
    }

    @Override
    public List<Funcion> mostrarFunPorFecha(LocalDate fecha) {
        return List.of();
    }
}
