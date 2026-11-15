public class TarifaEstu extends Tarifa{

    public TarifaEstu() {
        super(0.10);
    }

    @Override
    public double calcularValor(double valorBase) {
        return valorBase - (valorBase*getDescuento());
    }
}
