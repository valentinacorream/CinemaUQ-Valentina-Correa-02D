public abstract class Tarifa {
    private double descuento;

    public Tarifa(double descuento) {
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public abstract double calcularValor(double valorBase);
}
