package test.java.br.com.alura.tdd.service;

import main.java.br.com.alura.tdd.modelo.Desempenho;
import main.java.br.com.alura.tdd.modelo.Funcionario;
import main.java.br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializarInstancias() {
        // Antes de cada (before each) metodo a ser testado, rode essa funcao.
        service = new ReajusteService();
        funcionario = new Funcionario("Wagner", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    public void reajusteDeveSerDeTresPorCentoQuandoODesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(funcionario.getSalario(), new BigDecimal("1030.00"));
    }

    @Test
    public void reajusteDeveSerDeQuinzePorCentoQuandoODesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(funcionario.getSalario(), new BigDecimal("1150.00"));
    }

    @Test
    public void reajusteDeveSerDeVintePorCentoQuandoODesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(funcionario.getSalario(), new BigDecimal("1200.00"));
    }

    @AfterEach
    public void finalizandoCadaTeste() {
        System.out.println("... Testado ...");
    }

    @BeforeAll
    public static void antesDeTodosOsTestes() {
        System.out.println("-=-=-=-=-= Iniciando os Testes =-=-=-=-=-");
    }

    @AfterAll
    public static void depoisDeTodosOsTestes() {
        System.out.println("-=-=-=-=-= Finalizando os Testes =-=-=-=-=-");
    }
}
