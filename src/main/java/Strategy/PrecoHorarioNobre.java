package Strategy;

public class PrecoHorarioNobre implements EstrategiaDePreco {
    @Override
    public double calcular(double precoBase) { return precoBase; }
}