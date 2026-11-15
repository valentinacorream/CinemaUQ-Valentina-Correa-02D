public class TarifaAduMayor extends Tarifa{

    public TarifaAduMayor() {
        super(0.15);
    }

    @Override
    public double calcularValor(double valorBase) {
        return valorBase - (valorBase*getDescuento());
    }
}
