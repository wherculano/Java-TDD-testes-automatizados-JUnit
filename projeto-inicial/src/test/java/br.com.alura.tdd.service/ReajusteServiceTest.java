package test.java.br.com.alura.tdd.service;

import main.java.br.com.alura.tdd.modelo.Desempenho;
import main.java.br.com.alura.tdd.modelo.Funcionario;
import main.java.br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveSerDeTresPorCentoQuandoODesempenhoForADesejar() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Wagner", LocalDate.now(), new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(funcionario.getSalario(), new BigDecimal("1030.00"));
    }

    @Test
    public void reajusteDeveSerDeQuinzePorCentoQuandoODesempenhoForADesejar() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Wagner", LocalDate.now(), new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(funcionario.getSalario(), new BigDecimal("1150.00"));
    }

    @Test
    public void reajusteDeveSerDeVintePorCentoQuandoODesempenhoForADesejar() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Wagner", LocalDate.now(), new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(funcionario.getSalario(), new BigDecimal("1200.00"));
    }
}
