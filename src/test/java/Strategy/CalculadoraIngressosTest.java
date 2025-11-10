package Strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraIngressosTest {

    private static final double PRECO_BASE = 50.00;
    private static final double DELTA = 0.001;

    private final PrecoHorarioNobre precoIntegral = new PrecoHorarioNobre();
    private final PrecoMeiaEntrada precoMeia = new PrecoMeiaEntrada();
    private final PrecoPromocaoFidelidade precoPromocao = new PrecoPromocaoFidelidade();
    private final PrecoSalaGold precoGold = new PrecoSalaGold();

    // PREÇO INTEGRAL
    @Test
    void deveRetornarPrecoBaseQuandoNenhumaEstrategiaForDefinida() {
        CalculadoraIngressos calculadora = new CalculadoraIngressos(PRECO_BASE);
        assertEquals(PRECO_BASE, calculadora.calcularPrecoFinal(), DELTA);
    }

    // ESTRATÉGIAS DE ACRÉSCIMO & DESCONTO
    @Test
    void deveAplicarPrecoSalaGoldCorretamente() {
        CalculadoraIngressos calculadora = new CalculadoraIngressos(PRECO_BASE);
        calculadora.setEstrategia(precoGold);
        assertEquals(60.00, calculadora.calcularPrecoFinal(), DELTA);
        assertInstanceOf(PrecoSalaGold.class, calculadora.getEstrategiaAtual());
    }

    @Test
    void deveAplicarPrecoMeiaEntradaCorretamente() {
        CalculadoraIngressos calculadora = new CalculadoraIngressos(PRECO_BASE);
        calculadora.setEstrategia(precoMeia);
        assertEquals(25.00, calculadora.calcularPrecoFinal(), DELTA);
    }

    // TROCA DE ESTRATÉGIA EM TEMPO DE EXECUÇÃO
    @Test
    void deveTrocarEstrategiaDePrecoCorretamente() {
        CalculadoraIngressos calculadora = new CalculadoraIngressos(PRECO_BASE);
        // 1. Aplica Promoção
        calculadora.setEstrategia(precoPromocao);
        assertEquals(40.00, calculadora.calcularPrecoFinal(), DELTA);

        // 2. Troca para Integral
        calculadora.setEstrategia(precoIntegral);
        assertEquals(50.00, calculadora.calcularPrecoFinal(), DELTA);

        // 3. Troca para Sala Gold
        calculadora.setEstrategia(precoGold);
        assertEquals(60.00, calculadora.calcularPrecoFinal(), DELTA);
    }
}