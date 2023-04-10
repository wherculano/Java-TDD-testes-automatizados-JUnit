package test.java.br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.java.br.com.alura.tdd.modelo.Funcionario;
import main.java.br.com.alura.tdd.service.BonusService;


class BonusServiceTest {
    @Test
    public void bonusDeveSerZeroParaFuncionarioComBonusAcimaDeMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(
                new Funcionario("Wagner", LocalDate.now(), new BigDecimal("19000")));
        assertEquals(bonus, new BigDecimal("0.00"));
    }

    @Test
    public void bonusDeveSerDezPorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(
                new Funcionario("Wagner", LocalDate.now(), new BigDecimal("1900")));
        assertEquals(bonus, new BigDecimal("190.00"));
    }

    @Test
    public void bonusDeveSerDezPorCentoDoSalarioAindaQueOSalarioSejaIgualADezMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(
                new Funcionario("Wagner", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(bonus, new BigDecimal("1000.00"));
    }
}