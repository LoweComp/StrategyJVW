package Strategy;

public class PrecoSalaGold implements EstrategiaDePreco {
    @Override
    public double calcular(double precoBase) { return precoBase * 1.20; }
}