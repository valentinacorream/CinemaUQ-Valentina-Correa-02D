public class TarifaGeneral extends Tarifa{

    public TarifaGeneral() {
        super(0);
    }

    @Override
    public double calcularValor(double valorBase) {
        return valorBase;
    }
}
