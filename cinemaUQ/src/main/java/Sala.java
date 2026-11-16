import java.util.ArrayList;
import java.util.List;

public class Sala {
    private String codigo;
    private int numero;
    private int capacidad;
    private EstadoSala estadoSala;
    private List<Asiento> listAsientos;

    public Sala(String codigo, int numero, int capacidad, EstadoSala estadoSala) {
        this.codigo = codigo;
        this.numero = numero;
        this.capacidad = capacidad;
        this.estadoSala = estadoSala;

        listAsientos= new ArrayList<>();
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

    public List<Asiento> getListAsientos() {
        return listAsientos;
    }

    public void setListAsientos(List<Asiento> listAsientos) {
        this.listAsientos = listAsientos;
    }

    @Override
    public String toString() {
        return "Sala: " +
                "código: " + codigo +
                ", número: " + numero +
                ", capacidad: " + capacidad +
                ", estado de sala:" + estadoSala+
                ", lista de asientos: "+listAsientos;
    }

    //Verificar asiento
    public boolean verificarAsiento(String codigo) {
        boolean existe = false;
        for (Asiento asiento : listAsientos) {
            if (asiento.getCodigo().equals(codigo)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //Agregar asiento
    public boolean agregarAsiento(Asiento asiento) {
        boolean agregado = false;
        boolean existe = verificarAsiento(asiento.getCodigo());

        if (existe == false) {
            listAsientos.add(asiento);
            agregado = true;
        }
        return agregado;
    }

    //Consultar Asiento
    public Asiento consultarAsiento(String codigo) {
        Asiento encontrado = null;
        for (Asiento asiento : listAsientos) {
            if (asiento.getCodigo().equals(codigo)) {
                encontrado = asiento;
                break;
            }
        }
        return encontrado;
    }

}
