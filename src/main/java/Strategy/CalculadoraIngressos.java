package Strategy;

public class CalculadoraIngressos {

    private EstrategiaDePreco estrategia;
    private double precoBase;

    public CalculadoraIngressos(double precoBase) {
        this.precoBase = precoBase;
    }

    public void setEstrategia(EstrategiaDePreco novaEstrategia) {
        this.estrategia = novaEstrategia;
    }

    public double calcularPrecoFinal() {
        if (estrategia == null) {
            return precoBase;
        }
        return this.estrategia.calcular(precoBase);
    }

    public EstrategiaDePreco getEstrategiaAtual() {
        return estrategia;
    }
}