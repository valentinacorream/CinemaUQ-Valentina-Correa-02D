public class DetalleVenta {
    private Asiento asiento;
    private Tarifa tarifa;
    private double valorPagado;

    public DetalleVenta(Asiento asiento, Tarifa tarifa, double valorPagado) {
        this.asiento = asiento;
        this.tarifa = tarifa;
        this.valorPagado = valorPagado;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }
}
