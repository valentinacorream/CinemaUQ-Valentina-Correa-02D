public class TarifaNino extends Tarifa{

    public TarifaNino() {
        super(0.20);
    }

    @Override
    public double calcularValor(double valorBase) {
        return valorBase - (valorBase*getDescuento());
    }
}
